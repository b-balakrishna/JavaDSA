public class DoublyLinkedList {

    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0)
            return null;
        Node temp = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public boolean insert(int index, int value) {
        if (this.length == 0) {
            this.prepend(value);
            return true;
        } else if (index == this.length) {
            this.append(value);
            return true;
        }
        Node nextNode = this.get(index);
        if (nextNode != null) {
            Node newNode = new Node(value);
            Node prevNode = nextNode.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            this.length++;
            return true;
        }
        return false;
    }

    public Node removeFirst() {
        if (this.length == 0) {
            return null;
        }
        Node remNode = this.head;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = remNode.next;
            this.head.prev = null;
            remNode.next = null;
        }
        this.length--;
        return remNode;
    }

    public Node get(int index) {
        if (index >= this.length || index < 0) {
            return null;
        }
        Node temp = this.head;
        if (index < this.length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null)
            return false;
        temp.value = value;
        return true;
    }

    public int getLength() {
        return this.length;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

}

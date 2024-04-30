
public class SinglyLinkedList {

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public int length() {
        return this.length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public int getHead() {
        return this.head.value;
    }

    public int getTail() {
        return this.tail.value;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void append(int value) {
        Node n = new Node(value);
        if (this.length == 0) {
            this.head = n;
        } else {
            this.tail.next = n;
        }
        this.tail = n;
        this.length += 1;
    }

    public void prepend(int value) {
        Node n = new Node(value);
        if (this.length == 0) {
            this.tail = n;
        }
        n.next = this.head;
        this.head = n;
        this.length++;
    }

    public Node removeFirst() {
        if (this.length == 0) {
            return null;
        }
        Node temp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = temp.next;
            temp.next = null;
        }

        this.length--;
        return temp;
    }

    public Node removeLast() {
        if (this.length == 0)
            return null;

        Node temp = this.head;
        Node pre = this.head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
        this.tail = pre;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        }
        this.length -= 1;
        return temp;
    }

    public Node get(int index) {
        if (index >= this.length || index < 0) {
            return null;
        }
        Node temp = this.head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        if (index >= this.length || index < 0) {
            return false;
        }
        Node temp = this.get(index);
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index > this.length || index < 0)
            return false;

        if (index == 0) {
            this.prepend(value);
            return true;
        }
        if (index == this.length) {
            this.append(value);
            return true;
        }
        Node n = new Node(value);
        Node temp = this.get(index - 1);
        n.next = temp.next;
        temp.next = n;
        this.length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        if (index == 0) {
            return this.removeFirst();
        }
        if (index == this.length - 1) {
            return this.removeLast();
        }
        Node prevNode = this.get(index - 1);
        Node currentNode = prevNode.next;
        prevNode.next = currentNode.next;
        currentNode.next = null;
        this.length--;
        return currentNode;
    }

    public void reverse() {
        if (this.length == 0) {
            return;
        }
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node before = null;
        Node after = temp.next;
        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public boolean hasLoop() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void partitionList(int x) {
        if (this.head == null) {
            return;
        }

        Node lowerHead = null;
        Node lowerTail = null;
        Node greaterHead = null;
        Node greaterTail = null;
        Node current = this.head;

        while (current != null) {
            Node next = current.next;
            current.next = null;

            if (current.value < x) {
                if (lowerHead == null) {
                    lowerHead = current;
                    lowerTail = current;
                } else {
                    lowerTail.next = current;
                    lowerTail = current;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = current;
                    greaterTail = current;
                } else {
                    greaterTail.next = current;
                    greaterTail = current;
                }
            }
            current = next;
        }

        if (lowerHead != null) {
            this.head = lowerHead;
            lowerTail.next = greaterHead;
        } else {
            this.head = greaterHead;
        }
    }

    public int binaryToDecimal() {
        if (this.head == null) {
            return 0;
        }
        int decimal = 0;
        int exponent = this.length - 1;
        Node temp = this.head;
        while (temp != null) {
            decimal += temp.value * Math.pow(2, exponent);
            temp = temp.next;
            exponent--;
        }
        return decimal;
    }

}

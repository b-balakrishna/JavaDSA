public class Queue {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
    }

    public Node dequeue() {
        if (this.length == 0) {
            return null;
        }
        Node temp = this.first;
        this.first = this.first.next;
        if (this.length == 1) {
            this.last = null;
        } else {
            temp.next = null;
        }
        this.length--;
        return temp;
    }

    public void printQueue() {
        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getFirst() {
        return this.first.value;
    }

    public int getLast() {
        return this.last.value;
    }

    public int getLength() {
        return this.length;
    }
}

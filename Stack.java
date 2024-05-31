public class Stack {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.height = 1;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.height == 0) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.height++;
    }

    public Node pop() {
        if (this.height == 0)
            return null;
        Node temp = this.top;
        this.top = this.top.next;
        temp.next = null;
        this.height--;
        return temp;

    }

    public void printStack() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getTop() {
        return this.top.value;
    }
}
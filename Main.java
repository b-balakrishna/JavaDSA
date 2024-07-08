
public class Main {
    public static void main(String[] args) {
        // SinglyLinkedList list = new SinglyLinkedList(1);
        // list.append(4);
        // list.append(6);
        // list.append(2);
        // list.append(3);
        // list.append(5);
        // list.partitionList(3);
        // list.printList();
        // System.out.println(list.binaryToDecimal());

        DoublyLinkedList list = new DoublyLinkedList(0);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        // System.out.println(list.getTail().value);
        list.printList();
        System.out.println(list.getLength());
    }
}

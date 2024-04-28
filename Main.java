
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.prepend(0);
        // list.set(4, 10);
        System.out.println();
        // System.out.println(list.removeFirst().value);
        // list.insert(5, -1);
        // list.remove(2);
        list.printList();
        list.reverse();
        list.printList();
        System.out.println("Head => " + list.getHead());
        System.out.println("Tail => " + list.getTail());
        System.out.println("length => " + list.length());
        // System.out.println(list.get(5).value);
    }
}

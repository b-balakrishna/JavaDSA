
import java.util.ArrayList;
import java.util.HashMap;

public class HashTables {

    class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 7;
    private Node[] dataMap;

    public HashTables() {
        this.dataMap = new Node[this.size];
    }

    public HashTables(int size) {
        this.dataMap = new Node[size];
        this.size = size;
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < keyArray.length; i++) {
            int asciiValue = keyArray[i];
            hash = (hash + asciiValue * 7) % this.dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (this.dataMap[index] == null) {
            this.dataMap[index] = newNode;
        } else {
            Node temp = this.dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = this.hash(key);
        Node temp = this.dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int idx = 0; idx < this.dataMap.length; idx++) {
            Node temp = this.dataMap[idx];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public Node[] getDataMap() {
        return this.dataMap;
    }

    public void prinTable() {
        for (int i = 0; i < this.dataMap.length; i++) {
            Node ele = this.dataMap[i];
            System.out.println(i + "=> ");
            while (ele != null) {
                System.out.println(ele.key + ":" + ele.value);
                ele = ele.next;
            }
            System.out.println();
        }
    }

    public static boolean itemInCommon(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i : arr1) {
            map.put(i, true);
        }

        for (int j : arr2) {
            if (map.get(j) != null)
                return true;
        }
        return false;
    }

}

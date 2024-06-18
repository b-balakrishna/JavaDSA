public class BinarySearchTree {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        Node temp = this.root;
        while (true) {
            if (newNode.value == temp.value)
                return false;

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = this.root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);

        }
    }

    public boolean rContains(int value) {
        return rContains(this.root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null)
            return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (this.root == null)
            this.root = new Node(value);
        else
            rInsert(this.root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public Node delete(Node currentNode, int value) {
        if (currentNode == null)
            return null;
        if (value < currentNode.value) {
            currentNode.left = delete(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = delete(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = this.minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = delete(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void delete(int value) {
        delete(this.root, value);
    }
}

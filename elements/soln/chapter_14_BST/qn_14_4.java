import java.util.*;

class qn_14_4 {

    public Node getFirsOccurenceOfKRecursive(Node tree, int k) {
        if (tree == null) return null;

        int currentValue = tree.value;
        if (currentValue == k) {
            Node node = getFirstOccurenceOfKRecursive(tree.left, k);

            return node == null ? tree : node;
        };

        return getFirstOccurenceOfKRecursive(currentValue > k ? tree.left : tree.right, k);
    }

    public Node getFirstOccurenceOfKIterative(Node tree, int k) {
        if (tree == null) return null;

        Node current = tree;
        Node firstSoFar = null;
        while (current != null) {
            if (current.value > k) {
                current = current.left;
            } else if (current.value < k) {
                current = current.right;
            } else {
                firstSofar = current;
                current = current.left;
            }
        }

        return firstSoFar;
    }

    class Node {
        int value;
        Node parent;
        Node left;
        Node right;
    }
}

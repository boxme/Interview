import java.util.*;

class qn_14_5 {

    public Node getFirstNodeLarger(Node tree, int k) {
        if (tree == null) return null;
        
        int currentValue = tree.value;
        if (currentValue == k) {
            return getFirstNodeLarger(tree.right, k);
        } else if (currentValue > k) {
            Node node = getFirstNodeLarger(tree.left, k);

            return node == null ? tree : node;
        } else {
            return getFirstNodeLarger(tree.right, k);
        }
    }

    class Node {
        int value;
        Node left;
        Node right;
    }
}

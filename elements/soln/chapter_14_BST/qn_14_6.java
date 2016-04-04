import java.util.*;

class qn_14_6 {

    public boolean containsKInMinFirstBST(Node tree, int k) {
        if (tree == null || tree.value > k) return false;

        int currentValue = tree.value;
        if (currentValue == k) {
            return true;
        }

        if (tree.right != null && tree.right.value <= k) {
            return containsKInMinFirstBST(tree.right, k);
        }

        return containsKInMinFirstBST(tree.left, k);
    }

    class Node {
        int value;
        Node left;
        Node right;
    }
}

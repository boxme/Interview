import java.util.*;

class qn_9_6 {
    // Assuming k is 0th order
    public Node getKthNode(Node tree, int k) {
        if (tree == null) return null;

        if (tree.size <= k) return null;

        int leftSize = tree.left != null ? tree.left.size : 0;

        if (leftSize == k)     return tree;
        else if (leftSize > k) return getKthNode(tree.left, k);
        else                   return getKthNode(tree.right, k - leftSize - 1);
    }

    private static class N	ode {
        int size;
        int value;
        Node left;
        Node right;
    }
}

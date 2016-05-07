import java.util.*;

class qn_9_1 {
    boolean isTreeBalanced;

    public static void main(String[] main) {
        isTreeBalanced = true;

        checkHeight(node);
        if (isTreeBalanced) {
            // Tree is balanced
        } else {
            // Tree is not balanced
        }
    }

    public int checkHeight(Node node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);
        
        isTreeBalanced = (Math.abs(leftHeight - rightHeight) <= 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    class Node {
        public int value;
        public Node left;
        public Node right;
    }
}

import java.util.*;

class qn_9_3 {

    public static void main(String[] main) {
        
    }

    public boolean isSymmetric(Node tree) {
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private boolean checkSymmetric(Node leftSubTree, Node rightSubTree) {
        if (leftSubTree == null && rightSubTree == null) return true;

        if (leftSubTree != null && rightSubTree != null) {
            return leftSubTree.value == rightSubTree.value
                && checkSymmetric(leftSubTree.left, rightSubTree.right) 
                && checkSymmetric(leftSubTree.right, rightSubTree.left);
        }

        return false;
    }

    class Node {
        public int value;
        public Node left;
        public Node right;
    }
}

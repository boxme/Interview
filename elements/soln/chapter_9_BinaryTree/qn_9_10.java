import java.util.*;

class qn_9_10 {

    List<Integer> exteriorList = new LinkedList<Integer>();

    public static void main(String[] args) {

    }

    private void printExteriorOfBinaryTree(Node tree) {
        if (tree == null) return;

        System.out.print(tree.value);
        
    }

    private void printLeftBoundaryAndLeaves(Node t, boolean isBoundary) {
       if (t == null) return;

       if (isBoundary || isLeaf(t)) {
           System.out.print(" " + t.value);
           return;
       }

       // Print left
       printLeftBoundaryAndLeaves(t.left, isBoundary);

       // Print right
       printLeftBoundaryAndLeaves(t.right, boundary && t.left == null);
    }

    private void printRightBoundaryAndLeaves(Node t, boolean isBoundary) {
        if (t == null) return;
        
        // Print left
        printRightBoundaryAndLeaves(t.left, boundary && t.right == null);
        // Print right
        printRightBoundaryAndLeaves(t.right, isBoundary);

        if (isBoundary || isLeaf(t)) {
            System.out.print(" " + t.value);
        }
    }

    private boolean isLeaf(Node t) {
        return t.left == null && t.right == null;
    }
    
    class Node {
        int value;
        Node left;
        Node right;
    }
}

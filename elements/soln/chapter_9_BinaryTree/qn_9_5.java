import java.util.*;

class qn_9_5 {
    public static void main(String[] args) {

    }

    private void iterativeInOrderWithSpaceCompexOne(Node t) {
        if (t == null) return;

        Node tmp = t;
        Node tree = t;
        while (tree != null) {
            // Leaf
            if (tree.left == null && tree.right == null) {
                System.out.print(tree.value + " ");
                tree = tree.parent;
            } else {
                if (tmp == tree) {
                    // First time reaching the parent
                    if (tree.left != null) {
                        tmp = tree.left;
                        tree = tree.left;
                    } else if (tree.right != null){
                        System.out.print(tree.value + " ");
                        tmp = tree.right;
                        tree = tree.right;
                    }
                } else if (tmp == tree.left) {
                    // Second time reaching the parent
                    System.out.print(tree.value + " ");

                    if (tree.right != null) {
                        tree = tree.right;
                        tmp = tree.right;
                    } else {
                        tmp = tree;
                        tree = tree.parent;
                    }
                
                } else {
                    // Third time reaching the parent
                    tmp = tree;
                    tree = tree.parent;
                }
            }
        }
    }

    class Node {
        int value;
        Node left;
        Node right;
        Node parent;
    }
}

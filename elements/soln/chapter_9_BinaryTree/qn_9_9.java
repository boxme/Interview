import java.util.*;

class qn_9_9 {

    public static void main (String[] args) {
        
    }

    public Node linkedListFromLeavesOfBinaryTree(Node tree) {
        if (tree == null) return;

        if (tree.left == null && tree.right == null) return new Node(tree.value);

        Node leftLeaf;
        if (tree.left != null) {
            leftLeaf = linkedListFromLeavesOfBinaryTree(tree.left);
        }

        Node rightLeaf;
        if (tree.right != null) {
            rightLeaf = linkedListFromLeavesOfBinaryTree(tree.right);
        }

        if (leftLeaf != null) {
            leftLeaf.right = rightLeaf;
            return leftLeaf;
        } else {
            return rightLeaf;
        }
    }

    class Node {
        int value;

        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

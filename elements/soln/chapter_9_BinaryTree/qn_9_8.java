import java.util.*;

class qn_9_8 {
    private int index;

    public static void main(String[] args) {
        index = 0;
    }

    public Node reconstructBinaryTreeFromPreOrderWithMarker(String[] preOrder) {
        if (index >= preOrder.length) return null;

        String value = preOrder[index++];
        if (value == null) return null;

        Node node = new Node(value);

        // Reconstruct the left subtree
        node.left = reconstructBinaryTreeFromPreOrderWithMarker(preOrder);
        // Reconstruct the right subtree
        node.right = reconstructBinaryTreeFromPreOrderWithMarker(preOrder);

        return node;
    }

    class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }
}

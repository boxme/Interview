import java.util.*;

class qn_14_7 {

    public Node buildBSTFromSortedArray(int[] array, int start, int end) {
        if (start >= end) return null;

        int mid = start + ((end - start) / 2 );
        Node node = new Node(array[mid]);

        // Build left sub tree
        node.left = buildBSTFromSortedArray(array, start, mid);

        // Build right sub tree
        node.right = buildBSTFromSortedArray(array, mid + 1, end);

        return node;
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

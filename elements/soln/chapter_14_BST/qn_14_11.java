import java.util.*;

class qn_14_11 {

    List<Integer> arrayList = new ArrayList<Integer>();

    public void findKLargestElements(Node tree, int k) {
        if (tree == null || k == 0) return;

        if (tree.right == null) {
            arrayList.add(tree.value);
            findKLargestElements(tree.left, k - 1);
        } else if (tree.right != null) {
            findKLargestElements(tree.right, k);

            if (arrayList.size < k) {
                arrayList.add(tree.value);
                findKLargestElements(tree.left, k - arrayList.size);
            }

        }
    }

    // Better Answer
    public static List<Integer> findKLargestInBST(BSTNode<Integer> tree, int k) {
        List<Integer> kLargestElements = new ArrayList<>();
        findKLargestInBSTHelper(tree, k, kLargestElements);
        return kLargestElements;
    }
    
    private static void findKLargestInBSTHelper(BSTNode<Integer> tree, int k,
                                                List<Integer> kLargestElements) {
        // Perform reverse inorder traversal.
        if (tree != null && kLargestElements.size() < k) {
            findKLargestInBSTHelper(tree.getRight(), k, kLargestElements);
            if (kLargestElements.size() < k) {
                kLargestElements.add(tree.getData());
                findKLargestInBSTHelper(tree.getLeft(), k, kLargestElements);
            }
        }
    }

    class Node {
        int value;
        Node left;
        Node right;
    }
}

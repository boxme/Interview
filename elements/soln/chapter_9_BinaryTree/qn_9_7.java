import java.util.*;

class qn_9_7 {
    public static void main(String[] args) {

    }

    public void recreateBinaryTree(int[] inOrder, int[] preOrder) {
        HashMap<Integer> nodeToIndexMap = new HashMap<Integer>();
        int inOrderSize = inOrder.length;
        for (int i = 0; i < inOrderSize; ++i) {
            nodeToIndexMap.put(inOrder[i], i);
        }

        recreateBinaryTreeHelperFromPreOrder(
                0, inOrder.length, preOrder, 0, preOrder.length, nodeToIndexMap);
    }

    private Node recreateBinaryTreeHelperFromPreOrder(
            int inOrderStart, int inOrderEnd,
            int[] preOrder, int preOrderStart, int preOrderEnd,
            HashMap<Integer> nodeToIndexMap) {
        
        if (inOrderStart >= inOrderEnd || preOrderStart >= preOrderEnd) {
            return null;
        }

        int value = preOrder[preOrderStart];
        int index = nodeToIndexMap.get(value);
        int leftSubTreeSize = index - inOrderStart;
        Node node = new Node(value);
        
        // Build left subtree
        node.left = recreateBinaryTreeHelperFromPreOrder(
                inOrderStart, index,
                preOrder, preOrderStart + 1, preOrderStart + leftSubTreeSize + 1,
                nodeToIndexMap);

        // Build right subtree
        node.right = recreateBinaryTreeHelperFromPreOrder(
                index + 1, inOrderEnd,
                preOrder, preOrderStart + leftSubTreeSize + 1, preOrderEnd,
                nodeToIndexMap);

        return node;
    }
    
    private Node recreateBinaryTreeHelperFromPostOrder(
            int inOrderStart, int inOrderEnd,
            int[] postOrder, int postOrderStart, int postOrderEnd,
            HashMap<Integer> nodeToIndexMap) {
        
        if (inOrderStart >= inOrderEnd || postOrderStart >= postOrderEnd) {
            return null;
        }

        int value = postOrder[postOrderEnd - 1];
        int index = nodeToIndexMap.get(value);
        int rightSubTreeSize = inOrderEnd - index - 1;
        Node node = new Node(value);
        
        // Build left subtree
        node.left = recreateBinaryTreeHelperFromPostOrder(
                inOrderStart, index,
                postOrder, postOrderStart, postOrderEnd - rightSubTreeSize - 1,
                nodeToIndexMap);

        // Build right subtree
        node.right = recreateBinaryTreeHelperFromPostOrder(
                index + 1, inOrderEnd,
                postOrder, postOrderEnd - rightSubTreeSize - 1, postOrderEnd - 1,
                nodeToIndexMap);

        return node;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

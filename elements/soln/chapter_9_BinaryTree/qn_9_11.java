import java.util.*;

class qn_9_11 {
    public static BSTNode<Integer> findLCA(BSTNode<Integer> tree,
                                           BSTNode<Integer> s, BSTNode<Integer> b) {
        BSTNode<Integer> p = tree;
        while (p.getData() < s.getData() || p.getData() > b.getData()) {
            // Keep searching since p is outside of [s, b].
            while (p.getData() < s.getData()) {
                p = p.getRight(); // LCA must be in p's right child.
            }
            while (p.getData() > b.getData()) {
                p = p.getLeft(); // LCA must be in p's left child.
            }
        }
        
        // s.getData() >= p.getData() && p.getData() <= b.getData().
        return p;
    }
    
    // Returns an object of int and node; int field is 0, 1, or 2 depending on
    // how many of node0 and node1 are present in tree. If both are present in
    // tree, the node pointer is a common ancestor. It may not be the LCA
    // initially, but it will be LCA when the algorithm terminates.
    private static Status LCAHelper(BinaryTreeNode<Integer> tree,
                                    BinaryTreeNode<Integer> node0,
                                    BinaryTreeNode<Integer> node1) {
        if (tree == null) {
            return new Status(0, null);
        }
        
        Status leftResult = LCAHelper(tree.getLeft(), node0, node1);
        if (leftResult.numTargetNodes == 2) {
            // Found both nodes in the left subtree.
            return leftResult;
        }
        Status rightResult = LCAHelper(tree.getRight(), node0, node1);
        if (rightResult.numTargetNodes == 2) {
            // Found both nodes in the right subtree.
            return rightResult;
        }
        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes +
        (tree == node0 || tree == node1 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }
}

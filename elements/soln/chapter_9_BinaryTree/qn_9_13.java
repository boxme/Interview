import java.util.*;

class qn_9_13 {
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        Set<BinaryTree<Integer>> hash = new HashSet<>();
        while (node0 != null || node1 != null) {
            // Ascend in tandem for iter_0 and iter_1.
            if (node0 != null) {
                if (!hash.add(node0)) {
                    return node0;
                }
                node0 = node0.getParent();
            }
            if (node1 != null) {
                if (!hash.add(node1)) {
                    return node1;
                }
                node1 = node1.getParent();
            }
        }
        throw new RuntimeException("node0 and node1 are not in the same tree");
    }
}

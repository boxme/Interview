import java.util.*;

class qn_9_12 {
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        int depth0 = getDepth(node0), depth1 = getDepth(node1);
        // Makes node0 as the deeper node in order to simplify the code.
        if (depth1 > depth0) {
            BinaryTree<Integer> temp = node0;
            node0 = node1;
            node1 = temp;
        }
        // Ascends from the deeper node.
        int depthDiff = Math.abs(depth0 - depth1);
        while (depthDiff-- > 0) {
            node0 = node0.getParent();
        }
        
        // Now ascends both nodes until we reach the LCA.
        while (node0 != node1) {
            node0 = node0.getParent();
            node1 = node1.getParent();
        }
        return node0;
    }
    
    private static int getDepth(BinaryTree<Integer> node) {
        int depth = 0;
        while (node != null) {
            ++depth;
            node = node.getParent();
        }
        return depth;
    }

}

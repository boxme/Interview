import java.util.*;

class qn_9_2 {
    public static void main(String[] args) {

    }

    public Status getUnbalancedNode(Node tree, int k) {
        if (tree == null) return new Status(null, 0);
        
        Status left = getUnbalancedNode(tree.left, k);
        Status right = getUnbalancedNode(tree.right, k);
        
        int height = 1 + Math.max(left.height, right.height);
        if (Math.abs(left.height - right.height) < k && left.node == null && right.node == null) {
            if (height < k) {
                return new Status(null, height);
            } else {
                return new Status(tree, height);
            }
        } else {
            Node returnedNode = tree;
            if (left.node != null) {
                returnedNode = left.node;
            } else if (right.node != null) {
                returnedNode = right.node;
            }
        
            return new Status(returnedNode, height);
        }
    }

    class Status {
        public Node node;
        public int height;
    }

    class Node {
        public int value;
        public Node left;
        public Node right;
    }
}

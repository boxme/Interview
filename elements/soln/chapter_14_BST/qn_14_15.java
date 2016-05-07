import java.util.*;

class qn_14_15 {
    public static List<Integer> RangeLookupBST(BSTNode<Integer> tree,
                                               Interval interval) {
        List<Integer> result = new ArrayList<>();
        RangeLookupBSTHelper(tree, interval, result);
        return result;
    }
    
    public static void RangeLookupBSTHelper(BSTNode<Integer> tree,
                                            Interval interval,
                                            List<Integer> result) {
        if (tree == null) {
            return;
        }
        if (interval.left <= tree.getData() && tree.getData() <= interval.right) {
            // tree.getData() lies in the interval.
            RangeLookupBSTHelper(tree.getLeft(), interval, result);
            result.add(tree.getData());
            RangeLookupBSTHelper(tree.getRight(), interval, result);
        } else if (interval.left > tree.getData()) {
            RangeLookupBSTHelper(tree.getRight(), interval, result);
        } else { // interval.right <= tree.getData()
            RangeLookupBSTHelper(tree.getLeft(), interval, result);
        }
    }
}

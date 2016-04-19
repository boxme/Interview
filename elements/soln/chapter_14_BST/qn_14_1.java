import java.util.*;

class qn_14_1 {

    public static void main(String[] args)
    {
	// satisfyBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)
    }

    public boolean satisfyBST(Node node, int lo, int hi)
    {
	if (node == null) return true;

	int val = node.value;
	if (val < lo || val > hi)
	{
	    return false;
	}

	return satisfyBST(node.left, lo, val) && satisfyBST(node.right, val, hi);
    }

    // Wrong solution
    public boolean satisfyBSTProperty(Node tree) {
        if (tree == null) return true;

        int currentVal = tree.value;
        boolean satisfy = true;
        if (tree.left != null) {
            if (currentVal < tree.left.value) return false;
            satisfy = satisfyBSTProperty(tree.left);
        }

        if (!satisfy) return satisfy;

        if (tree.left != null) {
            if (currentVal > tree.right.value) return false;
            satisfy = satisfyBSTProperty(tree.right);
        }

        return satisfy;
    }

    class Node {
        int value;
        Node left;
        Node right;
    }
}

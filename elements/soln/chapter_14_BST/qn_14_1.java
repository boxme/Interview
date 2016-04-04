import java.util.*;

class qn_14_1 {

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

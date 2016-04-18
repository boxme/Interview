import java.util.*;

public class repeat_9_3
{
    public static boolean isSymmetric(Node root)
    {
	if (root == null) return true;
	
	return checkSymmetrical(root.left, root.right);
    }

    private static boolean checkSymmetrical(Node left, Node right)
    {
	if (left == null && right == null) return true;

	if (left != null && right != null)
	{
	    return left.value == right.value 
		   && checkSymmetrical(left.left, right.right)
		   && checkSymmetrical(left.right, right.left);
	}

	return false;
    }
}

class Node
{
    int value;
    Node left;
    Node right;
}


import java.util.*;

public class qn_14_13
{
    // @params root A BST
    // @params s node that is smaller in value than b
    // @param b node thatis larger in value tahn a
    public static Node LCA(Node root, Node s, Node b)
    {
	if (root == null || s == null || b == null) return null;
	
	while (root.value > b.value || root.value < s.value)
	{
	    if (root.value > b.value)
	    {
		root = root.left;
	    }
	    else if (root.value < s.value)
	    {
		root = root.right;
	    }
	}

	return root;
    }
}

public class Node
{
    int value;
    Node left;
    Node right;
}

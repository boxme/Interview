import java.util.*;

public class qn_14_2
{
    public static Node successor(Node node)
    {
	if (node == null) return null;

	if (node.right != null) return node.right;
	
	if (node.parent == null) return parent;
	Node parent = node.parent;
	if (parent.right == node)
	{
	    return successor(parent);
	}

	return parent;
    }
}

class Node
{
    int value;
    Node left, right, parent;
}

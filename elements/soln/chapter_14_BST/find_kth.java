import java.util.*;

public class find_kth
{
    int c;

    public Node findKthLargest(Node root, int k)
    {
	if (root == null) return null;
	c = 0;
	return findKthSuccessor(root, k);
    }

    private Node findKthSuccessor(Node node, k)
    {
	if (node == null) return null;

	if (k <= c) return null;

	Node large = findKthSuccessor(node.right, k);

	if (larges != null) return large;
	
	c++;
	if (k == c)
	{
	    return node;
	}

	return findKthSuccessor(node.left, k);
    }
}

class Node
{
    int value;
    Node left;
    Node right;
}

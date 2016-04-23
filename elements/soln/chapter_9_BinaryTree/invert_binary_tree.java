import java.util.*;

public class invert_binary_tree
{
    // Recursive
    public Node invert(Node root)
    {
	if (root == null) return;
	
	Node left = root.left;
	root.left = invert(node.right);
	root.right = invert(left);

	return root;
    }

    // Iterative
    public Node invert(Node root)
    {
	if (root == null) return null;
	
	Queue<Node> q = new LinkedList<>();
	q.offer(root);

	Node node;
	while (!q.isEmpty())
	{
	    node = q.poll();
	    if (node.left != null)
	    {
		q.offer(node.left);
	    }
	    if (node.right != null)
	    {
		q.offer(node.right);
	    }

	    Node temp = node.left;
	    node.left = node.right;
	    node.right = temp;
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

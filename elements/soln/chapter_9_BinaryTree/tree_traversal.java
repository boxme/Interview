import java.util.*;

public class tree_traversal
{
    public void interative_traversal(Node root)
    {
	if (root == null) return;

	Node prev = null;
	Node curr = root;

	while (curr != null)
	{
	    if (prev == null || curr == prev.left || curr == prev.right)
	    {
		prev = curr;
		if (curr.left != null)
		{   
		    // Go left
		    curr = curr.left;
		}
		else
		{
		    System.out.print(curr.value + " ");

		    if (curr.right != null)
		    {
			curr = curr.right;
		    }
		    else
		    {
			// Go up
			curr = curr.parent;
		    }
		}
	    } 
	    else if (curr.left == prev)
	    {	
		// Visited left

		System.out.print(curr.value + " ");
		if (curr.right != null)
		{
		    // go right
		    prev = curr;
		    curr = curr.right;
		}
		else
		{
		    // Go up
		    prev = curr;
		    curr = curr.parent;
		}
	    }
	    else
	    {	
		// Visied right, so go up
		prev = curr;
		curr = curr.parent;
	    }
	}
    }
}

public Node
{
    int value;
    Node parent;
    Node left, right;
}

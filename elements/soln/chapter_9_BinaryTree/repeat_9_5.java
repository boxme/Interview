import java.util.*;

public class repeat_9_5
{
    public static void dfs(Node root)
    {
	if (root == null) return;

	Node curr = root;
	Node prev = null;

	while (curr != null)
	{
	    if (prev == null || prev.left == curr || prev.right == curr)
	    {
            prev = curr;
		
            if (curr.left != null)
            {
                // go left
                curr = curr.left;
            }
            else
            {
                System.println(curr.value);
                curr = curr.right != null ? curr.right : curr.parent;
            }
	    }
	    else if (curr.left == prev)
	    {
            // visit right
            System.println(curr.value);
		`
            prev = curr;
            curr = curr.right != null ? curr.right : curr.parent;
	    }
	    else
	    {
            // Go up
            prev = curr;
            curr = curr.parent;
	    }
	}
    }
}

class Node
{
    int value;
    Node parent;
    Node left;
    Node right;
}

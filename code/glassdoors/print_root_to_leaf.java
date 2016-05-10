import java.util.*;

public class print_root_to_leaf
{
    public void solution(Node root)
    {
	print(root);
    }

    // DFS pre order traversal
    private void print(Node root, String p)
    {
	if (root == null) return;

	p += p.isEmpty() ? root.value : (" " + root.value);

	if (root.left == null && root.right == null)
	{
	    System.out.println("Path: " + p);
	    return;
	}

	print(root.left, p);
	print(root.right, p);
    }
}

private class Node
{
    int value;
    Node left;
    Node right;
}

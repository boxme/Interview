import java.util.*;

public class qn_14_2
{
    public static Node buildBstFromPreorder(Node[] nodes, int index, int min, int max)
    {
	if (nodes == null) return null;
	if (index >= nodes.length) return null;

	Node curr = nodes[index];
	if (curr.value < min || curr.value > max)
	{
	    return null;
	}

	Node root = new Node(curr.value);
	root.left = buildBstFromPreorder(nodes, index + 1, min, root.value);
	root.right = buildBstFromPreorder(nodex, index + 1, root.value, max);

	return root;
    }
}

public class Node
{
    int value;
    Node left;
    Node right;
}

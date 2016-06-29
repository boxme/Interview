import java.util.*;

public class qn_14_2
{
    private int idx = 0;
    
    public static Node buildBstFromPreorder(Node[] nodes, int min, int max)
    {
	if (nodes == null) return null;
	if (index >= nodes.length) return null;

	Node curr = nodes[index];
    
	if (curr.value < min || curr.value > max)
	{
	    return null;
	}
        
    index++;

	Node root = new Node(curr.value);
	root.left = buildBstFromPreorder(nodes, index, min, root.value);
	root.right = buildBstFromPreorder(nodes, index, root.value, max);

	return root;
    }
}

public class Node
{
    int value;
    Node left;
    Node right;
}

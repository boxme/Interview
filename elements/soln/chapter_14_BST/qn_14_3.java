import java.util.*;

public class qn_14_3
{
    public static void main(String[] args)
    {
    }

    public Integer findKeyInBstRecursive(Node node, int key)
    {
	if (node == null)
	{
	    return null;
	}

	int value = node.value;
	if (value == key) return node;

	if (value > key) return findKeyInBstRecursive(node.left, key);

	return findKeyInBstRecursive(node.right, key);
    }

    public Integer findKeyInBstIterative(Node node, int key)
    {
	if (node == null) return null;

	while (node != null)
	{
	    int value = node.value;
	    if (value == key) return node;

	    node = value < key ? node.right : node.left;
	}

	return null;
    }
}

class Node
{
    int value;
    Node left;
    Node right;
}

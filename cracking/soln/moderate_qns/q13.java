import java.util.*;

public class q13
{
    public static void main(String[] args)
    {
    }
    
    // Inefficient method
    public static BiNode convertTreeToLL(BiNode root)
    {
	if (root == null) return null;

	BiNode left = convertTreetoLL(root.left);
	BiNode right = convertTreeToLL(root.right);
	
	root.left = null;
	root.right = null;

	if (left != null)
	{
	    BiNode tail = getTail(left);
	    tail.right = root;
	    root.left = tail;
	}

	if (right != null)
	{
	    root.right = right;
	    right.left = root;
	}

	return left == null ? root : left;
    }

    private BiNode getTail(BiNode node)
    {
	if (node == null) return null;

	while (node.right != null)
	{
	    node = node.right;
	}

	return node;
    }

    // Use a circular linkedlisd method to get the tail efficiently
    public static BiNode convert(BiNode root)
    {
	if (root == null) return null;

	BiNode left = convert(root.left);
	BiNode right = convert(root.right);

	root.left = root;
	root.right = root;
	
	if (left == null && right == null)
	{
	    return root;
	}

	if (right != null)
	{
	    root.right = right;
	    // tail of Right
	    root.left = right.left;
	    
	    right.left = root;
	}

	if (left != null)
	{
	    // left.left is tail of Left
	    left.left.right = root;

	    BiNode tail = root.left;
	    
	    root.left = left.left;
	    left.left = tail;
	}

	return left != null ? left : root;
    }
}

class BiNode
{
    int value;
    BiNode left;
    BiNode right;

    public BiNode(int value)
    {
	this.value = value;
    }
}

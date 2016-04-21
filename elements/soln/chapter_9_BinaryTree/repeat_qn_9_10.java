import java.util.*;

public class repeat_qn_9_10
{
    public static void main(String[] args)
    {
    }

    // Print boundary of a binary tree
    public static void printBinaryTree(Node root)
    {
	if (root == null) return;

	// Print the root first
	System.out.print(root.value + " ");

	// Print left boundary of the tree from top down
	printLeftBoundaryOfTree(node.left);

	// Print leaves using in-order
	printLeaves(node.left);
	printLeaves(node.right);

	// Print right boundary of the tree from bottom up
	printRightBoundaryOfTree(node.right);
    }

    public static void printLeftBoundaryOfTree(Node node)
    {
	if (node == null) return;
	
	if (node.left != null)
	{
	    System.out.print(node.value + " ");
	    printLeftBoundaryOfTree(node.left);
	}
	else if (node.right != null)
	{
	    System.out.print(node.value + " ");
	    printLeftBoundaryOfTree(node.right)
	}
    }

    public static void printLeaves(Node node)
    {
	if (node == null) return;
	if (node.left == null && node.right == null)
	{
	    System.out.print(node.value + " ");
	    return;
	}

	printLeaves(node.left);
	printLeaves(node.right);
    }

    public static void printRightBoundaryOfTree(Node node)
    {
	if (node == null) return;

	if (node.right != null)
	{
	    printRightBoundaryOfTree(node.right);
	    System.out.print(node.value + " ");
	} 
	else if (node.left != null)
	{
	    printRightBoundaryOfTree(node.left);
	    System.out.print(node.value + " ");
	}
    }
}

class Node
{
    int value;
    Node left;
    Node right;
}

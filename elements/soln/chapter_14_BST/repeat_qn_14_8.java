import java.util.*;

public class repeat_14_8
{
    public static void main(String[] args)
    {
    }

    public Node buildBstFromSinglyLL(Node node, int length)
    {
	if (node == null) return null;

	if (length <= 0) return null;

	Node root = new Node();
	root.left = buildBstFromSinglyLL(node, length / 2);
	
	root.value = node.value;
	
	// Move head ahead by one in LL
	node = node.right;
      
	// length - length/2 - 1 is the total # of nodes of the right substree
	// minus 1 because the middle node is now the root
	root.right = buildBstFromSinglyLL(node, length - length/2 - 1);

	return root;
    }
}

class Node
{
    int value;
    Node left;
    // Only this pointer is allowed to be used in a singly linkedlist
    Node right;
}

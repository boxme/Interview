import java.util.*;

public class qn_14_10
{
    public static void main(String[] args)
    {
    }

    // Create doubly linked list from BST
    public Node getLLfromBst(Node root)
    {
	if (root == null)
	{
	    return null;
	}

	Node leftHead = getLLfromBst(root.left);
	Node rightHead = getLLfromBst(root.right);
	
	Node head = root;
	head.left = head.right = head;

	if (leftHead != null)
	{
	    Node leftTail = leftHead.left;
	    leftTail.right = root;
	    root.left = leftTail;

	    // Circular doubly linkedlist
	    leftHead.left = root;
	    root.right = leftHead;
	    head = leftHead;
	}

	if (rightHead != null)
	{
	    Node rightTail = rightHead.left;
	    root.right = rightHead;
	    rightHead.left = root;
	    head.left = rightTail;
	    rightTail.right = head;
	}

	return head;
    }

    // Convert doubly LL into BST
    public Node getBstFromLL(Node head, int size)
    {
	// Treat it like a singly linkedlist
	if (head == null) return null;
	if (size <= 0) return null;

	Node left = getBstFromLL(Node head, size/2);
	
	Node root = new Node();
	root.value = head.value;
	head = head.right;

	Node right = getBstFromLL(head, size - size/2 - 1);

	root.left = left;
	root.right = right;

	return root;
    }

    // Merge part of merge sort for doubly linkedlist
    public Node mergeSortedList(Node left, Node right)
    {
	if (left == null) return right;
	if (right == null) return left;

	Node head = null;
	Node tail = null;
	while (left != null && right != null)
	{
	    boolean isLeftBigger = left.value > right.value;
	    if (head == null)
	    {
		if (isLeftBigger)
		{
		    head = right;
		    right = right.right;
		}
		else
		{
		    head = left;
		    left = left.right;
		}
		tail = head;
	    }
	    else
	    {
		if (isLeftBigger)
		{
		    tail.right = right;
		    right = right.right;
		}
		else
		{
		    tail.right = left;
		    left = left.right;
		}

		tail.right.left = tail;
	        tail = tail.right;
	    }
	}

	Node leftOver = left != null ? left : right;
	while (leftOver != null)
	{
	    tail.right = leftOver;
	    leftOver = leftOver.right;
	    tail.right.left = tail;
	    tail = tail.right;
	}

	return head;
    }

    public int getLengthOfLL(Node head)
    {
	int len = 0;
	while (head != null)
	{
	    len++;
	    head = head.right;
	}

	return len;
    }
}

public class Node
{
    int value;
    Node left;
    Node right;
}

import java.util.*;

public class flatten_linkedlist
{
    public void solution(Node head)
    {
	if (head == null) return;
	
	Node flatten = recursive(head);
    }

    private Node recursive(Node head)
    {
	if (head == null) return null;

	Node temp = head;
	Node front, back;

	while (temp != null)
	{
	    Node node;
	    if (temp.list == null)
	    {
		node = temp;
		temp = temp.right;
	    }
	    else
	    {
		node = temp;
		temp = temp.right;
		node.right = recursive(node.list);
		node.list = null;
	    }

	    if (front == null)
	    {
		front = node;
		back = node;
	    }
	    else
	    {
		back.right = node;

		while (back.right != null)
		{
		    back = back.right;
		}
	    }
	}

	return front;
    }
}

private class Node
{
    int value;
    Node right;
    Node list;
}

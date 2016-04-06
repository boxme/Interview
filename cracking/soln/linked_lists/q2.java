import java.util.*;

public static void main(String[] args)
{
    
}

class FindKthItem
{
    pubic Node findKth(int k, Node list)
    {
	if (list == null) return null;

	Node head = list;
	int iteration = k;

	while (head != null && k >= 0)
	{
	    head = head.next;
	    k--
	}

	if (k >= 0 || head == null) return null;

	Node back = list;

	while (head.next != null)
	{
	    back = back.next;
	    head = head.next;
	}

	return back;
    }
}

class Node
{
    Node next;
    int data;

    public Node(int d)
    {
	data = d;
    }
}

import java.util.*;

public static void main(String[] args)
{
}

class QuickSort
{
    public void partition(Node list, int pivot)
    {
	if (list == null) return;

	Node smallHead, smallTail;
	Node largeHead, largeTail;

	Node head = list;

	while (head != null)
	{
	    int data = head.data;
	    if (data < pivot)
	    {
		if (smallHead == null)
		{
		    smallHead = head;
		    smallTail = head;
		}
	      
		smallTail.next = head;
	    }
	    else
	    {
		if (largeHead == null)
		{
		    largeHead = head;
		    largeTail = head;
		}

		largeTail.next = head;
	    }
	    
	    head = head.next;
	}
	
	// Connect the two partition
	if (smallTail != null)
	{
	    smallTail.next = largeHead;
	}
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



import java.util.*;

public static void main(String[] args)
{
    
}

class DeleteNode
{
    public void delete(Node node)
    {
	if (node == null) return;
	if (node.next == null) return;

	// Copy the value in front of each node
	Node front = node.next;
	while (front != null && front.next != null)
	{
	    node.data = front.data;
	    node = front;
	    front = front.next;
	}
	
	// Cut off link to the last node
	node.next = null;
    }
}

class Node
{
    int data;
    Node next;

    public Node(int d)
    {
	data = d;
    }
}

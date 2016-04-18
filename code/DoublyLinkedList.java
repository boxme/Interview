import java.util.*;

public static void main(String[] args)
{
}

class Node 
{
    int element;
    Node left;
    Node right;

    public Node(int element)
    {
	this.element = element;
	left = null;
	right = null;
    }
}

class DoublyLinkedList 
{
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList()
    {
	head = null;
	tail = null;
	size = 0;
    }

    // Add to the tail
    public void insert(int element)
    {
	Node node = new Node(element);

	if (head == null)
	{
	    head = node;
	    tail = head;
	}
	else
	{
	    tail.right = node;
	    node.left = tail;
	    tail = node;
	}

	size++;
    }

    public Node search(int element)
    {
	Node temp = head;
	while (temp != null)
	{
	    if (temp.element == null)
	    {
		return temp;
	    }

	    temp = temp.right;
	}
	return null;
    }

    public void delete(int element)
    {
	Node node = search(element);
	if (node == null) return;

	// Remove the head
	if (head == node)
	{
	    if (head == tail) 
	    {
		head = null;
		tail = null;
	    }
	    else 
	    {
		head = head.right;
	    }
	}
	else if (tail == node)
	{
	    tail = tail.left;
	}
	else
	{
	    Node left = node.left;
	    Node right = node.right;
	    left.right = right;
	    right.left = left;
	}

	size--;
    }

    public void insertAfter(Node node, int element)
    {
	if (node == null) return;

	Node newNode = new Node(element);
	if (head == node)
	{
	    if (tail == node)
	    {
		tail.right = newNode;
		newNode.left = tail;
		tail = newNode;
	    }
	    else
	    {
		newNode.right = head.right;
		head.right = newNode;
		newNode.left = head;
	    }
	}
	else if (tail == node)
	{
	    tail.right = newNode;
	    newNode.left = tail;
	    tail = newNode;
	}
	else if (head == null)
	{
	    insert(element);
	    return;
	}
	else 
	{
	    Node rightNode = node.right;
	    newNode.right = rightNode;
	    newNode.left = node;
	    
	    if (rightNode != null)
	    {
		rightNode.left = newNode;
	    }
	}

	size++;
    }
}

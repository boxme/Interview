import java.util.*;

class AddSumInLinkedList
{
    public Node addReverse(Node aList, Node bList)
    {
	if (aList == null) return bList;
	if (bList == null) return aList;
	
	int a = getNumberFromReverseList(aList);
	int b = getNumberFromReverseList(bList);

	int c = a + b;

	Node reverseHead;
	Node reverseTail;

	while (c > 10)
	{
	    int d = c % 10;
	    Node node = new Node(d);

	    if (reverseHead == null) 
	    {
		reverseHead = node;
		reverseTail = node;
	    }
	    else
	    {
		reverseTail.next = node;
		reverseTail = node;
	    }

	    c /= 10;
	}
	
	Node node = new Node(c);
	reverseTail.next = node;
	reverseTail = node;

	return reverseHead;
    }

    public Node add(Node aList, Node bList)
    {
	if (aList == null) return bList;
	if (bList == null) return aList;

	int a = getNumFromList(aList);
	int b = getNumFromList(bList);
	int c = a + b;

	Node newHead;
	while (c > 10)
	{
	    int d = c % 10;
	    Node node = new Node(d);

	    if (newTail == null)
	    {
		newHead = node;
	    }
	    else
	    {
		node.next = newHead;
		newHead = node;
	    }

	    c /= 10;
	}

	Node node = new Node(c);
	node.next = newHead;
	newHead = node;

	return newHead;
    }

    private int getNumberFromReverseList(Node list)
    {
	Node head = list;
	int pos = 1;
	int a;
	while (head != null)
	{
	    int d = head.data;
	    a += d * pos;
	    pos *= 10;
	    head = head.next;
	}

	return a;
    }

    private int getNumFromList(Node list)
    {
	Node head = list;
	int a = 0;
	while (head != null)
	{
	    int d = head.data;
	    a *= 10;
	    a += d;
	}

	return a;
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

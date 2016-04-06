import java.util.*;

public static void main(String[] args)
{

}

class Node
{
    Node next = null;
    int data;

    public Node(int d)
    {
	data = d;
    }
}

class RemoveDuplicate
{
    public Node removeDupFromUnsorted(Node list)
    {	
	if (list == null) return null;

	// Create two loops O(n^2) or mergesort then remove likes its sorted
	MergeSortLinkedList mergeSort = new MergeSortLinkedList();	
	list = mergeSort.mergeSort(list);
	return removeDupFromSorted(list);
    }

    public Node removeDupFromSorted(Node list)
    {
	if (list == null) return null;

	Node back = list;
	Node front = back.next;

	while (front != null)
	{
	    if (back.data == front.data)
	    {
		back.next = front.next;
		front.next = null;
		front = back.next;
	    }
	    else
	    {
		back = front;
		front = front.next;
	    }
	}

	return list;
    }

    private void delete(int d)
    {
	if (list == null) return;

	Node head = list.getHead();

	if (head == null) return null;

	Node temp = head;
	while (head != null)
	{
	    if (head.data == d)
	    {
		if (head == temp)
		{
		    head = head.next;
		    temp.next = null;
		}
		else
		{
		    temp.next = head.next;
		    head.next = null;
		}
	    }

	    temp = head;
	    head = head.next;
	}
    }
}

class MergeSortLinkedList
{
    
    public Node mergeSort(Node node)
    {
	if (node == null) return null;

	// divide two halves then merge
	Node aHead = node;
	
	Node aTail;
	Node back = aHead;
	Node front = aHead;

	while (front != null && front.next != null && front.next.next != null)
	{
	    aTail = back;
	    back = moveOneStep(back);
	    front = moveOneStep(front);
	    front = moveOneStep(front);
	}
	
	Node bHead = back;
	aTail.next = null;

	aHead = mergeSort(aHead);
	bHead = mergeSort(bHead);

	return combineTwoSortedLinkedList(aHead, bHead);
    }

    private Node moveOneStep(Node node)
    {
	if (node == null) return null;

	return node.next;
    }
    
    private Node combineTwoSortedLinkedList(Node aList, Node bList)
    {
	if (aList == null) return bList;
	if (bList == null) return aList;

	Node aHead = aList;
	Node bHead = bList;
	Node newHead = null;
	Node newTail = null;
	whie (aHead != null && bHead != null)
	{
	    int a = aHead.data;
	    int b = bHead.data;
	    
	    if (newHead == null)
	    {
		newHead = a < b ? aHead : bHead;
		newTail = a < b ? aHead : bHead;
		
		if (a < b)
		{
		    aHead = aHead.next;
		}
		else
		{
		    bHead = bHead.next;
		}

		newTail.next = null;
		continue;
	    }

	    if (a < b)
	    {
		newTail.next = aHead;
		newTail = newTail.next;
		aHead = aHead.next;
	    }
	    else
	    {
		newTail.next = bHead;
		newTail = newTail.next;
		bHead = bHead.next;
	    }

	    newTail.next = null;
	}

	if (aHead != null) newTail.next = aHead;
	if (bHead != null) newTail.next = bHead;

	return newHead;
    }
}

import java.util.*;

public static void main(String[] args)
{
    
}

class PalindromeCheck
{
    // Assuming you can modify the list
    public boolean isPalindrome(Node list)
    {
	if (list == null) return false;

	Node back = list;
	Node hare = list;
	Node tort = list;
	int len = 1;
	while (hare.next != null)
	{   
	    len++;
	    hare = hare.next;

	    if (hare.next == null)
	    {
		break;
	    }

	    len++;
	    hare = hare.next;

	    Node temp = tort;
	    tort = tort.next;
	    temp.next = back;
	    back = temp;
	}
	
	// tort is now the middle
	Node head = tort.next;
	if (len % 2 == 0)
	{
	    // Even number
	    tort.next = back;
	    back = tort;
	}

	while (head != null)
	{
	    if (head.data != back.data) return false;

	    head = head.next;
	    back = back.next;
	}

	return true;
    }
}

class Node
{
    int data;
    Node next;
}

import java.util.*;

public static void main(String[] args)
{
}

class Solution
{
    SortStack stack;

    public Solution()
    {
	stack = new SortStack();
    }

    private void test1()
    {
	stack.push(6);
	stack.push(3);
	stack.push(7);
	stack.push(5);

	int size = 4;
	assertTrue(stack.peek() == 7);
	assertTrue(stack.pop() == 7);
	assertTrue(stack.pop() == 6);
	assertTrue(stacl.pop() == 5);
        assertTrue(stack.peek() == 3);
    }
}

class SortStack
{
    Stack sorted;
    Stack holding;

    public SortStack()
    {
	sorted = new Stack();
	holding = new Stack();
    }

    void push(int item)
    {
	if (sorted.isEmpty())
	{
	    sorted.push(item);
	    return;
	}

	while (!sorted.isEmpty() && sorted.peek() > item)
	{
	    holding.push(sorted.pop());
	}

	sorted.push(item);

	while (!holding.isEmpty())
	{
	    sorted.push(holding.pop());
	}
    }

    int pop()
    {
	if (sorted.isEmpty()) throw new IllegalException("empty");

	return sorted.pop();
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

class Stack
{
    Node top;
    int size = 0;
    void push(int item)
    {
	Node node = new Node(item);
	node.next = top;
	top = node;
	size++;
    }

    int peek()
    {
	if (size == 0) throw new IllegalException("Empty");

	return top.data;
    }

    int pop()
    {
	if (size == 0) throw new IllegalException("Empty");

	Node temp = top;
	top = top.next;
	return temp.data;
    }

    boolean isEmpty()
    {
	return size == 0;
    }

}

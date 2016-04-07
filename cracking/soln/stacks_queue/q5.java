import java.util.*;

public static void main(String[] args)
{
}

class Solution
{
    MyQueue queue;

    public Solution()
    {
      queue = new MyQueue();	
    }
    private void test1()
    {
	int size = 3;
	for (int i = 0; i < size; ++i)
	{
	    queue.push(i);
	}

	assertTrue(queue.peek() == 0);

	for (int i = 0; i < size; ++i)
	{
	    assertTrue(queue.poll() == i);
	}
    }
}

class MyQueue
{
    Stack stackForPushing;
    Stack stackForPolling;

    public MyQueue()
    {
	stackForPushing = new Stack();
	stackForPolling = new Stack();
    }

    void push(int data)
    {
	stackForPushing.push(data);
    }

    int peek()
    {
	if (stackForPolling.isEmpty())
	{
	    transfer();
	}

	if (stackForPolling.isEmpty()) throw new IllegalException("empty");

	return stackForPolling.peek();
    }
    
    int poll()
    {
	if (stackForPolling.isEmpty())
	{
	    transfer();
	}

	if (stackForPolling.isEmpty()) throw new IllegalException("empty");

	return stackForPolling.pop();
    }

    private void transfer()
    {
	while(!stackForPushing.isEmpty())
	{
	    int data = stackForPushing.pop();
	    stackForPolling.push(data);
	}
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

    void push(int data)
    {
	Node node = new Node(data);
	node.next = top;
	top = node;
	size++;
    }

    int peek()
    {
	if (top == null) throw new IllegalException("stack id empty");

	return top.data;
    }

    Node pop()
    {
	if (top == null) return null;

	Node temp = top;
	top = top.next;
	size--;
	return temp;
    }

    int getSize()
    {
	return size;
    }

    boolean isEmpty()
    {
	return size == 0;
    }
}

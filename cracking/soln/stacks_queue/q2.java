import java.util*;

public static void main(String[] args)
{
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

class MinStack
{
    Stack stack;
    Stack minStack;
    int min

    public MinStack()
    {
	stack = new Stack();
	minStack = new Stack();
	min = Integer.MAX_VALUE;
    }

    void push(int item)
    {
	Node top = stack.peek();
	stack.push(item);

	if (min >= item)
	{
	    min = item;
	    minStack.push(stack.peek());
	}
    }

    int peek()
    {
	if (stack == null) throw new IllegalException("stack is empty");

	return stack.peekData();
    }

    int getMin()
    {
	return min;
    }

    int pop()
    {
	if (stack == null) throw new IllegalException("Stack is empty");
	
	 top = stack.peek();
	 if (top == min)
	 {
	    min = minStack.pop();
	 }

	 return stack.pop();
    }
}

class Stack
{
    Node top;

    void push(int item)
    {
	Node node = new Node(item);
	node.next = top;
	top = node;
    }

    void push(Node node)
    {
	if (node == null) return;

	node.next = top;
	top = node;
    }

    int peekData()
    {
	if (top == null) return -1;

	return top.data;
    }

    int pop()
    {
	if (top == null) return -1;
	
	Node temp = top;
	top = top.next;

	return temp.data;
    }

    Node peek()
    {
	if (top == null) return null;

	return top;
    }
}

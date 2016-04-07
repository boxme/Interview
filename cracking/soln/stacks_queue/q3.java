import java.util.*

public static void main(String[] args)
{
}

class SetOfStacks<T>
{
    int thresHold;
    int currSize;
    List<Stack<T>> listOfStacks;

    public void SetOfStacks(int limit)
    {
	thresHold = limit;
	listOfStacks = new ArrayList<>();
    }

    void push(T item)
    {
	int size = listOfStacks.size();
	
	Stack<T> currentStack;

	if (size == 0)
	{   
	    // To add a new stack when it's the first added item
	    currentStack = new Stack<>();
	    listOfStacks.add(currentStack);
	}
	else
	{ 
	    currentStack = listOfStacks.get(size - 1);
	}

	if (currentStack.size() == thresHold)
	{   
	    currentStack = new Stack<>();
	    listOfStacks.add(currentStack);
	}

	currentStack.push(item);
    }

    T pop()
    {
	if (listOfStacks.isEmpty()) return null;

	final int size = listOfStacks.size();
	Stack<T> currentStack = listOfStacks.get(size - 1);
	
	T item = currentStack.pop();
	if (currentStack.size() == 0)
	{
	    listOfStacks.remove(size - 1);
	}
	return item;
    }

    T popAt(int index)
    {
	if (index >= listOfStacks.size()) return null;
	
	if (index == listOfStacks.size() - 1) return pop();

	Stack<T> stack = listOfStacks.get(index);
	return stack.pop();
    }
}

class Node<T>
{
    T data;
    Node<T> next;

    public Node(T d)
    {
	data = d;
    }
}

class Stack<T>
{
    Node<T> top;
    int size;

    public Stack()
    {
	size = 0;
    }

    void push(T item)
    {
	Node<T> node = new Node<>(item);
	
	node.next = top;
	top = node;
	size++;
    }

    T peek()
    {
	if (top == null) return null;

	return top.data;
    }

    T pop()
    {
	if (top == null) return null;

	Node<T> temp = top;
	top = top.next;
	size--;
	return temp;
    }

    int size()
    {
	return size;
    }
}

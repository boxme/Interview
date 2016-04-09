import java.util.*;

public static void main(String[] args)
{
}

class Node
{
    int data;
    Node left;
    Node right;
}

class PrintPath
{
    Stack<Node> stack;
    Queue<Node> holding;
    int value;

    public PrintPath(int value)
    {
	this.value = value;
	stack = new Stack<>();
	holding = new Queue<>();
    }

    public void findPath(Node root)
    {
	if (root == null) return;

	Node head = root;
	stack.push(head);

	int currentValue = head.value;
	printPath(currentValue);

	while(!stack.isEmpty())
	{
	    Node curr = stack.pop();
	    currentValue -= curr.data;
	    printPath(currentValue);

	    if (curr.left != null) 
	    {
		stack.push(curr.left);
		currentValue += curr.left.data;
		printPath(currentValue);
	    }

	    if (curr.right != null) 
	    {
		stack.push(curr.right);
		currentValue += curr.right.data;
		printPath(currentValue);
	    }
	}
    }

    private void printPath(int curr)
    {
	if (curr != value) return;

	while(!stack.isEmpty())
	{
	    holding.offer(stack.pop());
	}

	Node node;
	StringBuilder path = new StringBuilder();
	path.append("Path:");
	while (!holding.isEmpty())
	{
	    node = holding.poll();
	    stack.push(node);
	    path.append(" ");
	    path.append(node.data);
	}

	System.out.println(path.toString());
    }
}

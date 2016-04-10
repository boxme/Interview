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

// Book solution
public static void findSum(Node root, int sum)
{
    int depth = treeDepth(root);
    int[] path = new int[depth];
    findSum(root, sum, path, 0);
}

// Pre-order traversal
public static void findSum(Node root, int sum, int[] path, int level)
{
    if (root == null) return;

    path[level] = root.data;

    // Look for paths
    int curr = 0;
    for (int i = level; i >= 0; --i)
    {
	curr += path[i];
	if (curr == sum)
	{
	    print(path, i, level);
	}
    }

    findSum(root.left, sum, path, level + 1);
    findSum(root.right, sum, path, level + 1);

    path[level] = Integer.MIN_VALUE;
}

private static void print(int[] path, int start, int end)
{
    for (int i = start; i <= end; ++i)
    {
	System.out.print(path[i]) + " "; 
    }

    System.out.println();
}

private static int treeDepth(Node root)
{
    if (root == null) return 0;

    return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
}

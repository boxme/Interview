import java.util.*;

public static void main(String[] args)
{
    
}

public boolean isSubTree(Node large, Node small)
{
    if (large == null || small == null) return false;

    Node smallHead = small;
    Node largeHead = large;

    while (largeHead != null && largeHead != smallHead.data)
    {
	int largeVal = largeHead.data;
	if (largeVal < smallHead.data)
	{
	    largeHead = largeHead.right;
	}
	else if (largeVal > smallHead.data)
	{
	    largeHead = largeHead.left;
	}
	else
	{
	    break;
	}
    }

    if (largeHead == null) return false;

    // Start DFS travesal together
    Stack<Node> smallStack = new Stack<>();
    Stack<Node> largeStack = new Stack<>();
    
    smallStack.push(smallHead);
    largeStack.push(largeHead);

    Node smallTemp;
    Node largeTemp;
    while (!smallStack.isEmpty() && !largeStack.isEmpty())
    {
	smallTemp = smallStack.pop();
	largeTemp = largeStack.pop();

	if (smallTemp.data != largeTemp.data) return false;

	smallStack.push(smallTemp.left);
	smallStack.push(smallTemp.right);

	largeStack.push(largeTemp.left);
	largeStack.push(largeTemp.right);
    }

    return smallStack.isEmpty() && largeStack.isEmpty();
}

class Node
{
    int data;
    Node left;
    Node right;
}

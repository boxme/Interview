import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int d)
    {
	data = d;
	left = null;
	right = null;
    }
}

class BalanceCheck
{

    public Pair isBalance(Node root)
    {
	if (root == null) return new Pair(true, 0);

	Pair left = isBalance(root.left);
	Pair right = isBalance(root.right);

	if (!left.isBalance || !right.isBalance) return new Pair(false, 0);

	return new Pair(true, Math.max(right.height, left.height) + 1);
    }
}

class Pair
{
    boolean isBalance;
    int height;

    public Pair(boolean balance, int height)
    {
	isBalance = balance;
	this.height = height;
    }
}

// Book solution
public int checkHeight(Node root)
{
    if (root == null) return -1;

    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) return -1;

    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) return -1;

    if (Math.abs(leftHeight - rightHeight) > 1)
    {
	return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
}

public static boolean isBalanced(Node root)
{
    if (checkHeight(root) == -1)
    {
	return false;
    }
    return true;
}

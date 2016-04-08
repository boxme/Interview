import java.util.*;

public static void main(String[] args)
{
    Node root = new Node(5);
    root.left = new Node(7);
    root.right = new Node(4);

    isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public static boolean isBST(Node root, int lo, int hi)
{
    if (root == null) return true;

    int data = root.data;
    if (data > hi || data < lo) return false;

    return isBST(root.left, lo, data) && isBST(root.right, data, hi);
}

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int d)
    {
	data = d;
    }
}

import java.util.*;

public static void main(String[] args)
{
    
}

public static Node findSuccessor(Node node)
{
    if (node == null) return null;

    if (node.right != null) return node.right;

    Node parent = node.parent;
    if (parent == null) return null;

    while (parent != null && parent.left != node)
    {
	node = parent;
	parent = node.parent;
    }

    return parent;
}

class Node
{
    int data;
    Node left;
    Node right;
    Node parent;
}

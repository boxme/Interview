import java.util.*;

public static void main(String[] args)
{
    
}

public static Node LCA(Node a, Node b)
{
    if (a == null || b == null) return null;

    Node curr = a;
    int aDepth = 0;
    while (curr != null)
    {
	curr = curr.parent;
	if (curr != null) aDepth++;
    }

    curr = b;
    int bDepth = 0;
    while (curr != null)
    {
	curr = curr.parent;
	if (curr != null) bDepth++;
    }

    Node low = aDepth < bDepth ? b : a;
    Node hi = aDepth < bDepth ? a : b;

    int diff = Math.abs(aDepth - bDepth);
    whlie (diff > 0)
    {
	low = low.parent;
	diff--;
    }

    while (low != unll && hi != null && low != hi)
    {
	low = low.parent;
	hi = hi.parent;
    }

    if (low == null || hi == null) return null;

    return low;
}

class Node
{
    int data;
    Node left;
    Node right;
    Node parent;
}

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

// Book solution
class Result
{
    Node node;
    boolean isAncestor;

    public Result(Node node, isAncestor)
    {
	this.node = node;
	this.isAncestor = isAncestor;
    }
}

public static Result commonAncestor(Node root, Node a, Node b)
{
    if (root == null) return new Result(null, false);

    if (root == a && root == b) return new Result(root, true);

    Result left = commonAncestor(root.left, a, b);
    if (left.isAncestor) return left;

    Result right = commonAncestor(root.right, a, b);
    if (right.isAncestor) return right;

    if (left.node != null && rigth.node != null)
    {
	// Current root is the ancestor
	return new Result(root, true);
    }
    else if (root == a || root == b)
    {
	// Subtree of a or b might contain either a/b, which then makes it an ancestor
	boolean isAncestor = (left.node != null || right.node != null) ? true : false;
	return new Result(root, isAncestor);
    }
    else
    {
	return new Result(left.node != null ? left.node : right.node, false);
    }
}

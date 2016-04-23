import java.util.*;

public class qn_14_22
{
    // Without counter in the node
    public int getNumberOfNodesInRange(Node root, int lo, int hi)
    {
	if (root == null) return 0;

	int value = root.value;

	if (value < lo)
	{
	    return getNumberOfNodesInRange(root.right, lo, hi);
	}
	else if (value > hi)
	{
	    return getNumberOfNodesInRange(root.left, lo, hi);
	}

	return 1 + getNumberOfNodesInRange(root.left , lo, hi) + getNumberOfNodesInRange(root.right, lo, hi);
    }

    // With counter in the node
    public int getNumOfNodesInRange(Node root, int lo, int hi)
    {
	if (root == null) return 0;
	
	int lessCount = findCountLessThanK(root, 0, lo);
	int moreCount = findCountMoreThanK(root, 0, hi);

	return root.count - lessCount - MoreCount;
    }

    private int findCountLessThanK(Node node, int count, int k)
    {
	if (node == null) return count;

	int value = node.value;
	if (value < k)
	{
	    int leftCount = node.left != null ? node.left.count : 0;
	    count += (leftCount + 1);
	    return findCountLessThanK(node.right, count, k); 
	}
	else if (value > k)
	{
	    return findCountLessThanK(node.left, count, k);
	}

	int leftCount = node.left != null ? node.left.count : 0;
        count += (leftCount + 1);
	return count;
    }

    private int findCountMoreThanK(Node node, int count, int k)
    {
	if (node == null) return count;

	int value = node.value;
	if (value > k)
	{
	    int rightCount = node.right != null ? node.right.count : 0;
	    count += (rightCount + 1);
	    return findCountMoreThanK(node.left, count, k);
	}
	else if (value < k)
	{
	    return findCountMoreThanK(node.right, count, k);
	}

	int rightCount = node.right != null ? node.right.count : 0;
	count += (rightCount + 1);
	return count;
    }
}

class Node
{
    int value;
    Node left;
    Node right;
    
    int count;
}

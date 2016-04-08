import java.util.*;

public static void main(String[] args)
{
}

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
	data = d;
    }
}

class GenerateTreeFromArray
{
    public Node generate(int[] array, int low, int hi)
    {	
	int size = array.length();

	if (low > hi) return null;
	if (low < 0 || hi >= size) return null;

	if (low == hi)
	{
	    return new Node(array[low]);
	}

	int mid = (hi - lo / 2) + lo;
	Node root = new Node(array[mid]);

	root.left = generate(array, low, mid - 1);
	root.right = generate(array, mid + 1, hi);

	return root;
    }
}

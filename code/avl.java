import java.util.*;

public static void main(String[] args)
{
}

class Node 
{
    Node parent;
    Node left;
    Node right;

    int value;
    int leftHeight;
    int rightHeight;

    public Node(int value)
    {
      parent = null;
      left = null;
      right = null;

      this.value = value;
      leftHeight = -1;
      rightHeight = -1;
    }

    public int getHeight()
    {
	return Math.max(leftHeight, rightHeight) + 1;	
    }

    public int getHeightDiff()
    {
	return leftHeight - rightHeight;
    }
}

class Avl
{
    Node head;
    int size;

    public Avl()
    {
	head = null;
    }

    public void insert(int value)
    {
	head = insertNewNode(head, value);
	head = balance(head);
    }

    private Node insertNewNode(Node node, int value)
    {
	if (node == null) return new Node(value);

	if (node.value <= value)
	{
	    node.left = insertNewNode(node.left, value);
	    node.leftHeight++;
	    node.left.parent = node;
	}
	else
	{
	    node.right = insertNewNode(node.right, value);
	    node.rightHeight++;
	    node.right.parent = node;
	}

	node = balance(node);
	return node;
    }

    public void delete(int value)
    {
	Node deleteNode = search(value);
	if (deleteNode == null) return;

	head = delete(head, value);
    }

    private Node delete(Node node, int value)
    {
	if (head == null) return null;

	if (node.value == value)
	{
	    if (node.left == null && node.right == null)
	    {
		node = null;
	    }
	    else if (node.left != null && node.right != null)
	    {
		Node successor = successor(node);
		node.value = successor.value;
		node.right = delete(node.right, node.value);
		node.rightHeight--;
	    }
	    else if (node.left != null)
	    {
		Node temp = node;
		node.left.parent = node.parent;
		node = node.left;
		temp.left = null;
		temp = null;
	    }
	    else if (node.right != null)
	    {
		Node temp = node;
		node.right.parent = node.parent;
		node = node.right;
		temp.right = null;
		temp = null;
	    }
	}
	else if (node.value < value)
	{
	    node.rightHeight--;
	    node.right = delete(node.right, value);
	}
	else if (node.value > value)
	{
	    node.leftHeight--;
	    node.left = delete(node.left, value);
	}

	return node;
    }

    public Node search(int value)
    {
	return searchValue(head, value);	
    }

    private Node searchValue(Node node, int value)
    {
	if (node == null) return null;
	
	if (node.value == value) return node;

	return searchValue(node.value < value ? node.right : node.left, value);
    }

    public Node findMax()
    {
	return max(head);
    }

    private Node max(Node node)
    {
	if (node == null) return null;

	if (node.right == null) return node;

	return max(node.right);
    }

    public Node findMin()
    {
	return min(head);
    }

    private Node min(Node node)
    {
	if (node == null) return null;

	if (node.left == null) return node;

	return min(node.left);
    }

    private Node successor(Node node)
    {
	if (node == null || node == head) return null;

	if (node.right != null) return node.right;

	Node child = node;
	Node parent = child.parent;
	while (parent.left != child)
	{
	    child = parent;
	    parent = child.parent;

	    if (parent == null) break;
	}

	return parent;
    }

    private Node descendent(Node node)
    {
	if (node == null || node == head) return null;

	if (node.right != null) return node.left;

	Node child = node;
	Node parent = child.parent;
	while (parent.right != child)
	{
	    child = parent;
	    parent = child.parent;

	    if (parent == null) break;
	}

	return parent;
    }

    private Node balance(Node node)
    {
	if (node == null) return;

	int heightDiff = node.getHeightDiff();
	
	if (heightDiff == 2)
	{
	    int leftChildHeightDiff = node.left.getHeightDiff();
	    if (leftChildHeightDiff == 1)
	    { 
		node = rotateRight(node);
	    }
	    else if (leftChildHeightDiff == -1)
	    {
		node.left = rotateLeft(node.left);
		node = rotateRight(node);
	    }
	}
	else if (heightDiff == -2)
  	{
	    int rightChildHeightDiff = node.right.getHeightDiff();
	    if (rightChildHeightDiff == 1)
	    {
		node.right = rotateRight(node.right);
		node = rotateLeft(node);
	    }
	    else if (rightChildHeightDiff == -1)
	    {
		node = rotateLeft(node);
	    }
	}

	return node;
    }

    private Node rotateLeft(Node node)
    {
	if (node == null) return null;

	if (node.right == null) return node;

	Node rightChild = node.right;
	Node parent = node.parent;
	
	node.right = rightChild.left;
	if (node.right != null) node.right.parent = node;

	rightChild.left = node;
	node.parent = rightChild;
	rightChild.parent = parent;

	if (parent != null) 
	{
	    parent.right = rightChild;
	}
	else
	{
	    // rightChild is now the head
	    head = rightChild
	}

	// Update height
	node.rightHeight = node.right == null ? -1 : node.right.getHeight();
	rightChild.leftHeight = node.getHeight();

	return rightChild;
    }

    private Node rotateRight(Node node)
    {
	if (node == null) return null;

	if (node.left == null) return node;

	Node leftChild = node.left;
	Node parent = node.parent;

	node.left = leftChild.right;
	if (node.left != null) node.left.parent = node;

	leftChild.right = node;
	node.parent = leftChild;
	leftChild.parent = parent;

	if (parent != null) 
	{
	    parent.left = leftChild;
	}
	else
	{
	    // leftChild is now the head
	    head = leftChild;
	}
	
	// updateHeight
	node.leftHeight = node.left == null ? -1 : node.left.getHeight();
	leftChild.rightHeight = node.getHeight();

	return leftChild;
    }
}



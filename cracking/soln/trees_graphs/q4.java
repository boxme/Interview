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

class CreateLinkedList
{
    private List<List<Node>> linkedLists;

    public void create(Node root)
    {
	if (root == null) return;
	
	linkedLists = new ArrayList<>();

	Queue<Pair> q = new LinkedList<>();
	q.offer(new Pair(root, 0));

	while (!q.isEmpty())
	{
	    Pair pair = q.poll();
	    Node curr = pair.node;
	    int depth = pair.depth;
	    
	    if (curr.left != null)
	    {
		q.offer(new Pair(curr.left, depth + 1));
	    }

	    if (curr.right != null)
	    {
		q.offer(new Pair(curr.right, depth + 1));
	    }
	    
	    while (linkedLists.size() <= depth)
	    {
		linkedLists.add(new ArrayList<>());
	    }

	    linkedLists.get(depth).add(curr);
	}

	int depth = linkedLists.size();
	for (int i = 0; i < depth; ++i)
	{
	    List<Node> currList = linkedLists.get(i);
	    Node head, tail;
	    for (int j = 0; j < currList.size(); ++j)
	    {
		if (j == 0) 
		{
		    head = currList.get(j);
		    tail = head;
		    continue;
		}

		tail.left = null;
		tail.right = currList.get(j);
		tail = tail.right;
	    }
	    currList.clear();
	    currList.add(head);
	}
    }
}

class Pair
{
    Node node;
    int depth;

    public Pair(Node node, int depth)
    {
	this.node = node;
	this.depth = depth;
    }
}

// Book solution
public static List<List<Node>> createLevelLinkedList(Node root)
{
    if (root == null) return null;

    List<List<Node>> lists = new ArrayList<>();
    createLevelLinkedList<roots, lists, 0);

    return lists;
}

public static void createLevelLinkedList(Node root, List<List<Node>> lists, int level)
{
    if (lists == null) return;

    List<Node> list = null;
    if (lists.size() == level)
    {
	list = new ArrayList<>();
	lists.add(list);
    }
    else
    {
	list = lists.get(level);
    }

    list.add(root);

    createLevelLinkedList(root.left, lists, level + 1);
    createLevelLinkedList(root.right, lists, level + 1);
}

// BFS solution
public static List<LinkedList<Node>> createLevelLL(Node root)
{
    if (root == null) return null;

    List<LinkedList<Node>> lists = new ArrayList<>();

    LinkedList<Node> current = new LinkedList<>();
    
    current.add(root);

    while (!current.isEmpty())
    { 
        // Add previous level
	lists.add(current);

	LinkedList<Node> parents = current;
	
	// New level
	current = new LinkedList<>();

	for (Node parent : parents)
	{
	    if (parent.left != null)
	    {
		current.add(parent.left);
	    }

	    if (parent.right != null)
	    {
		current.add(parent.right);
	    }
	}
    }

    return lists;
}

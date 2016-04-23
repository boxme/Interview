import java.util.*;

public class qn_14_18
{
    Queue<Entry> window = new LinkedList<>();
    HashMap<String, Node> map = new HashMap<>();
    BST tree = new BST();

    int w;

    public void add(Entry p)
    {
	int currentTime = p.timestamp;

	Node node;
	boolean isInTree = false;
	if (map.containsKey(p.page))
	{
	    isInTree = true;
	    node = map.get(p.page);
	}
	else
	{
	    node = new Node(p.page, 0);
	    map.put(node.page, node);
	}

	// Update the tree with the new pair
	if (isInTree)
	{
	    // Delete old value first
	    tree.remove(node);
	}
	node.freq++;
	tree.add(node);

	window.offer(p);
	int lowerTimeLimit = currentTime - w;
	
	Entry entry;
	while (!window.isEmpty() && window.peek().timestamp < lowerTimeLimit)
	{
	    entry = window.poll();
	    node = map.get(entry.page);
	    tree.remove(node);
	    node.freq--;
	    if (node.freq > 0)
	    {
		tree.add(node);
	    }
	}
    }

    public List<String> common(int k)
    {
	List<String> kMostVisited = new LinkedList<>();
	tree.findKLargestItems(tree.root, kMostVisited, k);

	return kMostVisited;
    }

}

public class BST
{
    Node root;

    public void add(Node node)
    {
    }

    public void remove(Node node)
    {
    }

    public void findKLargestItems(Node node, List<String> list, int k)
    {
	if (node == null) return;
	if (list.size >= k) return;

	// Find largest item first
	findKLargestItems(node.right, list, k);
	
	list.add(node.page);
	if (list.size == k) return;

	findKLargestItems(node.left, list, k);
    }

}

public class Node
{
    int freq;
    String page;

    public Node(int freq, String page)
    {
	this.freq = freq;
	this.page = page;
    }
}

public class Entry
{
    int timestamp;
    String page;

    public Entry(int time, String page)
    {
	timestamp = time;
	this.page = page;
    }
}

public class Pair
{
    String page;
    int freq;

    public Pair(String page, int freq)
    {
	this.page = page;
	this.freq = freq;
    }
}

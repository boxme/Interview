import java.util.*;

class Node
{
    int data;
    List<Node> edges;

    public Node(int d)
    {
	data = d;
	edges = new ArrayList<>();
    }
}

class FindPath
{
    public boolean hasRoute(Node start, Node end)
    {
	if (start == null) return false;

	List<Node> edges = start.edges;
	if (edges.isEmpty())
	{
	    return start == end;
	}

	boolean hasRoute = false;
	for (Node node : edges)
	{
	    hasRoute = hasRoute(node, end);

	    if (hasRoute) return hasRoute;
	}
    }
}

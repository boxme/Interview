import java.util.*;

public class bipartile_check
{
    // Use BFS
    public boolean isGraphBipartile(List<List<Pair>> graphs, Pair source)
    {
	boolean isBipartile = true;
	int[] colors = new int[graphs.size()];
	int[] visited = new int[graphs.size()];
	Arrays.fill(colors, -1);

	Queue<Pair> q = new LinkedList<>();
	colors[source.vertex] = 0;
	q.push(source);

	while (!q.isEmpty() && isBipartile)
	{
	    Pair curr = q.poll();

	    for (Pair v : graphs.get(curr.vertex))
	    {
		if (visited[v.vertex] != 0)
		{
		    continue;
		}

		if (colors[v.vertex] == colors[curr.vertex])
		{
		    isBipartile = false;
		    break;
		}
		else
		{
		    visited[v.vertex] = 1;
		    colors[v.vertex] = 1 - colors[curr.vertex];
		    q.push(v);
		}

	    }
	}

	return isBipartile;
    }

    // Use DFS
    public boolean isBipartile(List<List<Pair>> graphs, Pair s)
    {
	boolean isBipartile = true;
	int[] colors = new int[graphs.size()];
	int[] visited = new int[graphs.size()];
	Arrays.fill(colors, -1);

	Stack<Pair> stack = new Stack<>();
	colors[source.vertex] = 0;
	stack.push(source);

	while (!stack.isEmpty() && isBipartile)
	{
	    Pair curr = stack.pop();

	    for (Pair v : graphs.get(curr.vertex))
	    {
		if (visited[v.vertex] != 0)
		{
		    continue;
		}

		if (colors[v.vertex] == colors[curr.vertex])
		{
		    isBipartile = false;
		    break;
		}
		else
		{
		    visited[v.vertex] = 1;
		    colors[v.vertex] = 1 - colors[curr.vertex];
		    stack.push(v);
		}
	    }
	}

	return isBipartile;
    }
}

private class Pair
{
    int vertex;
    int weight;
}

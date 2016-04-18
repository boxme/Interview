import java.util.*;

class BFS
{
    int[] visited;
    int[] parent;
    List<List<Integer>> adjList;

    public void BFS_interactive(int root)
    {
	parent[root] = root;
	visited[root] = 1;
	Queue<Integer> queue = new LinkedList<>();
	queue.push(root);

	while (!queue.isEmpty())
	{
	    int u = queue.pop();

	    for (Integer v : adjList.get(u))
	    {
		if (visited[v] == 0)
		{
		    visited[v] = 1;
		    queue.push(v);
		    parent[v] = u;
		}
	    }
	}
    }

    private void setup()
    {
	if (adjList == null) return;

	visited = new int[adjList.size()];
	parent = new int[adjList.size()];
	Arrays.fill(parent, -1);
    }
}

class DFS
{
    int[] visited;
    int[] parent;
    List<List<Integer>> adjList;

    public void DFS(int root)
    {
	setup();

	parent[root] = root;
	for (Integer vertex : adjList.get(root))
	{
	    if (visited[vertex] == 0)
	    {
		DFS_recursive(vertex)
	    }
	}
    }

    private void DFS_recursive(int u)
    {
	visited[u] = 1;
	
	for (Integer v : adjList.get(u))
	{
	    if (visited[u] == 0)
	    {
		DFS_recursive(v);
		parent[v] = u;
	    }
	}
    }

    public void interactive_DFS(int root)
    {
	setup();
	
	visited[root] = root;
	parent[root];
	Stack<Integer> stack = new Stack<>();
	stack.push(root);

	while (!stack.isEmpty())
	{
	    int u = stack.pop();

	    for (Integer v : adjList.get(u))
	    {
            if (visited[v] == 0)
            {
                visited[v] = 1;
                stack.push(v);
                parent[v] = u;
            }
	    }
	}

    }

    private void setup()
    { 
	if (adjList == null) return;

	visited = new int[adjList.size()];
	parent = new int[adjList.size()];
	Arrays.fill(parent, -1);
    }
}

import java.util.*;

class DetectCycle
{
    int[] visited;
    int[] inStack;
    int[] parent;
    Stack<Integer> cycle;
    List<List<Pair>> adjList;

    public void checkForCycleInDirectedGraph(List<List<Pair>> adjList)
    {
	if (adjList == null) return;
	
	this.adjList = adjList;
	int size = adjList.size();
	visited = new int[size];
	inStack = new int[size];
	parent = new int[size];

	for (int i = 0; i < size; ++i)
	{
	    parent[i] = i;
	}

	for (int i = 0; i < size; ++i)
	{
	    if (visited[i] == 0)
	    {
		dfs(i);
	    }
	}
    }

    private void dfs(int u)
    {
	visited[u] = 1;
	inStack[u] == 1;

	for (Pair pair : adjList.get(u))
	{
	    if (visited[pair.v] == 0)
	    {	
		parent[pair.v] = u;
		dfs(pair.v);
	    } 
	    else if (inStack[pair.v] == 1)
	    {
		// Cycle detected
		cycle = new Stack<>();

		for (int i = u; i != pair.v; i = parent[i])
		{
		    cycle.push(i);    
		}

		cycle.push(pair.v);
		cycle.push(u);
	    } 
	}

	inStack[u] = 0;
    }
    
    private boolean hasCycle()
    {
	
    }
}

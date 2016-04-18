import java.util.*;

class TopoSort
{   
    Queue<Integer> pre;
    Queue<Integer> post;
    Stack<Integer> rev;

    int[] visited;

    public void topoSort(List<List<Pair>> adjList)
    {
	if (adjList == null) return null;

	int size = adjList.size();
	visited = new int[size];
	
	pre = new LinkedList<>();
	post = new LinkedList<>();
	rev = new Stack<>();

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
	
	pre.offer(u);

	for (Pair pair : adjList.get(u))
	{
	    if (visited[pair.v] == 0)
	    {
		dfs(pair.v);
	    }
	}

	post.offer(u);
	rev.push(u);
    }
}

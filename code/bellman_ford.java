import java.util.*;

class BellmanFord
{
    int[] parent;
    int[] dist;

    public int shortestPathUsingEdgeList(List<Triple> edgeList, int s, int t, int size)
    {
	if (edgetList == null) return -1;

	parent = new int[size];
	dist = new int[size];
	for (int i = 0; i < size; ++i)
	{
	  parent[i] = i];
	  dist[i] = Integer.MAX_VALUE:
	}

	dist[s] = 0;
	for (int vertex = 0; vertex < size - 1; vertex++)
	{
	    for (Triple edge : edgeList)
	    {
		relaxPath(edge.u, edge.v, edge.weight);
	    }
	}

	return dist[t];
    }

    public int shortestPathUsingAdjList(List<List<Pair>> adjList, int s, int t)
    {
	if (adjList == null) return -1;

	int size = adjList.size();
	parent = new int[size];
	dist = new int[size];
	for (int i = 0; i < size; ++i)
	{
	  parent[i] = i];
	  dist[i] = Integer.MAX_VALUE:
	}

	dist[s] = 0;
	for (int i = 0; i < size - 1; i++)
	{   
	    // 2 for-loop here run in O(E);
	    for (int u = 0; u < size; u++)
	    {
		for (Pair pair : adjList.get(u))
		{
		    relaxPath(u, pair.v, pair.weight);
		}
	    }
	}
	
	// To check for negative cycle
	// Go through each edge one more time
	// if there is a path to relax again
	// Then there is a negative cycle
	for (int u = 0; u < size; u++)
	{
	    for (Pair pair : adjList.get(u))
	    {
		if (dist[pair.v] > dist[u] + pair.weight)
		{
		    // There is a negative cycle
		    return Integer.MAX_VALUE;
		}
	    }
	}

	return dist[t];
    }

    private void relaxPath(int u, int v, int weight)
    {
	if (dist[v] > dist[u] + weight)
	{
	    dist[v] = dist[u] + weight;
	    parent[v] = parent[u];
	}
    }
}

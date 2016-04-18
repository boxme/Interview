import java.util.*;

class Prim
{
    int[] taken;
    List<List<IntegerPair>> adjList;
    PriorityQueue<IntegerPair> pq;

    // Return total weight of the MST 
    public int mst(List<List<IntegerPair>> adjList)
    {
	if (adjList == null) return -1;

	this.adjList = adjList;
	int size = adjList.size();
	
	pq = new Priority<>();

	// Starting vertex is 0
	process(0);

	int totalWeight = 0;
	IntegerPair pair;
	while (!pq.isEmpty())
	{   
	    pair = pq.poll();
	    if (taken[pair.v]) continue;
	    
	    totalWeight += pair.weight;
	    process(pair.v);
	}
    }

    private void process(int vertex)
    {
	taken[vertex] = 1;
	for (IntegerPair pair : adjList.get(vertex))
	{
	    pq.add(pair);
	}
    }
}

class IntegerPair
{
    int v;
    int weight;
}

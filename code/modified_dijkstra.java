import java.util.*;

class Dijksta
{
    int[] dist;
    PriorityQueue<Pair> pq;

    public int shortestPath(List<List<Pair>> adjList, int s, int t)
    {
	if (adjList == null) return -1;

	int size = adjList.size();
	dist = new int[size];
	Arrays.fill(dist, Integer.MAX_VALUE);

	dist[s] = 0;
	pq.add(new Pair(s, 0);

	Pair pair;
	while (!pq.isEmpty())
	{ 
	    pair = pq.poll();
	    if (pair.weight > dist[pair.u]) continue;

	    for (Pair vertex : adjList.get(pair.u))
	    {
		int v = vertex.v;
		int w = vertex.weight;
		
		if (dist[v] >= dist[pair.u] + w) continue;

		dist[v] = dist[pair.u] + w;
		pq.add(new Pair(v, dist[v]));
	    }
	}

	return dist[t];
    }
}

class Pair
{
    int u;
    int weight;

    public Pair(int u, int weight)
    {
	this.u = u;
	this.weight = weight;
    }
}

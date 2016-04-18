import java.util.*;

class Kruskal
{
    int[] par;

    // Return a adjList of MST
    public List<List<IntegerPair>> mst(List<IntegerTriple> edgeList, int size)
    {
	if (edgeList == null) return;

	par = new int[size];
	List<List<IntegerPair>> adjList = new ArrayList<>();
	for (int i = 0; i < size; ++i)
	{
	    par[i] = i;
	    adjList.add(new ArrayList<>());
	}
	
	// Sort the list in ascending order
	Collections.sort(edgetList);
	
	IntegerPair u;
	IntegerPair v;

	for (IntegerTriple edge: edgeList)
	{
	    if (getParent(edge.u) != getParent(edge.v))
	    {
		u = new IntegerPair();
		v = new IntegerPair();

		u.v = edge.u;
		u.w = edge.w;
		v.v = edge.v;
		v.w = edge.w;

		adjList.get(edge.u).add(u);
		adjList.get(edge.v).add(v);

		par[getParent(edge.u)] = getParent(edge.v);
	    }
	}

	return adjList;
    }

    private int getParent(int index)
    {
	if (par[index] == index) return index;

	return par[index] = getParent(par[index]);
    }
}

class IntegerPair
{
    int v, w;
}

class IntegerTriple
{
    int u;
    int v;
    int w;
}

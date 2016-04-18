import java.util.*;

class UFDS
{
    int[] parent;
    int[] rank;

    public UFDS(int size)
    {
	parent = new int[size];
	rank = new int[size];

	for (int i = 0; i < size; ++i)
	{
	    parent[i] = i;
	    rank[i] = 0;
	}
    }

    public int findParent(int x)
    {
	if (parent[x] == x) return x;

	return parent[x] = findParent(parent[x]);
    }

    public void union(int i, int j)
    {
	int parentI = findParent(i);
  	int parentJ = findParent(j);

	if (parentI != parentJ)
	{
	    if (rank[parentI] > rank[parentJ])
	    {
		parent[parentJ] = parentI;
	    }
	    else
	    {
		parent[parentI] = parentJ;

		if (rank[parentI] == rank[parentJ])
		{
		    rank[parentI]++;
		}
	    }
	}
    }
}

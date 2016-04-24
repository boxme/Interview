import java.util.*;

public class qn_10_1
{
    public List<Integer> mergeArrays(List<List<Integer>> listOfFiles, int k)
    {
	// k is the total number of files
	PriorityQueue<Pair> pq = new PriorityQueue<>(k);
	
	int[] indexes = new int[k];

	List<Integer> file;
	for (int i = 0; i < k; ++i)
	{
	    file = listOfFiles.get(i);
	    
	    pq.add(new Pair(i, file.get(0)));
	    
	    indexes[i] = 0;
	}
	
	List<Integer> sorted = new ArrayList<>();

	while (!pq.isEmpty())
	{
	    Pair pair = pq.pop();
	    sorted.add(pair.value);
	    indexes[pair.index]++;
	    
	    if (indexes[pair.index] < listOfFiles.get(pair.index).size())
	    {
		pq.add(new Pair(pair.index, listOfFiles.get(pair.index).get(pair.index));
	    }
	}

	return sorted;
    }
}

public class Pair implements Comparator<Pair>
{
    int index;
    int value;

    public Pair(int index, int value)
    {
	this.index = index;
	this.value = value;
    }

    @Override
    public int compare(Pair pair1, Pair pair2)
    {
	return pair1.value - pair2.value;
    }
}

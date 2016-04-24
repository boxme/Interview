import java.util.*;

public class qn_10_5
{
    public int getKthLargestInStream(List<Integer> streams, int k)
    {
	PriorityQueue<Integer> pq = new PriorityQueue<>(k);

	for (int i = 0; i < streams.size(); ++i)
	{
	    int value = streams.get(i);

	    if (pq.size() < k)
	    {
		pq.add(value);
	    }
	    else
	    {
		if (value > pq.peek())
		{
		    pq.pop();
		    pq.add(value);
		}
	    }
	}

	return pq.peek();
    }
}

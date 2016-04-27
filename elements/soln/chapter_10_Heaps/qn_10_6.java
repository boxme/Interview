import java.util.*;

public class qn_10_5
{
    public static void main(String[] args)
    {
    }

    public static List<Integer> approxiSort(List<Integer> stream, int k)
    {
	if (stream == null || stream.isEmpty())
	{
	    return null;
	}

	PriorityQueue<Integer> pq = new PriorityQueue<>(k);

	List<Integer> sorted = new ArrayList<>();

	for (Integer number : stream)
	{
	    if (pq.size() < k)
	    {
		pq.add(number);
	    }
	    else
	    {
		int curr = pq.peek();
		if (curr <= number)
		{
		    sorted.add(pq.poll());
		}
		else
		{
		    sorted.add(number);
		}
	    }
	}

	return sorted;
    }
}

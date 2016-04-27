import java.util.*;

public class qn_10_8
{
    public static void getMedianFromStream(List<Integer> stream)
    {
	// Keep the min element in the larger half of the stream
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	// Keep the max element in the smaller half of the stream
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	for (Integer number : stream)
	{
	    if (!maxHeap.isEmpty() && number > maxHeap.peek())
	    {
		minHeap.add(number);
	    } 
	    else 
	    {
		maxHeap.add(number);
	    }

	    // Try to keep both maxHeap & minHeap balanced with a difference of 1 in size
	    if (maxHeap.size() > minHeap.size() + 1)
	    {
		minHeap.add(maxHeap.poll());
	    }
	    else if (minHeap.size() > maxHeap.size() + 1)
	    {
		maxHeap.add(minHeap.poll());
	    }

	    // If both maxHeap & minHeap have the same size, then the median is the average between the top values
	    if (maxHeap.size() == minHeap.size())
	    {
		System.out.println((maxHeap.peek() + minHeap.peek()) / 2); 
	    }
	    else
	    {
		int median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
		System.out.println(median);
	    }
	}
    }
}

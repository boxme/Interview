import java.util.*;

public class qn_10_2
{
    public void sortKIncreasingDecreasingArray(List<Integer> A)
    {
	// Reverse the decreasing array to compose a list of sorted arrays
	List<List<Integer>> sortedArrays = new ArrayList<>();
	boolean isIncreasing = true;
	int startIndex = 0;

	for (int i = 1; i < A.size(); ++i)
	{   
	    int prev = A.get(i - 1);
	    int curr = A.get(i);
	    
	    if ((prev < curr && !isIncreasing) || (prev >= curr && isIncreasing))
	    {
		List<Integer> list = A.subList(startIndex, i);
		if (!isIncreasing)
		{
		    Collections.reverse(list);
		}
		sortedArrays.add(list);
		startIndex = i;
		isIncreasing = !isIncreasing;
	    }
	}

	// Pass sortedArrays into the solution in 10_1
    }
}

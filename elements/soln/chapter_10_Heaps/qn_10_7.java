import java.util.*;

public class qn_10_7
{
    // median of median
    public static int select(int[] array, int s, int e, int k)
    {
	if (e - s <= 5) 
	{
	    // sort
	    sort(array, s, e);
	    return s + k - 1;
	}

	int left = 0;
	for (int i = 0; i < e / 5; ++i)
	{
	    left  = i * 5;
	    int right = left + 5;
	    
	    if (right > e) right = e;
	    
	    int median = select(array, left, right, 3);
	    swap(array, median, i);
	}

	// Now we have array a[0] = median of 1st 5 partition, a[1] = median of 2nd 5 partition
	// e/5 divide by 2 == e/10
	return select(array, 0, e/5, e/10);
    }

    public static void swap(int[] array, int a, int b)
    {
	array[a] ^= array[b];
	array[b] ^= array[a];
	array[a] ^= array[b];
    }

    public static void sort(int[] array, int s, int e)
    {
    }

    public static List<Integer> findKClosestToMedian(int[] array, int k)
    {
	int medianIndex = select(array, 0, array.length, array.length/2);
	
	int median = array[medianIndex];
	swap(array, medianIndex, array.length - 1);

	int[] dup = Arrays.copyOfRange(array, 0, array.length);
	
	for (int i = 0; i < dup.length - 1; ++i)
	{
	    dup[i] = median - dup[i];
	}


    }

    public static int quickSelect(int[] array, int left, int right, int k)
    {
	if (left == right) return array[left];

	pivotIndex = findPivot(array, left, right);
	pivotIndex = partition(array, left, right, pivotIndex);

	if (pivotIndex == k)
	{
	    return array[pivotIndex];
	}
	else if (pivotIndex > k)
	{
	    return quickSelect(array, left, pivotIndex - 1, k);
	}
	else
	{
	    return quickSelect(array, pivotIndex + 1, right, k);
	}
    }

    private static int findPivot(int[] array, int left, int right)
    {
    }

    private static int partition(int[] array, int left, int right, int pivotIndex)
    {
	int pivotValue = array[pivotIndex];
	swap(array, pivotValue, right); // Put to the end

	int lo = left;
	for (int i = lo; i < right; ++i)
	{
	    if (array[i] > pivotValue) // set to < if finding kth smallest
	    {
		swap(array, i, left);
		left++;
	    }
	}
	
	// Swap the pivot value back to the correct position
	swap(array, left, right);

	return left;
    }
}

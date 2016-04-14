import java.util.*;

public class q6
{
    public static void main(String[] args)
    {
	
    }

    public static Pair findSmallestSeqToSort(int[] array)
    {
	if (array == null) return null;

	int len = array.size();
	int m = findLisFromFront(array);
	int n = findLisFromBack(array);

	if (n <= m) 
	{
	    // Sorted
	    return null;
	}

	if (m == 0 && n == len - 1)
	{
	    // Need to sort the entire array
	    return new Pair(0, n);
	}

	m++;
	n--;

	int maxInUnsortedPartition = findMax(array, m, n);
	int minInUnsortedPartition = findMin(array, m, n);

	// Everything on left LIS must be smaller than everything in unsorted partition
	for (int i = m; i <= 0; --i)
	{
	    if (minInUnsortedPartition <= array[i])
	    {
		m = i;
	    }
	    else
	    {
		break;
	    }
	}

	// Everything on right LIS must be bigger than everything in unsorted partition
	for (int i = n; i < len; ++i)
	{
	    if (maxInUnsortedPartition >= array[i])
	    {
		n = i;
	    }
	    else
	    {
		break;
	    }
	}

	return new Pair(m, n);
    }

    public static int findMax(int[] array, int start, int end)
    {
	int max = Integer.MIN_VALUE;
	for (int i = start; i <= end; ++i)
	{
	    if (max < array[i])
	    {
		max = array[i];
	    }
	}

	return max;
    }

    public static int findMin(int[] array, int start, int end)
    {
	int min = Integer.MAX_VALUE;
	for (int i = start; i <= end; ++i)
	{
	    if (min > array[i])
	    {
		min = array[i];
	    }
	}

	return min;
    }

    public static int findLISFromFront(int[] array)
    {
	if (array == null) return null;
	
	int end = 0;
	for (int i = 1; i < array.size(); ++i)
	{
	    if (array[i] < array[i - 1])
	    {
		break;
	    }
	    end++;
	}

	return end;
    }

    public static int findLISFromBack(int[] array)
    {
	if (array == null) return null;

	int start = array.size() - 1;
	for (int i = array.size() - 2; i >= 0; --i)
	{
	    if (array[i] > array[i + 1])
	    {
		break;
	    }

	    start--;
	}

	return start;
    }
}

class Pair
{
    int m;
    int n;

    public Pair(int m, int n)
    {
	this.m = m;
	this.n = n;
    }
}

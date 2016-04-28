import java.util.*;

public class repeat_qn_11_5
{
    public static int findSmallestInCyclicSortedArray(int[] array, int lo, int hi)
    {
	if (lo > hi) return -1;

	int mid = hi - lo / 2 + lo;

	int midValue = array[mid];
	int lowValue = array[lo];
	int hiValue = array[hi];

	if (hiValue < midValue)
	{
	    return findSmallestCyclicSortedArray(array, mid + 1, hi);
	}

	if (lowValue < midValue)
	{
	    return findSmallestCyclicSortedArray(array, lo, mid - 1);
	}

	if (lowValue > midValue)
	{
	    int index = findSmallestCyclicSortedArray(array, lo, mid - 1);
	    return index != -1 && array[index] < midValue ? index : mid;
	}

	return -1;
    }
}

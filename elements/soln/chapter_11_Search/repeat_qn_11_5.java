import java.util.*;

public class repeat_qn_11_5
{
    public static int findSmallestInCyclicSortedArray(int[] array, int lo, int hi)
    {
	if (lo > hi) return -1;

	int mid = hi - lo / 2 + lo;

	if (array[mid] > array[hi]) {
	    return findSmallestInCyclicSortedArray(array, mid+1, hi);
	}  else {
	    return findSmallestInCyclicSortedArray(array, lo, mid-1);
	}
    }
}

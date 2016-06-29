import java.util.*;

public class qn3 {
    
    public void solution(int[] array) {
	
    }

    // Find A[i] = i in sorted and distinct array
    public int findIndex(int[] array, int lo, int hi) {
	if (lo < 0) return -1;
	if (hi > array.length - 1) return -1;
	if (lo > hi) return -1;

	int mid = (hi - lo) / 2 + lo;

	int value = array[mid];

	if (mid == value) return mid;

	if (mid > value) return findIndex(array, mid+1, hi);

	return findIndex(array, lo, mid-1);
    }

    public int findMagicIndex(int[] array, int lo, int hi) {
	if (lo > hi || lo < 0 || hi > array.length - 1) return -1;

	int mid = (hi - lo) / 2 + lo;
	int midValue = array[mid];

	if (midValue == mid) return mid;

	// search left first
	int left = Math.min(mid - 1, midValue);
	int ans = findMagicIndex(array, lo, left);

	if (ans == -1) {
	    int right = Math.max(mid + 1, midValue);
	    ans = findMagicIndex(array, right, hi);
	}

	return ans;
    }
}

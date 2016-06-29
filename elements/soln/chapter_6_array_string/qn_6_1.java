import java.util.*;

public class qn_6_1 {

    public static void dutch_flag(int[] A, int index) {
	int pivot = A[index];
	int lo = 0;
	int hi = A.length - 1;
	int same = 0;

	while (same < hi) {
	    int val = A[hi];
	    if (val < pivot) {
		swap(A, lo, hi);
		lo++;
		same++;
	    } else if (val > pivot) {
		hi--;
	    } else {
		swap(A, same, hi);
		same++;
	    }
	}
    }

    private static void swap(int[] A, int a, int b) {
	A[a] ^= A[b];
	A[b] ^= A[a];
	A[a] ^= A[b];
    }
}

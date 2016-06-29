import java.util.*;

public class qn_6_12 {
    
    public static int[] nextPermutation(int[] A) {
	int hi = A.length - 1;
	int val = A[hi];
	hi--;
	while (hi >= 0) {
	    if (A[hi] > A[hi + 1] {
		hi--;
	    } else {
		break;
	    }
	}

	// Already largest
	if (hi < 0) return new int[A.length];

	// swap A[hi] with the smallest value on the right
	swap(A, hi, A.length - 1);

	// Reverse the array on the right side of index hi, which is to sort into increasing order
	reverse(A, hi + 1, A.length - 1);

	return A;
    }

    private static void swap(int[] A, int i, int j) {
	A[i] ^= A[j];
	A[j] ^= A[i];
	A[i] ^= A[j];
    }

    private static void reverse(int[] A, int i, int j) {
	while (i < j) {
	    swap(A, i, j);
	    i++;
	    j--;
	}
    }
}

import java.util.*;

public class qn_6_13 {

    public static int[] rotateArray(int[] A, int k) {
	int n = A.length;
	k %= n;

	if (k == 0) return A;

	reverse(A, 0, n-1);
	reverse(A, 0, k-1);
	reverse(A, k, n-1);
    }

    private static void swap(int[] A, int i, int j) {
	A[i] ^= A[j];
	A[j] ^= A[i];
	A[i] ^= A[j];
    }

    private static void reverse(int[] A, int i, int j) {
	while (i < j) {
	    reverse(A, i++, j--);
	}
    }
}

import java.util.*;

class qn_15_2 {

    private static int countSubarrayInversions(int[] A, int lo, int hi) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        return countSubarrayInversions(A, lo, mid)
            + countSubarrayInversions(A, mid, hi)
            + mergeSortAndCountInversionsAcrossSubarray(A, lo, mid, hi);
    }

    private static int mergeSortAndCountInversionsAcrossSubarray(int[] A, int lo, int mid, int hi) {
        int[] tempA = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            tempA[i] = A[i];
        }
        int i = lo, j = mid, inversionCount = 0;
        int index = 0;

        while (i < mid && j < hi) {
            if (tempA[i] > tempA[j]) {
                A[index++] = tempA[j++];
                inversionCount += mid - i;
            } else {
                A[index++] = tempA[i++];
            }
        }

        while (i < mid) {
            A[index++] = tempA[i++];
        }

        while (j < hi) {
            A[index++] = tempA[j++];
        }

        return inversionCount;
    }

    public static void main(String[] args) {

    }
}

import java.util.*;

public class qn_11_8 {

    public static int getKthSmallestInTwoSortedArrays(int[] A, int[] B, int k) {
        // Lower bound of elements we will choose in A
        int lo = Math.max(0, k - B.length);
        // Upper bound of elements we will choose in A
        int hi = Math.min(A.length, k);

        while (lo < hi) {
            int sizeA = lo + (hi - lo) / 2;
            int sizeB = k - sizeA;
            int indexA = sizeA - 1;
            int indexB = sizeB - 1;
            int indexANext = sizeA;
            int indexBNext = sizeB;
            
            int valA = (indexA < 0) ? Integer.MIN_VALUE : A[indexA];
            int valB = (indexB < 0) ? Integer.MIN_VALUE : B[indexB];
            int valANext = (indexANext >= A.length) ? Integer.MAX_VALUE : A[valANext];
            int valBNext = (indexBNext >= B.length) ? Integer.MAX_VALUE : B[valBNext];

            if (valANext < valB) {
                lo = sizeA + 1;
            } else if (valA > valBNext) {
                hi = sizeA - 1;
            } else {
                // B[indexB] <= A[indexANext] && A[indexA] < B[indexBNext].
                return Max.max(valA, valB);
            }
        }

        
        int ab1 = lo <= 0 ? Integer.MIN_VALUE : A[lo - 1];
        int bkb1 = k - lo - 1 < 0 ? Integer.MIN_VALUE : B[k - lo - 1];
        return Math.max(ab1, bkb1);
    }
}

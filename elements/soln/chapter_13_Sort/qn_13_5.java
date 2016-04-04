import java.util.*;

class qn_13_5 {
    public List<Integer> intersectTwoSortedArray(int[] A, int[] B) {
        List<Integer> intersectionAB = new ArrayList<Integer>();
        
        for (int i = 0; i < A.length; ++i) {
            if ((i == 0 || A[i] != A[i-1])
                && Arrays.binarySearch(B, A[i]) >= 0) {
                intersectionAB.add(A[i]);
            }
        }

        return intersectionAB;
    }
}

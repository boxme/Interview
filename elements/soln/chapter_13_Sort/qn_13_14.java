import java.util.*;

class qn_13_14 {
    
    public static boolean hasThreeSum(List<Integer> A, int t) {
        Collections.sort(A);
        for (Integer a : A) {
            // Finds if the sum of two numbers in A equals to t - a.
            if (hasTwoSum(A, t - a)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean hasTwoSum(List<Integer> A, int t) {
        int j = 0, k = A.size() - 1;
        
        while (j <= k) {
            if (A.get(j) + A.get(k) == t) {
                return true;
            } else if (A.get(j) + A.get(k) < t) {
                ++j;
            } else { // A[j] + A[k] > t.
                --k;
            }
        }
        return false;
    }
}

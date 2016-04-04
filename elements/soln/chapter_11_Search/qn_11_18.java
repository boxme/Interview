import java.util.*;

public class qn_11_18 {
    
    public static int searchCloseEntriesInArray(int[] A, int k) {
        int idx = 0;
        while (idx < A.length && A[idx] != k) {
            idx += Math.abs(A[idx] - k); // Fast forward to the next possible location to have K
        }

        return idx < A.length ? idx : -1;
    }
}

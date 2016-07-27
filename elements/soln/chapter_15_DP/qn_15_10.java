import java.util.*;

// Searching for a sequence in a 2D array
public class qn_15_10 {
    private Map<Tuple, Boolean> map = new HashMap<>();
    private int[][] A;
    private int[] S;

    public boolean sequenceIn2DArray(int[][] A, int[] S) {
        this.A = A;
        this.S = S;

        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (match(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean match(int i, int j, int len) {
        if (map.containsKey(new Tuple(i, j, len))) {
            return false;
        }

        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length) {
            return false;
        }

        if (len == s.length) return true;

        if (A[i][j] == S[len]) {
            if (match(i+1, j, len+1)) return true;
            if (match(i-1, j, len+1)) return true;
            if (match(i, j+1, len+1)) return true;
            if (match(i, j-1, len+1)) return true;
        }

        map.put(new Tuple(i, j, len), false);
        return false;
    }
}

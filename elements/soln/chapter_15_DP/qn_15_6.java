import java.util.*;

class qn_15_6 {
    public static int LIS(int[] array) {
        int[] longIncreasingSeq = new int[array.length];
        longIncreasingSeq[0] = 1;

        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[i] > array[j]) {
                    longIncreasingSeq[i] = Math.max(longIncreasingSeq[i], longIncreasingSeq[i] + 1);
                }
            }
        }

        // Find the largest
        int longestSeq = 0;
        for (int i = 0; i < array.length; ++i) {
            longestSeq = Math.max(longestSeq, longIncreasingSeq[i]);
        }

        return longestSeq;
    }
}

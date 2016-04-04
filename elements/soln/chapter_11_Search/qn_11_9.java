import java.util.*;

public class qn_11_9 {
    public static int squareRoot(int n) {
        int lo = 0;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long midSquare = mid * mid;
            if (midSquare < n) {
                lo = mid + 1;
            } else if (midSquare > n) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return lo - 1;
    }
}

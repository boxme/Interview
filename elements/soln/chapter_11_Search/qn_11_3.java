import java.util.*;

class qn_11_3 {

    public int searchForEntryEqualToItsIndex(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int value = array[mid] - mid;

            if (value = 0) {
                return mid;
            } else if (value < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}

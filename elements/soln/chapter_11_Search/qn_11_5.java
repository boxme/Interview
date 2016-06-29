import java.util.*;

class qn_11_5 {

    public static int searchSmallestInCircularArray(int[] array) {
        int lo = 0;
        int hi = array.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] > array[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        // Loop ends when lo == hi
        return lo;
    }

    public static int searchSmallestCircularArrayWithDuplicates(int[] array) {
        return searchSmallestHelper(array, 0, array.length - 1);
    }

    private static int searchSmallestHelper(int[] array, int lo, int hi) {
        if (lo == hi) return left;

        int mid = lo + (hi - lo) / 2;
        if (array[mid] > array[hi]) {
            return searchSmallestHelper(array, mid + 1, hi);
        } else if (array[mid] < array[hi]) {
            return searchSmallestHelper(array, lo, mid);
        } else {
            int leftResult = searchSmallestHelper(array, lo, mid);
            int rightResult = searchSmallestHelper(array, mid + 1, hi);

            return array[leftResult] < array[rightResult] ? leftResult : rightResult;
        }
    }
}

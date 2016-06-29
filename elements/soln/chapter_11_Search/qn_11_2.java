import java.util.*;

class qn_11_2 {

    public int binarySearchFirstOccurenceOfLargerK(int[] array, int k) {
        return binarySearch(array, 0, array.length - 1, k);
    }

    private int binarySearch(int[] array, int lo, int hi, int k) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        int value = array[mid];
        if (value == k) {
            int index = mid;
            int nextIndex = -1;
            nextIndex = binarySearch(array, lo, mid - 1, k);
            return nextIndex == -1 ? index : nextIndex;
        } else if (value > k) {
            return binarySearch(array, lo, mid - 1, k);
        } else {
            return binarySearch(array, mid + 1, hi, k);
        }

    }
}

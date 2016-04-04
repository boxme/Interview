import java.util*;

class qn_11_1 {

    public int binarySearch(int[] array, int k) {
        return binarySearch(array, 0, array.length - 1, k);
    }

    private int binarySearch(int[] array, int lo, int hi, int k) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        int value = array[mid];

        if (value >= k) {
            int firstIndex = -1;
            if (value == k) {
                firstIndex = mid;
            }
            int smallerIndex = binarySearch(array, lo, mid - 1, k);
            return smallerIndex == -1 ? firstIndex : smallerIndex;
        } else {
            return binarySearch(array, mid + 1, hi, k);
        }
    }
}

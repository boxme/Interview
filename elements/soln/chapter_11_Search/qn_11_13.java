import java.tuil.*;

class qn_11_13 {

    public static int findKthLargestInUnsortedArray(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        
        if (k >= hi + 1) throw new RuntimeException("no k-th node in array");
        
        Random r = new Random();
        while (lo <= hi) {
            // Generate a random pivot int in [lo, hi]
            int pivotIdx = r.nextInt(hi - lo + 1) + lo;
            int sortedIdx = quickSelect(lo, hi, pivotIdx, array);

            if (sortedIdx < k - 1) {
                lo = sortedIdx + 1;
            } else if (sortedIdx > k - 1) {
                hi = sortedIdx - 1;
            } else if (sortedIdx == k - 1) {
                return array[sortedIdx];
            }
        }
    }

    public static int quickSelect(int lo, int hi, int pivotIdx, int[] array) {
        int value = array[pivotIdx];
        swap(hi, pivotIdx, array); // Move pivot to the end instead of left as in quicksort

        int left = lo;
        for (int i = lo; i < hi; ++i) {
            if (array[i] > value) { // If searching for smallest k-th, then do array[i] < value
                swap(i, left, array);
                left++;
            }
        }
        swap(left, hi, array);
        return left;
    }

    private static void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

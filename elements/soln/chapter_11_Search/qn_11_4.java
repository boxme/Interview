import java.util.*;

class qn_11_4 {
    
    // Hashmap method that requires O(n) extra space, gives O(n) complexity
    public Pair searchPairInAbsSortedArray(int[] array, int k) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; ++i) {
            if (hashMap.containsKey(array[i])) {
                return new Pair(hashMap.get(array[i]), i);
            } else {
                hashMap.put(k - array[i], i);
            }
        }

        return new Pair(-1, -1);
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // O(n) complexity & O(1) extra space method. But will only work on normal sorted array
    public static Pair searchPairInNormalSortedArray(int[] array, int k)
    {
	int lo = 0;
	int hi = array.length - 1;

	while (lo < hi)
	{
	    int sum = array[lo] + array[hi];
	    if (sum == k)
	    {
		return new Pair(lo, hi);
	    }
	    else if (sum > k)
	    {
		hi--;
	    }
	    else
	    {
		lo--;
	    }
	}

	return new Pair(-1, -1);
    }
}

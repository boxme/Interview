import java.util.*;

class qn_11_4 {
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
}

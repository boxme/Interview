import java.util.*;
import java.io.*;

public class qn_11_14 {

    private static class Greater implements Comparator<Integer> {
        @Override
        public int compareTo(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    private static void nthElement(List<Integer> list) {
        Collections.sort(list, new Greater());
        // Can use quick select instead of sorting here. To reduce the total runtime
        // Quick select is used for qn_11_13
    }

    public static int findKthLargestUnknownLength(InputStream in, int k) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());

            if (list.size() == (k * 2) - 1) {
                nthElement(list);
            }

            list = new ArrayList<Integer>(list.subList(0, k));
        }

        nthElement(list);
        return list.get(k-1);
    }
}

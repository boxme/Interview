import java.util.*;

public class qn_16_2 {
    // Use BFS because the weigth of the path is constant at 1
    public static int transformString(Set<String> D, String s, String t) {
        LinkedList<Pair<String, Integer>> q = new LinkedList<>();
        D.remove(s); // Mark as visited
        q.offer(new Pair<>(s, 0));

        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.peek();

            if (curr.getFirst().equals(t)) {
                return curr.getSecond();
            }

            // Tries all possible transformations of curr.first
            String str = curr.getFirst();
            for (int i = 0; i < str.length(); ++i) {
                String strStart = i == 0 ? "" : str.substring(0, i);
                String strEnd = i + 1 < str.length() ? str.substring(i + 1) : "";
                for (int j = 0; j < 26; ++j) { // Iterates through 'a' ~ 'z'.
                    String modStr = strStart + (char)('a' + j) + strEnd;
                    if (D.remove(modStr)) {
                        q.offer(new Pair<>(modStr, curr.getSecond() + 1));
                    }
                }
            }
            q.poll();
        }
        
        return -1; // Cannot find a possible transformations.
    }
}

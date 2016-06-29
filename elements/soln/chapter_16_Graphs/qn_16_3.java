import java.util.*;

public class qn_16_3 {
    public static class GraphVertex {
        public int d = -1;
        public List<GraphVertex> edges = new ArrayList<>();
    }
    
    public static boolean isAnyPlacementFeasible(List<GraphVertex> G) {
        for (GraphVertex v : G) {
            if (v.d == -1) { // unvisited vertex.
                v.d = 0;
                if (!BFS(v)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean BFS(GraphVertex s) {
        LinkedList<GraphVertex> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {
            GraphVertex curr = q.peek();
            for (GraphVertex next : curr.edges) {
                if (next.d != -1) {
                    if (next.d == curr.d) return false;
                } else {
                    next.d = 1 - curr.d;
                    q.offer(next);
                }
            }

            q.poll();
        }

        return true;
    }

    private static boolean DFS(GraphVertex s) {
        for (GraphVertex next : s.edges) {
            if (next.d == -1) {
                next.d = 1 - s.d;

                if (!DFS(next)) {
                    return false;
                }
            } else if (next.d == s.d){
                return false;
            }
        }

        return true;
    }
}

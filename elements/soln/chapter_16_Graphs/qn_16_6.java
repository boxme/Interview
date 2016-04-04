import java.util.*;

public class qn_16_6 {
    public static class Constraints {
        int a, int b;
    }

    public static class Vertex {
        int value;
        int group;
        List<Vertex> edges;

        public Vertex(int value) {
            this.value = value;
            group = -1;
            edges = new ArrayList<Vertex>();
        }
    }

    private static void DFS(Vertex curr, int index) {
        for (Vertex next : curr.edges) {
            if (next.group != index) {
                next.group = index;
                DFS(next, index);
            }
        }
    }

    public static boolean areConstraintsSatisfied(List<Constraints> E, List<Constraints> I) {
        List<Vertex> graph = new ArrayList<Vertex>();
        for (int i = 0; i < 100; i++) graph.add(new Vertex(i));

        // Build graph using equality constraints
        for (Constraints c : E) {
            graph.get(c.a).edges.add(new Vertex(c.b));
            graph.get(c.b).edges.add(new Vertex(c.a));
        }

        // DFS to label each connected component
        for (Vertex vertex : graph) {
            if (vertex.group == -1) {
                vertex.group = vertex.value;
                DFS(vertex, vertex.index);
            }
        }

        // Check using the inequality constraints
        for (Constraints c : I) {
            if (graph.get(c.a).group == graph.get(c.b).group) {
                return false;
            }
        }

        return true;
    }
}

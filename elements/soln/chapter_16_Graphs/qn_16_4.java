import java.util.*;

public class qn_16_4 {
    
    public static class GraphVertex {
        public enum Color { WHITE, GRAY, BLACK }
        
        public Color color;
        public List<GraphVertex> edges;
        
        public GraphVertex() {
            color = Color.WHITE;
            edges = new ArrayList<>();
        }
        
        @Override
        public String toString() {
            return edges.toString();
        }
    }

    public static boolean doesUndirectedGraphContainCycle(List<GraphVertex> graph) {
        if (!graph.isEmpty()) {
            DFS(graph.get(0));
        }

        return false;
    }

    private static boolean DFS(GraphVertex curr, GraphVertex pre) {
        // Cycle detected
        if (curr.color == GraphVertex.Color.GRAY) {
            return true;
        }

        // Mark the color to be gray to represent that it has been
        // visited but not done with processing
        curr.color = GraphVertex.Color.GRAY;

        for (GraphVertex next : curr.edges) {
            if (next != pre && next.color != GraphVertex.Color.BLACK) {
                if (DFS(next, curr)) {
                    return true;
                }
            }
        }

        // Marks current vertex to be black to represent that
        // it has finished processing
        curr.color = GraphVertex.BLACK;
        return false;
    }
    
    public static class Vertex {
        public int d, l; // discovery and leaving time.
        public List<Vertex> edges;
        
        public Vertex() {
            d = 0;
            l = Integer.MAX_VALUE;
            edges = new ArrayList<>();
        }
        
        @Override
        public String toString() {
            return edges.toString();
        }
    }

    public static boolean isUndirectedGraphAllInACycle(List<Vertex> graph) {
        if (!graph.isEmpty()) {
            DFS(graph.get(0), null, 0);
        }

        return false;
    }

    private static boolean DFS(Vertex curr, Vertex prev, int time) {
        curr.d = ++time;
        curr.l = Integer.MAX_VALUE;

        For (Vertex next : curr.edges) {
            if (next != prev) {
                if (next.d != 0) {
                    curr.l = Math.min(curr.l, next.d);
                } else {
                    if (!DFS(next, curr, time)) {
                        return false;
                    }

                    curr.l = Math.min(curr.l, next.l);
                }
            }
        }

        return (prev == null || curr.l < curr.d);
    }
}

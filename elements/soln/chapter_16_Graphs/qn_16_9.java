import java.util.*;

public class qn_16_9 {
    
    public static class Vertex{
        int weight = 0;
        int index = -1;
        List<Vertex> edges = new ArrayList<Vertex>();
    }

    public static class GraphVertex implements Comparable<GraphVertex> {
        int index;
        int weight = 0;
        int dist = 0;

        public GraphVertex(int index, int dist, int weight) {
            this.index = index;
            this.dist = dist;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(GraphVertex o) {
            if (this.weight == o.weight) {
                return this.dist - o.dist;
            } else {
                return this.weight - o.weight;
            }
        }
    }

    private void findShortestPath(List<Vertex> graph, Vertex start, Vertex end) {
        PriorityQueue<GraphVertex> pq = new PriorityQueue<GraphVertex>();
        int[] parents = new int[100];
        int[] dist = new int[100];
        Arrays.fill(dist, 1000000);

        dist[start.index] = 0;
        pq.add(new GraphVertex(start.index, 0, 0));

        while (!pq.isEmpty()) {
            GraphVertex curr = pq.poll();
            
            if (curr.index == end.index) break;
            if (curr.weight > dist[curr.index]) continue;

            for (Vertex next : graph.get(curr.index).edges) {
                if (dist[curr.index] + next.weight < dist[next.index]) {
                    dist[next.index] = next.weight + dist[curr.index];
                    parent[next.index] = curr.index;
                    pq.add(new GraphVertex(next.index, dist[next.index], curr.dist + 1));
                }
            }
        }

        // Print the shortest path
        int index = end.index;
        System.out.print(index + ", ");
        while (parents[index] != 0) {
            System.out.print(parents[index] + ", ");
            index = parents[index];
        }
        System.out.println(parents[index] + "");
    }

    public static void shortestPathWithMinEdges(List<Vertex> graph, Vertex start, Vertex end) {
        findShortestPath(graph, start, end);
    }
}

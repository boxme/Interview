import java.util.*;

class qn_15_4 {
    
    public static void main(String[] args) {

    }

    // tree is undirected
    private static int findDiameterOfTree(List<Vertex> tree) {
        // DFS/BFS from any vertex to find the further vertex
        // from that vertex
        int[] weight = new int[tree.size()];
        Arrays.fill(weight, -1);

        weight[0] = 0;
        DFS(tree, 0);

        int furtherVetex = 0;
        int maxDist = 0;
        for (int i = 0; i < tree.size(); ++i) {
            if (weight[i] > maxDist) {
                maxDist = weight[i];
                furtherVertex = i;
            }
        }

        // DFS/BFS again from the above furthest vertex to find
        // the true longest distance, which is the diameter
        Arrays.fill(weight, -1);
        weight[furtherVertex] = 0;
        DFS(tree, furtherVertex);
        
        for (int i = 0; i < tree.size(); ++i) {
            if (weight[i] > maxDist) {
                maxDist = weight[i];
                furtherVertex = i;
            }
        }
        
        // Diameter of the tree
        return maxDist;
    }

    private static void DFS(List<Vertex> tree, int vertex) {
        for (Vertex curr : tree.get(vertex)) {
            if (weight[curr.value] == -1) {
                // Unvisited
                weight[curr.value] = curr.weight + weight[vertex];
                DFS(tree, curr.value);
            }
        }
    }

    private static void BFS(List<Vertex> tree, int vertex) {
        LinkedList<Integer> q = new LinkedList<>();
        
        q.offer(vertex);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Vertex vertex : tree.get(curr)) {
                if (weight[vertex.value] == -1) {
                    // Unvisited
                    weight[vertex.value] = vertex.weight + weight[curr];
                    q.offer(vertex.value);
                }
            }
        }
    }
}

public static class Vertex {
    public int value;
    public int weight;
}

public static class Node {
    int value;
    Node parent;
    List<Node> children;

    public Node() {
        parent = null;
        children = new ArrayList<>();
    }
}

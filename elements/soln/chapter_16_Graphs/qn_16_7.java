import java.util.*;

public class qn_16_7 {
    public static class Vertex {
        boolean visited = false;
        int maxDist = 1;
        List<Vertex> edges = new ArrayList<Vertex>();
    }

    private static Stack<Vertex> topoSort(List<Vertex> graph) {
        Stack<Vertex> stack = new Stack<Vertex>();
        for (Vertex curr : graph) {
            if (!curr.visited) {
                curr.visited = true;
                DFS(curr, stack);
            }
        }

        return stack;
    }

    private static void DFS(Vertex curr, Stack<Vertex> stack) {
        for (Vertex next : curr.edges) {
            if (!next.visited) {
                next.visited = true;
                DFS(next, stack);
            }
        }

        stack.push(curr);
    }

    public static int findLargestNumberTeams(List<Vertex> graph) {
        Stack<Vertex> stack = topoSort(graph);
        return findLongestPath(stack);
    }

    private static int findLongestPath(Stack<Vertex> topoOrder) {
        int maxDist = 0;
        while (!topoOrder.isEmpty()) {
            Vertex curr = topoOrder.pop();
            maxDist = Math.max(maxDist, curr.maxDist);

            for (Vertex next : curr.edges) {
                maxDist = Math.max(maxDist, curr.maxDist + 1);
            }
        }

        return maxDist;
    }
}

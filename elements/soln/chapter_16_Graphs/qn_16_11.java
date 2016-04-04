import java.util.*;

public class qn_16_11 {
    public static class HighwaySection {
        public int x, y;
        public double distance;
        
        public HighwaySection(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static void floydWarshall(int[][] G) {
        int n = G.length;

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
                }
            }
        }
    }
    
    public static HighwaySection findBestProposal(
            List<HighwaySection> H, List<HighwaySection> P, int a, int b, int n) {
        
        int[][] G = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(G[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; ++i) {
            G[i][i] = 0;
        }

        // Build the graph
        for (HighwaySection section : H) {
            G[section.x][section.y] = section.distance;
        }

        // Build the shortest path between each vertices
        floydWarshall(G);

        // Examine each propoal
        HighwaySecton bestProposal;
        int minDist = G[a][b];
        for (HighwaySection p : P) {
            
            // Check for both direction
            if (minDist > G[a][p.x] + p.distance + G[p.y][b]) {
                minDist = G[a][p.x] + p.distance + G[p.y][b];
                bestProposal = p;
            }

            if (minDist > G[a][p.y] + p.distance + G[p.x][b]) {
                minDist = G[a][p.y] + p.distance + G[p.x][b];
                bestProposal = p;
            }
        }

        return bestProposal;
    }


}

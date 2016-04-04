import java.util.*;

public class qn_16_12 {

    public static boolean doesArbitrageExist(double[][] G) {
        for (int i = 0; i < G.length; ++i) {
            for (int j = 0; j < G[i].length; ++j) {
                G[i][j] = -Math.log(G[i][j]);
            }
        }

        return bellmanFord(G, 0);
    }

    private static boolean bellmanFord(double[][] G, int start) {
        double[] distToSource = new double[G.length];
        Arrays.fill(distToSource, Double.MAX_VALUE);
        distToSource[start] = 0;

        for (int times = 0; times < G.length; ++times) {
            for (int i = 0; i < G.length; ++i) {
                for (int j = 0; j < G[i].length; ++j) {
                    if (distToSource[j] > distToSource[i] + G[i][j]) {
                        distToSource[j] = distToSource[i] + G[i][j];
                    }
                }
            }
        }
        

        // Detects circle
        for (int i = 0; i < G.length; ++i) {
            for (int j = 0; j < G[i].length; ++j) {
                if (distToSource[j] > distToSource[i] + G[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

import java.util.*;

public class qn_16_1 {
    private static final int NOT_VISITED = 0;
    private static final int VISITED = 1;

    //Direction N, S, E, W
    int[] x = {0, 0, -1, 1};
    int[] y = {1, -1, 0, 0};

    int[][] visited;
    int row = 0, col = 0;

    Stack<Pair> stack = new Stack<Pair>();

    private static void DFS(int[][] A,  Pair start, Pair end) {
        stack.push(start);

        while (!stack.empty()) {
            Pair curr = stack.pop();
            visited[curr.x][curr.y] = VISITED;

            for (int i = 0; i < 4; ++i) {
                int newX = curr.x + x[i];
                int newY = curr.y + y[i];

                if (newX < row && newY < col && visited[newX][newY] == NOT_VISITED 
                        && A[newX][newY] == WHITE) {

                    if (newX = end.x && newY = end.y) {
                        // Found the end
                        stack.push(curr);
                        return;
                    }
                    stack.push(curr);
                    stack.push(new Pair(newX, newY));
                }
            }
        }
    }

    public static void searchPathIn2DArray(int[][] A, Pair start, Pair end) {
        row = A.length;
        if (row > 0) col = A[0].length;

        visited = new int[row][col];
        
    }
}

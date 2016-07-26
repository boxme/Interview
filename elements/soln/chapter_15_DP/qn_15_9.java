import java.util.*;

public class qn_15_9 {
    // Largest 2D subarray containing only 1s
    public int maxSubArray(int[][] A) {
        int n = A.length;
        int m = A.length;
        MaxHW[][] table = new MaxHW[n][m];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                table[i][j] = A[i][j] == 1 
                    ? new MaxHW(i+1 < n ? table[i+1][j].h + 1 : 1, j+1 < m ? table[i][j+1].w + 1 : 1); 
                    : new MaxHW(0, 0);
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n: ++i) {
            for (int j = 0; j < m; ++j) {
                MaxHW maxHW = table[i][j];
                if (A[i][j] == 1 && (maxHW.h * maxHW.w > maxArea)) {
                    int minWidth = Integer.MAX_VALUE;
                    for (int a = 0; a < maxHW.h; ++a) {
                        minWidth = Math.min(minWidth, table[a + i][j].w);
                        maxArea = Math.max(maxArea, minWidth * (a + 1));
                    }
                }
            }
        }

        return maxArea;
    }

    // For square
    public int maxSquareSubArray(int[][] A) {
        int n = A.length;
        int m = A.length;
        MaxHW[][] table = new MaxHW[n][m];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                table[i][j] = A[i][j] == 1 
                    ? new MaxHW(i+1 < n ? table[i+1][j].h + 1 : 1, j+1 < m ? table[i][j+1].w + 1 : 1); 
                    : new MaxHW(0, 0);
            }
        }

        int[][] s = new int[n][m];
        int maxArea = 0;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int side = Math.min(table[i][j].w, table[i][j].h);
                if (A[i][j] == 1) {
                    if (i+1 < n && j+1 < m) {
                        side = Math.min(s[i+1][j+1] + 1, side);
                    }
                    s[i][j] = side;
                    maxArea = Math.max(maxArea, side * side);
                }
            }
        }

        return maxArea;
    }
}

private static class MaxHW {
    int h;
    int w;

    public MaxHW(int h, int w) {
        this.h = h;
        this.w;
    }
}

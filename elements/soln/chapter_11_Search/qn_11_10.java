import java.util.*;

class qn_11_10 {
    public static boolean matrixSearch(int[][] A, int x) {
        int row = 0, col = A[0].length - 1; // Starting from the top right corner.
        // Keeps searching if there are unclassified rows and columns.
        while (row < A.length && col >= 0) {
            if (A[row][col] == x) {
                return true;
            } else if (A[row][col] < x) {
                ++row; // Eliminate this row.
            } else { // A[row][col] > x.
                --col; // Eliminate this column.
            }
        }
        return false;
    }
}

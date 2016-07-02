import java.util.*;

public class qn_6_14 {
    
    private int[][] board;

    public static boolean isSudokuValid(int[][] board) {
        this.board = board;
	return backtrack(0, 0);
    }

    private static boolean backtrack(int row, int col) {
        if (row == 9 || col == 9) return true;

        if (board[row][col] != 0) {
	    if (col == 8) return backtrack(row + 1, 0);
	    
	    return backtrack(row, col+1);
	}
        
	int nextRow = col == 8 ? row + 1 : row;
	int nextCol = col == 8 ? 0 : col + 1;

	for (int i = 1; i <= 9; ++i) {
	    if (isDigitValid(row, col, i)) {
	        board[row][col] = i;
	        if (backtrack(nextRow, nextCol)) return true;
	    }
	}

        return false;
    }

    private static boolean isDigitValid(int row, int col, int num) {
        return isRowValid(row, num) && isColValid(col, num) && isSmallSquareValid(row, col, num);
    }

    private static boolean isRowValid(int row, int number) {
	for (int i = 0; i < 9; ++i) {
	    if (number == board[row][i]) return false;
	}

	return true;
    }

    private static boolean isColValid(int col, int number) {
        for (int i = 0; i < 9; ++i) {
	    if (number == board[i][col]) return false;
	}

	return true;
    }

    private static boolean isSmallSquareValid(int row, int col, int num) {
        int startRow = 3 * (row / 3); int startCol = 3 * (col / 3);

	for (int i = startRow; i < startRow + 3; ++i) 
	    for (int j = startCol; j < startCol + 3; ++j)
	        if (board[i][j] == num) return false;

	return true;
    }
}

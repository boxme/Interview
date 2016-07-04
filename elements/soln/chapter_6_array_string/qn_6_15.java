import java.util.*;

public qn_6_15 {

    private int[][] array;
    private int n;

    public static void solution(int[][] array) {
        this.array = array;
        this.n = array.length;

	printArrayInClockwise(0);

	// Special condition: if n is odd, print the middle element
	if (n % 2 != 0) System.out.print(" " + array[n / 2][n / 2]);
    }

    private static void printArrayInClockwise(int offset) {
        if (offset == n / 2) return;

	printLeftToRight(offset, offset, offset);
	printTopToBtm(offset, offset, n - 1 - offset);
	printRightToLeft(offset, n - 1 - offset, n - 1 - offset);
	printBtmTotop(offset, n - 1 - offset, offset);

	printArrayInClockWise(offset + 1);
    }

    private static void printLeftToRight(int offset, int row, int col) {
        for (int i = col; i < n - 1 - offset; ++i) {
	    if (row == 0 && i == 0) System.out.print(array[row][i]);
	    else                    System.out.print(" " + array[row][i]);
	}
    }

    private static void printTopToBtm(int offset, int row, int col) {
        for (int i = row; i < n - 1 - offset; ++i)
	    System.out.print(" " + array[i][col]);
    }

    private static void printRightToLeft(int offset, int row, int col) {
        for (int i = col; i > offset; --i)
	    System.out.print(" " + array[row][i]);
    }

    private static void printBtmToTop(int offset, int row, int col) {
        for (int i = row; i > offset; --i) 
	    System.out.print(" " + array[i][col]);
    }
}

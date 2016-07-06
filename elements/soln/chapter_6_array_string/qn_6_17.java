import java.util.*;

// Rotate a 2D array clockwise
public class qn_6_17 {
    
    private int[][] array;

    public void solution(int[][] array) {
        int n = array.length;
        this.array = array;
	int offset = 0;

	for (int offset = 0; i < n / 2; offset++) {
	    for (int i = offset; i < n - 1 - offset; ++i) {
	        int value = array[offset][i];
		value = swap(i, n - 1 - offset, value);
		value = swap(n - 1 - i, n - 1 - offset, value);
		value = swap(n - 1 - i, offset, value);
		array[offset][i] = value;
	    }
	}
    }

    private int swap(int toRow, int toCol, int value) {
        int temp = array[toRow][toCol];
	array[toRow][toCol] = value;
	return temp;
    }
}

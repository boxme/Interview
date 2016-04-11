import java.util.*;

public static void main(String[] args)
{
    
}

// 2D binary search
// M X N array
public static Pair 2dBinarySearch(int[][] array, int left, int right, int top, int btm, int num)
{
    if (array == null) return null;
    if (left > right) return null;
    if (top > btm) return null;

    int midCol = right - left / 2 + left;
    int midRow = btm - top / 2 + top;

    if (array[midRow][midCol] == num) return new Pair(midRow, midCol);

    // Check row range
    if (array[midRow][left] <= num && num <= array[midRow][right)
    {
	// Stick with this row

	if (array[midRow][midCol] < num)
	{
	    // Search right on this row
	    return 2dBinarySearch(array, midCol + 1, right, top, btm, num);
	}
	
	// Search left
	return 2dBinarySearch(array, left, midCol - 1, top, btm, num);
    }
    
    // Need to move out of this row
    if (array[midRow][midCol] < num)
    {
	// Move down the row & restart the left & right
	return 2dBinarySearch(array, 0, M, midRow + 1, btm, num); 
    }

    // Need to moveup the row & restart left & right
    return 2dBinarySearch(array, 0, M, top, midRow - 1, num);
}

class Pair
{
    int row;
    int col;

    public Pair(int row, int col)
    {
	this.row = row;
	this.col = col;
    }
}

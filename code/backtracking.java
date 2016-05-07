import java.util.*;

// UVa 750 solution
public class backtracking 
{
    private int a, b;
    private int[] cols;

    public void solution(int rowOfQueen, int colOfQueen)
    {
	a = rowOfQueen;
	b = colOfQueen;
	// 8x8 chessboard
	cols = new int[8];
	
	backTracking(0);
    }

    private void backTracking(int col)
    {
	if (col == 8) 
	{
	    if (cols[b] == a) 
	    {
		// Print solutions
		for (int col = 0; col < 8; ++i)
		{
		    System.out.print(cols[col] + " ");
		}
	    }

	    return;
	}
	
	for (int row = 0; row < 8; ++i)
	{
	    if (canPlaceQueenOnBoard(row, col))
	    {
		cols[col] = row;
		backTracking(col + 1);
	    }
	}
    }

    private boolean canPlaceQueenOnBoard(int row, int col)
    {
	for (int prev = col - 1; prev >= 0; prev--)
	{
	    if (cols[i] == row || Math.abs(prev - col) == Math.abs(cols[i] - row)) 
	    {
		return false;
	    }
	}

	return true;
    }
}

import java.util.*;

public class backtrack_sudoku
{
    private int[][] board = new int[9][9];

    public void solution()
    {
	// Fill up the board with numbers
	fillBoard();
	
	backtrack();
    }

    private boolean backtrack()
    {
	Pair pair = findNextEmptySlot();
	if (pair == null) 
	{
	    // Filled up all, print answer
	    return true;
	}

	for (int digit = 1; i <= 9; ++i)
	{
	    if (isSafe(pair.row, pair.col, digit)
	    {
		board[pair.row][pair.col] = digit;

		if (backtrack())
		{
		    return true;
		}
		board[pair.row][pair.col] = 0;
	    } 
	}

	retur false;
    }

    private void fillBoard()
    {
    }

    private Pair findNextEmptySlot()
    {
	for (int i = 0; i < 9; ++i)
	{
	    for (int j = 0; j < 9; ++j)
	    {
		if (board[i][j] == 0) return new Pair(i, j);
	    }
	}

	return null;
    }

    private boolean isSafe(int row, int col, int num)
    {
	return validRow(row, num) && validCol(col, num) && validBox(row, col, num);
    }

    private boolean validRow(int row, int num)
    {
	for (int i = 0; i < 9; ++i)
	{
	    if (board[row][i] == num) return false;
	}

	return true;
    }

    private boolean validCol(int col, int num)
    {
	for (int i = 0; i < 9; ++i)
	{
	    if (board[i][col] == num) return false;
	}

	return true;
    }

    private boolean validBox(int row, int col, int num)
    {
	int startingRow = 3 * (row / 3);
	int startingCol = 3 * (col / 3);

	for (int i = startingCol; i < startingCol + 3; i++)
	{
	    for (int j = startingRow; j < startingRow + 3; ++j)
	    {
		if (board[j][i] == num) return false;
	    }
	}
	return true;
    }
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

import java.util.*;

public class q2
{
    public static void main(String[] args)
    {
    }
}

class TitTacToe
{
    State[][] board;
    int win;

    public TitTacToe(int n)
    {
	win = n;
	board = new State[n][n];
    }

    public boolean hasWon(int row, int col, State move)
    {
	if (board[row][col] != State.BLANK) return false;

	board[row][col] = move;

	int count = 0;

	// Check col
	int idx = win - 1;
	while (idx >= 0)
	{
	    if (board[idx][col] != move) break;
	    count++;
	    idx--;
	}
	if (count == win) return true;

	// Check row
	idx = win - 1;
	count = 0;
	while (idx >=0)
	{
	    if (board[row][idx] != move) break;
	    count++;
	    idx--;
	}
	if (count == win) return true;
	
	// Check diagonal
	if (row == col)
	{
	    for (int i = 0; i < win; ++i)
	    {
		if (board[i][i] != move) break;

		if (i == win - 1) return true;
	    }
	}

	// Check anti diagonal
	for (int i = 0; i < win; ++i)
	{
	    if (board[i][win - i - 1] != move) break;

	    if (i == win - 1) return true;
	}

	return false;
    }
}

public enum State
{
    BLANK;
    X;
    O;
}

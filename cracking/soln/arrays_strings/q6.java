import java.util.*;

public static void main(String[] args)
{
  
}

class Solution
{
    
}

class Rotate90
{
    int[][] array;

    public int[][] rotate(int[][] a)
    {
	if (array == null) return null;

	array = a;
	
	// Assume square
	int N = a.size();
	
	Pair topLeft = new Pair();
	Pair topRight = new Pair();
	Pair btmLeft = new Pair();
	Pair btmRight = new Pair();

	int (int i = 0; i < N / 2; ++i)
	{
	    topLeft.setRow(i);
	    topRight.setCol(N - 1 - i);
	    btmLeft.setCol(N - 1 - i);
	    btmRight.setRow(N - 1 - i);

	    for (int j = i; j < N - 1 - i; j++)
	    {
		topLeft.setCol(j);
		topRight.setRow(j);
		btmLeft.setRow(N - 1 - j);
		btmRight.setCol(N - 1 - j);

		swap(topLeft, topRight, btmLeft, btmRight);
	    }
	}
	return array;
    }
    
    private void swap(Pair topLeft, Pair topRight, Pair btmLeft, Pair btmRight)
    {
	if (topLeft == null || topRight == null || btmLeft == null || btmRight == null) return;

	int topLeft = array[topLeft.row][topLeft.col];
	int topRight = array[topRight.row][topRight.col];
	int btmLeft = array[btmLeft.row][btmLeft.col];
	int btmRight = array[btmRight.row][btmRight.col];

	array[topLeft.row][topLeft.col] = btmLeft;
	array[topRight.row][topRight.col] = topLeft;
	array[btmRight.row][btmRight.col] = topRight;
	array[btmLeft.row][btmLeft.col] = btmRight;
    }
}

class Pair
{
    int row;
    int col;

    public Pair()
    {
    }

    public void setRow(int x)
    {
	row = x;
    }

    public void setCol(int y)
    {
	col = y;
    }
}

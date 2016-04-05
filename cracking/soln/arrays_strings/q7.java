import java.util.*;

public static void main(String[] args)
{
    
}

class Solution
{
}

class ResetToZero
{
    int[][] array;

    public void reset(int[][] a)
    {
	if (a == null) return;

	this.array = a;

	int M = array.size();
	int N = array[0].size();

	List<Pair> list = new ArrayList<>();

	for (int i = 0 ; i < M; ++i)
	{
	    for (int j = 0; j < N; ++j)
	    {
		if (array[i][j] == 0)
		{
		    Pair pair = new Pair();
		    pair.setRow(i);
		    pair.setCol(j);
		    list.add(pair);
		}
	    }
	}

	for (Pair pair : list)
	{
	    int row = pair.row;
	    int col = pair.col;

	    for (int i = 0; i < M; ++i)
	    {
		array[i][col] = 0;
	    }

	    for (int j = 0; j < N; ++j)
	    {
		array[row][j] = 0;
	    }
	}
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

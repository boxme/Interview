import java.util.*;

// Count the number of islands in a 2D array

public class floodfill
{
    // N, S, E, W, NE, NW, SW, SE
    int[] rows = {1, -1, 0, 0, -1, -1, 1, 1};
    int[] cols = {0, 0, 1, -1, 1, -1, -1, 1};

    int R, C;

    public int countIslands(int[][] array)
    {
	int count = 0;

	R = array.length;
	C = array[0].length;

	// Use DFS
	// land is denoted with 1, 0 is empty
	for (int i = 0; i < array.length; ++i)
	{
	    for (int j = 0; j < array[i].length; ++j)
	    {
		if (array[i][j] != 0)
		{   
		    count++;
		    dfs(i, j, array);
		}
	    }
	}

	return count;
    }

    private void dfs(int row, int col, int[][] array)
    {
	if (row < 0 || row >= R || c < 0 || c >= C)
	{
	    return;
	}

	if (array[row][col] == 0) 
	{
	    return;
	}
	
	// Prevent cycle
	array[row][col] = 0;

	int len = rows.length;
	for (int i = 0; i < len; ++i)
	{
	    int r = rows[i];
	    int c = cols[i];
	    dfs(r, c);
	}
    }
}

import java.util.*;

public class qn2 {

    private int R, C;
    private int[][] memo;
    private int[][] grid;

    private int[] x_dir = {1, 0};
    private int[] y_dir = {0, 1};

    private List<Point> path;

    public int solution(int X, int Y, int[][] grid) {
	R = X;
	C = Y;
	memo = new int[X+1][Y+1];
	for (int i = 0; i < X+1; ++i) {
	    Arrays.fill(memo[i], -1);
	}

	this.grid = grid;
	path = new ArrayList<>();

	return count(0, 0);
    }

    // Get 1 possible path
    private int getPath(int row, int col) {
	if (row > X || col > Y || row < 0 || col < 0) return 0;
	if (row == X && col == Y) return 1;
	if (grid[row][col] == -1) return 0;

	if (memo[row][col] != -1) return memo[row][col];

	int isPossible = getPath(row + y_dir[0], col + x_dir[0]);
	if (isPossible != 1) {
	    isPossible = getPath(row + y_dir[1], col + x_dir[1]);
	}

	if (isPossible == 1) {
	    path.add(new Point(row, col));
	}
	
	return memo[row][col] = isPossible;
    }

    // grid[row][col] == -1 means the path cannot be taken
    private int count(int row, int col) {
	if (row > X || col > Y || row < 0 || col < 0) return 0;
	if (row == X && col == Y) return 1;
	if (grid[row][col] == -1) return 0;
	
	if (memo[row][col] != -1) return memo[row][col];
	
	int ways = 0;
	for (int i = 0; i < 2; ++i) {
	    ways += count(row + y_dir[i], col + x_dir[i]);    
	}

	return memo[row][col] = ways;
    }

    private static class Point {
	int x, y;

	public Point(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
    }
}

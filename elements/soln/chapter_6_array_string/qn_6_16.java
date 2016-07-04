import java.util.*;

public class qn_6_16 {
    
    public static void solution(Color[][] array, int row, int col) {
        int d = array.length;
	int[][] visited = new int[d][d];
	visited[row][col] = 1;

	Queue<Pair> queue = new LinkedList<>();
	queue.offer(new Pair(row, col));
        Color color = array[row][col] == WHITE ? BLACK : WHITE;
        array[row][col] = color;

	while (!queue.isEmpty()) {
	    Pair curr = queue.poll();
            Pair top = color(array, visited, curr.row - 1, curr.col, color);
	    Pair left = color(array, visited, curr.row, curr.col - 1, color);
	    Pair right = color(array, visited, curr.row, curr.col + 1, color);
	    Pair btm = color(array, visited, curr.row + 1, curr.col, color);

	    if (top != null) queue.offer(top);
	    if (left != null) queue.offer(left);
	    if (right != null) queue.offer(right);
	    if (btm != null) queue.offer(btm);
	}
    }

    private static Pair color(int[][] array, int[][] visited, int row, int col, Color color) {
        if (row < 0 || row >= array.length || col < 0 || col >= array.length) return null;

	if (visited[row][col] == 1) return null;

        visited[row][col] = 1;
	array[row][col] = color;

	return new Pair(row, col);
    }
}

public class Pair {
    int row, col;

    public Pair(int row, int col) {
       this.row = row;
       this.col = col;
    }
}

public enum Color {

    WHITE(0);
    BLACK(1);

    privae int value;

    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

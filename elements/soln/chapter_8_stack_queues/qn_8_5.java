import java.util.*;

// Get the views of the sunset
public class qn_8_6 {
    public List<Pair> getListOfBuildingsThatCanViewTheSunSet(InputStream in) {
        Stack<Pair> stack = new Stack<>();
        int idx = -1;
        while (stream.hasInt()) {
            int height = stream.read();
            idx++;
            while(!stack.isEmpty() && height <= stack.peek().height) {
                stack.pop();
            }
            stack.push(new Pair(height, idx));
        }

        return new ArrayList<>(stack);
    }
}

private class Pair {
    int height;
    int index;

    public Pair(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

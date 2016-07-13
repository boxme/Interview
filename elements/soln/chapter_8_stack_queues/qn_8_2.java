import java.util.*;

// Reverse Polish Notation (RPN) evaluation
public class qn_8_2 {
    Queue<Integer> queue = new LinkedList<>();

    public int solution(String expression) {
        String[] strArray = expression.split(",");
        int value = 0;

        for (int i = 0; i < strArray.length; ++i) {
            String str = strArray[i];
            boolean divide = isDivide(str);
            boolean multiply = isMultiply(str);
            boolean add = isAdd(str);
            boolean subtract = isSubtract(str);
            if (!divide && !multiply && !add && !subtract) {
                queue.offer(Integer.parseInt(str));
                continue;
            }

            int value = queue.poll();
            while (!queue.isEmpty()) {
                int nextValue = queue.pop();
                if (divide) value /= nextValue;
                else if (multiply) value *= nextValue;
                else if (add) value += nextValue;
                else if (subtract) value -= nextValue;
            }

            queue.offer(value);
        }

        return queue.poll();
    }

    private boolean isDivide(String string) {
        return "/".equals(string);
    }

    private boolean isMultiply(String str) {
        return "*".equals(str);
    }

    private boolean isAdd(String str) {
        return "+".equals(str);
    }

    private boolean isSubtract(String str) {
        return "-".equals(str);
    }
}

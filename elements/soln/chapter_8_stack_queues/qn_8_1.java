import java.util.*;

// Implement a max stack
public class qn_8_1 {

}

public class MaxStack {
    Stack<Integer> maxStack;
    Stack<Integer> stack;

    public MaxStack() {
        maxStack = new Stack<>();
        stack = new Stack<>();
    }

    public int push(int element) {
        stack.push(element);
        if (maxStack.isEmpty() || element >= maxStack.peek()) {
            maxStack.push(element);
        }

        return element;
    }

    public int peek() {
        if (stack.isEmpty()) throw new Exception("Empty stack");

        return stack.peek();
    }

    public int pop() {
        if (stack.isEmpty()) throw new Exception("Empty stack");

        int element = stack.pop();
        if (element == maxStack.peek()) maxStack.pop();

        return element;
    }

    public int max() {
        if (maxStack.isEmpty()) throw new Exception("Empty stack");

        return maxStack.peek();
    }
}

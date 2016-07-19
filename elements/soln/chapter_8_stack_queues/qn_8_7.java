import java.util.*;

// Stack sorting to get a stack of descending order
public class qn_8_7 {
    
    public Stack<Integer> sortStackInDescendingOrder(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int num = stack.pop();
            sortStackInDescendingOrder(stack);
            insertNumIntoStack(stack, num);
        }

        return stack;
    }

    private void insertNumIntoStack(Stack<Integer> stack, int num) {
        if (!stack.isEmpty() && stack.peek() > num) {
            int top = stack.pop();
            insertNumIntoStack(stack, num);
            stack.push(top);
        } else {
            stack.push(num);
        }
    }
}

import java.util.*;

// Queue from two stacks
public class qn_8_12 {
    private static class Queue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        private int size;

        public Queue() {
            size = 0;
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int value) {
            stack1.push(value);
            size++;
        }

        public int peek() {
            if (isEmpty()) throw new Exception("Queue is empty");
            if (stack2.isEmpty()) {
                transfer();
            }

            return stack2.peek();
        }

        public int pop() {
            if (isEmpty()) throw new Exception("Queue is empty");
            if (stack2.isEmpty()) {
                transfer();
            }

            size--;
            return stack2.pop();
        }

        private void transfer() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}

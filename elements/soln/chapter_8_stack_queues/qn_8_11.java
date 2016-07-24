import java.util.*;

// Implement a queue using two unsigned integers
public class qn_8_11 {
    private static class Queue {
        private int size;
        private int sum;

        public Queue() {
            size = 0;
            sum = 0;
        }

        public void push(int value) {
            size++;
            sum *= 10;
            sum += value;
        }

        public int peek() {
            if (isEmpty()) throw new Exception("Queue is empty");
            if (size == 1) return sum;

            return sum / (10 * (size - 1));
        }

        public int pop() {
            if (isEmpty()) throw new Exception("Queue is empty");

            int value = peek();
            
            size--;
            if (size == 0) {
                sum = 0;
            } else {
                sum %= (10 * size);
            }

            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}

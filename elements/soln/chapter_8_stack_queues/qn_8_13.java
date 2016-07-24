import java.util.*;

// Queue with max
public class qn_8_13 {
    private static QueueMax {
        int size;
        Deque<Integer> maxDeque;
        Queue<Integer> queue;

        public QueueMax() {
            size = 0;
            maxDeque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(int value) {
            while (!maxQueue.isEmpty() && value > maxDeque.peekLast()) {
                maxQueue.pollLast();
            }
            maxQueue.offer(value);
            size++;
            queue.offer(value);
        }

        public int max() {
            if (isEmpty()) throw new Exception("Queue is empty");
            return maxDeque.peekFirst();
        }

        public int peek() {
            if (isEmpty()) throw new Exception("Queue is empty");
            return queue.peek();
        }

        public int poll() {
            if (isEmpty()) throw new Exception("Queue is empty");
            int value = queue.poll();
            if (value == maxDeque.peekFirst()) maxDeque.pollFirst();
            size--;
            return value;
        }
    }
}

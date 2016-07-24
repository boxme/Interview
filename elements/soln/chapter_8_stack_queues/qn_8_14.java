import java.util.*;

// Maximum of a sliding window
public class qn_8_14 {
    public void slidingWindow(Pair[] A, int w) {

    }

    private static class MaxQueue {
        private Queue<Pair> queue;
        private DeQue<Pair> deQue;
        private int window;
        private int size;

        public MaxQueue(int w) {
            window = w;
            size = 0;
            queue = new LinkedList<>();
            deQue = new LinkedList<>();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public Pair max() {
            if (isEmpty()) throw new Exception("Empty Queue");

            return deQue.peekFirst();
        }

        public void offer(Pair pair) {
            this.resize(pair.t);

            queue.offer(pair);
            size++;
            while (!deQue.isEmpty() && pair.v > deQue.peekLast().v) {
                deQue.pollLast();
            }

            deQue.offerLast(pair);
        }

        public Pair poll() {
            if (isEmpty()) throw new Exception("Empty Queue");

            Pair discard = queue.poll();
            if (discard == deQue.peekFirst()) deQue.pollFirst();
            size--;
            return discard;
        }

        private void resize(int time) {
            int lowerBound = time - window;
            while (!queue.isEmpty() && lowerBound > queue.peek().t) {
                this.poll();
            }
        }
    }
}

public static class Pair {
    private int t;
    private int v;

    public Pair(int t, int v) {
        this.t = t;
        this.v = v;
    }
}

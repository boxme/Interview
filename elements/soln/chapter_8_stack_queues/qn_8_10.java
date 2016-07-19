import java.util.*;

public class qn_8_10 {

}

private class CircularQueue {
    private int[] array;
    private int size;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        array = new int[capacity];
        size = 0;
        head = -1;
        tail = -1;
    }

    public int enqueue(int value) {
        tail = (tail + 1) % size;
        if (tail == head) throw new IllegalException("Size overflow");

        array[tail] = value;
        size++;

        return value;
    }

    public int dequeue() {
        if (size == 0) throw new IllegalException("Queue is empty");

        head = (head + 1) % size;
        if (head > tail) throw new IllegalException("Size underflow");

        int value = array[head];
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public void int resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        int index = 0;
        while (head <= tail) {
            temp[index++] = array[head++];
        }

        array = temp;
        head = size == 0 ? -1 : 0;
        tail = size == 0 ? size - 1;
    }
}

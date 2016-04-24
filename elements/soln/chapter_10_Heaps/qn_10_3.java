import java.util.*;

public class qn_10_3
{
    
}

class StackHeap
{
    PriorityQueue<StackItem> pq;
    int time;

    public StackHeap()
    {
	pq = new PriorityQueue<>();
	time = 0;
    }

    public void push(int value)
    {
	pq.add(new StackItem(time, value));
	time++;
    }

    public int pop()
    {
	if (pq.isEmpty()) return -1;

	StackItem item = pq.poll();
	return item.value;
    }
}

class QueueHeap
{
    PriorityQueue<QueueItem> pq;
    int time;

    public QueueHeap
    {
	pq = new PriorityQueue<>();
	time = 0;	
    }

    public void offer(int value)
    {
	pq.add(new StackItem(time, value);
	time++;
    }

    public int pop()
    {
	if (pq.isEmpty()) return -1;

	QueueItem item = pq.poll();
	return item.value;
    }
}

class StackItem implements Comparable<StackItem>
{
    int time;
    int value;

    public StackItem(int time, int value)
    {
	this.time = time;
	this.value = value;
    }

    @Override
    public int compareTo(StackItem other)
    {
	return other.time - time;
    }
}

class QueueItem implements Comparable<QueueItem>
{
    int time;
    int value;

    public QueueItem(int time, int value)
    {
	this.time = time;
	this.value = value;
    }

    @Override
    public int compareTo(QueueItem other)
    {
	return time - other.time;
    }
}

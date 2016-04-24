import java.util.*;

public static void main(String[] args)
{
}

class PriorityQueue
{
    int size;
    int[] array;

    public PriorityQueue(int size)
    {
	this.size = 0;
	array = new int[size + 1];
    }

    public void insert(int value)
    {
	size++;
	array[size] = value;
	shiftUp(size);
    }

    public int extractMax()
    {
	int max = array[1];
	int replacement = array[size];
	size--;
	array[1] = replacement;
	shiftDown(1);
	return max;
    }

    public void buildHeap(int[] newArray)
    {
	if (newArray == null) return;

	int size = newArray.length;
	array = new int[size + 1];
	for (int i = 0; i < size; ++i)
	{
	    array[i+1] = newArray[i];
	}

	for (int i = getParent(size); i >= 1; i--)
	{
	    shiftDown(i);
	}
    }

    private void shiftUp(int index)
    {
	if (index > size) return;

	while (index > 1)
	{
	    int parentIndex = getParent(index);
	    if (array[index] < array[parentIndex]) 
	    {
		break;
	    }

	    swap(index, newIndex);
	    index = newIndex;
	}
    }

    private void shiftDown(int index)
    {	
	while(index <= size)
	{
	    int currentVal = array[index];
	    int newIndex = getLeft(index);
	    if (newIndex < heapSize && array[newIndex] < array[newIndex + 1]) newIndex++;
	    if (currentVal >= array[newIndex)) break;
	    
	    swap(newIndex, index);
	    index = newIndex;
	}
    }

    private void swap(int i, int j)
    {
	if (i < 1 || i > size || j < 1 || j > size) return;

	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }

    private int getLeft(int index)
    {
	return index << 1;
    }

    private int getRight(int index)
    {
	return (index << 1) + 1;
    }

    private int getParent(int index)
    {
	return index >> 1;
    }
}

import java.util.*;

public static void main(String[] args)
{
}

private static class MergeSort 
{
    private int[] extraArray;
    private int[] array;

    public MergeSort(int[] array)
    {
	this.array = array;
    }

    public void sort()
    {
	if (array == null || array.length == 0)
	{
	    return;
	}

	extraArray = new int[array.length];
    }

    private void mergeSort(int i, int j)
    {
	if (i < j)
	{
	    int mid = i + (j - i / 2);
	    mergeSort(i, mid);
	    mergeSort(mid + 1, j);
	    merge(i, j);
	}
    }

    private void merge(int i, int mid, int j)
    {
	for (int k = i; k <= j; k++)
	{
	    extraArray[k] = array[k];   
	}

	int x = i;
	int y = mid + 1;
	int curr = i;

	while (x <= mid && y <= j)
	{
	    if (extraArray[x] < extraArray[y]) 
	    {
		array[curr++] = extraArray[x++];
	    } 
	    else if (extraArray[x] > extraArray[y]) 
	    {
		array[curr++] = extraArray[y++];
	    }
	    else 
	    {
		array[curr++] = extraArray[i++];
		array[curr++] = extraArray[j++];
	    }
	}

	while (x <= mid) 
	{
	    extraArray[curr++] = array[x++];
	}

	while (y <= j)
	{
	    extraArray[curr++] = array[y++];
	}
    }
}

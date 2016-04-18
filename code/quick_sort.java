import java.util*;

public static void main(String[] args)
{
}

private static class QuickSort 
{
    private int[] array;

    public QuickSort(int[] array)
    {
	this.array = array;
    }

    public int[] sort() 
    {
      if (array != null && array.length != 0)
      {
		  
      }
      return array;
    }

    private void quicksort(int i, int j)
    {
	if (i >= j)
	{
	    return;
	}

	int pivotPos = pivotPosition(i , j);
	int pivotVal = array[pivotPos];
	int leftMostVal = array[i];
	
	swap(pivotPos, i);
	
	int currX = i;
	int currY = j;
	while (currX < currY)
	{
	    while (array[currY] >= pivotVal && currX < currY)
	    {
		currY--;
	    }

	    if (currX < currY)
	    {
		swap(currX, currY);
		currX++;
	    }

	    while (array[currX] <= pivotVal && currX < currY)
	    {
		currX++;
	    }
	    
	    if (currX < currY)
	    {
		swap(currX, currY);
		currY--;
	    }
	}

	// Slot in pivotVal
	swap(i, currX);

	// Recursive
	quickSort(i, currX - 1;
	quickSort(currX + 1,j);
    }

    private void swap(int i, int j)
    {
	if (i == j || array == null || i >= array.length || j >= array.length) return;

	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }

    private int pivotPosition(int i, int j)
    {
	int mid = i + (j - i / 2);
	int midVal = array[mid];
	int iVal = array[i];
	int jVal = array[j];

	if (iVal < midVal && midVal < jVal)
	{
	    return mid;
	}

	if (iVal < midVal && jVal < midVal)
	{
	    if (iVal < jVal) return j;

	    return i;
	}

	if (midVal < iVal && midVal < jVal)
	{
	    if (iVal < jVal) return i;
	    return j
	}

	if (midVal < iVal && jVal < midVal)
	{
	    return mid;
	}
    }
}

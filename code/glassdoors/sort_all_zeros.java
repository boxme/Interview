import java.util.*;

public class sort_all_zeros
{
    public void keepAllZerostoLeft(int[] array)
    {
	if (array == null) return;

	int i = 0;
	int j = array.length - 1;

	while (i < j)
	{
	    int end = array[j];
	    if (end == 0)
	    {
		swap(i, j, array);
		i++;
	    }
	    else
	    {
		j--;
	    }
	}
    }

    private void swap(int i, int j, int[] array)
    {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }
}

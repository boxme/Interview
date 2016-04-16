import java.util.*;

public class q12
{
    public static void main(String[] args)
    {
    }

    // O(n) solution with O(n) space complexity
    public static List<Pair> findSum(int[] array, int sum)
    {
	HashMap<Integer, Integer> map = new HashMap<>();
	List<Pair> list = new ArrayList<>();
	int len = array.length;
	
	for (int i = 0; i < len; ++i)
	{
	    map.put(array[i], array[i]);
	}

	for (int i = 0; i < len; ++i)
	{
	    if (map.hasKey(sum - array[i]))
	    {
		list.add(new Pair(map.get(sum - array[i]), array[i]);
	    }
	}

	return list;
    }

    // O(1) space complexity O(NlgN) time complexity 
    public static List<Pair> findSum(int[] array, int sum)
    {
	List<Pair> list = new ArrayList<>();
	int len = array.length;
	
	Arrays.sort(array);

	int first = 0;
	int last = len - 1;

	while (first < last)
	{
	    int s = array[first] + array[last];

	    if (s == sum)
	    {
		list.add(new Pair(array[first], array[last]);
		first++;
		last--;
	    }
	    else if (s < sum)
	    {
		first++;
	    }
	    else
	    {
		last--;
	    }
	}

	return list;
    }
}

public class Pair
{
    int i;
    int j;

    public Pair(int a, int b)
    {
	i = a;
	j = b;
    }
}

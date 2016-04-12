import java.util.*;

public static void main(String[] args)
{
}

class IntegerStreamRanking
{
    TreeMap<Integer, Integer> treeMap;

    public IntegerStreamRanking()
    {
	treeMap = new TreeMap<>();	
    }

    public void track(int x)
    {
	if (map.containsKey(x))
	{
	    map.put(x, map.get(x) + 1);
	}
	else
	{
	    map.put(x, 0);
	}
    }

    public int getRankOfNumber(int x)
    {
	if (!map.containsKey(x))
	{
	    // No such number is being tracked
	    return -1;
	}

	NavigableSet<Integer> keySet = treeMap.navigableKeySet();
	int count = 0;
	for (Integer key : keySet)
	{
	    if (key <= x)
	    {
		count += map.get(key);
	    }
	    else
	    {
		break;
	    }
	}

	return count;
    }
}

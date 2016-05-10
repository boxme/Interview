import java.util.*;

public class string_reconstruction_from_array
{
    public void solution(String s, String[] array)
    {
	Map<String, Booelean> map = new HashMap<>();
	for (int i = 0; i < array.length; ++i)
	{
	    map.put(array[i], true);
	}

	boolean canBeConstructed = canBuildWords(s, map);
    }

    private boolean canBuildWords(String s, Map<String, Boolean> map)
    {
	if (map.containsKey(s))
	{
	    return map.get(s);
	}

	for (int i = 1; i < s.length(); ++i)
	{
	    String left = s.subString(0, i);
	    String right = s.subString(i);

	    if (map.containsKey(left) && map.get(left) && canBuildWords(right, map))
	    {
		return true;
	    }
	}

	map.put(s, false);
	return false;
    }
}

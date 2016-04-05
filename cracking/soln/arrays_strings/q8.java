import java.util.*;

public static void main(String[] args)
{
    
}

class Soln
{
    CheckRotation check;

    public Soln()
    {
      check = new CheckRotation();
    }

    public void solution()
    {
	test("waterbottle", "erbottlewat", true);
	test("a", "a", true);
	test("abcde", "deabc", true);
	test("abcde", "edabc", false);
	test("aabac", "acaab", true);
    }

    private void test(String s1, String s2, boolean expected)
    {
	assertEquals(check.isSubString(), expected);
    }
}

class CheckRotation
{
    public boolean isSubString(String s1, String s2)
    {
	if (s1 == null || s2 == null) return false;
	
	HashMap<String, Boolean> hash = new HashMap<>();

	for (int i = 0; i < s1.length(); ++i)
	{
	    String sub = s1.subString(i);
	    hash.put(sub, true);
	}

	return hash.containsKey(s2);
    }
}

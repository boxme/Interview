import java.util.*;

public void testCase()
{
    String uniqueString = "abc de";
    String nonUniqueString = "ab cCde";
    String emptyString = " ";

    CheckString checks = new CheckString();

    assertTrue(checks.checkWithDS(uniqueString));
    assertFalse(checks.checkWithDS(nonUniqueString));
    assertFalse(checks.checkWithDS(emptyString));
    

}

class CheckString
{
    HashMap<Character, Boolean> hashMap;

    public boolean checkWithDS(String string)
    {
	if (string == null) return false;
	if (string.trim().isEmpty()) return false;
	

	hashMap = new HashMap<>();
	int len = string.length();
	
	for (int i = 0; i < len; ++i)
	{
	    char c = Character.toLowerCase(string.charAt(i));
	    
	    if (Character.isWhitespace(c)) continue;
	    
	    if (hashMap.containsKey(c))
	    {
		return false;
	    }
	    hashMap.put(c, true);
	}

	return true;
    }

    public boolean checkWithNoDS(String string)
    {
	if (string == null || string.trim().isEmpty()) return false;
    }
}

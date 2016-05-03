import java.util.*;

public class qn_13_4
{
    public static Person[] groupObjectsByKey(List<Person> people)
    {
	Map<Integer, Integer> countMap = new HashMap<>();
	int size = people.size();
	Person[] results = new Person[size];

	// Count
	for (Person person : people)
	{
	    if (countMap.containsKey(person.key))
	    {
		countMap.put(person.key, countMap.get(person.key) + 1);
	    }
	    else
	    {
		countMap.put(person.key, 1);
	    }
	}
	
	// Offset position based on count
	Map<Integer, Integer> offsetMap = new HashMap<>();
	Set<Integer> keySets = countMap.keySet();
	int offset = 0;
	for (Integer key : keySets)
	{
	    offsetMap.put(key, offset);
	    offset += countMap.get(key);
	}

	// Put together
	for (Person person : people)
	{
	    int pos = offsetMap.get(person.key);
	    results[pos] = person;
	    offsetMap.put(person.key, pos + 1);
	}

	return results;
    }

    public static Person[] sortObjectsByKey(List<Person> people)
    {
	Map<Integer, Integer> countMap = new HashMap<>();
	int size = people.size();
	Person[] results = new Person[size];

	// Count
	for (Person person : people)
	{
	    if (countMap.containsKey(person.key))
	    {
		countMap.put(person.key, countMap.get(person.key) + 1);
	    }
	    else
	    {
		countMap.put(person.key, 1);
	    }
	}

	// Offset position based on Count
	Set<Integer> keySets = countMap.keySet();
	List<Integer> sortedKeySets = new ArrayList<>(keySets);
	Collections.sort(sortedKeySets);

	Map<Integer, Integer> offsetMap = new HashMap<>();
	int offset = 0;
	for (Integer key : sortedKeySets)
	{
	    offsetMap.put(key, offset);
	    offset += countMap.get(key);
	}

	// Put together
	for (Person person : people)
	{
	    int pos = offsetMap.get(person.key);
	    results[pos] = person;
	    offsetMap.put(person.key, pos + 1);
	}

	return results;
    }
}

class Person
{
    int key;
    Object data;
}

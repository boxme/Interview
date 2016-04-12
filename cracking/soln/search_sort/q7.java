import java.util.*;

public static void main(String[] args)
{
}

class Person implements Comparable<Person>
{
    int ht;
    int wt;

    public Person(int ht, int wt)
    {
	this.ht = ht;
	this.wt = wt;
    }

    @Override
    public int compareTo(Person other)
    {
	if (ht < other.ht && wt < other.wt) return -1;

	if (ht > other.ht && wt > other.wt) return 1;

	return 0;
    }
}

// Find longest increasing sequence
public List<Person> findLongestIncreasingSequence(List<Person> people)
{
    if (people == null) return null;

    // Sort first
    Collections.sort(people);

    List<Person> tower = new ArrayList<>();
    List<Person> temp = new ArrayList<>();

    for (Person person : people)
    {
	if (temp.isEmpty()) 
	{
	    temp.add(person);
	}
	else 
	{
	    Person prev = temp.get(temp.size() - 1);
	    if (prev.compareTo(person) == -1)
	    {
		temp.add(person);
	    }
	    else
	    {	
		Person last;
		while (!temp.isEmpty())
		{   
		    prev = temp.remove(0);
		    if (tower.isEmpty()) 
		    {
			tower.add(prev);
		    }
		    else
		    {
			last = tower.get(tower.size() - 1);
			if (last.compareTo(prev) == -1)
			{
			    tower.add(prev);
			}
		    }
		}
	    }
	}
    }
    
    return tower;
}

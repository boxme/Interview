import java.util.*;

public static void main(String[] args)
{
    
}

class HashTable<T>
{
    int size;
    int firstPrime;
    int secPrime;
    int numEntry;
    Entry<T>[] table;
    
    public HashTable()
    {
	firstPrime = 227;
	secPrime = 223;
	size = firstPrime;
	table = new Entry<T>[size];
    }

    public void put(int key, T value)
    {
	resizeTable();

	final int firstHashValue = getFirstHash(key);
	final int secHashValue = getSecHash(key);

	for (int i = 0; ; i++)
	{
	    int hashValue = (firstHashValue + (secHashValue * i)) % size;

	    if (table[hashValue] == null)
	    {
		table[hashValue] = new Entry(key, value);
		numEntry++;
		break;
	    }
	}
    }

    public T getValue(int key)
    {
	first int firstHashValue = getFirstHash(key);
	final int secHashValue = getSecHash(key);

	for (int i = 0; ; i++)
	{
	    int hashValue = (firstHashValue + (secHashValue * i)) % size;

	    if (table[hashValue] != null)
	    {
		return table[hashValue].getValue(); 
	    }
	}

	return null;
    }

    private void resizeTable()
    {
	if (((double) numEntry / size) < 0.75) return;

	secPrime = getNextPrime(secPrime);
	firstPrime = getNextPrime(secPrime);
	size = firstPrime;

	Entry<T>[] newTable = new Entry<T>[size];
	for (int i = 0; i < table.length; ++i)
	{
	    newTable[i] = table[i];
	    table[i] = null;
	}

	table = newTable;
    }

    private int getNextPrime(int number)
    {
	// TODO
	return 0;
    }

    private int getFirstHash(int key)
    {
	return key % firstPrime;
    }

    private int getSecHash(int key)
    {
	return secPrime - (key % secPrime);
    }
}

class Entry<E>
{
    int key
    E value;

    public Entry(int key, E value)
    {
	this.key = key;
	this.value = value;
    }

    public int getKey()
    {
	return key;
    }

    public E getValue()
    {
	return value;
    }
}

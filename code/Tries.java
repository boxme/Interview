import java.util.*;

public class Tries
{
    Node root;

    public Tries()
    {
	root = new Node('');
    }

    public void insert(String word)
    {
	if (word == null || word.trim().isEmpty()) return;

	insert(root, word, 0);	
    }

    private void insert(Node node, String word, int depth)
    {
	if (word == null || depth >= word.length()) return null;

	char c = word.getCharAt(depth);
	if (node.children[c] == null)
	{
	    node.children[c] = new Node(c);
	}

	// Add the word to the node because the char in the node is part of the prefix
	node.listOfWords.add(word);

	insert(node.children[c], word, depth + 1);
    }

    public Node getNodeWithString(String s)
    {
	return getNodeWithString(root, s, 0);
    }

    private Node getNodeWithString(Node node, String s, int depth)
    {
	if (node == null || depth == s.length()) return null;

	char c = s.getCharAt(depth);
	if (depth == s.length() - 1)
	{
	    return node.children[c];
	}

	return getNodeWithString(node.children[c], s, depth + 1);
    }
    
    // This is bad for memory, each node contains the list of words below it
    public List<String> getListOfStringsFromPrefix(String prefix)
    {
	if (prefix == null) return null;

	return getWordsFromPrefix(root, prefix, 0);
    }

    private List<String> getWordsFromPrefix(Node node, String prefix, int depth)
    {
	if (prefix == null) return null;

	if (depth == prefix.length - 1)
	{
	    return node.listOfWords;
	}

	char c = prefix.getCharAt(depth);
	if (node.children[c] == null)
	{
	    return null;
	}
	else
	{
	    return getWordsFromPrefix(node.children[c], prefix, depth + 1);
	}
    }

    public Iterable<String> getWordsWithPrefix(String prefix)
    {
	if (prefix == null) return null;

	Node node = getNodeWithString(prefix);
	if (node == null)
	{
	    // No words with this prefix
	    return null;
	}

	Queue<String> results = new LinkedList<>();
	collectWordsWithPrefix(node, new StringBuilder(prefix), results);

	return results;
    }

    private void getWordsWithPrefix(Node node, StringBuilder prefix, Queue<String> results)
    {
	if (node == null) return;
	
	results.offer(prefix.toString());

	for (Node child : node.children)
	{
	    // Add to back
	    prefix.append(child.c);
	    
	    getWordsWithPrefix(child, prefix, results);
	    
	    // Remove from back
	    prefix.deleteCharAt(prefix.length() - 1);
	}
    }

    public String getShortestPrefix(String word)
    {
	if (word == null) return null;

	return getShortestPredix(root, word);
    }

    private String getShortestPrefix(Node node, String word)
    {
	StringBuilder prefix = new StringBuilder();

	for (char c : word.toCharArray())
	{
	    prefix.append(c);
	    if (node.children[c] == null)
	    {
		return prefix.toString();
	    }
	    node = node.children[c];
	}

	// Entire word is a prefix
	return word;
    }

    public void deleteString(String s)
    {
	if (s == null) return;

	Node node = getNodeWithString(s);
	if (node == null) return;

	deleteString(root, s, 0);
    }

    private Node deleteString(Node node, String s, int depth)
    {
	if (node == null) return;

	if (depth == s.length() - 1)
	{
	    for (int i = 0; i < node.children.length; ++i)
	    {
		if (node.children[i] != null) return node;
	    }
	    return null;
	}
	else
	{
	    char c = s.getCharAt(depth);
	    node.children[c] = deleteString(node.children[c], s, depth + 1);
	    
	    for (int i = 0; i < node.children.length; ++i)
	    {
		if (node.children[i] != null) return node;
	    }
	    return null;
	}
    }
    
    // Find strings that match pattern
    // * is the wild card
    pulbic Interable<String> getMatchedString(String pattern)
    {
	if (s == null) return null;

	Queue<String> results = new LinkedList<>();
	getMatchedString(root, pattern, new StringBuilder(), results);
	return results;
    }

    private void getMatchedString(Node node, String pattern, StringBuilder prefix, Queue<String> results)
    {
	if (node == null) return;

	int d = prefix.length();
	if (d == pattern.length())
	{
	    results.offer(prefix.toString());
	    return;
	}
	
	char c = pattern.getCharAt(d);
	if (c == '*')
	{
	    for (Node child : node.children)
	    {
		prefix.append(child.c);
		getMatchedString(child, pattern, prefix, results);
		prefix.deleteCharAt(prefix.length() - 1);
	    }
	}
	else
	{
	    Node child = node.children[c];
	    if (child == null) return;

	    prefix.append(child.c);
	    getMatchedString(child, pattern, prefix, results);
	    prefix.removeCharAt(prefix.length() - 1);
	}
    }
}

public class Node
{
    char c;
    Node[] children;
    List<String> listOfWords;

    public Node(char s)
    {
	c = s;
	// Extends ascii
	children = new Node[256];
	listOfWords = new ArrayList<>();
    }
}



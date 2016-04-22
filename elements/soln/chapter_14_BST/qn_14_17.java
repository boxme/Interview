import java.util.*;

public class qn_14_17
{
}

class Node
{
    int timeStamp;
    String page;
}

/**
  * Create a BST with each node containing the page & frequency 
  * Use a HashTable to hash each page to its node in the BST
  * When add is triggered, check for its entry in the hashtable, then go to the node, get the total new count, remove old node and add the a new node with the updated count
  * When common is triggered, call getMax on the BST k times (Get the first max, then call getPredecessor() k - 1 times)
**/

import java.util.*;

public static void main(String[] args)
{

}

class DetectCycle
{
    public Node detect(Node list)
    {
	if (list == null) return null;

	Node head = list;
	
	Node hare = head;
	Node tort = head;

	while (hare != null && hare != tort)
	{
	    hare = moveForward(hare);
	    if (hare == null)
	    {
		// No cycle
		return null;
	    }
	    else
	    {
		hare = moveForward(hare);
	    }

	    tort = moveForward(tort);
	}
	
	tort = head;
	while (hard != null && hare != tort)
	{
	    tort = moveForward(tort);
	    hare = moveForward(hare);
	}

	return tort;
    }

    private void moveForward(Node node)
    {
	if (node == null) return;

	node = node.next;
    }
}

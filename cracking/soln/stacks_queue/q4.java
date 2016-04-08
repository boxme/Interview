import java.util.*;

public static void main(String[] args)
{
}

class Tower
{
    private Stack<Integer> disks;
    private int index;

    public Tower(int i)
    {
	disks = new Stack<>();
	index = i;
    }

    public void add(int d)
    {
	if (!disks.isEmpty() && disks.peek() <= d)
	{
	    throw new Execption("Error placing disk " + d);
	}

	disks.push(d);
    }

    public void moveTopTo(Tower t)
    {
	int top = disks.pop();
	t.add(top);
    }

    public void moveDisks(int n, Tower buffer, Tower dest)
    {
	if (n <= 0) return;

	// Move to buffer using dest (using dest as buffer)
	moveDisks(n - 1, dest, buffer);

	// Move the one single piece to the dest
	moveTopTo(dest);

	// Move from buffer to dest (using this as buffer)
	buffer.moveDisks(n - 1, this, dest);
    }
}

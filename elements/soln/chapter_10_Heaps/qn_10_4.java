import java.util.*;

public class qn_10_4
{
    public static List<Star> returnKNearestStars(List<Star> stars, int k)
    {
	PriorityQueue<Star> pq = new PriorityQueue<>(k);

	for (Star star : stars)
	{
	    if (pq.size() < k)
	    {
		pq.add(star);
	    }
	    else
	    {
		Star furtherestInQueueStack = pq.peek();
		int compare = star.compareTo(furtherestInQueueStack);

		if (compare < 1)
		{
		    // Nearer than the furtherest in the priority queue
		    pq.poll();
		    pq.add(star);
		}
	    }
	}

	return new ArrayList<>(pq);
    }
}

public class Star implement Comparable<Star>
{
    int id;
    int x;
    int y;
    int z;

    public Star(int id, int x, int y, int z)
    {
	this.id = id;
	this.x = x;
	this.y = y;
	this.z = z;
    }

    @Override
    public int compareTo(Star other)
    {
	int currentDist = distFromEarth(x, y, z);
	int otherDist = distFromEarth(other.x, other.y, other.z);

	return otherDist - currentDist;
    }

    public int distFromEarth(int x, int y, int z)
    {
	return Math.sqrt((x * x) + (y * y) + (z * z));
    }
}

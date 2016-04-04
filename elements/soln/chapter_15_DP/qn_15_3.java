import java.util.*;

class qn_15_3 {

    private static Tuple findClosestPairPoints(List<Point> points) {
        // Sort the list according to the x coordinates
        Collections.sort(points, new Comparator<Point> {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        Tuple closestPairWithDist = findClosestPairPointsHelper(points, 0, points.size());
    }

    private static Tuple findClosestPairPointsHelper(
            List<Point> points, int start, int end) {

        if (end - start <= 3) {
            return solveByEnumerateAllPairs(points, start, end);
        }

        int mid = start + (end - start) / 2;
        Tuple result1 = findClosestPairPointsHelper(points, start, mid);
        Tuple result2 = findClosestPairPointsHelper(points, mid, end);

        Tuple bestResult = result1.dist < result2.dist ? result1 : result2;

        // Store the points whose x-dist are in the range [mid.x - bestResult.dist, mid.x + bestResult.dist];
        // This is because these are the remaining points which are possible to be
        // shorter than the bestResult.
        List<Point> remain = new ArrayList<>();

        for (Point point : points) {
            if (Math.abs(p.x - points.get(mid).x) < bestResult.dist) {
                remain.add(point);
            }
        }

        Tuple midRet = findClosestPairInRemain(remain, bestResult);
        return midRet.dist < bestResult.dist ? midRet.dist : bestResult.dist;
    }

    private static Tuple solveByEnumerateAllPairs(List<Point> points, int start, int end) {
        Tuple closestPair = new Tuple();
        closestPair.dist = Double.MAX_VALUE;

        for (int i = start; i < end; ++i) {
            for (int j = start + 1; j < end; ++j) {
                double dist = distance(points.get(i), points.get(j));

                if (closestPair.dist > dist) {
                    closestPair.dist = dist;
                    closestPair.a = points.get(i);
                    closestPair.b = points.get(j);
                }
            }
        }

        return closestPair;
    }

    private static Tuple findClosestPairInRemain(List<Point> remains, Tuple bestResult) {
        // Sort by the y-axis to allow early elimination
        Collections.sort(remains, new Comparator() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });

        // Based on the paper by Shamos and Hoey, the max number of points here is 6
        Tuple ret = new Tuple();
        ret.dist = Double.MAX_VALUE;

        for int (int i = 0; i < remains.size(); ++i) {
            for (int j = i + 1; 
                    j < remains.size() && remains.get(j).y - remains.get(i).y < bestResult.dist; 
                    ++j) {
                double dist = distance(remains.get(i), remains.get(j));
                if (dist < ret.dist) {
                    ret.dist = dist;
                    ret.a = remains.get(i);
                    ret.b = remains.get(j);
                }
            }
        }

        return ret;
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}

public static class Tuple {
    public Point a;
    public Point b;
    public double dist;
}

public static class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

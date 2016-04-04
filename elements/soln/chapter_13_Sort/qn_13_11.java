import java.util.*;

class qn_13_11 {

    public List<Interval> unionOfIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return new ArrayList<Interval>();
        }

        // Sort intervals according to left endpoints of intervals
        Arrays.sort(intervals);

        Interval curr = intervals[0];
        List<Interval> results = new ArrayList<Interval>();

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i].left.time < curr.right.time
                    || (intervals[i].left.time == curr.right.time 
                        && (intervals[i].left.isClosed || curr.right.isClosed))) {
                
                if (intervals[i].right.time > curr.right.time
                        || (intervals[i].right.time == curr.right.time
                            && intervals[i].right.isClosed)) {
                    curr.right = intervals.[i].right;
                }
            } else {
                result.add(curr);
                curr = intervals[i];
            }
        }

        result.add(curr);
        return result;
    }

    class Interval implements Comparable<Interval> {
        class Endpoint {
            public boolean isClosed;
            public int time;
        }
        
        public int compareTo(Interval i) {
            if (left.time < i.left.time) {
                return -1;
            }
            if (left.time > i.left.time) {
                return 1;
            }
            if (left.isClosed && !i.left.isClosed) {
                return -1;
            }
            if (!left.isClosed && i.left.isClosed) {
                return 1;
            }
            return 0;
        }
        
        public Endpoint left = new Endpoint();
        public Endpoint right = new Endpoint();
    }
}

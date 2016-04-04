import java.util.*;

class qn_13_12 {

    public List<Integer> findMinVisits(Interval[] intervals) {
        List<EndPoint> endpoints = new ArrayList<EndPoint>();
        for (Interval interval : intervals) {
            endpoints.add(new EndPoint(interval, true));
            endpoints.add(new EndPoint(interval, false));
        }

        Collections.sort(endpoints);

        return findMinVisitsHelper(endpoints);
    }

    public List<Integer> findMinVisitsHelper(List<EndPoint> endpoints) {
        List<Integer> visitTimes = new ArrayList<Integer>();
        Set<Interval> covered = new HashSet<>();
        List<Interval> covering = new ArrayList<>();
        
        for (EndPoint e : endpoints) {
            if (e.isStart) {
                covering.add(e.ptr);
            } else if (!covered.contains(e.ptr)) {
                // e's interval has not been covered
                visitTimes.add(e.ptr.endTime);
                
                // Add all intervals in covering to covered
                covered.addAll(covering);
                
                // e is contained in all intervals in covering
                covering.clear();
            }
        }
        
        return visitTimes;
    }

    class EndPoint implements Comparable<EndPoint> {
        Interval ptr;
        boolean isStart;
        
        public EndPoint(Interval interval, isStart) {
            this.isStart = isStart;
            this.ptr = interval;
        }
        
        @Override
        public int compareTo(EndPoint o) {
            int a = isStart ? ptr.startTime : ptr.endTime;
            int b = o.isStart ? o.ptr.startTime : o.ptr.endTime;

            return a - b;
        }
    }
    
    class Interval {
        int startTime;
        in endTime;
    }

}

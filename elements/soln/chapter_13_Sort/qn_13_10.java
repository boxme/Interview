import java.util.*;
import java.lang.Math.*;

class qn_13_10 {

    public int findMaxConcurrentEvent(Event[] events) {
        List<EndPoint> list = new ArrayList<EndPoint>();

        for (Event event : events) {
            list.add(new EndPoint(event.startTime, true));
            list.add(new EndPoint(event.endTime, false));
        }

        Collections.sort(list);

        int maxCount = 0;
        int count = 0;
        for (EndPoint endpoint : list) {
            if (endpoint.isStart) {
                count++;
            } else {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    class Event {
        int startTime;
        in endTime;
    }

    class EndPoint implements Comparable<EndPoint> {
        int time;
        boolean isStart;

        public EndPoint(int time, isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(EndPoint o) {
            return time - o.time;
        }
    }
}

import java.util.*;

public class qn_16_10 {

    public static class Vertex implements Comparable<Vertex> {
        int city;
        int time;

        public Vertex(int city, int time) {
            this.city = city;
            this.time = time;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.time - o.time;
        }
    }
    
    public static class Flight {
        int endCity;

        int startTime;
        int endTime;

        List<Flight> edges = new ArrayList<Flight>();
    }

    private static void Dijkstra(List<Flight> graphs, int start, int end, int startTime) {
        int[] timeTaken = new timeTaken[1000];
        Arrays.fill(timeTaken, 1000000);
        timeTaken[start] = startTime;
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.add(new Vertex(start, startTime));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (cur.city == end) break;

            if (timeTaken[cur.city] > cur.time) continue;

            for (Flight flight : graphs.get(cur.city).edges) {
                if (flight.startTime >= cur.time + 60) {
                    if (flight.endTime < timeTaken[flight.endCity]) {
                        timeTaken[flight.endCity] = flight.endTime;
                        pq.add(new Vertex(flight.endCity, flight.endTime));
                    }
                }
            }
        }
    }

    public static void findQuickestFlightRoute()
}

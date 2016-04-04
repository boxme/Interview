import java.util.*;

public class qn_16_5 {
    public static class Vertex {
        int visitTime;
        List<Vertex> edges;
        List<Vertex> extendedContacts;

        public Vertex() {
            visitTime = -1;
            edges = new ArrayList<Vertex>();
            extendContacts = new ArrayList<Vertex>();  
        }
    }

    public static void findExtendedContacts(List<Vertex> graph) {
        for (int i = 0; i < graph.size(); ++i) {
            Vertex curr = graph.get(i);
            if (curr.visitTime != i) {
                curr.visitTime = i;
                findExtendedContactsForVertex(curr, i, curr.extendedContacts);
            }
        }
    }

    private static void findExtendedContactsForVertex(Vertex curr, int time, List<Vertex> contacts) {
        for (Vertex next : curr.edges) {
            if (next.visitTime != time) {
                next.visitTime = time;
                contacts.add(next);
                findExtendedContactsForVertex(next, time, contacts);
            }
        }
    }
}

import java.util.*;

class qn_14_15 {
    
    public static class ClientsCreditsInfo {
        private int offset = 0;
        private Map<String, Integer> clientToCredit = new HashMap<>();
        private NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();
        
        public void insert(String clientID, int c) {
            remove(clientID);
            clientToCredit.put(clientID, c - offset);
            Set<String> set = creditToClients.get(c - offset);
            if (set == null) {
                set = new HashSet<>();
                creditToClients.put(c - offset, set);
            }
            set.add(clientID);
        }
        
        public boolean remove(String clientID) {
            Integer clientIter = clientToCredit.get(clientID);
            if (clientIter != null) {
                creditToClients.get(clientIter).remove(clientID);
                if (creditToClients.get(clientIter).isEmpty()) {
                    creditToClients.remove(clientIter);
                }
                clientToCredit.remove(clientID);
                return true;
            }
            return false;
        }
        
        public int lookup(String clientID) {
            Integer iter = clientToCredit.get(clientID);
            return iter == null ? -1 : iter + offset;
        }
        
        public void addAll(int C) { offset += C; }
        
        public String max() {
            return creditToClients.isEmpty()
            ? ""
            : creditToClients.lastEntry().getValue().iterator().next();
        }
    }
}

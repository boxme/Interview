import java.util.*;

class qn_13_2 {

    ArrayList<String> list = new ArrayList<String<();

    // Assuming that the bigArray is a file
    public void indirectSort(String[] bigArray) {
        ArrayList<IndexToList> indexList = new ArrayList<IndexToList>();

        int len = bigArray.length;
        for (int i = 0; i < bigArray.length; ++i) {
            list.add(bigArray[i]);
            indexList.add(new IndexToList(i));
        }

        // Sort the indexList instead of directly on the list
        Collections.sort(indexList);
    }

    class IndexToList implements Comparable<IndexToList> {
        int index;

        public IndexToList(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(IndexToList o) {
            String string1 = list.get(index);
            String string2 = list.get(o.index);

            return string1.compareTo(string2);
        }
    }
}

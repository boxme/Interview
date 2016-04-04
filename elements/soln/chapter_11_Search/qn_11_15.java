import java.util.*;
import java.io.*;

public class qn_11_15 {

    public static int findMissingElement(InputStream ifs) throws Exception {
        int[] counter = new int[1 << 16];
        ifs.mark(Integer.MAX_VALUE);
        Scanner scanner = new Scanner(ifs);
        while (scanner.hasNextInt()) {
            // Any positive integer that's lesser than 1 >> 16 will give 0
            counter[scanner.nextInt() >> 16]++;
        }

        for (int i = 0; i < counter.length; ++i) {
            // find one bucket that contains less than (1 << 16) elements
            if (counter[i] < (1 << 16)) {
                BitSet bitVec = new BitSet(1 << 16);
                ifs.reset(); // Start again
                scanner = new Scanner(ifs);

                while (scanner.hasNextInt()) {
                    int x = scanner.nextInt();
                    if (i == (x >> 16)) {
                        // Gets the lower 16 bits of x
                        int allBitOnInSize16 = (1 << 16) - 1;
                        int lower16BitsOfX = allBitsOnInSize16 & x;
                        bitVec.set(lower16BitsOfX);
                    }
                }

                ifs.close();

                for (int j = 0; j < (1 << 16); ++j) {
                    if (!bitVec.get(j)) {
                        return (i << 16) | j;
                    }
                }
            }
        }
    }
}

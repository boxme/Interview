import java.util.*;

class qn_11_17 {

    // find the unqiue element in Array where all the other 
    // elements appear three times
    public static int findUniqueElement(int[] A) {
        int twos = 0;
        int ones = 0;
        int notThrees;

        for int (int i = 0; i < A.length; ++i) {
            int value = A[i];

            twos |= ones & value; // Add bits there already existed in ones
            ones ^= value;        // Remove the bit in ones if it already existed, otherwise add it

            // Next 3 lines of code converts the common 1's between 'ones' and 'twos' to 0
            notThrees = ~(ones & twos); // Get the bits which are not common between 'ones' and 'twos'
            ones &= notThrees;          // Remove value from the common 1's from ones
            twos &= notThrees;          // Remove value from the common 1's from twos
        }

        return ones;
    }

    // Find the unique element in Array where all the other
    // elements appear twice
    public static int findUniqueElementInArray(int[] A) {
        int ones = 0;
        for (int i = 0; i < A.length; ++i) {
            ones ^= A[i];
        }

        return ones;
    }
}

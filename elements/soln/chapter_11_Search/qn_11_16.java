import java.util.*;

public class qn_11_16 {

    // Return a Pair of (duplicate, missing)
    public static Pair<Integer, Integer> findDuplicateMissing(int[] A) {
        // XOR all the numbers in A. A[i] is supposed to be equal to i;
        int missXORDup = 0;
        for (int i = 0; i < A.length; ++i) {
            missXORDup ^= i ^ A[i];
        }

        // Find the bit that has set some bits into 1 in missXORDup.
        // This bit exists because one number is missing or duplicated
        // e.g 5 ^ 6 = 1, 10 ^ 9 = 3
        
        // Get the least significant bit that's on
        int differBit = missXORDup & (~(missXORDup - 1));
        int missOrDup = 0;
        for (int i = 0; i < A.length; ++i) {
            // Focus on entries and numbers in which the differ_bit-th is 1.
            
            // Find the numbers which the least significant bit is differBit
            if ((i & differBit) != 0) {
                missOrDup ^= i;
            }

            if ((A[i] & differBit) != 0) {
                missOrDup ^= A[i]; // This will reset missOrDup to 0 if A[i] == i
            }
        }

        // missOrDup is either the missing entry or the duplicated entry
        for (int a : A) {
            if (a == missOrDup) {
                // missOrDup is the duplicate
                return new Pair<Integer, Integer>(missOrDup, missOrDup ^ missXORDup);
            }
        }

        // missOrDup is the missing number
        return new Pair<Integer, Integer>(missOrDup ^ missXORDup, missOrDup);
    }
}

/**
 
 Scan the array 3 times:
 
 XOR together all the array elements -> A. XOR together all the numbers from 0 to N-1 -> B. Now A XOR B = X XOR D, where X is the removed element, and D is the duplicate element.
 
 Choose any non-zero bit in A XOR B. XOR together all the array elements where this bit is set -> A1. XOR together all the numbers from 0 to N-1 where this bit is set -> B1. Now either A1 XOR B1 = X or A1 XOR B1 = D.
 
 Scan the array once more and try to find A1 XOR B1. If it is found, this is the duplicate element. If not, the duplicate element is A XOR B XOR A1 XOR B1.
 
 Properties
 A XOR B = C ===> C XOR A = B and C XOR B = A
 
 and it immediately follows that
 
 (PARTIAL SUM) XOR (MISSING ELEMENT) = (TOTAL) =>
 (TOTAL) XOR ( PATIAL SUM) = (MISSING ELEMNT)
 **/

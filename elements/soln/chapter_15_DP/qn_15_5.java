import java.util.*;

class qn_15_5 {
    
    private static int maxSumInArray(int[] array) {
        // Find the max range sum in a normal array
        int maxSumInNormalArray = maxSumInNormalArray(array);

        // Find the total sum and inverse the sign in each value
        // of the array
        int total = 0;
        for (int i = 0; i < array.length; ++i) {
            total += array[i];
            array[i] = -array[i];
        }

        // Find the max range sum in the inversed array
        // This will give the range of sum that is not
        // included in the answer of the max range sum
        // of a circular array
        int maxSumInCircularArray = total + (maxSumInNormalArray(array));

        // Return the larger of the two, because in a circular array, the max
        // range sum can start from index 0 or anywhere in between 
        return Math.max(maxSumInNormalArray, maxSumInCircularArray);
    }

    // This will return 0 if all the values in the array is negative
    private static int maxSumInNormalArray(int[] array) {
        int maxSum = 0;
        int tempMaxSum = 0;

        for (int i = 0; i < array.length; ++i) {
            tempMaxSum += array[i];
            maxSum = Math.max(maxSum, tempMaxSum);

            if (tempMaxSum < 0) tempMaxSum = 0;
        }

        return maxSum;
    }
}

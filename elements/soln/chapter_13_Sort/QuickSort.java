import java.util.Arrays;
import java.util.Random;

/**
 * Created by desmond on 15/6/15.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = new int[7];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(20);
        }

        QuickSort sort = new QuickSort();
        sort.testNull();
        sort.testEmpty();
        sort.testSimpleElement();
        sort.testSpecial();
        sort.testAnotherSpecial();

        QuickSort.sort(numbers);
        if (!sort.validate(numbers)) {
            System.out.println("wrong answer");
        } else {
            sort.printResult(numbers);
        }
    }

    public void testNull() {
        sort(null);
    }

    public void testEmpty() {
        sort(new int[0]);
    }

    public void testSimpleElement() {
        int[] test = new int[1];
        test[0] = 5;
        sort(test);
    }

    public void testSpecial() {
        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        sort(test);
        if (!validate(test)) {
            System.out.println("Should not happen");
        }
        printResult(test);
    }
    
    public void testAnotherSpecial() {
        int[] test = { 3, 4, 2, 1, 5 };
        sort(test);
        if (!validate(test)) {
            System.out.println("Should not happen");
        }
        printResult(test);
    }

    private boolean validate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }

    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }

        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = findPivotFromThree(array, start, end);
        int pivotValue = array[pivot];
        int startPtr = start;
        int endPtr = end;

        while (startPtr <= endPtr) {
            while (array[startPtr] < pivotValue) {
                startPtr++;
            }

            while (array[endPtr] > pivotValue) {
                endPtr--;
            }

            if (startPtr <= endPtr) {
                swapValue(array, startPtr, endPtr);
                startPtr++;
                endPtr--;
            }
        }

        // sort left
        sort(array, start, endPtr);
        // sort right
        sort(array, startPtr, end);
    }
    
    private static void anotherMethodSort(int[] array, int start, int end) {
        private static void sort(int[] array, int start, int end) {
            if (start >= end) return;
            
            int pivot = findPivotFromThree(array, start, end);
            int pivotValue = array[pivot];
            swapValue(array, start, pivot);
            
            int startPtr = start;
            int endPtr = end;
            
            while (startPtr < endPtr) {
                while (array[endPtr] >= pivotValue && startPtr < endPtr) {
                    endPtr--;
                }
                
                if (startPtr < endPtr) {
                    swapValue(array, startPtr, endPtr);
                    startPtr++;
                }
                
                while (array[startPtr] <= pivotValue && startPtr < endPtr) {
                    startPtr++;
                }
                
                if (startPtr < endPtr) {
                    swapValue(array, startPtr, endPtr);
                    endPtr--;
                }
            }
            int splitPoint = startPtr;
            array[splitPoint] = pivotValue;
            
            printResult(array);
            
            // sort left
            sort(array, start, splitPoint - 1);
            // sort right
            isort(array, splitPoint + 1, end);
        }
    }

    private static int findPivotFromThree(int[] array, int start, int end) {
        if (start > end) return 0;

        int mid = start + (end - start) / 2;
        int firstValue = array[start];
        int lastValue = array[end - 1];
        int midValue = array[mid];

        if (firstValue > midValue) {
            if (midValue > lastValue) {
                return mid;
            } else if (firstValue > lastValue) {
                return end - 1;
            } else {
                return start;
            }
        } else {
            if (firstValue > lastValue) {
                return start;
            } else if (midValue > lastValue) {
                return end - 1;
            } else {
                return mid;
            }
        }
    }

    private static void swapValue(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

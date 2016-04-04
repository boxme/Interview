package com.caarly.caarlymarketplace.app;

import java.util.Random;

/**
 * Created by desmond on 15/6/15.
 */
public class MergeSort {

    private static int[] helperArray;

    public static void main(String[] args) {
        int[] numbers = new int[7];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(20);
        }

        MergeSort sort = new MergeSort();
        sort.testNull();
        sort.testEmpty();
        sort.testSimpleElement();
        sort.testSpecial();

        MergeSort.sort(numbers);
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

    public static void sort(int[] array) {
        if (array == null || array.length == 0) return;

        helperArray = new int[array.length];
        sort(array, 0, array.length - 1);
        helperArray = null;
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int low, int mid, int hi) {

        for (int i = low; i <= hi; ++i) {
            helperArray[i] = array[i];
        }

        int a = low;
        int b = mid + 1;
        int index = low;

        while ((a <= mid) && (b <= hi)) {
            array[index++] = helperArray[a] < helperArray[b]
                    ? helperArray[a++] : helperArray[b++];
        }

        while (a <= mid) {
            array[index++] = helperArray[a++];
        }

        while (b <= hi) {
            array[index++] = helperArray[b++];
        }
    }
}

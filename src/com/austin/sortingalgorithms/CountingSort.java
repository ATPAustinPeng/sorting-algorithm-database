package com.austin.sortingalgorithms;

public class CountingSort {

    public int[] countingSort(int[] arr) {
        int max = findLargest(arr);
        int[] indices = new int[max + 1];

        // stores the number of occurrences of each number in the array to their respective index
        // ex. occurrences of the number 1, will be stored at index 1
        for (int i = 0; i < arr.length; i++) {
            indices[arr[i]]++;
        }

        // add occurrences of all indices previous to the current index to the number of occurrences at the current index
        // essentially marks out the relative positions of each number in the array
        for (int i = 1; i < indices.length; i++) {
            indices[i] = indices[i] + indices[i - 1];
        }

        int[] sorted = new int[arr.length];

        // loop from end of the array being sorted (makes the algorithm stable)
        // places each element into their sorted location
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[indices[arr[i]] - 1] = arr[i];
            indices[arr[i]]--;
        }
        return sorted;
    }

    /**
     * Finds the largest element in the array.
     * @param arr the array where the largest element needs to be found
     * @return the max value in the array
     */
    public int findLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

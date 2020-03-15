package com.austin.sortingalgorithms;

public class RadixSort {

    public void radixSort(int[] arr) {
        int max = findLargest(arr);

        for (int place = 1; max / place > 0; place *= 10) {
            digitCountingSort(arr, place);
        }
    }

    public void digitCountingSort(int[] arr, int place) {
        // find max digit for the specified place
        int maxDigit = 0;

        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / place) % 10;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }

        int[] indices = new int[maxDigit + 1];

        // stores the number of occurrences of each number in the array to their respective index
        // ie. occurrences of the number 1, will be stored at index 1
        for (int i = 0; i < arr.length; i++) {
            // counts occurrences of the digit specified by place
            // ie if place = 1, we get the ones digit
            indices[(arr[i] / place) % 10]++;
        }

        // add occurrences of all indices previous to the current index to the number of occurrences of the index
        // this essentially marks out the relative positions of each number in the array
        for (int i = 1; i < indices.length; i++) {
            indices[i] = indices[i] + indices[i - 1];
        }

        int[] sorted = new int[arr.length];

        // loop from end of the array being sorted because we want counting sort to be stable
        // since our indices array provides the right most index for a repeated element in the array being sort,
        // we make sure to leave space before for the same element that appears first
        for (int i = arr.length - 1; i >= 0; i--) {
            // note I subtract 1 from all elements of occurrences because Java starts indexing at 0 not 1.
            sorted[indices[(arr[i] / place) % 10] - 1] = arr[i];
            indices[(arr[i] / place) % 10]--;
        }

        // replace the array with the array sorted by digits (aka significant figure)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
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


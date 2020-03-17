package com.austin.sortingalgorithms;

public class ShellSort {
    public void shellSort(int[] arr) {
        // Shell's original increment (n/2, n/4, n/8, ..., 1)
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            incrementInsertionSort(arr, increment);
        }
    }

    public void incrementInsertionSort(int[] arr, int increment) {
        // add 1 more element until each increment of the array is sorted
        for (int i = increment; i < arr.length; i++) {

            // perform insertion sort onto each increment of elements
            // swapping until the each element is placed in the right location
            for (int j = i; j >= increment && arr[j] < arr[j - increment]; j -= increment) {
                swap(arr, j, j - increment);
            }
        }
    }

    /**
     * Helper method for incrementInsertionSort. Swaps the elements at the given indices.
     * @param indexA the index of the element to swap
     * @param indexB the index of the other element to swap
     */
    public void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}

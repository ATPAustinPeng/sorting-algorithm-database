package com.austin.sortingalgorithms;

import java.util.Arrays;

public class QuickSort {
    /**
     * com.austin.sorting.QuickSort using the last element as the pivot.
     * My implementation of Hoare's Parition method uses the first element as the pivot.
     *
     * @param arr the array being sorted
     * @param p   the beginning index of the array/subarray being sorted
     * @param r   the end index of the array/subarray being sorted (also the used as the pivot element)
     */
    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
//            int q = partition(arr, p, r);
//            quickSort(arr, p, q - 1);
//            quickSort(arr, q + 1, r);

            int q = hoarePartition(arr, p, r);
            quickSort(arr, p, q);
            quickSort(arr, q + 1, r);
//            int q = medianOfThreePartition(arr, p, r);

        }
    }

    /**
     * com.austin.sorting.QuickSort which implements a while loop to recursively call com.austin.sorting.QuickSort on the second half of the partition
     *
     * @param arr the array being sorted
     * @param p   the beginning index of the array/subarray being sorted
     * @param r   the end index of the array/subarray being sorted (also the used as the pivot element)
     */
    public void tailRecursiveQuickSort(int[] arr, int p, int r) {
        while (p < r) {
            int q = partition(arr, p, r);
            tailRecursiveQuickSort(arr, p, q - 1);
            p = q + 1;
        }
    }

    /**
     * Partitions the array
     *
     * @param arr the array to be partitioned
     * @param p   the beginning index of the array/subarray being sorted
     * @param r   the end index of the array/subarray being sorted (also the used as the pivot element)
     * @return the index of the partition
     */
    public int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;

        // loop through all except for the last element
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    /**
     * Partitions the array with Hoare's method.
     * This method swaps elements to the elements smaller than the pivot from the left
     * to elements larger than the pivot on the right.
     * When the left and right pointers cross, the parition location is found, as it is the location where
     * all elements to the right are larger than the pivot and all elements to the left are all less than the pivot.
     *
     * @param arr the array to be partitioned
     * @param p   the beginning index of the array/subarray being sorted
     * @param r   the end index of the array/subarray being sorted (also the used as the pivot element)
     * @return the index of the partition
     */
    public int hoarePartition(int[] arr, int p, int r) {
        int x = arr[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            do {
                i++;
            }
            while (arr[i] < x);

            do {
                j--;
            }
            while (arr[j] > x);

            if (i >= j) {
                return j;
            } else {
                swap(arr, i, j);
            }
        }
    }

    /**
     * Partitions the array by choosing the pivot to be the median of 3 values (first, middle, and last elements).
     *
     * @param arr the array to be partitioned
     * @param p   the beginning index of the array/subarray being sorted
     * @param r   the end index of the array/subarray being sorted (also the used as the pivot element)
     * @return the index of the partition
     */
    public int medianOfThreePartition(int[] arr, int p, int r) {
        int x = getMedian(arr, p, r);
        int i = p - 1;

        // loop through all except for the last element
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    /**
     * Gets the median value of the array (either the first, middle, or last element).
     * This method also performs swaps to make sure that the median element is located at the
     *
     * @param arr   the array being sorted
     * @param left  the leftmost index of the array/subarray being partitioned
     * @param right the rightmost index of the array/subarray being partitioned
     * @return the median value of the array
     */
    public int getMedian(int[] arr, int left, int right) {
        int center = (left + right) / 2;

        if (arr[left] > arr[center])
            swap(arr, left, center);

        if (arr[left] > arr[right])
            swap(arr, left, right);

        if (arr[center] > arr[right])
            swap(arr, center, right);

        swap(arr, center, right);
        return arr[right];
    }

    /**
     * Helper method for quickSort. Swaps the elements at the given indices.
     *
     * @param arr    the array including the indices you would like to swap
     * @param indexA the index of the element to swap
     * @param indexB the index of the other element to swap
     */
    public void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}

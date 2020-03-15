package com.austin.sortingalgorithms;

public class MergeSort {

    public int[] mergeSort(int[] arr) {
        // if the array is size 1, it is sorted by definition
        if (arr.length == 1) {
            return arr;
        }

        // split the array into halves
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // call merge sort on each half
        left = mergeSort(left);
        right = mergeSort(right);

        // merge the two halves by comparing each element and putting the smaller element into the sorted array.
        return merge(left, right);
    }

    // helper method for mergeSort

    /**
     * Helper method for mergeSort. Merges two arrays by comparing elements in the split arrays with one another
     * and putting the smaller of the two into the sorted array
     * @param a the left half of the array being merged
     * @param b the right half of the array being merged
     * @return a sorted array with all the elements from a and b
     */
    public static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int aPointer = 0;
        int bPointer = 0;

        while(aPointer <  a.length && bPointer < b.length) {
            if (a[aPointer] < b[bPointer]) {
                merged[aPointer + bPointer] = a[aPointer];
                aPointer++;
            } else {
                merged[aPointer + bPointer] = b[bPointer];
                bPointer++;
            }
        }

        while (aPointer < a.length) {
            merged[aPointer + bPointer] = a[aPointer];
            aPointer++;
        }

        while (bPointer < b.length) {
            merged[aPointer + bPointer] = b[bPointer];
            bPointer++;
        }

        return merged;
    }
}

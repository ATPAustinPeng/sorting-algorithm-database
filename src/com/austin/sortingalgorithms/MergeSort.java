package com.austin.sortingalgorithms;

public class MergeSort {

    public int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    // helper method for mergeSort
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

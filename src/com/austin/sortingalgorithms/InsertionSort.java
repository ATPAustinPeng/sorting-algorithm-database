package com.austin.sortingalgorithms;

public class InsertionSort {
    public int[] insertionSort(int[] arr) {

        // for each element, insert it into the right index within the sorted part of the array
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
}

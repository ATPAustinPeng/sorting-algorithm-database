package com.austin.sortingalgorithms;

public class SelectionSort {
    public int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minValIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minValIndex]) {
                    minValIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minValIndex];
            arr[minValIndex] = temp;
        }
        return arr;
    }
}

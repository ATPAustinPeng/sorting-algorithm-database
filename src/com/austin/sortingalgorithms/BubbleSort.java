package com.austin.sortingalgorithms;

public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swaps = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps = true;
                }
            }

            if (!swaps) {
                break;
            }
        }
        return arr;
    }
}

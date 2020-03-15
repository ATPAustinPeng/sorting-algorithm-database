package com.austin.sortingalgorithms;

public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swaps = false;

            // compares each previous element with the next, if the previous is greater than the next, swap them
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps = true;
                }
            }

            // if no swaps occurred through anyone iteration, the array must be sorted
            if (!swaps) {
                break;
            }
        }
        return arr;
    }
}

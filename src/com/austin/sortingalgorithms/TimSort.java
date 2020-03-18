package com.austin.sortingalgorithms;

public class TimSort {
    public void timSort(int[] arr, int runSize) {
        // run insertion sort on each runSize length subarray in arr
        for (int i = 0; i < arr.length; i += runSize) {
            insertionSort(arr, i, Math.min(i + runSize - 1, arr.length - 1));
        }

        // merge every runSize segment together, then merge runSize * 2 segement, etc.
        // until size of merged array is greater than the original array length
        for (int size = runSize; size < arr.length; size *= 2) {
            for (int left = 0; left < arr.length; left += 2 * size) {
                merge(arr, left, left + size - 1, Math.min(left + (2 * size) - 1, arr.length - 1));
            }
        }
    }

    public void insertionSort(int[] arr, int left, int right) {
        for (int i = left; i < right; i++) {
            int j = i + 1;
            while (j > left && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    // Merges arr[left ... mid] and arr[mid + 1 ... right]
    public void merge(int[] arr, int left, int mid, int right) {
        int[] l = new int[mid - left + 1];
        int[] r = new int[right - mid];

        for (int x = 0; x < l.length; x++) {
            l[x] = arr[left + x];
        }
        for (int x = 0; x < r.length; x++) {
            r[x] = arr[mid + 1 + x];
        }

        // l pointer
        int i = 0;

        // r pointer
        int j = 0;

        // original arr pointer
        int k = left;

        while(i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < l.length) {
            arr[k] = l[i];
            i++;
            k++;
        }

        while (j < r.length) {
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    /**
     * Helper method for insertionSort. Swaps the elements at the given indices.
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

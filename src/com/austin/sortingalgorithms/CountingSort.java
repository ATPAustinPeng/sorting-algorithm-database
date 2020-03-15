package com.austin.sortingalgorithms;

import java.util.Arrays;

public class CountingSort {

    public int[] countingSort(int[] arr) {
        int max = findLargest(arr);
        int[] indices = new int[max + 1];

        // stores the number of occurrences of each number in the array to their respective index
        // ie. occurences of the number 1, will be stored at index 1
        for (int i = 0; i < arr.length; i++) {
            indices[arr[i]]++;
        }

        // add occurences of all indices previous to the current index to the number of occurences of the index
        // this essentially marks out the relative positions of each number in the array
        for (int i = 1; i < indices.length; i++) {
            indices[i] = indices[i] + indices[i - 1];
        }

        // then subtract 1 from all elements of occurences
        // this is because Java is indexed at 0, and our array is indexed beginning with 1
//        for (int i = 0; i < indices.length; i++) {
//            indices[i]--;
//        }

        int[] sorted = new int[arr.length];

        // loop from end of the array being sorted because we want counting sort to be stable
        // since our indices array provides the right most index for a repeated element in the array being sort,
        // we make sure to leave space before for the same element that appears first
        // ie if we were to sort {1,2,3,1}, the process of placing elements would be as follows
        // [0, 1, 0, 0], note that the 1 placed into the array is actually the 2nd occurence of the 1 in the array {1,2,3,"1"}
        // [0, 1, 0, 3]
        // [0, 1, 2, 3]
        // [1, 1, 2, 3]
        // [1, 1, 2, 3]
        // if we were to start our for loop from 0 to the array length - 1, we would be placing repeated elements
        // in reverse order of appearances in the array we want to sort
        // ie if we were to sort {1,2,3,1}, the process of placing elements would be as follows
        // [0, 1, 0, 0], note that the 1 placed into the array is now actually the 1st occurence of the 1 in the array {"1",2,3,1}
        // [0, 1, 0, 3]
        // [0, 1, 2, 3]
        // [1, 1, 2, 3]
        // [1, 1, 2, 3]
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[indices[arr[i]] - 1] = arr[i];
            indices[arr[i]]--;
            System.out.println(Arrays.toString(sorted));
        }
        return sorted;
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

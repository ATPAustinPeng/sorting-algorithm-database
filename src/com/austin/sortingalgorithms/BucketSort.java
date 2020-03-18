package com.austin.sortingalgorithms;

import java.util.ArrayList;

public class BucketSort {
    public ArrayList<Integer> bucketSort(ArrayList<Integer> arr) {
        int max = findMax(arr);
        int numOfBuckets = arr.size();
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();

        // initializes each bucket in the list of buckets
        for(int i = 0; i < numOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // maps and adds each element from the given array to their respective buckets
        for (Integer element : arr) {
            buckets.get(mapElementWithNumOfBuckets(element, max, numOfBuckets)).add(element);
        }

        // sorts each bucket with insertion sort
        for (ArrayList<Integer> bucket : buckets) {
            for (int j = 0; j < bucket.size() - 1; j++) {
                for (int k = j + 1; k > 0; k--) {
                    if (bucket.get(k) < bucket.get(k - 1)) {
                        swap(bucket, k, k - 1);
                    }
                }
            }
        }

        // clears the unsorted array before putting the sorted array into it
        arr.clear();

        for (ArrayList<Integer> bucket : buckets) {
            arr.addAll(bucket);
        }
        return arr;
    }

    /**
     * Helper method for bucketSort. Swaps the elements at the given indices.
     *
     * @param arr    the array including the indices you would like to swap
     * @param indexA the index of the element to swap
     * @param indexB the index of the other element to swap
     */
    public void swap(ArrayList<Integer> arr, int indexA, int indexB) {
        int temp = arr.get(indexA);
        arr.set(indexA, arr.get(indexB));
        arr.set(indexB, temp);
    }

    /**
     * Maps the element in the array needed to be sorted to the right bucket.
     * @param element the element needed to place in a bucket
     * @param max the max value in the array needed to be sorted
     * @param numOfBuckets the size of the array needed to be sorted (aka the number of buckets)
     * @return the index of the bucket the element will be placed in
     */
    public int mapElementWithNumOfBuckets(int element, int max, int numOfBuckets) {
        // multiply by numOfBuckets - 1 because Java indexes starting with 0
        // and numOfBuckets counts buckets starting from 1
        return (int) ( (double) element / max * (numOfBuckets - 1));
    }

    /**
     * Finds the largest element in the array.
     * @param arr the array where the largest element needs to be found
     * @return the max value in the array
     */
    public int findMax(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }
}


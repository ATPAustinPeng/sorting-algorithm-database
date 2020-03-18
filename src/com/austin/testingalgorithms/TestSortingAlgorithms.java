package com.austin.testingalgorithms;

import com.austin.sortingalgorithms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSortingAlgorithms {
    public static void main(String[] args) {
        TestCaseGenerator caseGenerator = new TestCaseGenerator();

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        HeapSort heapSort = new HeapSort();
        CountingSort countingSort = new CountingSort();
        RadixSort radixSort = new RadixSort();
        BucketSort bucketSort = new BucketSort();
        ShellSort shellSort = new ShellSort();
        TimSort timSort = new TimSort();

        System.out.println("Test case consists of both positive and negative integers.");

        int[] testCase1 = caseGenerator.generateCase(10, -100, 100);
        System.out.printf("%-17s" + Arrays.toString(bubbleSort.bubbleSort(testCase1)) + "\n", "Bubble Sort: ");
        System.out.printf("%-17s" + Arrays.toString(selectionSort.selectionSort(testCase1)) + "\n", "Selection Sort: ");
        System.out.printf("%-17s" + Arrays.toString(insertionSort.insertionSort(testCase1)) + "\n", "Insertion Sort: ");
        System.out.printf("%-17s" + Arrays.toString(mergeSort.mergeSort(testCase1)) + "\n", "Merge Sort: ");

        int[] copyTestCase1 = new int[testCase1.length];
        System.arraycopy(testCase1, 0, copyTestCase1, 0, testCase1.length);
        quickSort.quickSort(copyTestCase1, 0, copyTestCase1.length - 1);
        System.out.printf("%-17s" + Arrays.toString(copyTestCase1) + "\n", "Quick Sort: ");

        System.out.printf("%-17s" + heapSort.heapSort(testCase1) + "\n", "Heap Sort: ");
        System.out.println("\n");


        System.out.println("Test case consists of only positive integers.");

        int[] testCase2 = caseGenerator.generateCase(10, 0, 999);
        System.out.printf("%-17s" + Arrays.toString(countingSort.countingSort(testCase2)) + "\n", "Counting Sort: ");

        int[] copyTestCase2 = new int[testCase2.length];
        System.arraycopy(testCase2, 0, copyTestCase2, 0, testCase2.length);
        radixSort.radixSort(copyTestCase2);
        System.out.printf("%-17s" + Arrays.toString(copyTestCase2) + "\n", "Radix Sort: ");

        List<Integer> anotherCopyTestCase2 = Arrays.stream(testCase2).boxed().collect(Collectors.toList());
        System.out.printf("%-17s" + bucketSort.bucketSort((ArrayList<Integer>) anotherCopyTestCase2) + "\n", "Bucket Sort: ");


        int[] oneMoreCopyTestCase2 = new int[testCase2.length];
        System.arraycopy(testCase2, 0, oneMoreCopyTestCase2, 0, testCase2.length);
        shellSort.shellSort(oneMoreCopyTestCase2);
        System.out.printf("%-17s" + Arrays.toString(oneMoreCopyTestCase2) + "\n", "Shell Sort: ");

        int[] lastCopyTestCase2 = new int[testCase2.length];
        System.arraycopy(testCase2, 0, lastCopyTestCase2, 0, testCase2.length);
        timSort.timSort(lastCopyTestCase2, 32);
        System.out.printf("%-17s" + Arrays.toString(lastCopyTestCase2) + "\n", "Timsort: ");
    }
}

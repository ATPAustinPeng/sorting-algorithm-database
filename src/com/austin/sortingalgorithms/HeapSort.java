package com.austin.sortingalgorithms;

import com.austin.heap.Heap;

public class HeapSort {
    public Heap heapSort(int[] arr) {
        Heap heap = new Heap(arr);
        heap.heapSort();
        return heap;
    }
}

package com.austin.heap;

// Note: all methods are indexed from 0
public class Heap {

    private int[] array;
    private int heapSize;

    public Heap() {
        array = new int[0];
        heapSize = 0;
    }

    public Heap(int[] inputArr) {
        array = new int[inputArr.length];
        System.arraycopy(inputArr, 0, array, 0, inputArr.length);
        heapSize = inputArr.length;
    }

    public String toString() {
        String str = "[" + array[0];
        for (int i = 1; i < array.length; i++) {
            str = str + ", " + array[i];
        }
        str = str + "]";

        return str;
    }

    /**
     * Adds the key to the array.
     * @param key the element you want to add to the array
     */
    public void add(int key) {
        int[] temp = new int[array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[temp.length - 1] = key;
        array = temp;
        heapSize++;
    }

    /**
     * Removes the element at the specified index.
     * @param index the index of the element you want to remove
     */
    public void remove(int index) {
        int[] temp = new int[array.length - 1];
        int tempCounter = 0;
        for (int arrayCounter = 0; arrayCounter < array.length; arrayCounter++) {
            if (arrayCounter == index) {
                arrayCounter++;
                continue;
            }
            temp[tempCounter] = array[arrayCounter];
            tempCounter++;
        }
        array = temp;
        heapSize--;
    }

    public int getParent(int index) {
        return index / 2 - 1;
    }

    public int getLeft(int index) {
        return 2 * index + 1;
    }

    public int getRight(int index) {
        return 2 * index + 2;
    }

    /**
     * Max heapifies the node at index i.
     * @param i the index of the node you are max heapifying
     */
    public void maxHeapify(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest;

        // if left element is bigger than parent, remember it
        if (left < heapSize && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        // if right element is bigger than parent, remember it
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        // if the index of the largest value is not the index of i, swap the elements at i and largest
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Helper method for maxHeapify. Swaps the elements at the given indices.
     * @param indexA the index of the element to swap
     * @param indexB the index of the other element to swap
     */
    public void swap(int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public void buildMaxHeap() {
        heapSize = array.length;
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = array.length - 1; i > 0; i--) {
            swap(0, i);
            heapSize -= 1;
            maxHeapify(0);
        }
        heapSize = array.length;
    }

    public int getMaximum() {
        return array[0];
    }

    public int extractMaximum() {
        if (heapSize < 1) {
            System.out.println("ERROR: Heap Underflow (size < 1)");
            // TODO: if the error is printed out, the below code will still run... I need to throw an exception
        }

        int max = array[0];
        array[0] = array[heapSize - 1];
        remove(heapSize - 1);
        maxHeapify(0);
        return max;
    }

    public void heapIncreaseKey(int index, int key) {
        if (key < array[index]) {
            System.out.println("ERROR: New key has smaller value than current key.");
            return;
        }

        array[index] = key;
        while (index > 0 && array[getParent(index)] < array[index]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public void maxHeapInsert(int key) {
        heapSize++;
        add(Integer.MIN_VALUE);
        heapIncreaseKey(heapSize, key);
    }
}

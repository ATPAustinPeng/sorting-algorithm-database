import com.austin.sortingalgorithms.*;
import java.util.Arrays;

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

        for (int i = 0; i < 5; i++) {
            int[] testCase1 = caseGenerator.generateCase(10, -100, 100);
//            System.out.println(Arrays.toString(bubbleSort.bubbleSort(testCase1)));
//            System.out.println(Arrays.toString(selectionSort.selectionSort(testCase1)));
//            System.out.println(Arrays.toString(insertionSort.insertionSort(testCase1)));
            System.out.println(Arrays.toString(mergeSort.mergeSort(testCase1)));
//
            int[] testCase2 = new int[testCase1.length];
            System.arraycopy(testCase1,0, testCase2, 0, testCase1.length);
            quickSort.quickSort(testCase2, 0, testCase2.length - 1);
            System.out.println(Arrays.toString(testCase2));
//
//            System.out.println(heapSort.heapSort(testCase1));
//
//            int[] testCase3 = caseGenerator.generateCase(10,0,1000);
//            System.out.println(Arrays.toString(countingSort.countingSort(testCase3)));
//
//            int[] testCase4 = new int[testCase3.length];
//            System.arraycopy(testCase3,0, testCase4, 0, testCase3.length);
//            radixSort.radixSort(testCase4);
//            System.out.println(Arrays.toString(testCase4));
        }
    }

}

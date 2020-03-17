# sorting-algorithm-database

Below is a list of sorting algorithms I will be covering (in Java programming language).

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort
5. Quick Sort
6. Heap Sort
7. Counting Sort
8. Radix Sort
9. Bucket Sort
10. Shell Sort
11. Tree Sort
12. Timsort
13. Cubesort


## Basic Info On Each Sorting Algorithm
- **Name**: the algorithm name
- **O(n) worst case**: the time complexity of the worst case scenario and what the worst case is
- **O(n) average case**: the time complexity of the average case scenario
- **O(n) best case**: the time complexity of the best case scenario and what the best case is
- **Space Complexity**: the amount of memory space required to solve an instance of the computational problem as a function of the size of the input
- **Stable**: whether two objects with equal keys/values appear in the same order in sorted output as they appear in the input array to be sorted
- **Adaptive**: whether the order of the elements to be sorted of an input array matters (or) affects the time complexity of a sorting algorithm
- **Class**: whether the algorithm is comparison or non-comparison sorting


Note: k = the max value in the array
Note: d = the max value in the array of digits (aka bits used to represent the max value)
Note: b = the number of buckets

 
Algorithm      | O(n) Worst Case    | O(n) Avg Case    | O(n) Best Case   | Space Complexity | Stable | Adaptive | Class
---------------| ------------------ | ---------------- | ---------------- | ---------------- | ------ | -------- | --------------
Bubble Sort    | O(n<sup>2</sup>)   | O(n<sup>2</sup>) | O(n)             | O(1)             | Yes    | Yes      | Comparison
Selection Sort | O(n<sup>2</sup>)   | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1)             | Yes    | No       | Comparison
Insertion Sort | O(n<sup>2</sup>)   | O(n<sup>2</sup>) | O(n)             | O(1)             | Yes    | Yes      | Comparison
Merge Sort     | O(nlog(n))         | O(nlog(n))       | O(nlog(n))       | O(n)             | Yes    | No       | Comparison
Quick Sort     | O(n<sup>2</sup>)   | O(nlog(n))       | O(nlog(n))       | O(log(n))        | No     | No       | Comparison
Heap Sort      | O(nlog(n))         | O(nlog(n))       | O(nlog(n))       | O(1)             | No     | No       | Comparison
Counting Sort  | O(n + k)           | O(n + k)         | O(n + k)         | O(n + k)         | Yes    | No       | Non-comparison
Radix Sort     | O(dn)              | O(dn)            | O(dn)            | O(n + d)         | Yes    | No       | Non-comparison
Bucket Sort    | O(n<sup>2</sup>)   | O(n + b)         | O(n + b)         | O(bn)            | Yes    | No       | Comparison
Shell Sort     | O(n<sup>2</sup>)** | O(nlog(n))       | O(nlog(n))       | O(n)             | No     | Yes      | Comparison
Tree Sort      | 
Timsort        | 
Cubesort       | 

**Shell Sort worst case runtime depends on the increments used. Using Shell's original increment the worst case is O(n<sup>2</sup>).

## A Little More In-Depth

Here, I will be describing how each algorithm sorts, explaining the best and worst case inputs, 
and sharing other important ideas about each algorithm.

Note: All the information I cover here are based off my implementation of each sorting algorithm. 
There are too many variations of each sorting algorithm and I cannot possibly cover them all. 
Additionally, I have only implemented the algorithms to sort integers.

### Bubble Sort
* **How It Works**
    * Loops through the array, comparing the current element to the next.
    * If the current element is greater than the next, swap the two elements.
    * Sorts from the end of the array to the front.
* **Best Case Scenario**
    * If the given array is in ascending order.
* **Worst Case Scenario**
    * If the given array is in descending order.
    
### Selection Sort
* **How It Works**
    * Finds the minimum value in the array and swaps it with the first unsorted element from the front of the array.
    * Sorts from the front of the array to the end.
* **Best Case Scenario**
    * If the given array is in ascending order.
* **Worst Case Scenario**
    * If the given array is in descending order.
    
### Insertion Sort
* **How It Works**
    * Loops through the array, taking the each element and placing it into its sorted position.
    * Sorts from the front of the array to the end.
* **Best Case Scenario**
    * If the given array is in ascending order.
* **Worst Case Scenario**
    * If the given array is in descending order.

### Merge Sort
* **How It Works**
    * Splits the given array down into arrays of size 1 (which are sorted by definition)
    * Combines the split arrays together by looking at each array as if it were a stack of cards.
    * It picks the smaller of the elements among 2 split arrays and puts it into the sorted array.
* **Best Case Scenario**
    * If the given array is in ascending order.
* **Worst Case Scenario**
    * If each element left branch of the split arrays is larger than its respective element in the right branch of the split arrays.
    * This is the worst case because it causes the most comparisons during the sort.
    * An example is this array [4,0,6,2,5,1,7,3]
    
### Quick Sort
* **How It Works**
    * Partitions the array/subarrays with a pivot (using Lomuto's, Hoare's, Median of Three, or other methods)
    , placing elements larger than the pivot to the right of the pivot, and elements smaller than the pivot to the left of the pivot.
    * Repeats this partitioning and pivot step for every subarray until the subarray is size 1 (which is sorted by definition).
* **Best Case Scenario**
    * If the pivot pick is always the middle or near the middle element of the array/subarray.
* **Worst Case Scenario**
    * If the pivot picked is always the smallest or largest element of the array/subarray.

### Heap Sort
* **How It Works**
    * Uses the max heap property of a heap to sort the array.
    * Swaps the first element of the heap with the last element.
    * Then max heapify the heap, excluding the last element of the heap.
    * Repeat for all elements in the heap.
    Sorts the array from left to right, down to top (with respect to the heap)
* **Best Case Scenario**
    * N/A
* **Worst Case Scenario**
    * N/A

### Counting Sort
* **Assumptions**
    * Elements in the array are non-negative integers.
* **How It Works**
    * Counts the occurrences of each distinct element in the array.
    * Store the cumulative sum of elements into the array, meaning the element at each index is equal to the sum of 
    itself and all the preceding elements.
    * Loop through the original array from the last index to the first. 
    * Using the array containing cumulative sum of elements, place each element into the right location.
* **Best Case Scenario**
    * When maximum value of the elements in the given array is small.
* **Worst Case Scenario**
    * When the maximum value of the elements in the given array is large.

### Radix Sort
* **Assumptions**
    * Elements in the array are non-negative integers.
* **How It Works**
    * Uses a stable sorting algorithm (I used counting sort) to sort the elements in the given array by the ones digit, tens digit, and so on.
* **Best Case Scenario**
    * When small digit numbers (base 2, base 10, etc.) are used, the intermediate sorting algorithm (counting sort) doesn't use too much space.
* **Worst Case Scenario**
    * When large digit numbers (32-bit, 64-bit) are used, the intermediate sorting algorithm (counting sort) takes a lot of space

### Bucket Sort (aka Bin Sort)
* **Assumptions**
    * Elements in the array are non-negative integers.
* **How It Works**
    * Distribute elements of an array into a number of buckets.
    * Each bucket is sorted individually using a sorting algorithm (preferably a stable sort).
    * Then each sorted bucket is concatenated into one single array of elements.
* **Best Case Scenario**
    * When the input is uniformly distributed and elements in each bucket are in ascending order.
* **Worst Case Scenario**
    * When the elements in the input array are not uniformly distributed over a range, causing a bucket to fill 
    significantly more than others, and causing insertion sort to run with O(n<sup>2</sup>)
    
### Shell Sort (aka Diminishing Increment Sort)
* **How It Works**
    * Break the given array into increments using Shell's original sequence (n / 2, n / 4 ... 1), or any other increment method,
    where n is the size of the array.
    * Sorts elements on the given increments with insertion sort.
* **Best Case Scenario**
    * When the array is already in ascending order (least comparisons).
* **Worst Case Scenario**
    * When the array is in descending order (insertion sort worst case takes O(n<sup>2</sup>)).

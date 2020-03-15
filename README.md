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

 
Algorithm      | O(n) Worst Case  | O(n) Avg Case    | O(n) Best Case   | Space Complexity | Stable | Adaptive | Class
---------------| ---------------- | ---------------- | ---------------- | ---------------- | ------ | -------- | --------------
Bubble Sort    | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(n)             | O(1)             | Yes    | Yes      | Comparison
Selection Sort | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1)             | Yes    | No       | Comparison
Insertion Sort | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(n)             | O(1)             | Yes    | Yes      | Comparison
Merge Sort     | O(nlog(n))       | O(nlog(n))       | O(nlog(n))       | O(n)             | Yes    | No       | Comparison
Quick Sort     | O(n<sup>2</sup>) | O(nlog(n))       | O(nlog(n))       | O(log(n))        | No     | No       | Comparison
Heap Sort      | O(nlog(n))       | O(nlog(n))       | O(nlog(n))       | O(1)             | No     | No       | Comparison
Counting Sort  | O(n + k)         | O(n + k)         | O(n + k)         | O(n + k)         | Yes    | No       | Non-comparison
Radix Sort     | O(dn)            | O(dn)            | O(dn)            | O(n + d)         | Yes    | No       | Non-comparison
Bucket Sort    | 
Shell Sort     |  
Tree Sort      | 
Timsort        | 
Cubesort       | 


## A Little More In-Depth

Here, I will be describing how each algorithm sorts, explaining the best and worst case inputs, 
and sharing other important ideas about each algorithm.

Note: All the information I cover here are based off my implentation of each sorting algorithm. 
There are too many variations of each sorting algorithm and I cannot possibly cover them all.

### Bubble Sort
* **How It Works**
    * Loops through the array, comparing the current element to the next.
    * If the current element is greater than the next, swap the two elements.
    * Sorts from the end of the array to the front.
* **Best Case Situation**
    * If the given array is in ascending order.
* **Worst Case Situation**
    * If the given array is in descending order.
    
### Selection Sort
##### How It Works
* Finds the minimum value in the array and inserts it to the front.
* Sorts from the front of the array to the end.
##### Best Case Situation
* N/A
##### Worst Case Situation
* If the given array is in descending order.

package com.austin.testingalgorithms;

public class TestCaseGenerator {
    /**
     * Fills an int array of the specified size with elements ranging from [-range / 2, range / 2)
     * @param size the size of the int array test case
     * @param min the lower bound of the range of elements being generated (inclusive)
     * @param max the upper bound of the range of elements being generated (inclusive
     * @return the int array with elements
     */
    public int[] generateCase(int size, int min, int max) {
        int[] testCase = new int[size];

        for (int i = 0; i < size; i++) {
            testCase[i] = min + (int)(Math.random() * (max - min + 1));
        }
        return testCase;
    }
}

package edu.charlotte.sorting_techniques;

import java.util.Arrays;

/**
 * This class contains various method for sorting the array using Merge Sort.
 * No one can create an object for this class. The class is designed using Singleton Design Pattern.
 *
 * The documentation for the methods contained in this class includes brief descriptions of the implementations.
 * Such descriptions should be regarded as implementation notes.
 */
public class MergeSort {
    private static MergeSort instance = null;

    // Private constructor to ensure Singleton pattern
    private MergeSort() {}

    // Method to get a single instance of MergeSort
    public static synchronized MergeSort getInstance() {
        if (instance == null)
            instance = new MergeSort();
        return instance;
    }

    /**
     * Method to perform Sorting.
     * The algorithm works on the basis of divide and conquer rule.
     * Calls the same method recursively as long as start index is less than end index.
     * The method calls merge method to perform merging of two arrays.
     *
     * @param values the array to be sorted
     * @param startPosition the starting index of the array
     * @param endPosition the ending index of the array
     */
    public void sort(int[] values,int startPosition, int endPosition) {
        if(startPosition < endPosition) {
            int middlePosition = (startPosition + endPosition) / 2;
            sort(values, startPosition, middlePosition);
            sort(values, middlePosition + 1, endPosition);
            merge(values, startPosition, middlePosition, endPosition);
        }
    }

    /**
     * The merge method merges two arrays in sorted way.
     *
     * @param arrayValues the array to be sorted
     * @param startPosition the starting index of the array
     * @param middlePosition th middle index of the array
     * @param endPosition the ending index of the array
     */
    public void merge(int[] arrayValues, int startPosition, int middlePosition, int endPosition) {
        int sizeOfArrayLeft = middlePosition - startPosition + 1;
        int sizeOfArrayRight = endPosition - middlePosition;
        int[] arrayLeft = Arrays.copyOfRange(arrayValues, startPosition, middlePosition + 1);
        int[] arrayRight = Arrays.copyOfRange(arrayValues, middlePosition + 1, endPosition + 1);

        int indexOfArrayLeft = 0, indexOfArrayRight = 0, index = startPosition;
        while(indexOfArrayLeft < sizeOfArrayLeft && indexOfArrayRight < sizeOfArrayRight) {
            if(arrayLeft[indexOfArrayLeft] <= arrayRight[indexOfArrayRight]) {
                arrayValues[index] = arrayLeft[indexOfArrayLeft];
                indexOfArrayLeft++;
            } else {
                arrayValues[index] = arrayRight[indexOfArrayRight];
                indexOfArrayRight++;
            }
            index++;
        }

        while(indexOfArrayLeft < sizeOfArrayLeft) {
            arrayValues[index] = arrayLeft[indexOfArrayLeft];
            indexOfArrayLeft++;
            index++;
        }

        while(indexOfArrayRight < sizeOfArrayRight) {
            arrayValues[index] = arrayRight[indexOfArrayRight];
            indexOfArrayRight++;
            index++;
        }
    }
}

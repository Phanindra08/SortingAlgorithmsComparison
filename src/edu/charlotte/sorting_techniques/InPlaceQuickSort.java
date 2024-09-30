package edu.charlotte.sorting_techniques;

import edu.charlotte.utils.SortingAlgorithmsUtilities;

import java.util.Random;

/**
 * This class contains various method for sorting the array using In-Place Quick Sort.
 * No one can create an object for this class. The class is designed using Singleton Design Pattern.
 *
 * The documentation for the methods contained in this class includes brief descriptions of the implementations.
 * Such descriptions should be regarded as implementation notes.
 */
public class InPlaceQuickSort {
    private static InPlaceQuickSort instance = null;
    private static final Random RANDOM_OBJECT = new Random();

    // Private constructor to ensure Singleton pattern
    private InPlaceQuickSort() {}

    // Method to get a single instance of InPlaceQuickSort
    public static synchronized InPlaceQuickSort getInstance() {
        if (instance == null)
            instance = new InPlaceQuickSort();
        return instance;
    }

    /**
     * Method to perform Sorting.
     * Taking first element of the array as the pivot element.
     * The method calls inPlacePartition method to perform sorting.
     * Calls the sort method recursively as long as leftElementIndex is less than rightElementIndex.
     *
     * @param arrayValues the array to be sorted
     * @param leftElementIndex the starting index of the array
     * @param rightElementIndex the ending index of the array
     */
    public void sort(int[] arrayValues, int leftElementIndex, int rightElementIndex) {
        if(leftElementIndex < rightElementIndex) {
            int pivotIndex = RANDOM_OBJECT.nextInt(rightElementIndex - leftElementIndex + 1) + leftElementIndex;
            int newPivotIndex = inPlacePartition(arrayValues, leftElementIndex, rightElementIndex, pivotIndex);
            sort(arrayValues, leftElementIndex, newPivotIndex - 1);
            sort(arrayValues, newPivotIndex + 1, rightElementIndex);
        }
    }

    /**
     * The method sorts the array in such a way that all the elements to the left of pivot index are less than the pivot value
     * and all the elements to the right of the pivot index are greater than the pivot value.
     *
     * @param arrayValues the array to be sorted
     * @param leftElementIndex the starting index of the array
     * @param rightElementIndex the ending index of the array
     * @param pivot the index of pivot element
     * @return the index of the pivot is returned from the inPlacePartition method
     */
    private int inPlacePartition(int[] arrayValues, int leftElementIndex, int rightElementIndex, int pivot) {
        int pivotValue = arrayValues[pivot];
        SortingAlgorithmsUtilities.swap(arrayValues, pivot, rightElementIndex);
        int tempIndex = leftElementIndex;
        for(int i = leftElementIndex; i <= (rightElementIndex - 1); i++) {
            if(arrayValues[i] < pivotValue) {
                SortingAlgorithmsUtilities.swap(arrayValues, i, tempIndex);
                tempIndex++;
            }
        }
        SortingAlgorithmsUtilities.swap(arrayValues, tempIndex, rightElementIndex);
        return tempIndex;
    }
}

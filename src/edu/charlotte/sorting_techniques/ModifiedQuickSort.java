package edu.charlotte.sorting_techniques;

import edu.charlotte.utils.SortingAlgorithmsUtilities;

/**
 * This class contains various method for sorting the array using Modified Sort.
 * No one can create an object for this class. The class is designed using Singleton Design Pattern.
 *
 * The documentation for the methods contained in this class includes brief descriptions of the implementations.
 * Such descriptions should be regarded as implementation notes.
 */
public class ModifiedQuickSort {

    private static ModifiedQuickSort instance = null;

    // Private constructor to ensure Singleton pattern
    private ModifiedQuickSort() {}

    // Method to get a single instance of ModifiedQuickSort
    public static synchronized ModifiedQuickSort getInstance() {
        if (instance == null)
            instance = new ModifiedQuickSort();
        return instance;
    }

    /**
     * Method to perform Sorting.
     * This method calls Insertion sort if the length of the array is less than 8.
     * Taking middle element of the array as the pivot element.
     * The method calls partition method to perform sorting.
     * Calls the sort method recursively as long as lenght of the array is less than 8.
     *
     * @param arrayValues the array to be sorted
     * @param leftElementIndex the starting index of the array
     * @param rightElementIndex the ending index of the array
     */
    public void sort(int[] arrayValues, int leftElementIndex, int rightElementIndex) {
        InsertionSort insertionSortObject = InsertionSort.getInstance();
        if(rightElementIndex - leftElementIndex + 1 > 8) {
            int pivotValue = getMedian(arrayValues, leftElementIndex, rightElementIndex);
            int pivotIndex = partition(arrayValues, leftElementIndex, rightElementIndex, pivotValue);
            sort(arrayValues, leftElementIndex, pivotIndex - 1);
            sort(arrayValues, pivotIndex + 1, rightElementIndex);
        } else {
            insertionSortObject.sort(arrayValues);
        }
    }

    /**
     * The method sorts the array in such a way that all the elements to the left of pivot index are less than the pivot value
     * and all the elements to the right of the pivot index are greater than the pivot value.
     *
     * @param arrayValues the array to be sorted
     * @param leftElementIndex the starting index of the array
     * @param rightElementIndex the ending index of the array
     * @param pivotValue the value of pivot element
     * @return the index of the pivot is returned from the partition method
     */
    private int partition(int[] arrayValues, int leftElementIndex, int rightElementIndex, int pivotValue) {
        int arrayIndex1 = leftElementIndex, arrayIndex2 = rightElementIndex - 1;
        while(true) {
            while(arrayValues[++arrayIndex1] < pivotValue);
            while(pivotValue < arrayValues[--arrayIndex2]);
            if(arrayIndex1 >= arrayIndex2)
                break;
            else
                SortingAlgorithmsUtilities.swap(arrayValues, arrayIndex1, arrayIndex2);
        }
        SortingAlgorithmsUtilities.swap(arrayValues, arrayIndex1, rightElementIndex - 1);
        return arrayIndex1;
    }

    /**
     * The getMedian method sorts the first element, middle element, and the last element of the array and swaps the median of the array to
     * second position from the last of the array.
     *
     * @param arrayValues the array to be sorted
     * @param leftElementIndex the starting index of the array
     * @param rightElementIndex the ending index of the array
     * @return the value of the median is returned from the getMedian method
     */
    private int getMedian(int[] arrayValues, int leftElementIndex, int rightElementIndex) {
        int center = (leftElementIndex + rightElementIndex) / 2;
        if(arrayValues[center] < arrayValues[leftElementIndex])
            SortingAlgorithmsUtilities.swap(arrayValues, center, leftElementIndex);
        if(arrayValues[rightElementIndex] < arrayValues[leftElementIndex])
            SortingAlgorithmsUtilities.swap(arrayValues, rightElementIndex, leftElementIndex);
        if(arrayValues[rightElementIndex] < arrayValues[center])
            SortingAlgorithmsUtilities.swap(arrayValues, rightElementIndex, center);
        SortingAlgorithmsUtilities.swap(arrayValues, center, rightElementIndex - 1);
        return arrayValues[rightElementIndex - 1];
    }
}

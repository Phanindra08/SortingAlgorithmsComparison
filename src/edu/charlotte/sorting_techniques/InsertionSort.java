package edu.charlotte.sorting_techniques;

import edu.charlotte.utils.SortingAlgorithmsUtilities;

/**
 * This class contains method for sorting the array using In-Place Quick Sort.
 * No one can create an object for this class. The class is designed using Singleton Design Pattern.
 *
 * The documentation for the methods contained in this class includes brief descriptions of the implementations.
 * Such descriptions should be regarded as implementation notes.
 */
public class InsertionSort {

    private static InsertionSort instance = null;

    // Private constructor to ensure Singleton pattern
    private InsertionSort() {}

    // Method to get a single instance of InsertionSort
    public static synchronized InsertionSort getInstance() {
        if (instance == null)
            instance = new InsertionSort();
        return instance;
    }

    /**
     * Method to perform Sorting.
     * Taking the elements of the array starting from the zeroth index and comparing the values with the other values to the right of the array
     * till the last index of the array.
     * If any element to the right of the array is less than the current value of the array then swap the elements with that index.
     *
     * @param values the array to be sorted
     */
    public void sort(int[] values) {
        for(int index = 0; index < values.length; index++) {
            for(int index2 = index + 1; index2 < values.length; index2++) {
                if(values[index] > values[index2])
                    SortingAlgorithmsUtilities.swap(values, index, index2);
            }
        }
    }
}

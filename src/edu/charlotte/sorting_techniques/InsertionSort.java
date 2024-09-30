package edu.charlotte.sorting_techniques;

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
     * Taking the elements of the array starting from the first index and comparing the values with the other values to the left of the array
     * till the zeroth index of the array.
     * If any element to the left of the array is greater than the current value of the array stored in a temporary variable then store that value to the next index of the array.
     * Repeat this until the element to the left of the array is less than value in temporary variable and then store the value in the temporary variable to the next index of the array.
     *
     * @param values the array to be sorted
     */
    public void sort(int[] values) {
        int tempValue, index2;
        for(int index = 1; index < values.length; index++) {
            tempValue = values[index];
            for(index2 = index - 1; index2 >= 0; index2--) {
                if(values[index2] > tempValue)
                    values[index2 + 1] = values[index2];
                else
                    break;
            }
            values[index2 + 1] = tempValue;
        }
    }
}

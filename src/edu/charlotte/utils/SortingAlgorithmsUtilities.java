package edu.charlotte.utils;

import java.util.Random;

/**
 * This class is a Utility class that contains various method for using in this project.
 * No one can create an object for this class or extend this class. This class contains only static methods.
 *
 * The documentation for the methods contained in this class includes brief descriptions of the implementations.
 * Such descriptions should be regarded as implementation notes.
 */
public final class SortingAlgorithmsUtilities {

    private static final Random RANDOM_OBJECT = new Random();

    // Private constructor to ensure no object is created for this class.
    private SortingAlgorithmsUtilities() {}

    /**
     * Method to perform swap operation.
     * This method swaps the elements of the array at the indexes provided as parameters to the method.
     *
     * @param values the array in which the values in two indexes have to be swapped.
     * @param index1 the first index of the array to be swapped
     * @param index2 the second index of the array to be swapped
     */
    public static void swap(int[] values, int index1, int index2) {
        int duplicate;
        duplicate = values[index1];
        values[index1] = values[index2];
        values[index2] = duplicate;
    }

    /**
     * This method generated random integers at each element of the array.
     * The random value is generated using the nextInt method of the Random class in Java.
     *
     * @param arrayValues the array in which the random integer inputs have to be generated and stored.
     */
    public static void generateRandomValues(int[] arrayValues) {
        for(int index = 0; index < arrayValues.length; index++)
            arrayValues[index] = RANDOM_OBJECT.nextInt();
    }
}

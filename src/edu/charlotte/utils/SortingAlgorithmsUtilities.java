package edu.charlotte.utils;

import java.util.Random;

public final class SortingAlgorithmsUtilities {

    private static final Random RANDOM_OBJECT = new Random();
    private SortingAlgorithmsUtilities() {}

    public static void swap(int[] values, int index1, int index2) {
        int duplicate;
        duplicate = values[index1];
        values[index1] = values[index2];
        values[index2] = duplicate;
    }

    public static void generateRandomValues(int[] arrayValues) {
        for(int index = 0; index < arrayValues.length; index++)
            arrayValues[index] = RANDOM_OBJECT.nextInt();
    }
}

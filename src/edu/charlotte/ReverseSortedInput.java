package edu.charlotte;

import edu.charlotte.sorting_techniques.InsertionSort;
import edu.charlotte.utils.SortingAlgorithmsUtilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ReverseSortedInput {
    public static void main(String[] args) {
        Scanner scanningInput = new Scanner(System.in);
        System.out.print("Enter the number of inputs to be sorted: ");
        int sizeOfArray = scanningInput.nextInt();
        scanningInput.close();

        int[] inputArray = new int[sizeOfArray];
        SortingAlgorithmsUtilities.generateRandomValues(inputArray);
        int[] inputArrayInDescendingOrder = Arrays.stream(inputArray).boxed().sorted(Collections.reverseOrder()).
                mapToInt(Integer::intValue).toArray();

        int[] inputArrayForInsertionSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);

        InsertionSort insertionSortObject = InsertionSort.getInstance();
        long startTime = System.nanoTime();
        System.out.println("*** Insertion Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForInsertionSort));
        insertionSortObject.sort(inputArrayForInsertionSort);
        long endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForInsertionSort));
        long executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Insertion sort in nanoseconds is: " + executionTime);
    }
}

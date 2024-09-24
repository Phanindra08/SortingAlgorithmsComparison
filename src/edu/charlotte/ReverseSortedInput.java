package edu.charlotte;

import edu.charlotte.sorting_techniques.InsertionSort;
import edu.charlotte.sorting_techniques.MergeSort;
import edu.charlotte.utils.SortingAlgorithmsUtilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseSortedInput {
    public static void main(String[] args) {
        long startTime, endTime, executionTime;
        Scanner scanningInput = new Scanner(System.in);
        System.out.print("Enter the number of inputs to be sorted: ");
        int sizeOfArray = scanningInput.nextInt();
        scanningInput.close();

        int[] inputArray = new int[sizeOfArray];
        SortingAlgorithmsUtilities.generateRandomValues(inputArray);
        int[] inputArrayInDescendingOrder = Arrays.stream(inputArray).boxed().sorted(Collections.reverseOrder()).
                mapToInt(Integer::intValue).toArray();

        int[] inputArrayForInsertionSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);
        int[] inputArrayForMergeSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);

        InsertionSort insertionSortObject = InsertionSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Insertion Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForInsertionSort));
        insertionSortObject.sort(inputArrayForInsertionSort);
        endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForInsertionSort));
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Insertion sort in nanoseconds is: " + executionTime);

        MergeSort mergeSortObject = MergeSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Merge Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForMergeSort));
        mergeSortObject.sort(inputArrayForMergeSort, 0, sizeOfArray-1);
        endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForMergeSort));
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Merge sort in nanoseconds is: " + executionTime);
    }
}

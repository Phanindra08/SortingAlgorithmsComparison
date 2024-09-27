package edu.charlotte;

import edu.charlotte.sorting_techniques.InPlaceQuickSort;
import edu.charlotte.sorting_techniques.InsertionSort;
import edu.charlotte.sorting_techniques.MergeSort;
import edu.charlotte.sorting_techniques.ModifiedQuickSort;
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
        int[] inputArrayForInPlaceQuickSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);
        int[] inputArrayForModifiedQuickSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);

        InsertionSort insertionSortObject = InsertionSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Insertion Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForInsertionSort));
        insertionSortObject.sort(inputArrayForInsertionSort);
        endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForInsertionSort));
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Insertion sort in nanoseconds is: " + executionTime);
        Arrays.sort(inputArray); //
        System.out.println("Checking the validity of Insertion Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForInsertionSort))); //

        MergeSort mergeSortObject = MergeSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Merge Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForMergeSort));
        mergeSortObject.sort(inputArrayForMergeSort, 0, sizeOfArray-1);
        endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForMergeSort));
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Merge sort in nanoseconds is: " + executionTime);
        System.out.println("Checking the validity of Merge Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForMergeSort))); //

        InPlaceQuickSort inPlaceQuickSortObject = InPlaceQuickSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** In-Place Quick Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForInPlaceQuickSort));
        inPlaceQuickSortObject.sort(inputArrayForInPlaceQuickSort, 0, sizeOfArray - 1);
        endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForInPlaceQuickSort));
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using In-Place Quick sort in nanoseconds is: " + executionTime);
        System.out.println("Checking the validity of In-Place Quick Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForInPlaceQuickSort))); //

        ModifiedQuickSort modifiedQuickSortObject = ModifiedQuickSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Modified Quick Sort ***");
        System.out.println("Original array is: " + Arrays.toString(inputArrayForModifiedQuickSort));
        modifiedQuickSortObject.sort(inputArrayForModifiedQuickSort, 0, sizeOfArray - 1);
        endTime = System.nanoTime();
        System.out.println("Array after sorting is: " + Arrays.toString(inputArrayForModifiedQuickSort));
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Modified Quick sort in nanoseconds is: " + executionTime);
        System.out.println("Checking the validity of Modified Quick Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForModifiedQuickSort))); //
    }
}

package edu.charlotte;

import edu.charlotte.sorting_techniques.HeapSort;
import edu.charlotte.sorting_techniques.InPlaceQuickSort;
import edu.charlotte.sorting_techniques.InsertionSort;
import edu.charlotte.sorting_techniques.MergeSort;
import edu.charlotte.sorting_techniques.ModifiedQuickSort;
import edu.charlotte.utils.SortingAlgorithmsUtilities;

import java.util.*;

/**
 * It is a driver class.
 * It takes the size of the array as input from the user.
 * It generates array randomly using Random class in Java and then sorts the array in descending order
 * It creates five duplicate copies of array and provides those as input to Insertion Sort, Merge Sort, Heap Sort, In-Place Quick Sort, and
 * Modified Quick Sort.
 * It measures the execution time of each sort.
 * It also measures whether each of the sort are working as expected by comparing the result with the result of the in-built sort method of the Arrays class in Java.
 */
public class ReverseSortedInput {
    public static List<Long> mainForReverseSortedInput(int sizeOfArray) {
        long startTime, endTime, executionTime;
        System.out.println("Starting mainForReverseSortedInput method in ReverseSortedInput Class.");

        List<Long> listForExecutionTime = new ArrayList<>();
        int[] inputArray = new int[sizeOfArray];
        SortingAlgorithmsUtilities.generateRandomValues(inputArray);
        int[] inputArrayInDescendingOrder = Arrays.stream(inputArray).boxed().sorted(Collections.reverseOrder()).
                mapToInt(Integer::intValue).toArray();

        int[] inputArrayForHeapSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);
        int[] inputArrayForInsertionSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);
        int[] inputArrayForMergeSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);
        int[] inputArrayForInPlaceQuickSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);
        int[] inputArrayForModifiedQuickSort = Arrays.copyOf(inputArrayInDescendingOrder, sizeOfArray);

        InsertionSort insertionSortObject = InsertionSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Insertion Sort ***");
        insertionSortObject.sort(inputArrayForInsertionSort);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Insertion sort in nanoseconds is: " + executionTime);
        Arrays.sort(inputArray); //
        System.out.println("Checking the validity of Insertion Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForInsertionSort))); //
        listForExecutionTime.add(executionTime);

        MergeSort mergeSortObject = MergeSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Merge Sort ***");
        mergeSortObject.sort(inputArrayForMergeSort, 0, sizeOfArray-1);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Merge sort in nanoseconds is: " + executionTime);
        System.out.println("Checking the validity of Merge Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForMergeSort))); //
        listForExecutionTime.add(executionTime);

        InPlaceQuickSort inPlaceQuickSortObject = InPlaceQuickSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** In-Place Quick Sort ***");
        inPlaceQuickSortObject.sort(inputArrayForInPlaceQuickSort, 0, sizeOfArray - 1);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using In-Place Quick sort in nanoseconds is: " + executionTime);
        System.out.println("Checking the validity of In-Place Quick Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForInPlaceQuickSort))); //
        listForExecutionTime.add(executionTime);

        ModifiedQuickSort modifiedQuickSortObject = ModifiedQuickSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** Modified Quick Sort ***");
        modifiedQuickSortObject.sort(inputArrayForModifiedQuickSort, 0, sizeOfArray - 1);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Modified Quick sort in nanoseconds is: " + executionTime);
        System.out.println("Checking the validity of Modified Quick Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForModifiedQuickSort))); //
        listForExecutionTime.add(executionTime);

        HeapSort HeapSortObject = HeapSort.getInstance();
        startTime = System.nanoTime();
        System.out.println("*** HeapSort ***");
        HeapSortObject.sort(inputArrayForHeapSort);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("The time taken to sort array using Heap Sort in nanoseconds is: " + executionTime);
        Arrays.sort(inputArray); //
        System.out.println("Checking the validity of Heap Sort: " + Arrays.toString(inputArray).equals(Arrays.toString(inputArrayForHeapSort))); //
        listForExecutionTime.add(executionTime);
        System.out.println("Ending mainForReverseSortedInput method in ReverseSortedInput Class.");
        return listForExecutionTime;
    }
}

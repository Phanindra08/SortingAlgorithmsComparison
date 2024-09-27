package edu.charlotte.sorting_techniques;

import edu.charlotte.utils.SortingAlgorithmsUtilities;

public class ModifiedQuickSort {

    private static ModifiedQuickSort instance = null;

    private ModifiedQuickSort() {}

    public static synchronized ModifiedQuickSort getInstance() {
        if (instance == null)
            instance = new ModifiedQuickSort();
        return instance;
    }
    public void sort(int[] arrayValues, int leftElementIndex, int rightElementIndex) {
        InsertionSort insertionSortObject = InsertionSort.getInstance();
//        if(leftElementIndex + 8 <= rightElementIndex) {
        if(rightElementIndex - leftElementIndex + 1 > 8) {
            int pivotValue = getMedian(arrayValues, leftElementIndex, rightElementIndex);
            int pivotIndex = partition(arrayValues, leftElementIndex, rightElementIndex, pivotValue);
            sort(arrayValues, leftElementIndex, pivotIndex - 1);
            sort(arrayValues, pivotIndex + 1, rightElementIndex);
        } else {
            insertionSortObject.sort(arrayValues);
        }
    }

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

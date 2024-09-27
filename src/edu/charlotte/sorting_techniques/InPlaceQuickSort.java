package edu.charlotte.sorting_techniques;

import edu.charlotte.utils.SortingAlgorithmsUtilities;

public class InPlaceQuickSort {
    private static InPlaceQuickSort instance = null;

    private InPlaceQuickSort() {}

    public static synchronized InPlaceQuickSort getInstance() {
        if (instance == null)
            instance = new InPlaceQuickSort();
        return instance;
    }

    public void sort(int[] arrayValues, int leftElementIndex, int rightElementIndex) {
        if(leftElementIndex < rightElementIndex) {
            int pivotIndex = leftElementIndex;
            int newPivotIndex = inPlacePartition(arrayValues, leftElementIndex, rightElementIndex, pivotIndex);
            sort(arrayValues, leftElementIndex, newPivotIndex - 1);
            sort(arrayValues, newPivotIndex + 1, rightElementIndex);
        }
    }

    private int inPlacePartition(int[] arrayValues, int leftElementIndex, int rightElementIndex, int pivot) {
        int pivotValue = arrayValues[pivot];
        SortingAlgorithmsUtilities.swap(arrayValues, pivot, rightElementIndex);
        int tempIndex = leftElementIndex;
        for(int i = leftElementIndex; i <= (rightElementIndex - 1); i++) {
            if(arrayValues[i] < pivotValue) {
                SortingAlgorithmsUtilities.swap(arrayValues, i, tempIndex);
                tempIndex++;
            }
        }
        SortingAlgorithmsUtilities.swap(arrayValues, tempIndex, rightElementIndex);
        return tempIndex;
    }
}

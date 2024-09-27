package edu.charlotte.sorting_techniques;

import edu.charlotte.utils.SortingAlgorithmsUtilities;

public class InsertionSort {

    private static InsertionSort instance = null;

    private InsertionSort() {}
    public static synchronized InsertionSort getInstance() {
        if (instance == null)
            instance = new InsertionSort();
        return instance;
    }

    public void sort(int[] values) {
        for(int index = 0; index < values.length; index++) {
            for(int index2 = index + 1; index2 < values.length; index2++) {
                if(values[index] > values[index2])
                    SortingAlgorithmsUtilities.swap(values, index, index2);
            }
        }
    }
}

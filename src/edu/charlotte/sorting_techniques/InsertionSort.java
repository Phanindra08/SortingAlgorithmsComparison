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
            for(int j = index + 1; j < values.length; j++) {
                if(values[index] > values[j])
                    SortingAlgorithmsUtilities.swap(values, index, j);
            }
        }
    }
}

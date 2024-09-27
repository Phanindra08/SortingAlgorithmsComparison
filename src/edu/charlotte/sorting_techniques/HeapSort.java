package edu.charlotte.sorting_techniques;

import java.util.Arrays;

public class HeapSort {
    private static HeapSort instance = null;

    // Private constructor to ensure singleton pattern
    private HeapSort() {}

    // Method to get a single instance of HeapSort
    public static synchronized HeapSort getInstance() {
        if (instance == null)
            instance = new HeapSort();
        return instance;
    }

    // Public method to perform heap sort
    public void sort(int[] values) {
        int size = values.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(values, size, i);
        }

        // Extracting elements from the heap
        for (int i = size - 1; i > 0; i--) {
            int temp = values[0];
            values[0] = values[i];
            values[i] = temp;
            heapify(values, i, 0);
        }
    }

    private void heapify(int[] values, int n, int i) {
        int largest = i; // Initialize the largest element as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If the left child is larger than the root
        if (left < n && values[left] > values[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far
        if (right < n && values[right] > values[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and continue heapifying
        if (largest != i) {
            int swap = values[i];
            values[i] = values[largest];
            values[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(values, n, largest);
        }
    }
}

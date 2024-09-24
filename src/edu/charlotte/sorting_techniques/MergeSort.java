package edu.charlotte.sorting_techniques;

import java.util.Arrays;

public class MergeSort {
    private static MergeSort instance = null;

    private MergeSort() {}
    public static synchronized MergeSort getInstance() {
        if (instance == null)
            instance = new MergeSort();
        return instance;
    }

    public void sort(int[] values,int startPosition, int endPosition) {
        if(startPosition < endPosition) {
            int middlePosition = (startPosition + endPosition) / 2;
            sort(values, startPosition, middlePosition);
            sort(values, middlePosition + 1, endPosition);
            merge(values, startPosition, middlePosition, endPosition);
        }
    }

    public void merge(int[] arrayValues, int startPosition, int middlePosition, int endPosition) {
        int sizeOfArrayLeft = middlePosition - startPosition + 1;
        int sizeOfArrayRight = endPosition - middlePosition;
        int[] arrayLeft = Arrays.copyOfRange(arrayValues, startPosition, middlePosition + 1);
        int[] arrayRight = Arrays.copyOfRange(arrayValues, middlePosition + 1, endPosition + 1);

        int indexOfArrayLeft = 0, indexOfArrayRight = 0, index = startPosition;
        while(indexOfArrayLeft < sizeOfArrayLeft && indexOfArrayRight < sizeOfArrayRight) {
            if(arrayLeft[indexOfArrayLeft] <= arrayRight[indexOfArrayRight]) {
                arrayValues[index] = arrayLeft[indexOfArrayLeft];
                indexOfArrayLeft++;
            } else {
                arrayValues[index] = arrayRight[indexOfArrayRight];
                indexOfArrayRight++;
            }
            index++;
        }

        while(indexOfArrayLeft < sizeOfArrayLeft) {
            arrayValues[index] = arrayLeft[indexOfArrayLeft];
            indexOfArrayLeft++;
            index++;
        }

        while(indexOfArrayRight < sizeOfArrayRight) {
            arrayValues[index] = arrayRight[indexOfArrayRight];
            indexOfArrayRight++;
            index++;
        }
    }
}

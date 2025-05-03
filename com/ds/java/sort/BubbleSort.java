package com.ds.java.sort;

import com.ds.java.ArrayUtil;

import static com.ds.java.ArrayUtil.printArray;

public class BubbleSort {
    public static void main(String[] args) {
        // Random values
        ArrayUtil.testMethod(BubbleSort::bubbleSort, null);
        ArrayUtil.testMethod(BubbleSort::bubbleSortWithSwapFlag, null);
        // Sorted values
        int[] arr = ArrayUtil.generateRandom();
        bubbleSortWithSwapFlag(arr);
        ArrayUtil.testMethod(BubbleSort::bubbleSort, arr);
        ArrayUtil.testMethod(BubbleSort::bubbleSortWithSwapFlag, arr);
    }

    // Should sort adjacent values only so use j, j+1
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortWithSwapFlag(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap)
                break; // No swaps made, array is sorted
        }
    }
}

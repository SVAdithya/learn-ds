package com.ds.java.sort;

import com.ds.java.ArrayUtil;

import static com.ds.java.ArrayUtil.printArray;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr1 = new int[200];
        for (int i=0; i<200; i++){
            arr1[i] = i;
        }

        int[] arr = ArrayUtil.arr;
        System.out.println("Original Array:");
        printArray(arr);
        System.out.println(System.currentTimeMillis() + " - Bubble Sort");

        bubbleSort(arr);
        printArray(arr);
        System.out.println(System.currentTimeMillis() + " - End");
        arr= arr1;
        bubbleSortWithSwapFlag(arr);
        System.out.println(System.currentTimeMillis() + " - Sorted Swap End");

        bubbleSort(ArrayUtil.sortedArray);
        System.out.println(System.currentTimeMillis() + " - Sorted regular End");

        System.out.println("Sorted Array:");
        printArray(arr);
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
        boolean swap = false;
        for (int i = 0; i < arr.length - 1; i++) {
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

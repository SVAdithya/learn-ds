package com.ds.java.sort;

import com.ds.java.ArrayUtil;

public class SelectionSort {
    public static void main(String[] args) {
        // random values
        ArrayUtil.testMethod(SelectionSort::selectionSort, null);
        // sorted values
        int[] arr = ArrayUtil.generateRandom();
        selectionSort(arr);
        ArrayUtil.testMethod(SelectionSort::selectionSort, arr);

    }

    public static void selectionSort(int[] arr) {
        for(int i=0; i< arr.length-1; i++) {
            int minIndex = i;
            // find the smallest element in unsorted array for ith position
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the found minimum element with the first element of unsorted array
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}

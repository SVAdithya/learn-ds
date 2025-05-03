package com.ds.java.search;
/*

|-----|-----|-----|-----|-----|-----|       // blocks of size √n (e.g., 5 elements each)
1     6    11    16    21    26     30        // start of each block
        ✓                                   // jump to block starting with 11
            |-----|                             // linear search inside block
        11  12 <13>  14  15                   // target (e.g., 13) found here
*/

import com.ds.java.ArrayUtil;

public class JumpSearch {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.sortedArray;
        int key = 21; // element to search
        System.out.println(System.currentTimeMillis() + " - Jump Search");
        int position = jumpSearch(arr, key);
        System.out.println(System.currentTimeMillis() + " - Jump Search End");
        if(position == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found at index: " + position);
        }
    }

    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length, i=0;
        int step = (int) Math.sqrt(n); // block size

        // Jump through blocks
        //     check if less than len
        //                  check if i dont go out of bounds, keeping <i+step> below n, indexed n-1
        while (i < n && arr[Math.min(i + step, n) - 1] < key) {
            i += step;
        }

        // Linear search in the identified block
        for (int j = i; j < n && j < i+step ; j++) {
            if (arr[j] == key) {
                return j; // found
            }
        }

        return -1; // not found
    }
}

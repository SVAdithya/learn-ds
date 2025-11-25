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

/*
 * ================================================================================
 * COMPLEXITY ANALYSIS - JUMP SEARCH
 * ================================================================================
 *
 * OPERATION         | TIME COMPLEXITY | SPACE COMPLEXITY | NOTES
 * ------------------|-----------------|------------------|------------------------
 * Best Case         | O(1)            | O(1)             | Element at first block start
 * Average Case      | O(√n)           | O(1)             | Element somewhere in middle
 * Worst Case        | O(√n)           | O(1)             | Element at end or not found
 *
 * Where n = number of elements in sorted array
 *
 * ALGORITHM BREAKDOWN:
 * 1. Jump Phase: Jump by √n steps → O(√n) jumps
 * 2. Linear Search Phase: Search within block of size √n → O(√n) comparisons
 * Total: O(√n) + O(√n) = O(√n)
 *
 * OPTIMAL BLOCK SIZE: √n
 * - Smaller blocks → More jumps, less linear search
 * - Larger blocks → Fewer jumps, more linear search
 * - √n balances both phases for optimal performance
 *
 * PREREQUISITES:
 * - Array MUST be sorted (ascending order)
 * - Random access required (works best with arrays)
 *
 * CHARACTERISTICS:
 * - Hybrid approach: Jump + Linear search
 * - Faster than linear search, slower than binary search
 * - Better for systems where backward jumps are costly
 * - Fixed jump size (√n) throughout
 *
 * ADVANTAGES:
 * - Faster than linear search: O(√n) vs O(n)
 * - Only forward jumps (good for systems with forward-only traversal)
 * - Simple to implement
 * - Better cache locality than binary search (sequential access in blocks)
 * - O(1) space complexity (no recursion)
 * - Good for external memory (tape drives, sequential access media)
 *
 * DISADVANTAGES:
 * - Slower than binary search: O(√n) vs O(log n)
 * - Requires sorted array
 * - Still requires some sequential scanning
 * - Not as commonly used as binary search
 *
 * COMPARISON WITH OTHER SEARCHES:
 * Array Size | Linear | Jump     | Binary   | Winner
 * -----------|--------|----------|----------|--------
 * 100        | 100    | 10       | 7        | Binary
 * 10,000     | 10,000 | 100      | 14       | Binary
 * 1,000,000  | 1M     | 1,000    | 20       | Binary
 *
 * WHEN JUMP SEARCH > BINARY SEARCH:
 * - Systems where backward movement is costly (tape drives)
 * - Unbounded search (infinite/unknown array size)
 * - Better cache performance needed
 * - Want to avoid recursion (binary uses stack)
 *
 * BEST USE CASES:
 * - Sorted arrays on systems with sequential access
 * - Tape drives or magnetic tapes
 * - Systems where jumping backward is expensive
 * - When you need O(1) space but better than O(n) time
 * - Unbounded/infinite sorted arrays
 *
 * WHEN TO AVOID:
 * - Random access is cheap → Use binary search
 * - Unsorted data → Use linear search or sort first
 * - Very large datasets where O(log n) matters → Use binary
 *
 * MATHEMATICAL PROOF:
 * Let block size = m
 * - Jumping: n/m blocks → O(n/m) comparisons
 * - Linear search: m elements → O(m) comparisons
 * - Total: O(n/m + m)
 * - Minimize: d/dm(n/m + m) = 0 → -n/m² + 1 = 0 → m = √n
 * - Therefore optimal block size is √n
 *
 * ================================================================================
 */

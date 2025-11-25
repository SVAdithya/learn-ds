package com.ds.java.sort;

/*
 * Bubble Sort: Compare adjacent elements and swap if needed
 *
 * Visual Example - Pass by Pass:
 * Original: [5, 3, 8, 4, 2]
 *
 * Pass 1: Largest element "bubbles up" to the end
 * [5, 3, 8, 4, 2]  → compare 5,3 → swap
 * [3, 5, 8, 4, 2]  → compare 5,8 → no swap
 * [3, 5, 8, 4, 2]  → compare 8,4 → swap
 * [3, 5, 4, 8, 2]  → compare 8,2 → swap
 * [3, 5, 4, 2, 8]  ← 8 in final position!
 *
 * Pass 2: Next largest bubbles up
 * [3, 5, 4, 2 | 8]  → compare 3,5 → no swap
 * [3, 5, 4, 2 | 8]  → compare 5,4 → swap
 * [3, 4, 5, 2 | 8]  → compare 5,2 → swap
 * [3, 4, 2, 5 | 8]  ← 5 in final position!
 *
 * Pass 3:
 * [3, 4, 2 | 5, 8]  → compare 3,4 → no swap
 * [3, 4, 2 | 5, 8]  → compare 4,2 → swap
 * [3, 2, 4 | 5, 8]  ← 4 in final position!
 *
 * Pass 4:
 * [3, 2 | 4, 5, 8]  → compare 3,2 → swap
 * [2, 3 | 4, 5, 8]  ← Done!
 *
 * Key: Each pass moves the next largest element to its correct position
 * Like bubbles rising to the surface!
 */

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

/*
 * ================================================================================
 * COMPLEXITY ANALYSIS - BUBBLE SORT
 * ================================================================================
 *
 * VARIANT           | BEST CASE | AVERAGE CASE | WORST CASE | SPACE
 * ------------------|-----------|--------------|------------|-------
 * Basic             | O(n²)     | O(n²)        | O(n²)      | O(1)
 * Optimized (flag)  | O(n)      | O(n²)        | O(n²)      | O(1)
 *
 * Where n = number of elements in array
 *
 * DETAILED COMPLEXITY:
 * - Outer loop: n-1 iterations
 * - Inner loop: (n-1), (n-2), (n-3), ... 1 iterations
 * - Total comparisons: (n-1) + (n-2) + ... + 1 = n(n-1)/2 = O(n²)
 *
 * BEST CASE (with swap flag): O(n)
 * - Array already sorted
 * - One pass with no swaps → break early
 *
 * WORST CASE: O(n²)
 * - Array sorted in reverse order
 * - Maximum swaps needed
 * - Every element needs to bubble all the way
 *
 * AVERAGE CASE: O(n²)
 * - Random order
 * - About n²/4 swaps on average
 *
 * SPACE COMPLEXITY: O(1)
 * - In-place sorting (only temp variable needed)
 * - No additional data structures
 *
 * ALGORITHM CHARACTERISTICS:
 * - Comparison-based sort
 * - Stable sort (maintains relative order of equal elements)
 * - In-place (no extra space)
 * - Adaptive (optimized version benefits from partial sorting)
 *
 * HOW IT WORKS:
 * - Repeatedly steps through list
 * - Compares adjacent elements
 * - Swaps if in wrong order
 * - Largest element "bubbles up" to end each pass
 *
 * ADVANTAGES:
 * - Simple to understand and implement
 * - No extra space needed (O(1) space)
 * - Stable sort
 * - Adaptive with swap flag (O(n) for nearly sorted)
 * - Good for small datasets or educational purposes
 *
 * DISADVANTAGES:
 * - Very slow for large datasets (O(n²))
 * - Many unnecessary comparisons
 * - Not practical for real-world large data
 * - Poor cache performance (many scattered accesses)
 *
 * OPTIMIZATION - SWAP FLAG:
 * - Tracks if any swap occurred in a pass
 * - If no swap → array is sorted → exit early
 * - Improves best case from O(n²) to O(n)
 * - Critical for nearly sorted data
 *
 * COMPARISON WITH OTHER SORTS:
 * Dataset Size | Bubble Sort | Selection | Insertion | Quick Sort
 * -------------|-------------|-----------|-----------|------------
 * 10           | ~45 ops     | ~45 ops   | ~25 ops   | ~30 ops
 * 100          | ~5,000      | ~5,000    | ~2,500    | ~600
 * 1,000        | ~500,000    | ~500,000  | ~250,000  | ~10,000
 * 10,000       | ~50M        | ~50M      | ~25M      | ~130,000
 *
 * BEST USE CASES:
 * - Educational purposes (teaching sorting concepts)
 * - Very small datasets (n < 10)
 * - Nearly sorted data (with swap flag optimization)
 * - When code simplicity is more important than speed
 *
 * WHEN TO AVOID:
 * - Large datasets (use Quick Sort, Merge Sort, or Heap Sort)
 * - Performance-critical applications
 * - Production code with variable input sizes
 * - When O(n log n) algorithms are available
 *
 * REAL-WORLD VERDICT:
 * - Rarely used in practice
 * - Better alternatives exist (Quick Sort, Merge Sort)
 * - Mainly educational value
 * - Can be useful for tiny datasets or nearly sorted data
 *
 * ================================================================================
 */

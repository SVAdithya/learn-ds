package com.ds.java.sort;

/*
 * Selection Sort: Select minimum element and place it at the beginning
 *
 * Visual Example - Pass by Pass:
 * Original: [5, 3, 8, 4, 2]
 *            ↑ sorted | unsorted →
 *
 * Pass 1: Find minimum in [5, 3, 8, 4, 2], swap with position 0
 * [5, 3, 8, 4, 2]  → minimum is 2 at index 4
 * [2 | 3, 8, 4, 5]  ← 2 swapped to front, now in final position
 *  ↑ sorted
 *
 * Pass 2: Find minimum in [3, 8, 4, 5], swap with position 1
 * [2 | 3, 8, 4, 5]  → minimum is 3 at index 1
 * [2, 3 | 8, 4, 5]  ← 3 already at front, no swap needed
 *     ↑ sorted
 *
 * Pass 3: Find minimum in [8, 4, 5], swap with position 2
 * [2, 3 | 8, 4, 5]  → minimum is 4 at index 3
 * [2, 3, 4 | 8, 5]  ← 4 swapped to position 2
 *        ↑ sorted
 *
 * Pass 4: Find minimum in [8, 5], swap with position 3
 * [2, 3, 4 | 8, 5]  → minimum is 5 at index 4
 * [2, 3, 4, 5 | 8]  ← 5 swapped to position 3
 *           ↑ sorted
 *
 * Pass 5: Only one element left
 * [2, 3, 4, 5, 8]   ← Done!
 *              ↑ all sorted
 *
 * Key: Each pass selects the minimum from unsorted part
 * and places it at the end of sorted part.
 * Like selecting the smallest card from your hand repeatedly!
 */

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

/*
 * ================================================================================
 * COMPLEXITY ANALYSIS - SELECTION SORT
 * ================================================================================
 *
 * CASE              | TIME COMPLEXITY | SPACE COMPLEXITY | NOTES
 * ------------------|-----------------|------------------|------------------------
 * Best Case         | O(n²)           | O(1)             | Even if sorted
 * Average Case      | O(n²)           | O(1)             | Random order
 * Worst Case        | O(n²)           | O(1)             | Reverse order
 *
 * Where n = number of elements in array
 *
 * DETAILED COMPLEXITY:
 * - Outer loop: n-1 iterations
 * - Inner loop: (n-1), (n-2), (n-3), ... 1 iterations
 * - Total comparisons: (n-1) + (n-2) + ... + 1 = n(n-1)/2 = O(n²)
 * - Total swaps: n-1 (at most one swap per outer loop iteration)
 *
 * KEY CHARACTERISTIC:
 * - ALWAYS O(n²) comparisons regardless of input
 * - No early exit optimization possible
 * - Already sorted array still takes O(n²) time
 *
 * SPACE COMPLEXITY: O(1)
 * - In-place sorting (only temp variable for swaps)
 * - No additional data structures needed
 *
 * ALGORITHM CHARACTERISTICS:
 * - Comparison-based sort
 * - NOT stable (can change relative order of equal elements)
 * - In-place (no extra space)
 * - NOT adaptive (doesn't benefit from partial sorting)
 * - Minimizes number of swaps (useful if swaps are expensive)
 *
 * HOW IT WORKS:
 * 1. Divide array into sorted and unsorted parts
 * 2. Find minimum element in unsorted part
 * 3. Swap with first element of unsorted part
 * 4. Move boundary of sorted part one position right
 * 5. Repeat until entire array is sorted
 *
 * ADVANTAGES:
 * - Simple to understand and implement
 * - No extra space needed (O(1) space)
 * - Minimum number of swaps: O(n) - Good if swaps are expensive
 * - Works well when writing to memory is costly
 * - Performs well on small lists
 *
 * DISADVANTAGES:
 * - Very slow for large datasets (O(n²))
 * - Not stable (equal elements may be reordered)
 * - Not adaptive (no benefit from partial sorting)
 * - Always O(n²) comparisons even if already sorted
 * - Poor cache performance
 *
 * SELECTION SORT vs BUBBLE SORT:
 * Feature           | Selection Sort    | Bubble Sort (optimized)
 * ------------------|-------------------|------------------------
 * Best Case         | O(n²)             | O(n) - with swap flag
 * Worst Case        | O(n²)             | O(n²)
 * Swaps             | O(n) - minimum!   | O(n²) - many swaps
 * Stable?           | No                | Yes
 * Adaptive?         | No                | Yes (with flag)
 *
 * WHEN SELECTION SORT > BUBBLE SORT:
 * - When swapping is expensive (writing to slow memory)
 * - When you want to minimize write operations
 * - Flash memory, EEPROM (limited write cycles)
 *
 * NUMBER OF SWAPS:
 * - Best Case: 0 swaps (already sorted, minIndex = i always)
 * - Worst Case: n-1 swaps (one per outer iteration)
 * - Average: n-1 swaps
 * - This is MUCH better than Bubble Sort's O(n²) swaps!
 *
 * COMPARISON WITH OTHER SORTS:
 * Dataset Size | Selection | Bubble   | Insertion | Quick Sort
 * -------------|-----------|----------|-----------|------------
 * 10           | ~45 ops   | ~45 ops  | ~25 ops   | ~30 ops
 * 100          | ~5,000    | ~5,000   | ~2,500    | ~600
 * 1,000        | ~500,000  | ~500K    | ~250K     | ~10,000
 * 10,000       | ~50M      | ~50M     | ~25M      | ~130,000
 *
 * STABILITY EXAMPLE (Why Selection Sort is NOT stable):
 * Input:  [4a, 3, 4b, 2, 1]  (4a and 4b are equal but distinguishable)
 * Output: [1, 2, 3, 4b, 4a]  ← Order of 4a and 4b is reversed!
 *
 * BEST USE CASES:
 * - Small datasets (n < 20)
 * - When minimizing swaps is critical (expensive memory writes)
 * - Flash memory or EEPROM with limited write cycles
 * - Educational purposes (simple to understand)
 * - When auxiliary space is not available
 *
 * WHEN TO AVOID:
 * - Large datasets (use Quick Sort, Merge Sort, Heap Sort)
 * - When stability is required (use Merge Sort, Insertion Sort)
 * - Nearly sorted data (use Insertion Sort instead)
 * - Performance-critical applications
 * - When O(n log n) algorithms are available
 *
 * REAL-WORLD VERDICT:
 * - Better than Bubble Sort for expensive swaps
 * - Still rarely used in practice for large data
 * - Useful in embedded systems with slow memory writes
 * - Educational value in teaching sorting concepts
 *
 * ================================================================================
 */

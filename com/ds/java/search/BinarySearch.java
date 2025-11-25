package com.ds.java.search;
/*

|----------------------------|       // full range: 1 to 40
|-----------|                ✓       // first half selected: 1 to 20
|----|                   ✓       // further half: 1 to 10
  |--|              ✓       // narrowing: 1, 5, 10
        5   8   10       ○       // mid points to 8 (target found)
*/

import com.ds.java.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

// SORTED ARRAY SEARCH
public class BinarySearch {
    public static void main(String[] args) {

        List<Integer> aa = new ArrayList<>();
        aa.add(121);
        aa.get(1);

        int[] a = ArrayUtil.sortedArray;
        System.out.println(System.currentTimeMillis() + " - Binary Search");
        int res = binarySearch(a, -7, 0, a.length - 1);
        System.out.println(System.currentTimeMillis() + " - Binary Search End");
        if(res == -1)
            System.out.println("Not Found");
        else
            System.out.println("Found //" + res + ":" + a[res]);
    }

    /**
     * The search starts with the full array:
     *      low = 0, high = 14, mid = 7.
     * Value at index 7 is 17, but 6 < 17, so the search continues in the left half.
     * The next step is:
     *      low = 0, high = 6, mid = 3.
     * Value at index 3 is 6, which matches the key.
     * The algorithm terminates, and the result is that the key 6 is found at index 3.
     *
     */
    public static int binarySearch(int[] elements, int key, int low, int high) {
        // Base case: if low index exceeds high, element is not found
        if (low > high ) {
            return -1;
        }

        int mid = (low + high) / 2;
        System.out.println("----"+low+ ":"+ elements[low] + "/" + high + ":" + elements[high]);


        // Check if the key is at mid
        if (elements[mid] == key)
            return mid;             // If key is greater, search the right half
        else if (key > elements[mid])
            low = mid + 1;          // If key is smaller, search the left half
        else
            high = mid - 1;

        System.out.println(low+  "/" + high);
        return binarySearch(elements, key, low, high);
    }
    // TODO: Length even/odd-> before first, after last, mid, random mid left, mid right,
}

/*
 * ================================================================================
 * COMPLEXITY ANALYSIS - BINARY SEARCH (Recursive Implementation)
 * ================================================================================
 *
 * OPERATION         | TIME COMPLEXITY | SPACE COMPLEXITY | NOTES
 * ------------------|-----------------|------------------|------------------------
 * Best Case         | O(1)            | O(1)             | Element at middle position
 * Average Case      | O(log n)        | O(log n)         | Recursive call stack
 * Worst Case        | O(log n)        | O(log n)         | Element at end or not found
 *
 * Where n = number of elements in sorted array
 *
 * RECURRENCE RELATION: T(n) = T(n/2) + O(1)
 * - Each step divides search space in half
 * - Log₂(n) divisions until single element remains
 *
 * SPACE COMPLEXITY BREAKDOWN:
 * - Recursive: O(log n) due to call stack (each recursive call adds stack frame)
 * - Iterative: O(1) space (no recursion, just variables)
 *
 * PREREQUISITES:
 * - Array MUST be sorted (ascending or descending)
 * - Random access required (array, not linked list)
 *
 * CHARACTERISTICS:
 * - Divide and conquer algorithm
 * - Eliminates half of remaining elements each step
 * - Much faster than linear search for large datasets
 *
 * ADVANTAGES:
 * - Very fast: O(log n) time complexity
 * - Efficient for large sorted datasets
 * - Predictable performance
 * - Better than linear search when n > 10-20 elements
 *
 * DISADVANTAGES:
 * - Requires sorted array (sorting cost: O(n log n))
 * - Requires random access (not good for linked lists)
 * - More complex to implement than linear search
 * - Recursive version uses O(log n) stack space
 *
 * COMPARISON WITH LINEAR SEARCH:
 * Array Size    | Linear Search | Binary Search | Difference
 * --------------|---------------|---------------|------------
 * 10            | 10 ops        | 4 ops         | 2.5x faster
 * 100           | 100 ops       | 7 ops         | 14x faster
 * 1,000         | 1,000 ops     | 10 ops        | 100x faster
 * 1,000,000     | 1M ops        | 20 ops        | 50,000x faster!
 *
 * BEST USE CASES:
 * - Large sorted datasets
 * - Repeated searches on same data
 * - Dictionary lookups
 * - Database indexing
 * - Finding boundaries (first/last occurrence)
 *
 * WHEN TO AVOID:
 * - Unsorted data (sort first or use linear search)
 * - Small datasets (n < 10, linear is simpler)
 * - Linked lists (no random access)
 * - Frequently changing data (re-sorting expensive)
 *
 * ================================================================================
 */

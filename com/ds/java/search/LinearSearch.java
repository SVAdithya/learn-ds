package com.ds.java.search;

/*
 * Linear Search:
 * |-----|-----|-----|-----|-----|-----|       // check each element one by one
 *   ✗     ✗     ✗     ✓                     // sequentially compare until match found
 *   1     2     3     4     5     6             // e.g., searching for 4 in unsorted array
 */

import java.util.Arrays;
import java.util.List;

// UN-SORTED ELEMENTS
public class LinearSearch {
    public static void main(String[] args) {
        Integer[] a = {1,18, 29, 16, 27, 20, 11, 23, 244, 12};
        System.out.println("Value exists: " + linearSearch(a, 12));

        String[] s = {"Hello", "1", "2", "12"};
        System.out.println("Value exists: " + linearSearch(s, "121"));

        List list1  = Arrays.stream(a).toList();
        System.out.println("Value exists: " + linearSearch(list1, 12));

        List list2  = Arrays.stream(s).toList();
        System.out.println("Value exists: " + linearSearch(list2, "121"));
    }

    // linear search for Array [generic]
    public static <T> boolean linearSearch(T[] a, T key) {
        for (T t : a) {
            if (t.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // linear search for List
    public static <T> boolean linearSearch(List a, T key) {
        for(Object i: a){
            if(i.equals(key)){
                return true;
            }
        }
        return false;
    }
}

/*
 * ================================================================================
 * COMPLEXITY ANALYSIS - LINEAR SEARCH
 * ================================================================================
 *
 * OPERATION         | TIME COMPLEXITY | SPACE COMPLEXITY | NOTES
 * ------------------|-----------------|------------------|------------------------
 * Best Case         | O(1)            | O(1)             | Element at first position
 * Average Case      | O(n/2) ≈ O(n)   | O(1)             | Element in middle
 * Worst Case        | O(n)            | O(1)             | Element at end or not found
 *
 * Where n = number of elements in array/list
 *
 * CHARACTERISTICS:
 * - Sequential search from start to end
 * - Works on both sorted and unsorted data
 * - No preprocessing required
 * - Simple implementation
 *
 * ADVANTAGES:
 * - Simple to implement and understand
 * - Works on unsorted arrays/lists
 * - No extra space needed (in-place)
 * - Good for small datasets
 * - Works with any data type (generic)
 *
 * DISADVANTAGES:
 * - Slow for large datasets (O(n) time)
 * - Doesn't take advantage of sorted data
 * - Many comparisons needed on average
 *
 * BEST USE CASES:
 * - Small datasets (n < 100)
 * - Unsorted data where sorting is expensive
 * - Single search operation (no repeated searches)
 * - When simplicity is more important than speed
 *
 * WHEN TO AVOID:
 * - Large datasets (use Binary Search if sorted)
 * - Multiple searches on same data (consider sorting first)
 * - Performance-critical applications
 *
 * ================================================================================
 */

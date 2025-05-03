package com.ds.java;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class ArrayUtil {
    public static final int[] arr = { 5, 1, 4, 2, 8 };
    public static final int[] sortedArray = { 1, 2, 3, 4,5,6, 8, 10, 14, 17,20, 21, 23, 24, 25, 26, 27,28, 30, 31, 32,33,34, 35, 36, 38, 39, 400, 2323, 2649};
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] generateRandom() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    public static void testMethod(Consumer<int[]> consumer, int[] a) {
        int[] arr = Optional.ofNullable(a).orElse(generateRandom());

        long start = System.nanoTime();
        consumer.accept(arr);
        System.out.println(" Time " + (System.nanoTime()-start) + " ns");
    }
}

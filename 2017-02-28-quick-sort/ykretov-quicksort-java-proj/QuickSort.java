/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.*;

/**
 *
 * @author ykretov
 */

public class QuickSort {
    private int[] arr;

    // static aka "class" methods
    private static int median3(int n1, int n2, int n3) {
        // code optimization...
        if (n1 <= n2) {
            if (n2 <= n3) return n2;
            return Math.max(n1, n3);
        }
        if (n2 >= n3) return n2;
        return Math.min(n1, n3);
    }

    private static void swap(int [] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    // constructor
    public QuickSort(int [] arr) {
        this.arr = arr;
    }

    //
    // protecting against pre-sorted arrays
    //
    private int pivot(int lo, int hi) {
        int med_idx = (lo + hi)/2;
        return median3(arr[lo], arr[hi], arr[med_idx]);
    }

    //
    // protecting against blobs of same values
    //
    private int[] fatPartition(int pivot, int lo, int hi) {
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            do { i++; } while (arr[i] < pivot);
            do { j--; } while (arr[j] > pivot);
            if (i >= j) {
                // normally, we would just return 'j' at this point
                // by we want to implement "fat" partition
                // to protect against blobs of same values
                i = j;
                while (arr[i] == pivot && i > lo) { i--; }
                while (arr[j] == pivot && j < hi) { j++; }

                return new int[] {i,j};
            }
//            swap(i, j);
            // speed optimization - every ms counts...
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

        }
    }

    private void myQuickSort(int lo, int hi) {
        if (lo < hi) {
            int p = pivot(lo, hi);
            int[] range = fatPartition(p, lo, hi);
            myQuickSort(lo, range[0]);
            myQuickSort(range[1], hi);
        }
    }

    private static void testSort(int size, int random_range, String presorted) {
        int[] numbers = new int[size];
        Random rand = new Random();

        for (int i=0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(random_range);
        }

        if (!"RANDOM".equals(presorted)) {
            java.util.Arrays.sort(numbers);
        }

        if ("DESC".equals(presorted)) {
            for (int i=0, j=numbers.length-1; i < j; i++, j--) {
                swap(numbers, i, j); // static method
            }
        }

        int[] lib_sorted = numbers.clone();
        int[] our_sorted = numbers.clone();

        String label = "sort N=" + size
          + " Random range: 1.." + random_range
          + "; Initial state: " + presorted;

        MyTimer t1 = new MyTimer("Java lib " + label);
        java.util.Arrays.sort(lib_sorted);
        t1.timeit();

        QuickSort mySort = new QuickSort(our_sorted);
        MyTimer t2 = new MyTimer("Our sort " + label);
        mySort.myQuickSort(0, size-1);
        t2.timeit();

//        System.out.print("Original: ");
//        System.out.println(Arrays.toString(numbers));
//
//        System.out.print("Java sort: ");
//        System.out.println(Arrays.toString(lib_sorted));
//
//        System.out.print("Our sort: ");
//        System.out.println(Arrays.toString(our_sorted));

        if (!Arrays.equals(lib_sorted, our_sorted)) {
            System.out.println("Our sort failed!!!\n");
            System.exit(1);
        }

        System.out.println("Sorted!!!\n");

    }

    private static void runTests() {
      int[] test_lenghts = { 10000, 100000, 1000000, 10000000 };
      // int[] test_lenghts = { 10, 100 };
      int[] test_range = { 3, 100, 1000000 };
      // int[] test_range = { 3 };
      String[] test_presort = { "ASC", "DESC", "RANDOM" };

      for (int i=0; i < test_lenghts.length; i++) {
          for (int j=0; j < test_range.length; j++) {
              for (String presort1 : test_presort) {
                  testSort(test_lenghts[i], test_range[j], presort1);
              }
          }
        }
    }

    private static void testMedian3() {
        int[][] arr = new int[][]{
          { 1, 2, 3 },
          { 1, 3, 2 },
          { 2, 1, 3 },
          { 2, 3, 1 },
          { 2, 3, 3 },
          { 3, 1, 2 },
          { 3, 2, 1 },
          { 1, 1, 1 },
          { 1, 1, 2 },
          { 2, 2, 1 }
        };

        for (int[] arr1 : arr) {
            System.out.print("Median for: ");
            System.out.print(Arrays.toString(arr1));
            System.out.print(" is ");
            System.out.println(median3(arr1[0], arr1[1], arr1[2]));
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // testMedian3();
        runTests();
    }

}

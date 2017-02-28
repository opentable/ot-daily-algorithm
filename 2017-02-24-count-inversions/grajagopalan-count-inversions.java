package com.ot.algorithms.date.date20170224countInversions;

public class InversionCounter {

    public int inversions(int[] a ) {
        if (a == null || a.length == 1) {
            return 0;
        }

        return sort(a, 0, a.length - 1);
    }

    private int sort(int[] a, int low, int high) {
        if (low == high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int inversions = sort(a, low, mid);
        inversions = inversions + sort(a, mid + 1, high);
        inversions = inversions + merge(a, low, mid, high);
        return inversions;
    }

    private int merge(int a[], int low, int mid, int high) {
        if (low == mid) {
            return 0;
        }

        int[] temp = copy(a, low, mid);
        int tempPtr = 0;
        int rightPtr = mid + 1;
        int mergePtr = low;

        int inv = 0;
        while (tempPtr < temp.length && rightPtr <= high) {
            if (temp[tempPtr] <= a[rightPtr]) {
                a[mergePtr] = temp[tempPtr];
                tempPtr++;
            } else {
                a[mergePtr] = a[rightPtr];
                rightPtr++;
                inv = inv + (mid - mergePtr + 1);
            }

            mergePtr++;

        }

        while (tempPtr < temp.length) {
            a[mergePtr] = temp[tempPtr];
            tempPtr++;
            mergePtr++;
        }

        while (rightPtr <= high) {
            a[mergePtr] = a[rightPtr];
            rightPtr++;
            mergePtr++;
        }

        return inv;
    }

    private int[] copy(int[] a, int low, int mid) {
        int[] temp = new int[mid - low + 1];
        for(int i = 0, j = low; i < temp.length; i++, j++) {
            temp[i] = a[j];
        }

        return temp;
    }
}


public class InversionCounterTest {
    @Test
    public void inversionsTest() {
        int a[] = new int[] {2, 4, 1, 3, 5};
        assertEquals(3, new InversionCounter().inversions(a));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, a);
    }
}
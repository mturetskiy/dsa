package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

/**
 * Classic impl for partition function as it described in Skiena's book and
 * in many manuals - where we are moving (two pointers) from the left and switching with last
 * high element if needed.
 */
@Slf4j
public class QuickSorter implements Sorter {
    @Override
    public void sort(int[] data) {
        quicksort_r(data, 0, data.length);
    }

    protected void quicksort_r(int[] data, int start, int end) {
        int length = end - start;

        if (length > 1) {
            int pivotIndex = partition(data, start, end);
            quicksort_r(data, start, pivotIndex);
            quicksort_r(data, pivotIndex + 1, end);
        }
    }

    protected int partition(int[] data) {
        return partition(data, 0, data.length);
    }

    // returns index of pivot after partitioning
    protected int partition(int[] data, int start, int end) {
        int length = end - start;
        if (length <= 0) {
            return -1;
        }

        if (length == 1) {
            return 0;
        }

        // select pivot:
        int pivotIndex = end - 1;
        int pivot = data[pivotIndex];

        int firstHigh = start;
        for (int i = start; i < end - 1; i++) {
            if (data[i] < pivot) {
                swap(data, i, firstHigh);
                firstHigh++;
            }
        }

        swap(data, firstHigh, pivotIndex);
        return firstHigh;
    }
}

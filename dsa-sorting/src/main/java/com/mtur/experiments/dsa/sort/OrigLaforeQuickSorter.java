package com.mtur.experiments.dsa.sort;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

/**
 * Impl of partition function as it is described in Lafore's book.
 */
public class OrigLaforeQuickSorter extends QuickSorter {
    @Override
    protected int partition(int[] data, int start, int end) {
        int length = end - start;
        if (length <= 0) {
            return -1;
        }

        if (length == 1) {
            return 0;
        }

        int pivotIndex = end - 1;
        int pivot = data[pivotIndex];

        int lIndex = start - 1;
        int rIndex = pivotIndex;

        while (true) {
            while (data[++lIndex] < pivot);
            while (rIndex > 0 && data[--rIndex] > pivot);
            if (lIndex >= rIndex) {
                break;
            } else {
                swap(data, lIndex, rIndex);
            }
        }

        swap(data, lIndex, pivotIndex);

        return lIndex;
    }
}

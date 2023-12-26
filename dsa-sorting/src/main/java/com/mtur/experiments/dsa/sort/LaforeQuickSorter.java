package com.mtur.experiments.dsa.sort;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

/**
 * My own implementation of partition function based on Lafore's approach
 * (moving start & end pointers towards to each other)
 */
public class LaforeQuickSorter extends QuickSorter {
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

        int lIndex = start;
        int rIndex = pivotIndex - 1;

        while (lIndex < rIndex) {
            // move left index:
            while (data[lIndex] < pivot && lIndex < rIndex) {
                lIndex++;
            }

            // move right index:
            while (data[rIndex] >= pivot && rIndex > lIndex) {
                rIndex--;
            }

            if (data[lIndex] > data[rIndex]) { // ? or left Val > rVal ?
                swap(data, lIndex, rIndex);
            }
        }

        if (data[rIndex] >= pivot) {
            swap(data, rIndex, pivotIndex);
            pivotIndex = rIndex;
        }

        return pivotIndex;
    }
}

package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

@Slf4j
public class QuickSorter {
    public void quicksort_r(int[] data) {
        quicksort_r(data, false);
    }

    public void quicksort_r(int[] data, boolean useLaforePartitioning) {
        int h = quicksort_r(data, 0, data.length, useLaforePartitioning, 0);
        log.info("sort height: {}", h);
    }

    public int quicksort_r(int[] data, int start, int end, boolean useLaforePartitioning, int h) {
        int length = end - start;

        if (length > 1) {
            int pivotIndex;
            if (useLaforePartitioning) {
//                pivotIndex = partitionLafore(data, start, end);
                pivotIndex = partitionLaforeOrig(data, start, end);
            } else {
                pivotIndex = partitionBasic(data, start, end);
            }

            int h1 = quicksort_r(data, start, pivotIndex, useLaforePartitioning, h+1);
            int h2 = quicksort_r(data, pivotIndex + 1, end, useLaforePartitioning, h+1);
            return Math.max(h1, h2);
        }

        return h;
    }

    protected int partitionBasic(int[] data) {
        return partitionBasic(data, 0, data.length);
    }

    // returns index of pivot after partitioning
    protected int partitionBasic(int[] data, int start, int end) {
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

    protected int partitionLafore(int[] ints) {
        return partitionLafore(ints, 0, ints.length);
    }
    protected int partitionLafore(int[] ints, int start, int end) {
        int length = end - start;
        if (length <= 0) {
            return -1;
        }

        if (length == 1) {
            return 0;
        }

        int pivotIndex = end - 1;
        int pivot = ints[pivotIndex];

        int lIndex = start;
        int rIndex = pivotIndex - 1;

        while (lIndex < rIndex) {
            // move left index:
            while (ints[lIndex] < pivot && lIndex < rIndex) {
                lIndex++;
            }

            // move right index:
            while (ints[rIndex] >= pivot && rIndex > lIndex) {
                rIndex--;
            }

            if (ints[lIndex] > ints[rIndex]) { // ? or left Val > rVal ?
                swap(ints, lIndex, rIndex);
            }
        }

        if (ints[rIndex] >= pivot) {
            swap(ints, rIndex, pivotIndex);
            pivotIndex = rIndex;
        }

        return pivotIndex;
    }

    protected int partitionLaforeOrig(int[] ints) {
        return partitionLaforeOrig(ints, 0, ints.length);
    }
    protected int partitionLaforeOrig(int[] ints, int start, int end) {
        int length = end - start;
        if (length <= 0) {
            return -1;
        }

        if (length == 1) {
            return 0;
        }

        int pivotIndex = end - 1;
        int pivot = ints[pivotIndex];

        int lIndex = start - 1;
        int rIndex = pivotIndex;

        while (true) {
            while (ints[++lIndex] < pivot);
            while (rIndex > 0 && ints[--rIndex] > pivot);
            if (lIndex >= rIndex) {
                break;
            } else {
                swap(ints, lIndex, rIndex);
            }
        }

        swap(ints, lIndex, pivotIndex);


        return lIndex;
    }
}

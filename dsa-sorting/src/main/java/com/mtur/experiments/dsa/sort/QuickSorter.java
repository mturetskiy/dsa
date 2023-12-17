package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

@Slf4j
public class QuickSorter {
    public void quicksort_r(int[] data) {
        quicksort_r(data, 0, data.length);
    }

    public void quicksort_r(int[] data, int start, int end) {
        int length = end - start;

        if (length > 1) {
            int pivotIndex = partition1(data, start, end);
            quicksort_r(data, start, pivotIndex);
            quicksort_r(data, pivotIndex + 1, end);
        }
    }

    // returns index of pivot after partitioning
    private int partition1(int[] data, int start, int end) {
        int length = end - start;
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

    private void partition2(int[] data) {
        int length = data.length;
        // select pivot:
        int pivotIndex = length - 1;
        int pivot = data[pivotIndex];

        log.info("Select pivot index: {}, val: {}", pivotIndex, pivot);


        int firstHigh = -1;
        for (int i = 0; i < length - 1; i++) {
            if (data[i] < pivot) {
                firstHigh++;
                swap(data, i, firstHigh);
            }

        }

        firstHigh++;
        swap(data, firstHigh, pivotIndex);

        log.info("Partitioned. Pivot index: {}, value: {}. New array: {}", firstHigh, data[firstHigh], data);
    }
}

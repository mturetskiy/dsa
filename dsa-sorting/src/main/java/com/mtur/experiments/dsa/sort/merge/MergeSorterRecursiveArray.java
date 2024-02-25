package com.mtur.experiments.dsa.sort.merge;

import com.mtur.experiments.dsa.sort.Sorter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeSorterRecursiveArray implements Sorter {
    @Override
    public void sort(int[] data) {
        sortGroup(data, 0, data.length - 1);
    }

    private void sortGroup(int[] data, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sortGroup(data, start, middle);
            sortGroup(data, middle + 1, end);
            merge(data, start, middle, end);
        }
    }

    private void merge(int[] data, int start, int middle, int end) {
        int lSize = middle - start + 1;
        int rSize = end - middle;
        int[] left = new int[lSize];
        int[] right = new int[rSize];

        for (int i = start, lIdx = 0; i <= middle; i++, lIdx++) {
            left[lIdx] = data[i];
        }

        for (int i = middle + 1, rIdx = 0; i <= end; i++, rIdx++) {
            right[rIdx] = data[i];
        }

        int pLeft = 0;
        int pRight = 0;
        int pData = start;
        while (pLeft < lSize && pRight < rSize) {
            int lVal = left[pLeft];
            int rVal = right[pRight];

            if (lVal < rVal) {
                data[pData++] = lVal;
                pLeft++;
            } else {
                data[pData++] = rVal;
                pRight++;
            }
        }

        for (int i = pLeft; i < lSize; i++) {
            data[pData++] = left[i];
        }

        for (int i = pRight; i < rSize; i++) {
            data[pData++] = right[i];
        }
    }
}
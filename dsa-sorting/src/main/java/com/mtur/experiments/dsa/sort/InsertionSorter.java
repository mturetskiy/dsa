package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;


@Slf4j
public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] data) {
        log.info("Sorting {} elements.", data.length);

        for (int i = 1; i < data.length; i++) {
            int j = i;
            while (j > 0 && (data[j] < data[j - 1])) {
                swap(data, j, j - 1);
                j--;
            }
        }

    }
}

package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

@Slf4j
public class SelectionSorter implements Sorter {
    @Override
    public void sort(int[] data) {
        int length = data.length;
        log.info("Sorting {} elements.", length);

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            int min = data[minIndex];

            for (int j = i + 1; j < length; j++) {
                if (data[j] < min) {
                    minIndex = j;
                    min = data[minIndex];
                }
            }

            if (minIndex != i) {
                swap(data, i, minIndex);
            }
        }

    }


    // Sort version for array list.

}

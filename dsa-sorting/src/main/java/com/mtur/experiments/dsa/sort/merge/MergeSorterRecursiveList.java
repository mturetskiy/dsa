package com.mtur.experiments.dsa.sort.merge;

import com.mtur.experiments.dsa.sort.Sorter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class MergeSorterRecursiveList implements Sorter {
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
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for (int i = start, lIdx = 0; i <= middle; i++, lIdx++) {
            left.addLast(data[i]);
        }

        for (int i = middle + 1, rIdx = 0; i <= end; i++, rIdx++) {
            right.addLast(data[i]);
        }

        int pData = start;
        while (!left.isEmpty() && !right.isEmpty()) {
            Integer lValue = left.getFirst();
            Integer rValue = right.getFirst();

            if (lValue < rValue) {
                data[pData++] = left.removeFirst();
            } else {
                data[pData++] = right.removeFirst();
            }
        }

        while (!left.isEmpty()) {
            data[pData++] = left.removeFirst();
        }

        while (!right.isEmpty()) {
            data[pData++] = right.removeFirst();
        }
    }
}
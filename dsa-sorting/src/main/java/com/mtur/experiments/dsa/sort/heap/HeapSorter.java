package com.mtur.experiments.dsa.sort.heap;

import com.mtur.experiments.dsa.sort.Sorter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeapSorter implements Sorter {
    @Override
    public void sort(int[] data) {
        PriorityQueue priorityQueue = constructHeap(data);

        for (int i = 0; i < data.length; i++) {
            data[i] = priorityQueue.extractMin();
        }
    }

    private PriorityQueue constructHeap(int[] data) {
        PriorityQueue priorityQueue = new PriorityQueue(data.length);
        for (int n : data) {
            priorityQueue.add(n);
        }

        return priorityQueue;
    }
}
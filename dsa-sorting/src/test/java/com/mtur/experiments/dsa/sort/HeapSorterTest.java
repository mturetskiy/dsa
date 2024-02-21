package com.mtur.experiments.dsa.sort;

import com.mtur.experiments.dsa.sort.heap.HeapSorter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
class HeapSorterTest {
    final int COUNT = 1_000_000;
    @Test
    void testInsertionSort() {
        Sorter sorter = new HeapSorter();
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
//        int[] ints = new int[]{7, 7, 6, 6, 3, 2, 7, 7, 2, 0};
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("Sorted time: {} ms, Swap count: {}", System.currentTimeMillis() - start,
                SortUtils.SWAP_COUNT);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }
}
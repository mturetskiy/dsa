package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class QuickSorterTest {
    private final int COUNT = 20_000_000;
    private QuickSorter sorter = new QuickSorter();
    @Test
    void testQuickSortRecursive() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.quicksort_r(ints);

        log.info("Sorted time: {} ms", System.currentTimeMillis() - start);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }
}
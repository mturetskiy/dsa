package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class InsertionSorterTest {
    final int COUNT = 200_000;
    @Test
    void testInsertionSort() {
        Sorter sorter = new InsertionSorter();
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("Sorted time: {} ms, Swap count: {}", System.currentTimeMillis() - start,
                SortUtils.SWAP_COUNT);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }
}
package com.mtur.experiments.dsa.sort.merge;

import com.mtur.experiments.dsa.sort.DataGenerator;
import com.mtur.experiments.dsa.sort.Sorter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
class MergeSorterRecursiveTest {
    @Test
    void testSortRecursiveArray() {
        int COUNT = 40_000_000;
        Sorter sorter = new MergeSorterRecursiveArray();
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("[Recursive Array] Sorted time: {} ms", System.currentTimeMillis() - start);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }

    @Test
    void testSortRecursiveList() {
        int COUNT = 40_000_000;
        Sorter sorter = new MergeSorterRecursiveList();
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("[Recursive List] Sorted time: {} ms", System.currentTimeMillis() - start);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }
}
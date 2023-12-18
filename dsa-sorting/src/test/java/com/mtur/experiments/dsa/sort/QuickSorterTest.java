package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class QuickSorterTest {
    private final int COUNT = 40_000_000;
    private QuickSorter sorter = new QuickSorter();

    @Test
    void testQuickSortRecursiveBoth() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] ints2 = Arrays.copyOf(ints, ints.length);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.quicksort_r(ints);

        log.info("[Basic] Sorted time: {} ms", System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        sorter.quicksort_r(ints2, true);

        log.info("[Lafore] Sorted time: {} ms", System.currentTimeMillis() - start2);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
        assertArrayEquals(copy, ints2);
    }

    @Test
    void testQuickSortBasicRecursive() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.quicksort_r(ints);

        log.info("[Basic] Sorted time: {} ms", System.currentTimeMillis() - start);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }

    @Test
    void testQuickSortLaforeRecursive() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.quicksort_r(ints, true);

        log.info("[Lafore] Sorted time: {} ms", System.currentTimeMillis() - start);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }

    @Test
    void testQuickSortBasicPartition() {
        testBasicPartition(new int[]{});
        testBasicPartition(new int[]{1});
        testBasicPartition(new int[]{1, 2});
        testBasicPartition(new int[]{2, 1});
        testBasicPartition(new int[]{4, 1, 3});
        testBasicPartition(new int[]{1, 2, 3, 4, 5});
        testBasicPartition(new int[]{1, 2, 3, 4, 5, 6});
        testBasicPartition(new int[]{6, 5, 4, 3, 2, 1});
        testBasicPartition(new int[]{1, 1, 1, 1, 1});
        testBasicPartition(new int[]{1, 5, 2, 4, 3, 7, 1, 9, 5});
        testBasicPartition(new int[]{8, 2, 4, 7, 1, 3, 9, 6, 5});
    }

    @Test
    void testQuickSortLaforePartition() {
        testLaforePartition(new int[]{});
        testLaforePartition(new int[]{1});
        testLaforePartition(new int[]{1, 2});
        testLaforePartition(new int[]{2, 1});
        testLaforePartition(new int[]{4, 1, 3});
        testLaforePartition(new int[]{1, 2, 3, 4, 5});
        testLaforePartition(new int[]{1, 2, 3, 4, 5, 6});
        testLaforePartition(new int[]{6, 5, 4, 3, 2, 1});
        testLaforePartition(new int[]{1, 1, 1, 1, 1});
        testLaforePartition(new int[]{1, 5, 2, 4, 3, 7, 1, 9, 5});
        testLaforePartition(new int[]{8, 2, 4, 7, 1, 3, 9, 6, 5});
    }

    private void testLaforePartition(int[] ints) {
        int chosenPivotValue = ints.length > 0 ? ints[ints.length - 1] : -1;

        int pIdx = sorter.partitionLafore(ints);

        if (ints.length > 0) {
            assertTrue(pIdx >= 0);
        }

        assertPartitions(ints, pIdx, chosenPivotValue);
    }

    private void testBasicPartition(int[] ints) {
        int chosenPivotValue = ints.length > 0 ? ints[ints.length - 1] : -1;

        int pIdx = sorter.partitionBasic(ints);

        if (ints.length > 0) {
            assertTrue(pIdx >= 0);
        }

        assertPartitions(ints, pIdx, chosenPivotValue);
    }

    private void assertPartitions(int[] ints, int pivotIndex, int expectedPivotValue) {
        if (ints.length <= 0) {
            return;
        }

        int pivotVal = ints[pivotIndex];
        assertEquals(expectedPivotValue, pivotVal);

        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(ints[i] <= pivotVal);
        }

        for (int i = pivotIndex + 1; i < ints.length; i++) {
            assertTrue(ints[i] >= pivotVal);
        }
    }

}
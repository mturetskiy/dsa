package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mtur.experiments.dsa.sort.SortUtils.SWAP_COUNT;
import static com.mtur.experiments.dsa.sort.SortUtils.listToArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public class ComparisonSortersTest {
    final int COUNT = 300_000;
    @Test
    void testCompareSlowSorters() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);

        int[] isRes = sort("Insertion sort", ints, new InsertionSorter());
        List<Integer> alSsRes = sort("AL Selection sort", ints, new ArrayListSelectionSorter());
        int[] ssRes = sort("Selection sort", ints, new SelectionSorter());
        List<Integer> sAlSsRes = sort("Slow AL Selection sort", ints, new SlowArrayListSelectionSorter());

        int[] etalonRes = etalonSort(ints);

        assertArrayEquals(etalonRes, isRes);
        assertArrayEquals(etalonRes, ssRes);
        assertArrayEquals(etalonRes, listToArray(alSsRes));
        assertArrayEquals(etalonRes, listToArray(sAlSsRes));
    }

    private int[] etalonSort(int[] data) {
        int[] ints = Arrays.copyOf(data, data.length);
        long start = System.currentTimeMillis();
        Arrays.sort(ints);
        log.info("[Etalon] Sort time: {} ms", System.currentTimeMillis() - start);
        return ints;
    }

    private int[] sort(String name, int[] data, Sorter sorter) {
        SWAP_COUNT = 0;
        int[] ints = Arrays.copyOf(data, data.length);
        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("[{}] Sort time: {} ms, Swap count: {}", name, System.currentTimeMillis() - start,
                SWAP_COUNT);

        return ints;
    }

    private List<Integer> sort(String name, int[] data, ArrayListSorter sorter) {
        SWAP_COUNT = 0;
        int[] ints = Arrays.copyOf(data, data.length);
        long start = System.currentTimeMillis();
        List<Integer> sorted = sorter.sort(ints);

        log.info("[{}] Sort time: {} ms, Swap count: {}", name, System.currentTimeMillis() - start,
                SWAP_COUNT);

        return sorted;
    }
}

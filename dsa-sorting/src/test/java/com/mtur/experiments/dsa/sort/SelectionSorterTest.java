package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.mtur.experiments.dsa.sort.SortUtils.arrayToList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SelectionSorterTest {
    private final int COUNT = 200_000;

    @Test
    void testSimpleSort() {
        Sorter sorter = new SelectionSorter();
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("Sorted time: {} ms, Swap count: {}", System.currentTimeMillis() - start,
                SortUtils.SWAP_COUNT);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }

    @Test
    void testArrayListSort() {
        ArrayListSorter sorter = new ArrayListSelectionSorter();
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        List<Integer> intsList = arrayToList(ints);

        List<Integer> copy = new ArrayList<>(intsList);

        long start = System.currentTimeMillis();
        List<Integer> sorted = sorter.sort(intsList);

        log.info("Sorted time: {} ms", System.currentTimeMillis() - start);

        Collections.sort(copy);
        assertEquals(copy, sorted);
    }
}
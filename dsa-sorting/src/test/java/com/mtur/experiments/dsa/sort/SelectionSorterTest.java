package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SelectionSorterTest {
    private final int COUNT = 200_000;
    private SelectionSorter sorter = new SelectionSorter();

    @Test
    void testSimpleSort() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        int[] copy = Arrays.copyOf(ints, ints.length);

        long start = System.currentTimeMillis();
        sorter.sort(ints);

        log.info("Sorted time: {} ms", System.currentTimeMillis() - start);

        Arrays.sort(copy);
        assertArrayEquals(copy, ints);
    }


    @Test
    void testArrayListSort() {
        int[] ints = DataGenerator.generateUnsortedArray(COUNT);
        ArrayList<Integer> intsList = Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> copy = new ArrayList<>(intsList);

        long start = System.currentTimeMillis();
        List<Integer> sorted = sorter.sort(intsList);

        log.info("Sorted time: {} ms", System.currentTimeMillis() - start);

        Collections.sort(copy);
        assertEquals(copy, sorted);
    }
}
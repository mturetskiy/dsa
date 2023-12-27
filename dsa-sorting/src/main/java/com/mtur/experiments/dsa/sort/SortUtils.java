package com.mtur.experiments.dsa.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SortUtils {
    public static int SWAP_COUNT = 0;
    public static void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
        SWAP_COUNT++;
    }

    public static void swap(List<Integer> al, int indexA, int indexB) {
        int tmp = al.get(indexA);
        al.set(indexA, al.get(indexB));
        al.set(indexB, tmp);
        SWAP_COUNT++;
    }

    public static int[] listToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> arrayToList(int[] ints) {
        return Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}

package com.mtur.experiments.dsa.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public interface ArrayListSorter {
    ArrayList<Integer> sort(ArrayList<Integer> data);

    default ArrayList<Integer> sort(int[] data) {
        ArrayList<Integer> list = Arrays.stream(data)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        return sort(list);
    }
}

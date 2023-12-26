package com.mtur.experiments.dsa.sort;

import java.util.List;

import static com.mtur.experiments.dsa.sort.SortUtils.arrayToList;

public interface ArrayListSorter {
    List<Integer> sort(List<Integer> data);

    default List<Integer> sort(int[] ints) {
        return sort(arrayToList(ints));
    }
}

package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArrayListSelectionSorter implements ArrayListSorter {
    @Override
    public List<Integer> sort(List<Integer> data) {
        int length = data.size();
        log.info("Sorting list of {} elements.", length);

        List<Integer> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            int minIndex = findMinIndex(data);
            Integer currMin = data.remove(minIndex);
            result.add(currMin);
        }

        return result;
    }

    private int findMinIndex(List<Integer> list) {
        int minIndex = 0;
        int minValue = list.get(minIndex);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < minValue) {
                minIndex = i;
                minValue = list.get(i);
            }
        }

        return minIndex;
    }
}

package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

@Slf4j
public class SlowArrayListSelectionSorter implements ArrayListSorter {
    @Override
    public List<Integer> sort(List<Integer> data) {
        int length = data.size();
        log.info("Sorting list of {} elements.", length);

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            int minValue = data.get(minIndex);

            for (int j = i + 1; j < length; j++) {
                if (data.get(j) < minValue) {
                    minIndex = j;
                    minValue = data.get(minIndex);
                }
            }

            if (minIndex != i) {
                swap(data, i, minIndex);
            }
        }

        return data;
    }
}

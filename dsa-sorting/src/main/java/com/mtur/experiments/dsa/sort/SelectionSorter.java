package com.mtur.experiments.dsa.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class SelectionSorter {

    public void sort(int[] data) {
        int length = data.length;
        log.info("Sorting {} elements.", length);

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            int min = data[minIndex];

            for (int j = i + 1; j < length; j++) {
                if (data[j] < min) {
                    minIndex = j;
                    min = data[minIndex];
                }
            }

            if (minIndex != i) {
                swap(data, i, minIndex);
            }
        }

    }

    // Slower because every time we access to array by index
    public void sort2(int[] data) {
        int length = data.length;
        log.info("Sorting {} elements.", length);

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(data, i, minIndex);
            }
        }

    }


    private void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    // Sort version for array list.
    public List<Integer> sort(ArrayList<Integer> data) {
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

    private int findMinIndex(ArrayList<Integer> list) {
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

    // Sort version for linked list - not ready, because it's not clear how to remove found min value w/o access by index.
    // Perhaps it can be done only inside from custom List impl, where we can preserve pointers and change them between
    // elements.
    public List<Integer> sort(LinkedList<Integer> data) {
        log.info("Sorting linked list");

        List<Integer> result = new LinkedList<>();
        // todo:

        return result;
    }

    private Integer findMin(LinkedList<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int min = it.next();

        while (it.hasNext()) {
            Integer val = it.next();
            if (val < min) {
                min = val;
            }
        }
        return min;
    }
}

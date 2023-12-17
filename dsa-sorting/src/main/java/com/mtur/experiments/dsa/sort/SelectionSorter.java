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


        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[i]) {
                    swap(data, i, j);
                }
            }
        }

    }

    private void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

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
//
//    public List<Integer> sort(LinkedList<Integer> data) {
//        log.info("Sorting linked list");
//
//        List<Integer> result = new LinkedList<>();
//        // todo:
//
//        return result;
//    }
//
//    private Integer findMin(LinkedList<Integer> list) {
//        Iterator<Integer> it = list.iterator();
//        int min = it.next();
//
//        while (it.hasNext()) {
//            Integer val = it.next();
//            if (val < min) {
//                min = val;
//            }
//        }
//        return min;
//    }
}

package com.mtur.experiments.dsa.sort.heap;

import lombok.extern.slf4j.Slf4j;

import static com.mtur.experiments.dsa.sort.SortUtils.swap;

@Slf4j
public class PriorityQueue {
    private int[] pQueue;
    int size;

    public PriorityQueue(int size) {
        this.pQueue = new int[size];
        this.size = 0;

    }

    public void add(int val) {
        if (size >= pQueue.length) {
            throw new IllegalStateException("Queue is full.");
        }

        int elementPos = size;
        this.size++;
        this.pQueue[elementPos] = val;
        bubbleUp(elementPos);
    }

    // Move element up if it is smaller than its parent.
    private void bubbleUp(int elementPos) {
        int parentPos = getParentPos(elementPos);
        if (parentPos == -1) { // already head
            return;
        }

        if (pQueue[elementPos] < pQueue[parentPos]) {
            swap(pQueue, parentPos, elementPos);
            bubbleUp(parentPos);
        }
    }

    public int getParentPos(int childPos) {
        if (childPos == 0) { // head
            return -1;
        }

        return (childPos + 1) / 2 - 1; // This is because each parent has only two child ...
    }

    public int getLeftChildPos(int parentPos) {
        return (parentPos + 1) * 2 - 1;
    }

    public int extractMin() {
        if (this.size <= 0) {
            throw new IllegalStateException("Empty queue.");
        }

        int min = pQueue[0]; // head is smallest
        pQueue[0] = pQueue[size - 1];
        size--;
        bubbleDown(0);
        return min;
    }

    // Move element down (swapping with left child) if element is smaller than child
    private void bubbleDown(int elementPos) {
        int leftChildPos = getLeftChildPos(elementPos);
        int minPos = elementPos;

        // compare with both children:
        for (int i = 0; i <= 1; i++) {
            int childPos = leftChildPos + i;
            if (childPos < size) { // not out of the boundaries:
                if (pQueue[minPos] > pQueue[childPos]) {
                    minPos = childPos;
                }
            }
        }

        if (minPos != elementPos) {
            swap(pQueue, minPos, elementPos);
            bubbleDown(minPos);
        }
    }
}
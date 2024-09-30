package com.mtur.experiments.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListElement<T> {
    private T data;
    private ListElement<T> prev;
    private ListElement<T> next;

    public T remove() {
        if (prev != null) {
            prev.setNext(next);
        }

        if (next != null) {
            next.setPrev(prev);
        }

        return data;
    }
}
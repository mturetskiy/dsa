package com.mtur.experiments.ds;

public class RawLinkedList<T> {
    private ListElement<T> head;
    private ListElement<T> tail = head;
    private int size;

    public ListElement<T> addLast(T data) {
        ListElement<T> el = new ListElement<>(data, null, null);
        size++;

        if (tail == null) {
            head = el;
            tail = head;
        } else {
            tail.setNext(el);
            tail = el;
        }

        return tail;
    }

    public ListElement<T> addFirst(T data) {
        ListElement<T> el = new ListElement<>(data, null, null);
        size++;

        if (head == null) {
            head = el;
            tail = head;
        } else {
            head.setPrev(el);
            head = el;
        }

        return el;
    }

 }
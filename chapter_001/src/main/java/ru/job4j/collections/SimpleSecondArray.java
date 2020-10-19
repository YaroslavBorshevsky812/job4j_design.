package ru.job4j.collections;

import java.util.*;

public class SimpleSecondArray<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Object[] array;

    public SimpleSecondArray() {
        this.array = new Object[10];
        modCount++;
    }
    public SimpleSecondArray(int size) {
        this.array = new Object[size];
        modCount++;
    }

    public T grow() {
        if (size == array.length) {
            this.array = Arrays.copyOf(array, array.length * 2);
        }
        return (T) array;
    }

    public void add(T model) {
        grow();
        array[size++] = model;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {
            private int point = 0;
           private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (point == size) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw  new ConcurrentModificationException();
                }
                return point < size;
            }
            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
        return iterator;
    }
}





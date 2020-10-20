package ru.job4j.collections;

import ru.job4j.generics.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> {
    private SimpleArray<T> array;
    private int size = 0;

    public SimpleSet() {
        this.array = new SimpleArray<T>(10);
    }

    public int getSize() {
        return size;
    }

    private boolean equalE(T element) {
        boolean canAdd = true;
        Iterator<T> it = array.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), element)) {
                canAdd = false;
                break;
            }
        }
        return canAdd;
    }

    public boolean add(T element) {
        boolean canAdd = equalE(element);
        if (canAdd) {
            size++;
            array.add(element);
        }
        return canAdd;
    }
}

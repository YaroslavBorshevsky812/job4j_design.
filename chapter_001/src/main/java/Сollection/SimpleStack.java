package Сollection;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleStack<T> {
    private int size = 0;
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public int getSize() {
        return size;
    }

    public T pop() {
        size--;
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
        size++;
    }
}

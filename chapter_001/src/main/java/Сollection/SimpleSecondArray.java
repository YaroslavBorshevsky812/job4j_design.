package Сollection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleSecondArray<T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;
    private int point = 0;
    private int modCount = 0;

    public SimpleSecondArray() {
        this.array = new Object[size];
        modCount++;
    }

    public void add(T model) {
        Objects.checkIndex(size, this.array.length);
        array[size++] = model;
        modCount++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        this.array[index] = model;
        modCount++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        array[index] = null;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size - 1] = null;
        size--;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
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
    }
}


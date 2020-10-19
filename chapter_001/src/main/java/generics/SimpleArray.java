package generics;

import java.util.*;

public class SimpleArray<T> implements Iterable<T>{
        private Object[] array;
        private int size = 0;
    public SimpleArray(int size) {
        this.array = new Object[size];
    }
    public void add(T model) {
        Objects.checkIndex(size, this.array.length);
        array[size++] = model;
    }
    public void set(int index, T model){
        Objects.checkIndex(index, size);
        this.array[index] = model;
    }
    public void remove(int index){
        Objects.checkIndex(index, size);
        array[index] = null;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size - 1] = null;
        size--;
    }
    public T get(int index){
        Objects.checkIndex(index, size);
        return (T) array[index];
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point < size;
            }
            @Override
            public Object next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return (T) array[point++];
            }
        };
    }
}


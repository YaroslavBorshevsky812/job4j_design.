package Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SimpleArray<T> implements Iterable<T>{
        private int modCount;
        private int size;

    public boolean add(T model) {
        return true;
    }
    public boolean set(int index, T model){
        return true;
    }
    public boolean remove(int index){
        return true;
    }
    public T get(int index){
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

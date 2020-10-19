package сollections;

import generics.SimpleArray;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> {
    private SimpleArray<T> array;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public SimpleSet() {
        this.array = new SimpleArray<T>(10);
    }

    private boolean equalE(T element){
        boolean canAdd = true;
        Iterator<T> it = array.iterator();
        while(it.hasNext()) {
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
    public static void main(String[] args) {
        SimpleSet<String> set = new SimpleSet<>();
        Iterator<String> it = set.array.iterator();
        set.add("T");
        set.add("T");
        set.add("Y");
        set.add("Y");
        set.add("y");
        set.add("Y");
        System.out.println(set.size);
        for (int i = 0; i < set.size; i++) {
            System.out.println(set.array.get(i));
        }
    }
}

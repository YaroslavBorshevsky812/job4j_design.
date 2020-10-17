package Сollection;

import Generics.SimpleArray;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> {
    private SimpleArray<T> array;
    private int size = 0;

    public SimpleSet(){
        this.array = new SimpleArray<T>(this.size);
    }

    public boolean add(T element){
        boolean canAdd = true;
        Iterator<T> it = array.iterator();
            while(it.hasNext()){
                if(it.next().equals(element)){
                    canAdd = false;
                }
            }
        if(canAdd){
            size++;
            array.add(element);
        }
        return canAdd;
    }

    public static void main(String[] args) {
        HashSet<String> data = new HashSet<>();
        data.add("s");
        data.add("t");
        System.out.println(Arrays.asList(data));
    }
}

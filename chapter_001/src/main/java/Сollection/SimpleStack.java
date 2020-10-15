package Сollection;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
            linked.add(value);
    }

    public static void main(String[] args) {
        SimpleStack<String> data = new SimpleStack<>();
        data.push(new String("Y"));
        data.push(new String("A"));
        data.push(new String("R"));
        System.out.println(data.pop());
    }

}

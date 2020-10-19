package ru.job4j.collections;

public class SimpleQueue<T> {
    private final SimpleStack<T> s1 = new SimpleStack<>();
    private final SimpleStack<T> s2 = new SimpleStack<>();

    public T pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public void push(T value) {
        s1.push(value);
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.push(3);
        System.out.println(queue.pop());
    }
}
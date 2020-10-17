package Сollection;

public class SimpleQueue<T> {
    private int size = 0;
    private final SimpleStack<T> s1 = new SimpleStack<>();
    private final SimpleStack<T> s2 = new SimpleStack<>();

    public T pop() {
        if(s1.getSize() != 0){
            for (int i = 0; i < size; i++) {
                s2.push(s1.pop());
            }
        }
        size--;
        return s2.pop();
    }
    public void push(T value) {
        s1.push(value);
        size++;
    }
}
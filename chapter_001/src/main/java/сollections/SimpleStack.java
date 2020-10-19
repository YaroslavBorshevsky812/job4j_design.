package сollections;

public class SimpleStack<T> {
    private int size = 0;
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
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

package Сollection;

public class SimpleQueue<T> {
    private int size = 0;
    private final SimpleStack<T> s1 = new SimpleStack<>();
    private final SimpleStack<T> s2 = new SimpleStack<>();

    public T pop() {
        T buf = null;
        if(!s2.isEmpty()){
            buf = s2.pop();
            size--;
        } else {
            if (!s1.isEmpty()) {
                for (int i = 0; i < size; i++) {
                    s2.push(s1.pop());
                }
            }
            buf = s2.pop();
            size--;
        }
        return buf;
    }
    public void push(T value) {
        s1.push(value);
        size++;
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.size);
    }
}
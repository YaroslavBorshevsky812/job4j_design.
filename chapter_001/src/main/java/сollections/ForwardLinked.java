package сollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }
    public T deleteFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = temp.next;
        temp.next = null;
        size--;
        return temp.value;
    }

   public T deleteLast() {
        Node<T> buf = head;
       T rsl = null;
       if(head == null){
            throw new NoSuchElementException();
        }
        if (size == 1) {
            rsl = deleteFirst();
        } else {
            for (int i = 0; i < size - 2; i++) {
                buf = buf.next;
            }
            rsl = buf.next.value;
            buf.next = null;
            size--;
        }
        return rsl;
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinked<String> data = new ForwardLinked<>();
        data.add(new String("T"));

        String s1 = data.deleteLast();
        System.out.println(data.size);
        for (String s : data) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println(s1);
    }
}

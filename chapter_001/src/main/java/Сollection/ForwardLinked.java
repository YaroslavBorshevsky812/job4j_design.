package Сollection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }
    public Node<T> deleteFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        Node<T> temp = head.next;
        head.next = null;
        head = temp;
        return temp;
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

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinked<String> data = new ForwardLinked<>();
        data.add(new String("A"));
        data.add(new String("B"));
        data.add(new String("C"));
        data.deleteFirst();
        Iterator<String> it = data.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }
}

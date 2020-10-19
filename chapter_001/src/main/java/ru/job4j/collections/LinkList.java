package ru.job4j.collections;

import java.util.*;

public class LinkList<E> implements Iterable<E> {

    private static class Node<E> {
       private E item;
       private Node<E> next;
       private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public LinkList() {
        this.first = new Node<>(null, null, null);
    }

    public E get(int index) {
//        if (index < 0 || index >= size) {
//            throw new NoSuchElementException();
//        }
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
                result = first.next;
        }
        return (E) result.item;
    }

    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
            size++;
            modCount++;
        }
    }

    @Override
    public Iterator<E> iterator() {
                return new Iterator() {
                   private Node<E> result = first;
                   private Node<E> buf = null;
                   private Node<E> buf1 = null;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw  new ConcurrentModificationException();
                }
                return result != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object value = result.item;
                result = result.next;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        LinkList<String> data = new LinkList<>();
        data.addLast(new String("Y"));
        Iterator<String> it = data.iterator();
        System.out.println(data.get(0));
    }
}


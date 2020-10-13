package Сollection;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class LinkList<E> implements Iterable<E>{

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    private int modCount = 0;

    public LinkList(){
    };
    public LinkList(Collection<? extends E> col){
    }

    public E get (int index){
        if(index < 0 || index >= size){
            throw new NoSuchElementException();
        }
        Node result = first;
        for (int i = 0; i < index; i++) {
                result = first.next;
        }
        return (E) result.item;
    }

    public void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    public void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
    public void add(int index, E element){
        Objects.checkIndex(index, size);
        if(index == size){
            linkLast(element);
        } else {
           linkBefore(element, new Node<E>(first.prev, get(index), first.next));
        }
    }
    @Override
    public Iterator<E> iterator() {
        Iterator iterator = new Iterator() {
            private int point = 0;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if(point == size){
                    throw new NoSuchElementException();
                }
                if(expectedModCount != modCount){
                    throw  new ConcurrentModificationException();
                }
                return point < size;
            }
            @Override
            public Object next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                Node<E> result = first;

                return first.next;
            }
        };
        return iterator;
    }
}

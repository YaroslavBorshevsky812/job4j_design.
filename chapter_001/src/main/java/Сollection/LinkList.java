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
        Node(E element){
            this.item = element;
        }
    }
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public LinkList(){
        this.first = new Node<>(null, null, null);
    };

    public E get (int index){
        if(index < 0 || index >= size){
            throw new NoSuchElementException();
        }
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
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    @Override
    public Iterator<E> iterator() {
                return new Iterator() {
                    Node<E> result = first;
                    Node<E> buf = null;
                    Node<E> buf1 = null;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if(expectedModCount != modCount){
                    throw  new ConcurrentModificationException();
                }
                return result != null;
            }
            @Override
            public Object next() {
                if(!hasNext()){
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
        data.addLast(new String("A"));
        data.addLast(new String("R"));
        Iterator<String> it = data.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}


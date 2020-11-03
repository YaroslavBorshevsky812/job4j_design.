package ru.job4j.collections.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {

    private Node<K, V>[] hashTable = new Node[16];
    private static final float LOAD_FACTOR = 0.75f;
    private float threshold = hashTable.length * LOAD_FACTOR;
    private transient int size = 0;
    private transient int modCount = 0;



    private int indexFor(int hash) {
        return hash & (hashTable.length - 1);
    }

    private void grow() {
        Node<K, V>[] oldHashTable = hashTable;
        int oldSize = oldHashTable.length;
        hashTable = new Node[oldSize * 2];
        threshold = hashTable.length * LOAD_FACTOR;

        for (int i = 0; i < oldSize; i++) {
            if (oldHashTable[i] != null) {
                K key = oldHashTable[i].getKey();
                int indexNew = indexFor(hashKey(key));
                hashTable[indexNew] = oldHashTable[i];
            }
        }
    }

    public boolean delete(K key) {
        int index;
        boolean result = false;
        if (key != null) {
            index = indexFor(hashKey(key));
            if (hashTable[index] != null
                    && Objects.equals(key, hashTable[index].key)) {
                hashTable[index] = null;
                size--;
                modCount++;
                result = true;
            }
        }
        return result;
    }



    public boolean insert(K key, V value) {
        boolean result = false;
        if (size >= threshold) {
            grow();
        }
        int index = indexFor(hashKey(key));
        if (hashTable[index] == null) {
            hashTable[index] = new Node<>(key, value);
            result = true;
            size++;
            modCount++;
        }
        return result;
    }

    private int hashKey(K key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    public V get(K key) {
        int index;
        V result = null;
        if (key != null) {
            index = indexFor(hashKey(key));
            if (hashTable[index] != null
                    && Objects.equals(key, hashTable[index].key)) {
                result = hashTable[index].value;
            }
        }
        return result;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            private void checkForComodification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkForComodification();
                while (hashTable[cursor] == null
                        && cursor < hashTable.length - 1) {
                    cursor++;
                }
                return hashTable[cursor] != null;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hashTable[cursor++];
            }
        };
    }

    public static class Node<K, V> {
        private final K key;
        private V value;

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

       @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key)
                    && Objects.equals(value, node.value);
        }

    }
}

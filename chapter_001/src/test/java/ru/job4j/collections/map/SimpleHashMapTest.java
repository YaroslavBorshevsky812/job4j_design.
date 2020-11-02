package ru.job4j.collections.map;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;


public class SimpleHashMapTest {

    @Test
    public void insertTrue() {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        assertThat(hashMap.insert("first", "first"), is(true));
    }

    @Test
    public void insertFalse() {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.insert("first", "first");
        assertThat(hashMap.insert("first", "second"), is(false));
    }

    @Test
    public void getFirst() {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.get("first"), is("Vasya"));
    }

    @Test
    public void getNull() {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.get("second"), is(nullValue()));
    }

    @Test
    public void deleteTrue() {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.delete("first"), is(true));
    }


    @Test
    public void deleteFalse() {
        SimpleHashMap<String, String> hashMap = new  SimpleHashMap<>();
        hashMap.insert("first", "Vasya");
        assertThat(hashMap.delete("second"), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<String, String> hashMap = new  SimpleHashMap<>();
        hashMap.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleHashMap<String, String> hashMap = new  SimpleHashMap<>();
        hashMap.insert("first", "Vasya");
        Iterator<SimpleHashMap.Node<String, String>> it = hashMap.iterator();
        hashMap.insert("second", "Petya");
        it.next();
    }
}

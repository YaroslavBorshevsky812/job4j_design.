package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReversedLinkedTest {

    @Test
    public void whenListRevested() {
        ReversedLinked<String> list = new ReversedLinked<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.revert();
        Iterator<String> it = list.iterator();
        assertThat(it.next(), is("Three"));
        assertThat(it.next(), is("Two"));
        assertThat(it.next(), is("One"));

    }
}

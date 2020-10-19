package generics;

import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;


public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<Object> array = new SimpleArray<>(1);
        array.add("first");
        Object rsl = array.get(0);
        assertThat(rsl, is("first"));
    }
    @Test
    public void whenSetThenGet(){
        SimpleArray<Object> array = new SimpleArray<Object>(2);
        array.add("First");
        array.set(0,"Second");
        Object rsl = array.get(0);
        assertThat(rsl, is("Second"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveThenTakeLeft(){
        SimpleArray<Object> array = new SimpleArray<Object>(3);
        array.add("First");
        array.add("Second");
        array.add("Third");
        array.remove(0);
        SimpleArray<Object> rsl = new SimpleArray<Object>(2);
        rsl.add("Second");
        rsl.add("Third");
        assertEquals(rsl, array);
    }
    @Test
    public void whenCorruptedIt() {
        SimpleArray<Object> array = new SimpleArray<>(2);
        array.add("first");
        Iterator<Object> it = array.iterator();
        array.add("second");
        it.next();
    }
    @Test
    public void whenThreeElement(){
        SimpleArray<Object> array = new SimpleArray<Object>(3);
        Iterator<Object> it = array.iterator();
        array.add("first");
        array.add("second");
        array.add("third");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("first"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("second"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("third"));
        assertThat(it.hasNext(), is(false));

    }
}
package Сollection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SimpleSetTest {

    @Test
    public void onlySet(){
        SimpleSet<String> set = new SimpleSet<>();
        set.add("T");
        set.add("t");
        set.add("T");
        int expected = 2;
        assertThat(expected, is(set.getSize()));

    }

}
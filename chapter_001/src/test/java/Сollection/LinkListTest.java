package Сollection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkListTest {

    @Test
    public void whenAddLastThenGet(){
        LinkList<String> data = new LinkList<>();
        data.linkLast(new String("Y"));
        String expected = "Y";
        assertThat(expected, is(data.get(0)));
    }
}
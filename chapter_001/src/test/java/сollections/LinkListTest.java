package сollections;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkListTest {

    @Test
    public void whenAddLastThenGet() {
        LinkList<String> data = new LinkList<>();
        data.addLast(new String("Y"));
        String expected = "Y";
        assertThat(expected, is(data.get(0)));
    }
    @Test
    public void whenAddThenIter() {
        LinkList<Integer> linked = new LinkList<>();
        linked.addLast(1);
        linked.addLast(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }
}
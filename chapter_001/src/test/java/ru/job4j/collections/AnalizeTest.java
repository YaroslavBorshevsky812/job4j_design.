package ru.job4j.collections;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;
import ru.job4j.collections.analyzing.Analize;
import ru.job4j.collections.analyzing.Info;
import ru.job4j.collections.analyzing.User;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;



public class AnalizeTest {


    @Test
    public void diffTest() {

        User userPrev1 = new User(1, "One");
        User userPrev2 = new User(2, "Two");
        User userPrev3 = new User(3, "Tree");

        List<User> previous =
                Arrays.asList(userPrev1, userPrev2, userPrev3);

        User userCurr2 = new User(2, "Two");
        User userCurr3 = new User(3, "Fix");
        User userCurr4 = new User(4, "Changed");

        List<User> current =
                Arrays.asList(userCurr2, userCurr3, userCurr4);

        Analize analize = new Analize();
        Info result = analize.dif(previous, current);
        assertThat(result.getDeleted(), is(1));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getAdded(), is(1));
    }
}
package ru.job4j.collections.exam;

import java.util.*;

public class Exam {

    public void merger() {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> setMail = Set.of("Speransky812@mail.ru");
        Set<String> setMail1 = Set.of("lildog97@mail.ru", "mark23@");
        Set<String> setMail2 = Set.of("Speransky812@mail.ru", "1mm24");
        map.put("User1", setMail);
        map.put("User2", setMail1);
        map.put("User3", setMail2);

           }

}



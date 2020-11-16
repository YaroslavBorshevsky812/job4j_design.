package ru.job4j.collections.exam;

import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private List<String> mailList;


    public User(String name, List<String> mail) {
        this.name = name;
        this.mailList = mail;
    }

    public String getName() {
        return name;
    }

    public List<String> getMailList() {
        return mailList;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name + '\''
                + ", mailList="
                + mailList
                + '}';
    }
}

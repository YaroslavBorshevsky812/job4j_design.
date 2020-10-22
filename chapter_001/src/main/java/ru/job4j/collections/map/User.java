package ru.job4j.collections.map;

import java.util.*;

public class User {
    private String name;
    private int age;
    private Calendar birthday;

    public User(String name, int age, Calendar birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user = new User("Yaroslav", 24, new GregorianCalendar(1997, 0, 5));
        User user1 = new User("Yaroslav", 24, new GregorianCalendar(1997, 0, 5));
        Map<User, Object> map = new HashMap<>();
        map.put(user, "First");
        map.put(user1, "Second");

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        for (Map.Entry<User, Object> entry : map.entrySet()) {
            User key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }
}

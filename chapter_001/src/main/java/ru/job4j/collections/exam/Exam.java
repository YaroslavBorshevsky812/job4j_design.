package ru.job4j.collections.exam;

import java.util.*;

public class Exam {

    static public Map<String, Set<String>>  merger(List<User> userList) {
        Map<String, Set<String>> userMap = new HashMap<>();

        for (User user : userList) {
            Iterator<String> iterator = user.getMailList().iterator();
            Set<String> stringSet = new HashSet<>();
            stringSet.addAll(user.getMailList());

            if (!(userMap.isEmpty())) {
                for (Set<String> set : userMap.values()) {
                    if (set.contains(iterator.next())) {
                        set.addAll(user.getMailList());
                    }
                }
            } else {
                    userMap.put(user.getName(), stringSet);
            }
        }

        return userMap;
    }

    public static void main(String[] args) {
        List<String> mailList = List.of("one", "two");
        User user = new User("Вася", mailList);

        List<String> mailList1 = List.of("three", "fourth");
        User user1 = new User("Петя", mailList1);

        List<String> mailList2 = List.of("one", "five");
        User user2 = new User("Коля", mailList2);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        System.out.println(Exam.merger(userList));
    }
}



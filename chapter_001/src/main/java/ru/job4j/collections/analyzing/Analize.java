package ru.job4j.collections.analyzing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info dif(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, User> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user);
        }

        for (User user : current) {
            if (!(map.containsValue(user)) && map.containsKey(user.getId())) {
                result.setDeleted(result.getDeleted() + 1);
            }
            if (map.containsValue(user) && !(map.get(user.getId()).equals(user.getName()))) {
                result.setChanged(result.getChanged() + 1);
            }
        }

        int added = current.size() + result.getDeleted() - previous.size();
        result.setAdded(result.getAdded() + added);

        return result;
    }
}


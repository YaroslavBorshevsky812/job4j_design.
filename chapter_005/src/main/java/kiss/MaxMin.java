package kiss;

import java.util.*;

public class MaxMin {
    public static <T> T max(List<T> value, Comparator<T> comparator) {
        Iterator<? extends T> i = value.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (comparator.compare(next, candidate) > 0)
                candidate = next;
        }
        return candidate;
    }

    public static <T> T min(List<T> value, Comparator<T> comparator) {
        Iterator<? extends T> i = value.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (comparator.compare(next, candidate) < 0)
                candidate = next;
        }
        return candidate;
    }


    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> list = List.of(5,2,11,0);
        System.out.println(MaxMin.min(list, c));
    }
}
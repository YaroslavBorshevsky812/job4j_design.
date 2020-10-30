package ru.job4j.iterator;
import java.util.*;
import java.util.function.Predicate;

    public class ListUtils {

        public static <T> void addBefore(List<T> list, int index, T value) {
            Objects.checkIndex(index, list.size());
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                if (i.nextIndex() == index) {
                    i.add(value);
                    break;
                }
                i.next();
            }
        }

        public static <T> void addAfter(List<T> list, int index, T value) {
            Objects.checkIndex(index, list.size());
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                if (i.previousIndex() == index) {
                    list.add(i.nextIndex(), value);
                    break;
                }
                i.next();
            }
        }

        public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                if (filter.test(i.next())) {
                    i.remove();
                }
            }
            return list;
        }

        public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                T temp = i.next();
                if (filter.test(temp)) {
                    list.set(i.nextIndex() - 1, value);
                }
            }
            return list;
        }

        public static <T> List<T> removeAll(List<T> list, List<T> elements) {
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                if (elements.contains(i.next())) {
                    i.remove();
                }
            }
            return list;
        }

        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("One");
            list.add("Two");
            ListUtils.addAfter(list, 1, "value");
            System.out.println(list);
        }
    }



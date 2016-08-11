package sbt.java.generics;

import java.util.*;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        return source.subList(0, size);
    }


    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }


    public static void removeAll(List<?> removeFrom, List<?> c2) {
        removeFrom.removeAll(c2);
    }


    public static boolean containsAll(List<?> c1, List<?> c2) {
        return c1.containsAll(c2);
    }


    public static boolean containsAny(List<?> c1, List<?> c2) {
        for (Object o : c2){
            if (c1.contains(o)) {
                return true;
            }
        }
        return false;
    }


    public static <T extends Comparable<? super T>> List<? extends T> range(List<? extends T> list, T min, T max) {
        List<? extends T> sorted = new ArrayList<T>(list);
        Collections.sort(sorted);
        return list.subList(list.indexOf(min), list.lastIndexOf(max) + 1);
    }


    public static <T> List<? extends T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<? extends T> sorted = new ArrayList<T>(list);
        sorted.sort(comparator);
        return list.subList(list.indexOf(min), list.lastIndexOf(max) + 1);
    }

    public static void main(String[] args) {
        List<Integer> li = newArrayList();
    }
}
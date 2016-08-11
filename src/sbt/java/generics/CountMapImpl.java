package sbt.java.generics;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private final Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T t) {
        if (map.containsKey(t)) {
            map.put(t, map.get(t) + 1);
        } else {
            map.put(t, 1);
        }
    }

    @Override
    public int getCount(T t) {
        if (map.containsKey(t)) {
            return map.get(t);
        } else {
            return 0;
        }
    }

    @Override
    public int remove(T t) {
        if (map.containsKey(t)) {
            int count = map.get(t);
            if (count == 0) {
                map.remove(t);
                return 0;
            } else {
                return map.put(t, count - 1);
            }
        } else {
            return 0;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        Map<? extends T, Integer> sMap = source.toMap();
        for (T t : sMap.keySet()) {
            map.put(t, getCount(t) + sMap.get(t));
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        for (T t : map.keySet()) {
            int count;
            if (!destination.containsKey(t)) {
                count = 0;
            } else {
                count = destination.get(t);
            }
            destination.put(t, map.get(t) + count);
        }
    }
}

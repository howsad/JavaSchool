package Alex.SBTSchool.Basics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Alexander on 22.07.2016.
 */
public class Repeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> repeats = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (set.contains(a)) {
                repeats.add(a);
            } else {
                set.add(a);
            }
        }
        System.out.println(repeats.size());
        if (!repeats.isEmpty()) {
            int first = repeats.first();
            System.out.print(first);
            repeats.remove(first);
        }
        for (Integer repeat : repeats) {
            System.out.print(" " + repeat);
        }
    }
}

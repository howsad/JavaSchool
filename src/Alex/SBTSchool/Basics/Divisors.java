package Alex.SBTSchool.Basics;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Alexander on 21.07.2016.
 */
public class Divisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int maxDivisors = 0;
        TreeSet<Integer> values = new TreeSet<>();
        for (int i = l; i <= r; i++) {
            int divisors = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    divisors++;
                }
            }
            if (divisors == maxDivisors) {
                values.add(i);
            }
            if (divisors > maxDivisors) {
                values.clear();
                values.add(i);
                maxDivisors = divisors;
            }
        }
        if (l * r == 2 || l * r == 3) {
            values.remove(1);
        }
        System.out.println(values.size());
        String output = "";
        for (Integer value : values) {
            output += value.toString() + ",";
        }
        System.out.println(output.substring(0, output.length() - 1));
    }
}

package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2001 description:
 * Заданы a и b. Выведите a+b.
 * <p>
 * <p>
 * Входные данные
 * В единственной строке входных данных заданы целочисленные a и b (1 ≤ a,b ≤ 1000).
 * <p>
 * <p>
 * Выходные данные
 * Выведите a+b.
 */
public class AAndB {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b);
    }
}
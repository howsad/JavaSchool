package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2005 description:
 * Заданы n целых чисел. Выведите индекс (позицию) первого из минимальных элементов
 * последовательности. Элементы последовательности занумерованы от 1 слева направо.
 * <p>
 * <p>
 * Входные данные
 * В первой строке записано целое число n (1 ≤ n ≤ 10000). Вторая строка содержит
 * последовательность целых чисел a1, a2,..., an (-10000 ≤ ai ≤ 10000).
 * <p>
 * <p>
 * Выходные данные
 * Выведите искомый индекс.
 */
public class MinIndex {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int minIndex = 1;
        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            if (min > a) {
                min = a;
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
}

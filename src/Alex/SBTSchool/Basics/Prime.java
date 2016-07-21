package Alex.SBTSchool.Basics;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2015 description:
 * Задана последовательность a1, a2,..., an, которая отсортирована
 * по неубыванию. Выведите наиболее часто встречающееся в ней значение
 * и количество его появлений в последовательности.
 * <p>
 * <p>
 * Входные данные
 * В первой строке задано целое число n (1 ≤ n ≤ 10000). Вторая строка
 * содержит n целых чисел, каждое от 1 до 10000 включительно. Заданная
 * последовательность отсортирована по неубыванию.
 * <p>
 * <p>
 * Выходные данные
 * Выведите два целых числа f, c (числа разделяйте пробелом), где f —
 * значение наиболее часто встречающегося элемента последовательности и c —
 * количество его появлений. Если существует несколько возможных значений
 * для f, то выведите наименьшее из них.
 */
public class Prime {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<Integer> primes = new TreeSet<>();
        primes.add(2);
        for (int i = 3; i <= n; i += 2) {
            boolean isPrime = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        for (Integer prime : primes) {
            System.out.println(prime);
        }
    }
}

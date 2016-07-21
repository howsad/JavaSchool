package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2025:
 * Рассмотрим простой вариант задачи RMQ (Range Minimum Query,
 * запрос минимума на подмассиве).
 * <p>
 * Задан массив из n целых чисел (a1, a2,..., an) и m запросов вида
 * (li, ri) (1 ≤ li ≤ ri ≤ n). Ваша задача — на каждый запрос вывести
 * минимальный среди элементов с индексами от li до ri включительно.
 * <p>
 * <p>
 * Входные данные
 * В первой строке входного файла дано число n (1 ≤ n ≤ 100) — количество
 * чисел в массиве. Во второй строке через пробел записаны целые числа
 * a1, a2,..., an (1 ≤ ai ≤ 100). В третьей строке входного файла дано число m
 * (1 ≤ m ≤ 100) — количество запросов. Далее в m строках даны запросы по одному
 * на строке в виде двух целых чисел li, ri, разделенных пробелом (1 ≤ li ≤ ri ≤ n).
 * <p>
 * <p>
 * Выходные данные
 * Выведите m чисел — ответы на запросы. Числа разделяйте пробелом или переводом строки.
 * На запросы следует отвечать в том порядке, в котором они заданы во входных данных.
 */
public class RMQ {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int min = Integer.MAX_VALUE;
            for (int j = l - 1; j < r; j++) {
                if (min > array[j]) {
                    min = array[j];
                }
            }
            System.out.println(min);
        }
    }
}
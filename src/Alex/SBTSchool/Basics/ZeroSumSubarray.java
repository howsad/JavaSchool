package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2030 description:
 * Задан массив из n чисел (a1, a2,..., an). Ваша задача —
 * подсчитать количество пар (i, j), 1 ≤ i ≤ j ≤ n, что сумма
 * чисел, стоящих на позициях i, i+1,..., j-1, j равна 0.
 * <p>
 * <p>
 * Входные данные
 * В первой строке задано число n (1 ≤ n ≤ 2000). Во второй строке
 * заданы целые числа a1, a2,..., an, которые записаны через пробел (-100 ≤ ai ≤ 100).
 * <p>
 * <p>
 * Выходные данные
 * Выведите в выходной файл единственное число — количество искомых пар.
 */
public class ZeroSumSubarray {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int numOfPairs = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            for (int j = 0; j <= i; j++) {
                array[j] += a;
                if (array[j] == 0) {
                    numOfPairs++;
                }
            }
        }
        System.out.println(numOfPairs);
    }
}

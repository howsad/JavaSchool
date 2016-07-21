package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2020 description:
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
 * количество его появлений. Если существует несколько возможных значений для f,
 * то выведите наименьшее из них.
 */
public class EqualValues {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int number = 0;
        int occurrences = 0;
        int result = 0;
        int maxOccurrences = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a == number) {
                occurrences++;
            } else {
                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    result = number;
                }
                number = a;
                occurrences = 1;
            }
        }
        System.out.println(result + " " + maxOccurrences);
    }
}

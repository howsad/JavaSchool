package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int changes = 0;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] != array[n - i - 1]) {
                changes++;
            }
        }
        System.out.println(changes);
    }
}

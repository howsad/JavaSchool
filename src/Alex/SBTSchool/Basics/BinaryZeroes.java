package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 */
public class BinaryZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int zeroes = 0;
        while (number % 2 == 0) {
            number /= 2;
            zeroes++;
        }
        System.out.println(zeroes);
    }
}

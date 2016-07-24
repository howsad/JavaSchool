package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 */
public class Roots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a != 0) {
            int d = (b * b) - (4 * a * c);
            if (d < 0) {
                System.out.println(0);
            } else if (d == 0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else {
            if (b != 0) {
                System.out.println(1);
            } else if (c != 0) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}

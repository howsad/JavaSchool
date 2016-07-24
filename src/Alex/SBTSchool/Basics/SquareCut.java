package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class SquareCut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int a = Math.min(a1, b1) + Math.min(a2, b2);
        b1 = Math.max(a1, b1);
        b2 = Math.max(a2, b2);
        if (a == b1 && b1 == b2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

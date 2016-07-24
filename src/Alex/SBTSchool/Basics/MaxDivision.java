package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 23.07.2016.
 */
public class MaxDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        boolean first = true;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            values[i] = a;
            if (a > max) {
                if (!first) {
                    secondMax = max;
                } else {
                    first = false;
                }
                max = a;
            }
        }
        int maxOut = max;
        int secMaxOut = secondMax;
        if (max >= 2 * secondMax) {
            maxOut = max / 4;
        } else {
            maxOut = max / 2;
        }
        if (max <= 2 * secondMax) {
            secMaxOut = secondMax / 2;
        }
        first = true;
        for (int i = 0; i < n; i++) {
            if (!first) {
                System.out.print(" ");
            } else {
                first = false;
            }
            int a = values[i];
            if (a == max) {
                System.out.print(maxOut);
            } else if (a == secondMax) {
                System.out.print(secMaxOut);
            } else {
                System.out.print(a);
            }
        }
    }
}

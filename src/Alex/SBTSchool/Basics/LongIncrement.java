package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class LongIncrement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        byte[] aDigits = new byte[n];
        for (int i = 0; i < n; i++) {
            aDigits[i] = scanner.nextByte();
        }
        boolean carry = true;
        for (int i = n - 1; i >= 0 && carry; i--) {
            if (aDigits[i] == 9) {
                aDigits[i] = 0;
            } else {
                carry = false;
                aDigits[i]++;
                break;
            }
        }
        boolean firstPrint = true;
        if (carry) {
            System.out.println(n + 1);
            System.out.print(1);
            firstPrint = false;
        } else {
            System.out.println(n);
        }
        for (int i = 0; i < n; i++) {
            if (!firstPrint) {
                System.out.print(" ");
            } else {
                firstPrint = false;
            }
            System.out.print(aDigits[i]);
        }
    }
}

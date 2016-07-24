package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class LongNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        byte[] aDigits = new byte[n];
        for (int i = 0; i < n; i++) {
            aDigits[i] = scanner.nextByte();
        }
        int m = scanner.nextInt();
        if (n < m) {
            System.out.println(-1);
        } else if (n > m) {
            System.out.println(1);
        } else {
            boolean equal = true;
            for (int i = 0; i < n; i++) {
                byte b = scanner.nextByte();
                if (aDigits[i] < b) {
                    System.out.println(-1);
                    equal = false;
                    break;
                } else if (aDigits[i] > b) {
                    System.out.println(1);
                    equal = false;
                    break;
                }
            }
            if (equal) {
                System.out.println(0);
            }
        }
    }
}

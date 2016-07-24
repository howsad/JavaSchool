package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class TrickySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = 0;
        int length = 1;
        int sum = 0;
        boolean sign = true;
        for (int i = 0; i < n; i++) {
            if (i == start + length) {
                start = start + length;
                length++;
                sign = !sign;
            }
            if (sign) {
                sum += scanner.nextInt();
            } else {
                sum -= scanner.nextInt();
            }
        }
        System.out.println(sum);
    }
}

package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class SumPosPowOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int powOfTwo = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            if (i == powOfTwo) {
                sum += a;
                powOfTwo *= 2;
            }
        }
        System.out.println(sum);
    }
}

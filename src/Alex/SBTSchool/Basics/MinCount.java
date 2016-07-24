package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class MinCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int minCount = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (min > a) {
                min = a;
                minCount = 1;
            } else if (min == a) {
                minCount++;
            }
        }
        System.out.println(minCount);
    }
}

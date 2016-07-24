package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class NearestLarger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        boolean[] changed = new boolean[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            data[i] = a;
            for (int j = 0; j < i; j++) {
                if (!changed[j] && data[j] < a) {
                    data[j] = a;
                    changed[j] = true;
                }
            }
        }
        boolean firstPrint = true;
        for (int i = 0; i < n; i++) {
            if (!firstPrint) {
                System.out.print(" ");
            } else {
                firstPrint = false;
            }
            if (changed[i]) {
                System.out.print(data[i]);
            } else {
                System.out.print(0);
            }
        }
    }
}

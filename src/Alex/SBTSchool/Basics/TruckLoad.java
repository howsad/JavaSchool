package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class TruckLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int sum = 0;
        int crates = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (sum + a <= w) {
                sum += a;
                crates++;
            }
        }
        System.out.println(crates + " " + sum);
    }
}

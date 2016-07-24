package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 400 == 0) {
            System.out.println(1);
        } else if (year % 100 == 0) {
            System.out.println(0);
        } else if (year % 4 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

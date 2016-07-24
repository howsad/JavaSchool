package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 */
public class FeetInch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cm = scanner.nextInt();
        if (cm % 3 == 2) {
            cm++;
        }
        int inch = cm / 3;
        System.out.println(inch / 12 + " " + inch % 12);
    }
}

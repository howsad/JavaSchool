package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class AgeAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 7) {
            System.out.println("preschool child");
        } else if (n < 18) {
            System.out.println("schoolchild " + (n-6));
        } else if (n < 23) {
            System.out.println("student " + (n - 17));
        } else {
            System.out.println("specialist");
        }
    }
}

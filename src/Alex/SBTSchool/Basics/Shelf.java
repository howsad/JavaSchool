package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class Shelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int shelfNum = 1;
        int totalBooks = 0;
        while (totalBooks < n) {
            totalBooks += shelfNum;
            shelfNum++;
        }
        System.out.println(shelfNum - 1);
    }
}

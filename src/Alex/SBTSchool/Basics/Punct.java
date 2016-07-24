package Alex.SBTSchool.Basics;

import java.util.Scanner;

public class Punct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.replaceAll("\\s*([.,!?])", "$1 ");
        s = s.replaceAll("\\s+", " ");
        System.out.print(s);
    }
}

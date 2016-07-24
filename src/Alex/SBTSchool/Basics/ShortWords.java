package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class ShortWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt() - 1;
        s = s.replaceAll("(?<!^)[a-z]{0," + n + "},(?!$)", "");
        s = s.replaceAll(",?[a-z]{0," + n + "},?", "");
//        s = s.replaceAll("[,][a-z]{0," + n + "}[,]", ",");
        System.out.println(s);
    }
}

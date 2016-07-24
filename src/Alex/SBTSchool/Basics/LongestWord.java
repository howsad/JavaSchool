package Alex.SBTSchool.Basics;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 22.07.2016.
 */
public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(s);
        String longword = "";
        while (m.find()) {
            if (m.group().length() > longword.length()) {
                longword = m.group();
            }
        }
        System.out.println(longword.length());
    }
}

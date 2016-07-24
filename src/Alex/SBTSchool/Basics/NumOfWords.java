package Alex.SBTSchool.Basics;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 22.07.2016.
 */
public class NumOfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(s);
        int num = 0;
        while (m.find()) {
            num++;
        }
        System.out.println(num);
    }
}

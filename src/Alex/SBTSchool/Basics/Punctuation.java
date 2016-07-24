package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 */
public class Punctuation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean hasComma = false;
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.charAt(0) == ',') {
                word = ", " + word.substring(1);
            }
            else if (!hasComma) {
                word = " " + word;
            }
            if (word.charAt(word.length() - 1) == ',') {
                hasComma = true;
                word += " ";
            } else {
                hasComma = false;
            }
            System.out.print(word);
        }
    }
}

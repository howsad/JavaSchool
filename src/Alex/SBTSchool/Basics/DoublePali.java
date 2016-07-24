package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class DoublePali {
    public static boolean isPali(String s, int l, int r) {
        int len = r - l + 1;
        for (int i = l; i < l + len / 2; i++) {
            if (s.charAt(i) != s.charAt(r - i + l)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        boolean doublePali = false;
        for (int i = 0; i < s.length(); i++) {
            if (isPali(s, 0, i) && isPali(s, i + 1, s.length() - 1)) {
                doublePali = true;
                break;
            }
        }
        if (doublePali) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

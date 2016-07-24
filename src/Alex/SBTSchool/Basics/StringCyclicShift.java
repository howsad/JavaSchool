package Alex.SBTSchool.Basics;

import java.util.Scanner;

public class StringCyclicShift {
    public String s;
    public int n;

    public StringCyclicShift(String s) {
        this.s = s;
        n = s.length();
    }

    public boolean less(int a, int b) {
        for (int i = 0; i < n; i++) {
            if (a + i == n) {
                a = -i;
            }
            if (b + i == n) {
                b = -i;
            }
            if (s.charAt(a + i) < s.charAt(b + i)) {
                return false;
            } else if (s.charAt(a + i) > s.charAt(b + i)) {
                return true;
            }
        }
        return false;
    }

    public void print(int shift) {
        int position = shift;
        for (int i = 0; i < n; i++) {
            if (position == n) {
                position -= n;
            }
            System.out.print(s.charAt(position));
            position++;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringCyclicShift shift = new StringCyclicShift(s);
        int shiftLength = 0;
        for (int i = 1; i < shift.n; i++) {
            if (shift.less(shiftLength, i)) {
                shiftLength = i;
            }
        }
        shift.print(shiftLength);
    }
}

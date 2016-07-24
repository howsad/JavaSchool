package Alex.SBTSchool.Basics;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class OftenValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (!values.containsKey(a)) {
                values.put(a, 1);
            } else {
                values.replace(a, values.get(a) + 1);
            }
        }
        int mostOften = 0;
        int oftenKey = 0;
        for (Integer key : values.keySet()) {
            if (mostOften < values.get(key)) {
                oftenKey = key;
                mostOften = values.get(key);
            }
        }
        System.out.println(oftenKey + " " + mostOften);
    }
}

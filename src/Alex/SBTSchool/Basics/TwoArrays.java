package Alex.SBTSchool.Basics;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Alexander on 22.07.2016.
 */
public class TwoArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] first = new int[n];
        HashMap<Integer, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            first[i] = a;
            if (firstMap.containsKey(a)) {
                int aHits = firstMap.get(a);
                firstMap.replace(a, aHits + 1);
            } else {
                firstMap.put(a, 1);
            }
        }
        int m = scanner.nextInt();
        int[] second = new int[n];
        int bLen = 0;
        HashMap<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int b = scanner.nextInt();
            if (firstMap.containsKey(b) && !firstMap.get(b).equals(0)) {
                second[bLen++] = b;
                if (secondMap.containsKey(b)) {
                    int bHits = firstMap.get(b);
                    secondMap.replace(b, bHits + 1);
                } else {
                    secondMap.put(b, 1);
                }
                int bHitsInFirstMap = firstMap.get(b);
                firstMap.replace(b, bHitsInFirstMap - 1);
            }
        }
        int numOfMatches = 0;
        int[] matches = new int[bLen];
        for (int i = 0, j = 0; i < bLen && j < n;) {
            if (!secondMap.containsKey(first[j]) || secondMap.get(first[j]).equals(0)) {
                j++;
            } else if (second[i] == first[j]) {
                int number = first[j++];
                i++;
                matches[numOfMatches++] = number;
                secondMap.replace(number, secondMap.get(number) - 1);
            }
        }
        boolean firstPrint = true;
        System.out.println(numOfMatches);
        for (int i = 0; i < numOfMatches; i++) {
            if (!firstPrint) {
                System.out.print(" ");
            } else {
                firstPrint = false;
            }
            System.out.print(matches[i]);
        }
    }
}

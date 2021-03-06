package Alex.SBTSchool.Basics;

import java.util.Scanner;

/**
 * Created by Alexander on 21.07.2016.
 * Problem 2036 description:
 * Дан набор из n слов, состоящих из маленьких латинских букв.
 * <p>
 * Будем называть слово странным, если в нем встречаются 3 или более гласные буквы подряд.
 * <p>
 * Ваша задача — удалить из данного набора все странные слова.
 * <p>
 * Гласными буквами в латинском алфавите считаются e,y,u,i,o,a.
 * <p>
 * <p>
 * Входные данные
 * В первой строке содержится число n — количество слов в наборе, n не превосходит 100.
 * Далее в n строках по одному на строке содержатся слова из набора. Слова состоят только
 * из маленьких латинских букв. Длина каждого слова не менее 1 и не более 20 символов.
 * <p>
 * <p>
 * Выходные данные
 * Выведите все слова из набора, не являющиеся странными. Каждое слово выводите на отдельной
 * строке в том порядке, в котором они заданы во входных данных.
 */
public class StrangeWords {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (!s.matches(".*[aeuioy]{3,}.*")) {
                System.out.println(s);
            }
        }
    }
}

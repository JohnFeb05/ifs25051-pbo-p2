package framework.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Utility untuk membaca input string dari keyboard.
 * Berada di layer framework karena bergantung pada {@link System.in}.
 */
public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            // Input habis (EOF), hentikan program dengan graceful
            System.exit(0);
            return null; // tidak akan pernah sampai sini
        }
    }
}
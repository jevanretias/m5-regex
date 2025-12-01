package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        final String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("You entered \"" + userInput + "\"");
        System.out.println(checkForPassword(userInput, 6));
        System.out.println(extractEmails(userInput));
        System.out.println(checkForDoubles(userInput));
    }

    public static boolean checkForPassword(String str, int minLength) {
        if (str == null || str.length() < minLength) {
            return false;
        }
        return Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+", str);
    }

    public static List<String> extractEmails(String str) {
        if (str == null) {
            return new ArrayList<>(); // FIXED
        }

        final Pattern pattern =
                Pattern.compile("\\b[^@\\s]+@(mail\\.utoronto\\.ca|utoronto\\.ca)\\b");

        final Matcher matcher = pattern.matcher(str);
        final List<String> result = new ArrayList<>();

        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static boolean checkForDoubles(String str) {
        if (str == null) {
            return false; // FIXED
        }
        return str.matches(".*([A-Z]).*\\1.*");
    }
}

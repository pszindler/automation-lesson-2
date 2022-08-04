import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(tokenGenerator());
    }

    public static String tokenGenerator() {
        System.out.println("Insert a number of token length" +
                "(available numbers are 5, 10, 15). \nIf you choose wrong the " +
                "5 will be set as default.");
        int numOfCharacters = askUserForTokenLength();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < numOfCharacters; i++) {
            // 33 stands for '!' and after that letters and special characters, 126 stands for '~'
            token.append((char) generateRandomNumber(33, 126));
        }
        return token.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();

    }

    public static int tryParseInt(String value, int defaultValue) {
        String defaultValCommunicate = "5 has been used as default value";
        String[] arrayOfCorrectNumbers = {"5", "10", "15"};
        if (Arrays.asList(arrayOfCorrectNumbers).contains(value)) {
            return Integer.parseInt(value);
        } else {
            System.out.println(defaultValCommunicate);
            return defaultValue;
        }
    }

    public static int askUserForTokenLength() {
        Scanner scn = new Scanner(System.in);
        String userNumber = scn.nextLine().strip();
        return tryParseInt(userNumber, 5);
    }

}

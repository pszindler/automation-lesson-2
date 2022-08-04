import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(tokenGenerator());
    }

    public static String tokenGenerator() {
        int numOfCharacters = askUserForTokenLength();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < numOfCharacters; i++) {
            // 33 - 126 ascii table that contains letters, numbers and special characters
            // for more info check ascii code table
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
        String[] arrayOfCorrectNumbers = {"5", "10", "15"};
        return (Arrays.asList(arrayOfCorrectNumbers).contains(value))
                ? Integer.parseInt(value) : defaultValue;
    }

    public static int askUserForTokenLength() {
        System.out.println("Insert a number of token length" +
                "(available numbers are 5, 10, 15). \nIf you choose wrong the " +
                "5 will be set as default.");
        Scanner scn = new Scanner(System.in);
        String userNumber = scn.nextLine().strip();
        return tryParseInt(userNumber, 5);
    }

}

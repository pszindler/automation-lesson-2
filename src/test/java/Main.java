import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(tokenGenerator());
    }

    public static @NotNull String tokenGenerator() {
        int numOfCharacters = askUserForTokenLength();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < numOfCharacters; i++) {
            // 33 - 126 ascii table that contains letters, numbers and special characters
            // for more info check ascii code table
            token.append((char) generateRandomNumber(33, 126));
        }
        return token.toString();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();

    }

    private static int askUserForTokenLengthAndValidate() {
        System.out.println("Insert a number of token length " +
                "(available numbers are 5, 10, 15)");
        String[] arrayOfCorrectNumbers = {"5", "10", "15"};
        Scanner scn = new Scanner(System.in);
        String userNumber = "";
        while (!Arrays.asList(arrayOfCorrectNumbers).contains(userNumber)) {
            System.out.println("Please insert correct token length");
            userNumber = scn.nextLine().strip();
        }
        return Integer.parseInt(userNumber);
    }
}

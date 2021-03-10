package zad3;

import java.util.Scanner;

public class PhoneDecryptor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter four-digit number: ");
        String userInput = input.nextLine();
        int number = Integer.parseInt(userInput);

        if(isFourDigitNumber(userInput)) {
            int firstDigit, secondDigit, thirdDigit, fourthDigit;

            fourthDigit = number % 10;
            number /= 10;
            thirdDigit = number % 10;
            number /= 10;
            secondDigit = number % 10;
            number /=10;
            firstDigit = number % 10;

            fourthDigit = (fourthDigit + 3) % 10;
            thirdDigit = (thirdDigit + 3) % 10;
            secondDigit = (secondDigit + 3) % 10;
            firstDigit = (firstDigit + 3) % 10;

            int numberHolder;

            numberHolder = firstDigit;
            firstDigit = thirdDigit;
            thirdDigit = numberHolder;

            numberHolder = secondDigit;
            secondDigit = fourthDigit;
            fourthDigit = numberHolder;

            System.out.printf("Decrypted number: %d%d%d%d", firstDigit, secondDigit, thirdDigit, fourthDigit);
        }
        else {
            System.err.println("Wrong input.\n");
        }
    }

    private static boolean isFourDigitNumber(String userInput) {
        return (!userInput.startsWith("-") && userInput.length() == 4);
    }

}

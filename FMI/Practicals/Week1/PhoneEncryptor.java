package zad3;

/* All their data is transmitted as four-digit Integers. They
have asked you to write a program that encrypts their data so that it may be
transmitted more securely. Your program should read a four-digit Integer entered by
the user and encrypt it as follows: Replace each digit by (the sum of that digit plus 7)
modulo 10. Then swap the first digit with the third, and swap the second digit with the
fourth. Print the encrypted Integer.*/

import java.util.Scanner;

public class PhoneEncryptor {
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

            fourthDigit = (fourthDigit + 7) % 10;
            thirdDigit = (thirdDigit + 7) % 10;
            secondDigit = (secondDigit + 7) % 10;
            firstDigit = (firstDigit + 7) % 10;

            int numberHolder;

            numberHolder = firstDigit;
            firstDigit = thirdDigit;
            thirdDigit = numberHolder;

            numberHolder = secondDigit;
            secondDigit = fourthDigit;
            fourthDigit = numberHolder;

            System.out.printf("Encrypted number: %d%d%d%d", firstDigit, secondDigit, thirdDigit, fourthDigit);
        }
        else {
            System.err.println("Wrong input.\n");
        }
    }

    private static boolean isFourDigitNumber(String userInput) {
        return (!userInput.startsWith("-") && userInput.length() == 4); //the program doesn't accept negative numbers
    }
}

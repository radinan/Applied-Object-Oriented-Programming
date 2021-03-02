package zad2;

/* 2. Write code that inputs a five-digit number . Display an error message if the number
is not five digits. Write code that separates the digits in the five digit number.  Store the
original value of number in variable originalNumber before performing calculations.
Write code that determines whether the first and last digits are identical and the second
and fourth digits are identical. Assign  resultString a string indicating whether or
not the original string is a palindrome.: */

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter five-digit number: ");
        String userInput = input.nextLine();
        int number = Integer.parseInt(userInput);

        if(isFiveDigitNumber(userInput)) {
            int originalNumber = number;
            int firstDigit, secondDigit, thirdDigit, fourthDigit, fifthDigit;

            fifthDigit = number % 10;
            number /=10;
            fourthDigit = number % 10;
            number /=10;
            thirdDigit = number % 10;
            number /=10;
            secondDigit = number % 10;
            number /=10;
            firstDigit = number % 10;

            String resultString;

            if(firstDigit == fifthDigit && secondDigit == fourthDigit) {
                resultString = "Entered number is palindrome.\n";
            }
            else {
                resultString = "Entered number is not palindrome.\n";
            }

            System.out.println(resultString);
        }
        else {
            System.err.println("Wrong input.");
        }
    }

    private static boolean isFiveDigitNumber (String number) {
        return ((number.startsWith("-") && number.length() == 6) ||
                (!number.startsWith("-") && number.length() == 5 ));
    }
}

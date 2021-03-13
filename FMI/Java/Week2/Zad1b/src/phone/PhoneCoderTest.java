package phone;

import java.util.Scanner;

public class PhoneCoderTest {
    public static void main(String[] args) {
        PhoneCoder phoneCoder = new PhoneCoder();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter 4-digit number: ");
        String phoneNumber = input.nextLine();

        System.out.printf("Encoded: %s \n", phoneCoder.encode(phoneNumber));

        System.out.print("Enter coded 4-digit number: ");
        String encodedPhoneNumber = input.nextLine();
        System.out.printf("Decoded: %s \n", phoneCoder.decode(encodedPhoneNumber));

    }
}

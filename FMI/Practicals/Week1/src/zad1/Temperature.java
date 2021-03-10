package zad1;

    /*1. Write an application to:
a) compute and output the celsius equivalent of an input  Fahrenheit temperature,
    using the calculation
    C = 5.0 / 9.0 * ( F - 32 );
b) compute and output Fahrenheit the equivalent of an input  celsius temperature,
    using the calculation
    F = 9.0 / 5.0 * C + 32;
c) Use the methods from parts (a) and (b) to write an application that enables the
    user either to enter a Fahrenheit temperature and display the Celsius equivalent
    or to enter a Celsius temperature and display the Fahrenheit equivalent. */

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("1. Convert fahrenheit to celsius\n2. Convert celsius to fahrenheit\n: ");
        int choice = input.nextInt();

        if(choice == 1) {
            convertFahrenheitToCelsius(input);
        }
        else if(choice == 2) {
            convertCelsiusToFahrenheit(input);
        }
        else {
            System.out.println("Invalid input.\n");
        }
    }

    private static void convertFahrenheitToCelsius (Scanner input) {
        System.out.print("Fahrenheit degree: ");
        double fahrenheit = input.nextDouble();
        double celsius = 5.0 / 9.0 * ( fahrenheit - 32 );
        System.out.printf("Celsius: %.2f", celsius);
    }

    private static void convertCelsiusToFahrenheit (Scanner input){
        System.out.print("Celsius degree: ");
        double celsius = input.nextDouble();
        double fahrenheit = 9.0 / 5.0 * celsius + 32;
        System.out.printf("Fahrenheit: %.2f", fahrenheit);
    }
}

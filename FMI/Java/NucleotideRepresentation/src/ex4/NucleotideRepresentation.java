package ex4;

/*A four- digit number N is used to store genetic information about the four nucleotide
bases denoted by each one of the A, C, G and T in terms of the powers of the digit 4.
Let
    𝑛
𝑁 = ∑ 𝑘𝑖 * 4^𝑖
   𝑖=0

where 𝑘𝑖 ∈ [0, 3]. Assume, the digits 0, 1, 2 ,3 denote the characters ‘A’, ‘C’,’G’, ‘T’
of the four nucleotide bases. Write a Java application that reads a four digit integer
number and outputs its representation in terms of the characters ‘A’, ‘C’,’G’, ‘T’
*/

import java.util.Scanner;

public class NucleotideRepresentation {
    public static void main(String[] args) {


        Scanner input = new Scanner (System.in);
        System.out.print("Enter a four digit integer number: ");
        String userInput = input.nextLine();
        int originalNumber = Integer.parseInt(userInput);
        StringBuilder numRepresentation = new StringBuilder();

        if(isFourDigit(userInput)) {
            int number = originalNumber;

            int firstMultiplicand, secondMultiplicand, thirdMultiplicand, fourthMultiplicand;

            firstMultiplicand = number % 4;
            number /= 4;
            secondMultiplicand = number % 4;
            number /= 4;
            thirdMultiplicand = number % 4;
            number /= 4;
            fourthMultiplicand = number % 4;

            //making a four digit number, which digits are the multiplicands
            int numAllMultiplicands = firstMultiplicand*1000 + secondMultiplicand*100 +
                    thirdMultiplicand*10 + fourthMultiplicand;

            // 0 -> A
            // 1 -> C
            // 2 -> G
            // 3 -> T

            for(int i = 0; i < 4 ; ++i){
                int currentDigit = numAllMultiplicands % 10;
                numAllMultiplicands /= 10;

                switch (currentDigit) {
                    case 0 -> numRepresentation.append('A');
                    case 1 -> numRepresentation.append('C');
                    case 2 -> numRepresentation.append('G');
                    case 3 -> numRepresentation.append('T');
                }
            }

            System.out.printf("Representation is: %s\n", numRepresentation);
        } else {
            System.err.println("Incorrect input.");
        }

    }

    public static boolean isFourDigit(String number)
    {
        return (!number.startsWith("-") && number.length() == 4 );
    }
}

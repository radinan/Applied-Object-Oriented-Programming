package ex5;

/*In this lecture, you learned about integers and the type int. Java can also represent
uppercase letters, lowercase letters and a considerable variety of special symbols.
Every character has a corresponding integer representation. The set of characters a
computer uses together with the corresponding integer representations for those
characters is called that computer’s character set. You can indicate a character value
in a program simply by enclosing that character in single quotes, as in ‘A’.
Write an application that displays the integer equivalents of some uppercase letters,
lowercase letters, digits and special symbols. Display the integer equivalents of the
following: A B C a b c 0 1 2 $ * + / and the blank character.*/

import java.util.Scanner;

public class IntegerEquivalents {
    public static void main(String[] args) {

        System.out.printf("%d %d %d %d %d %d %d %d %d %d %d %d %d \n",(int)'A', (int)'B', (int)'C', (int)'a',
                (int)'b', (int)'c', (int)'0', (int)'1', (int)'$', (int)'*', (int)'+', (int)'/', (int)' ');

    }
}

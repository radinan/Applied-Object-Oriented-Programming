- ***Characters***
stores a single character ('a')

- ***Strings***
-immutable (several methods return modified copies of the original)
String name = "My Name";
or
String name = new String("My Name"); //not needed
-**string literal: **
"This is string literal" <- *String*
- **string concatenation**
"First string " + "second string" + 5

- ***Integers***
60_000_000 represents the int value 60,000,000
Integer.MIN_VALUE
Integer.MAX_VALUE

- ***Comments***
`//` or ``/*...*/``

- ***Identifiers***
consisting of letters, digits, "_", "$"
does not begin with a digit, has no spaces
case sensitive

- **public static void main (String args[])**

- **System.out**
standart output object
prints on the terminal


- **System.out.print()** - default
- **System.out.println()** - with \n
- **System.out.printf()** - for formatting
- format specifiers:
%s (string)
%n (new line)
%d (integer)
%f (float)
%c (char)

- ***Escape characters***
Backslash (\) 

\n - newline

\t - tab

\r - position cursor at the beginning of the line (rewrite)

\\ - backslash char

\" - double quote



import java.util.Scanner <- java class library

...

Scanner input = new Scanner (Systems.in);

number = input.nextInt();
         input.nextLine();
         input.nextDouble();
               ...

- ***Constants**
identifier; holds the same value during its existence
*final* int MIN_HEIGHT = 69;
 1. give meaning to otherwise unclear literal values (MAX_LOAD instead of 150)
 2. if used in multiple places, its set in one place
 3. formally establish that a value should not change



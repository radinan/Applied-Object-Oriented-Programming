package shape;

import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter width: ");
        double userWidth = input.nextDouble();

        System.out.print("Enter height: ");
        double userHeight = input.nextDouble();

        Rectangle rectangle = new Rectangle(userWidth, userHeight);

        System.out.printf("Rectangle's width: %.2f, height: %.2f, color: %s \n",
                rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());

        System.out.printf("Area: %.2f and Perimeter: %.2f \n",
                rectangle.getArea(), rectangle.getPerimeter());
    }
}

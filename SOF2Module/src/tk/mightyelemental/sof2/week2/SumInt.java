package tk.mightyelemental.sof2.week2;

import java.util.Scanner;

public class SumInt {

    // Exercise 5
    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter a positive integer (0 to exit): ");
	int number = keyboard.nextInt();
	int total = number;
	while (number != 0) {
	    System.out.print("Enter a positive integer (0 to exit): ");
	    number = keyboard.nextInt();
	    total += number;
	}
	System.out.printf("sum: %d\n", total);
	keyboard.close();
    }

}

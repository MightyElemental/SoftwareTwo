package tk.mightyelemental.sof2.week2;

import java.util.Scanner;

public class UserInputs {

    // Exercise 1
    public static void main(String[] args) {

	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter a int: ");
	int number = keyboard.nextInt();
	keyboard.close();

	System.out.println("number entered is: " + number);
    }
}
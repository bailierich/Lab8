package lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {
Scanner scnr = new Scanner(System.in);

		String[] familyNames = { "Bailie", "Mya", "Candice", "Sylvestor", "Verna", "Darrin", "Deandre", "DJ", "Kesha","Amanda" };
		String[] faveFood = { "Fruit", "Pizza", "Steak", "Oranges", "Grapes", "Starburst", "Watermelon", "Salmon",
				"Cantelope", "Strawberries" };
		int[] age = { 21, 17, 45, 22, 40, 45, 21, 15, 70, 20 };

		System.out.println(
				"You've accessed the Richard Family registry! \nThere are 10 family members registered at this time. \n"
						+ "Which family member would you like to access?");

		tryIntInput(scnr, familyNames, faveFood, age);

		System.out.println(
				"Thank You for accessing our database. Please stay tuned for more updates and added family members!");

	}

	private static void tryIntInput(Scanner scnr, String familyNames[], String faveFood[], int age[]) {
		int userInput = 0;
		try {
			System.out.println("Please enter a number 1-10: ");
			userInput = scnr.nextInt();
			if (userInput == 1) {
				System.out.println("The " + userInput + "st family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(scnr, userInput, familyNames, faveFood, age);
			} else if (userInput == 2) {
				System.out.println("The " + userInput + "nd family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(scnr, userInput, familyNames, faveFood, age);
			} else if (userInput == 3) {
				System.out.println("The " + userInput + "rd family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(scnr ,userInput, familyNames, faveFood, age);
			} else if (userInput > 3) {
				System.out.println("The " + userInput + "th family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(scnr, userInput, familyNames, faveFood, age);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("That family member doesn't exist.");
			tryIntInput(scnr,familyNames, faveFood, age);
		} catch (InputMismatchException e) {
			System.out.println("That family member doesn't exist.");
			tryIntInput(scnr, familyNames, faveFood, age);
		}
	}

	private static void getFaveFoodOrAge(Scanner scnr, int familyNumber, String familyNames[], String faveFood[], int age[]) {
		String choice = null;
		System.out.println();
		try {
			System.out.print("Would you like to know " + familyNames[familyNumber] + "'s favorite food or age? \n"
					+ "Please type food or age: ");
			choice = scnr.next();
			if (choice.equalsIgnoreCase("food")) {
				System.out.println();
				System.out.println(familyNames[familyNumber] + "'s favorite food is " + faveFood[familyNumber] + ".");
				pickAnotherMemberOr(scnr, familyNumber, familyNames, faveFood, age);
			} else if (choice.equalsIgnoreCase("age")) {
				System.out.println();
				System.out.println(familyNames[familyNumber] + " is " + age[familyNumber] + " years old");
				pickAnotherMemberOr(scnr, familyNumber, familyNames, faveFood, age);
			}else {
				System.out.println();
				System.out.println("That data does not exist. Please try again. ");
				getFaveFoodOrAge(scnr, familyNumber, familyNames, faveFood, age);
			}
		} catch (Exception e) {
			System.out.println("That data does not exist. Please try again. ");
			getFaveFoodOrAge(scnr, familyNumber, familyNames, faveFood, age);
		}
	}

	private static void pickAnotherMemberOr(Scanner scnr, int familyNumber, String familyNames[], String faveFood[], int age[]) {
		String choice = null;
		System.out.println();
		System.out.print("Would you like to pick another family member or would you like to learn more about "
				+ familyNames[familyNumber] + "? \n"
				+ "Type NEXT to move on to another family member, MORE to learn more about " + familyNames[familyNumber]
				+ " or DONE to stop.");
		choice = scnr.next();
		try {
			if (choice.equalsIgnoreCase("next")) {
				tryIntInput(scnr, familyNames, faveFood, age);
			} else if (choice.equalsIgnoreCase("more")) {
				getFaveFoodOrAge(scnr, familyNumber, familyNames, faveFood, age);
			} else if (choice.equalsIgnoreCase("done")) {
				return;
			}
		} catch (Exception e) {
			System.out.println("Opps. Maybe you should try that again.");
			pickAnotherMemberOr(scnr, familyNumber, familyNames, faveFood, age);
		}
	}

}

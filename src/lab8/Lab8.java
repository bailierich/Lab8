package lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {

		String[] familyNames = { "Bailie", "Mya", "Candice", "Sylvestor", "Verna", "Darrin", "Deandre", "DJ", "Kesha" };
		String[] faveFood = { "Fruit", "Pizza", "Steak", "Oranges", "Grapes", "Starburst", "Watermelon", "Salmon",
				"Cantelope", "Strawberries" };
		int[] age = { 21, 17, 45, 22, 40, 45, 21, 15, 70 };

		System.out.println(
				"You've accessed the Richard Family registry! \nThere are 10 family members registered at this time. \n"
						+ "Which family member would you like to access?");

		tryIntInput(familyNames, faveFood, age);

		System.out.println(
				"Thank You for accessing our database. Please stay tuned for more updates and added family members!");

	}

	private static void tryIntInput(String familyNames[], String faveFood[], int age[]) {
		Scanner scnr1 = new Scanner(System.in);
		int userInput = 0;
		try {
			System.out.println("Please enter a number 1-10: ");
			userInput = scnr1.nextInt();
			if (userInput == 1) {
				System.out.println("The " + userInput + "st family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(userInput, familyNames, faveFood, age);
			} else if (userInput == 2) {
				System.out.println("The " + userInput + "nd family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(userInput, familyNames, faveFood, age);
			} else if (userInput == 3) {
				System.out.println("The " + userInput + "rd family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(userInput, familyNames, faveFood, age);
			} else if (userInput > 3) {
				System.out.println("The " + userInput + "th family member registered in our database is "
						+ familyNames[userInput] + " Richard.");
				getFaveFoodOrAge(userInput, familyNames, faveFood, age);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("That family member doesn't exist.");
			tryIntInput(familyNames, faveFood, age);
		} catch (InputMismatchException e) {
			System.out.println("That family member doesn't exist.");
			tryIntInput(familyNames, faveFood, age);
		}
		scnr1.close();
	}

	private static void getFaveFoodOrAge(int familyNumber, String familyNames[], String faveFood[], int age[]) {
		Scanner scnr2 = new Scanner(System.in);
		String choice = null;
		System.out.println();
		try {
			System.out.print("Would you like to know " + familyNames[familyNumber] + "'s favorite food or age? \n"
					+ "Please type food or age: ");
			choice = scnr2.next();
			if (choice.equalsIgnoreCase("food")) {
				System.out.println();
				System.out.println(familyNames[familyNumber] + "'s favorite food is " + faveFood[familyNumber] + ".");
				pickAnotherMemberOr(familyNumber, familyNames, faveFood, age);
			} else if (choice.equalsIgnoreCase("age")) {
				System.out.println();
				System.out.println(familyNames[familyNumber] + " is " + age[familyNumber] + " years old");
				pickAnotherMemberOr(familyNumber, familyNames, faveFood, age);
			}else {
				System.out.println();
				System.out.println("That data does not exist. Please try again. ");
				getFaveFoodOrAge(familyNumber, familyNames, faveFood, age);
			}
		} catch (Exception e) {
			System.out.println("That data does not exist. Please try again. ");
			getFaveFoodOrAge(familyNumber, familyNames, faveFood, age);
		}
		scnr2.close();
	}

	private static void pickAnotherMemberOr(int familyNumber, String familyNames[], String faveFood[], int age[]) {
		Scanner scnr3 = new Scanner(System.in);
		String choice = null;
		System.out.println();
		System.out.print("Would you like to pick another family member or would you like to learn more about "
				+ familyNames[familyNumber] + "? \n"
				+ "Type NEXT to move on to another family member, MORE to learn more about " + familyNames[familyNumber]
				+ " or DONE to stop.");
		choice = scnr3.next();
		try {
			if (choice.equalsIgnoreCase("next")) {
				tryIntInput(familyNames, faveFood, age);
			} else if (choice.equalsIgnoreCase("more")) {
				getFaveFoodOrAge(familyNumber, familyNames, faveFood, age);
			} else if (choice.equalsIgnoreCase("done")) {
				scnr3.close();
				return;
			}System.out.println("Opps. Maybe you should try that again.");
			pickAnotherMemberOr(familyNumber, familyNames, faveFood, age);
		} catch (Exception e) {
			System.out.println("Opps. Maybe you should try that again.");
			pickAnotherMemberOr(familyNumber, familyNames, faveFood, age);
		}

		;
	}

}

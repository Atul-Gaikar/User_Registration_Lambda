package com.bridgelabz.lambdauserregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

@FunctionalInterface
interface Registration {
	Boolean validate(String string);
}

public class LambdaUserRegistration {
	public static void main(String[] args) {
		Registration FirstName = firstName -> Pattern.matches(NAME_PATTERN, firstName);
		System.out.println(printResult(FirstName.validate(validFirstName())));
	}

	private static final String NAME_PATTERN = ("^[A-Z]{1}[a-z]{2}$");
	static Scanner input = new Scanner(System.in);

	private static String validFirstName() {
		System.out.println("Enter the First Name");
		return input.nextLine();
	}

	public static String printResult(Boolean result) {
		if (Boolean.TRUE.equals(result))
			return "Your Entry is Valid";
		else
			return "Your Entry is Invalid";
	}

}
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
		Registration LastName = lastName -> Pattern.matches(NAME_PATTERN, lastName);
		Registration Email = email -> Pattern.matches(EMAIL_PATTERN, email);
		Registration MobileNumber = mobileNumber -> Pattern.matches(MOBILE_NUMBER_PATTERN, mobileNumber);
		System.out.println(printResult(FirstName.validate(validFirstName())));
		System.out.println(printResult(LastName.validate(validLastName())));
		System.out.println(printResult(Email.validate(validEmail())));
		System.out.println(printResult(MobileNumber.validate(validMobileNumber())));
	}

	private static final String NAME_PATTERN = ("^[A-Z]{1}[a-z]{2}$");
	private static final String EMAIL_PATTERN = ("^[a-z0-9+_.-]+@[a-zA-Z0-9.-]+$");
	private static final String MOBILE_NUMBER_PATTERN = ("^[7-9][0-9]{9}$");
	static Scanner input = new Scanner(System.in);

	private static String validFirstName() {
		System.out.println("Enter the First Name");
		return input.nextLine();
	}

	private static String validLastName() {
		System.out.println("Enter the Last Name");
		return input.nextLine();
	}

	private static String validEmail() {
		System.out.println("Enter The Email Address");
		return input.next();
	}

	private static String validMobileNumber() {
		System.out.println("Enter The Mobile Number");
		return input.next();
	}

	public static String printResult(Boolean result) {
		if (Boolean.TRUE.equals(result))
			return "Your Entry is Valid";
		else
			return "Your Entry is Invalid";
	}

}
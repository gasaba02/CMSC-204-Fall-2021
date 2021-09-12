package application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Germain Asaba
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> invalidPasswords;

	@Before
	public void setUp() throws Exception {
		String[] myPasswords = {"Starwars33", "infinitywar03#", "iron"};
		invalidPasswords = new ArrayList<String>();
		invalidPasswords.addAll(Arrays.asList(myPasswords));
		
	}

	@After
	public void tearDown() throws Exception {
		invalidPasswords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("tall1"));
		} catch (LengthException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("cr7ronaldo7!"));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("CR7RONALDO7!"));
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("C7be!"));
		} catch (WeakPasswordException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("AAAaaok1!"));
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("crronaldo!"));
		} catch (NoDigitException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Cr7ronaldo7!"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> myResult;
		myResult = PasswordCheckerUtility.getInvalidPasswords(invalidPasswords);
		assertEquals(myResult.size(), 3);
		assertEquals(myResult.get(0), "Starwars33 -> The password must contain at least one special character");
		assertEquals(myResult.get(0), "infinitywar03# -> The password must contain at least one uppercase alphabetic character");
		assertEquals(myResult.get(0), "iron -> The password must be at least 6 characters long");



		

	}
	
}
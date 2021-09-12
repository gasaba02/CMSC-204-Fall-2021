package application;

import java.util.ArrayList;

/**
 * This is a class that 
 * @author Germain Asaba
 *
 */
public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {

	}


	/**
	 * This method takes two passwords and checks if they're equal
	 * @param password Password to be checked
	 * @param passwordConfirm password to be compared
	 * @throws UnmatchedException Thrown if the passwords aren't the same
	 */
	public static void comparePasswords(String password, 
			String passwordConfirm) throws UnmatchedException {
		if(password != null) {

			if(!password.equals(passwordConfirm)) {
				throw new UnmatchedException();
			}

		}
		else {
			throw new UnmatchedException();
		}
	}


	/**
	 * This method takes two passwords and checks if they're equal 
	 * @param password Password String to be checked
	 * @param passwordConfirm Password string to be compared 
	 * @return Returns true if both are the same
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password != null) {
			if(!password.equals(passwordConfirm)) {
				return false;
			}
			return true;

		}
		else {
			return false;
		}
	}

	/**
	 * This method checks if the password string has a digit
	 * @param password Password string to be checked
	 * @return Returns true if the password string has a digit
	 * @throws NoDigitException Thrown if it does not have a digit
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException(); 
	}


	/**
	 *  This method checks if the password string has between six & nine characters
	 * @param password Password string to be checked
	 * @return Returns true if it has between six & nine characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		int lowerBound = 6;
		int upperBound = 9;
		if(password.length() >= lowerBound && password.length() <= upperBound) {
			return true;
		}
		return false;
	}


	/**
	 * This method checks if the password string has lower-case letter
	 * @param password Password string to be checked
	 * @return Returns true if the string has a lower-case letter
	 * @throws NoLowerAlphaException Thrown if the password string doesn't have a lower-case leter
	 */
	public static boolean hasLowerAlpha(String password) 
			throws NoLowerAlphaException {

		for(int index= 0; index < password.length(); index++) {
			if(Character.isLowerCase(password.charAt(index))) {
				
				return true;
			}

		}

		throw new NoLowerAlphaException();
	}


	/**
	 * This method checks if the string has more than two of the same characters in a sequence
	 * @param password Password string to be checked
	 * @return Returns true if the password string meets the requirement
	 * @throws InvalidSequenceException Thrown if the password string doesn't meet the requirement
	 */
	public static boolean hasSameCharInSequence(String password)
			throws InvalidSequenceException {

		for(int index = 0; index < password.length() - 2; index++) {
			if(password.charAt(index) == password.charAt(index + 1) &&
					password.charAt(index) == password.charAt(index + 2)) {
				throw new InvalidSequenceException();

			}
		}

		return false;
	}

	/**
	 * This method checks of the password string has at least one special character
	 * @param password Password string to be checked
	 * @return Returns true if the password string has a special character
	 * @throws NoSpecialCharacterException Thrown if the password string doesn't have a special character
	 */
	public static boolean hasSpecialChar(String password) 
			throws NoSpecialCharacterException{

		for(int index = 0; index < password.length(); index++) {
			if(!(Character.isUpperCase(password.charAt(index))) && 
					(!(Character.isLowerCase(password.charAt(index)))) &&
					((!(Character.isDigit(password.charAt(index)))))) {
				
				return true;
			}
		}

		throw new NoSpecialCharacterException();
	}


	/**
	 * This method checks if the string has an upper-case letter
	 * @param password The password string to be checked
	 * @return Returns true if the password has an upper-case letter
	 * @throws NoUpperAlphaException Thrown if the password doesn't have an upper-case letter
	 */
	public static boolean hasUpperAlpha(String password)
			throws NoUpperAlphaException{
		for(int index = 0; index < password.length(); index++) {
			if(Character.isUpperCase(password.charAt(index))) {
				return true;
			}
		}

		throw new NoUpperAlphaException();
	}


	/**
	 * This method checks if the password meets the length requirement of six or more
	 * @param password password The password string to be checked
	 * @return Returns true if the length is six or more
	 * @throws LengthException Thrown if the length is not more than six
	 */
	public static boolean isValidLength (String password)
			throws LengthException{
		int passLength = 6;
		if(password.length() >= passLength) {
			
			return true;
		}
		throw new LengthException();

	}


	/**
	 * This method checks if the password string follows all the rules 
	 * @param password Password string to be checked
	 * @return Returns true if the password string follows all the rules
	 * @throws LengthException Thrown if the length is not more than six
	 * @throws NoUpperAlphaException Thrown if the password doesn't have an upper-case letter
	 * @throws NoLowerAlphaException Thrown if the password doesn't have an lower-case letter
	 * @throws NoDigitException Thrown if the password doesn't have a digit
	 * @throws NoSpecialCharacterException Thrown if the password doesn't have a special character
	 * @throws InvalidSequenceException Thrown if the password has more than two of the same characters in a sequence
	 */
	public static boolean isValidPassword(String password)
			throws LengthException,
			NoUpperAlphaException,
			NoLowerAlphaException,
			NoDigitException,
			NoSpecialCharacterException,
			InvalidSequenceException{




		return isValidLength(password)    
				&& (!hasSameCharInSequence(password)) && hasDigit(password)  && hasUpperAlpha(password) && 
				hasLowerAlpha(password) && hasSpecialChar(password);

	}


	/**
	 * This method Checks if the password is valid but weak
	 * @param password Password to be checked
	 * @return Returns true if the password is valid but weak
	 * @throws WeakPasswordException Thrown if the password is weak
	 */
	public static boolean isWeakPassword(String password) 
			throws WeakPasswordException{

		if ( hasBetweenSixAndNineChars(password)) {
			return true;
		} else if(password.length()> 9) {
			return false;
		}
		throw new WeakPasswordException();
	}


	/**
	 * This method reads a file of passwords and stores all the invalid ones into an arraylist 
	 * @param passwords List of passwords read from a text file
	 * @return Returns an arraylist of all the invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String>passwords){
		ArrayList<String> inValidPasswords = new ArrayList<String>();
		for (String password: passwords) {
			try {
				if (isValidPassword(password) ) {
					continue;
				} else {
					inValidPasswords.add(password);
				}
			} catch(Exception e) {
				inValidPasswords.add(password + " -> " + e.getMessage());
			}
		}

		return inValidPasswords;

	}



}

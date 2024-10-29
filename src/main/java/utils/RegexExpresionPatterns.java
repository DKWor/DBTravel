package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpresionPatterns {

	public RegexExpresionPatterns() {

	}

	public boolean isMobileNumber(String value) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]+");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBlank(String value) {

		int num = value.length();
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isChar(String value) {
//		Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
//			System.out.println("text filed contain text characters");
			return true;
		} else {
//			System.out.println("text filed not contain text characters");
			return false;
		}

	}

	public boolean isAlphaNumberic(String value) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isAlphabets(String value) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAlphaNumbericSpecial(String value) {
		Pattern pattern = Pattern.compile("^\\\\d{13}$");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSpecial(String value) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmailValidation(String value) {
		Pattern pattern = Pattern.compile(
				"^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		System.out.println("email id matchFound" + matchFound);
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isMobileNumberValidation(String value) {

		Pattern pattern = Pattern.compile("^\\\\d{13}$");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		if (matchFound) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isMobileCode(String value) {

		Pattern pattern = Pattern.compile("^\\d{3}$");
		Matcher matcher = pattern.matcher(value);

		boolean matchFound = matcher.find();
		System.out.println("Country code is" + value);
		System.out.println("Country code match found" + matchFound);

		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

}

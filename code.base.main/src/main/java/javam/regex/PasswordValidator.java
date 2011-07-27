/**
 * 
 */
package javam.regex;

import java.util.regex.Pattern;

/**
 * @author Deniz KALFA
 *
 */
public class PasswordValidator extends AbstractValidator {
	private static final String PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	@Override
	public Pattern getPattern() {
		return Pattern.compile(PATTERN);
	}

}

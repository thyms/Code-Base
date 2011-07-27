/**
 * 
 */
package javam.regex;

import java.util.regex.Pattern;

/**
 * @author Deniz KALFA
 *
 */
public class UsernameValidator extends AbstractValidator{
	private static final String PATTERN = "^[a-z0-9_-]{3,15}$";

	@Override
	public Pattern getPattern() {
		return Pattern.compile(PATTERN);
	}
}

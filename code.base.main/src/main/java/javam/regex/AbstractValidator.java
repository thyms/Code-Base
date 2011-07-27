/**
 * 
 */
package javam.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Deniz KALFA
 *
 */
public abstract class AbstractValidator implements Validator {

	@Override
	public boolean validate(String value) {
		Matcher matcher = getPattern().matcher(value);
		return matcher.matches();
	}

	@Override
	public abstract Pattern getPattern();
	

}

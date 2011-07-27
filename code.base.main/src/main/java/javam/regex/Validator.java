/**
 * 
 */
package javam.regex;

import java.util.regex.Pattern;

/**
 * @author Deniz KALFA
 *
 */
public interface Validator {
	public boolean validate(String value);
	public Pattern getPattern();
}

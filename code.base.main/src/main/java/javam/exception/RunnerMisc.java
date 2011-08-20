/**
 * 
 */
package javam.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerMisc {
	public static void main(String[] args) {
		
		//
		// Getting exception stack trace message
		//
		try {
			int a = 10 / 0;
			System.out.println(String.valueOf(a));
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			e.printStackTrace(pw);
			System.out.println("Error = " + sw.toString());
		}
	}
}

/**
 * 
 */
package javam.util;

import model.customer.Customer;

/**
 * @author Deniz KALFA
 *
 */
public class RunnerString {
	public static void main(String[] args) {
		//
		//	ToString override with ToStringBuilder.reflectionToString
		//
		Customer customer = new Customer();
		customer.setFirstName("Joe");
		customer.setLastName("Black");
		
		System.out.println(customer);
	}
}

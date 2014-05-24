package com.exemple.ecommerce.exceptions;

/**
 * Class exception for when the product is not retrieve
 * @author Steven
 *
 */
public class UnknownProductException extends Exception {

	private static final long serialVersionUID = -6575422112534297724L;

	/**
	 * Personal message with the id the user was trying to access
	 * @param id
	 */
	public UnknownProductException(Long id){
		super("The product with id "+id+" doesn't exist!");
	}
	
	public UnknownProductException(String msg){
		super(msg);
	}
}

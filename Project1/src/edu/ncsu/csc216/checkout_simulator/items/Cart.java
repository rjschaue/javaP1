/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * This abstract class provides functionality for all types of carts
 * 
 * @author Joey
 *
 */
public abstract class Cart {
	/** the initial register index for the cart */
	public static final int INITIAL_REGISTER_IDX = -1;
	/** the arrival time of the cart in a line */
	private int arrivalTime;
	/** the waiting time for a cart */
	private int waitTime;
	/** the processing time for a cart */
	private int processTime;
	/** the register index of the cart */
	private int registerIndex;
	/** gets whether the cart is waiting or processing (true) or not (false) */
	private boolean waitingProcessing;
	
	/**
	 * The constructor for Cart
	 * @param arrivalTime the time the cart arrives in line
	 * @param processTime the amount of time it takes the cart to be processed
	 * @throws IllegalArgumentException if the arrival or process time is less than 0
	 */
	public Cart(int arrivalTime, int processTime) {
		if (arrivalTime < 0 || processTime < 0) {
			throw new IllegalArgumentException();
		}
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
	}
	
	/**
	 * Returns the arrival time of the cart
	 * @return the arrival time of the cart
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * Returns the wait time of the cart
	 * @return the wait time of the cart
	 */
	public int getWaitTime() {
		return waitTime;
	}
	
	/**
	 * Sets the wait time of the cart to the given wait time
	 * @param waitTime the given wait time of the cart
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	/**
	 * Returns the process time of the cart
	 * @return the process time of the cart
	 */
	public int getProcessTime() {
		return processTime;
	}
	
	/**
	 * Returns the register index of the cart
	 * @return the register index of the cart
	 */
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	/**
	 * Returns whether a cart is in line or not
	 * @return whether a cart is in line (true) or not (false)
	 */
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	/**
	 * Removes a cart from a line
	 */
	public void removeFromWaitingLine() {
		waitingProcessing = false;
	}
	
	/**
	 * Sets the register index to the given index
	 * @param registerIndex the register index to set the cart to
	 */
	protected void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
	}
	
	/**
	 * The abstract method for a cart getting in line
	 * @param checkoutRegister an array of available checkout registers
	 */
	public abstract void getInLine(CheckoutRegister[] checkoutRegister);
	
	/**
	 * The abstract method for returning a cart's color
	 * @return the cart's color
	 */
	public abstract Color getColor();
}

package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * Logs the information from checked out carts
 * @author Joey Schauer
 *
 */
public class Log {
	/** The number of checked out carts */
	private int numCompleted;
	/** the total wait time of checked out carts */
	private int totalWaitTime;
	/** the total process time for checked out carts */
	private int totalProcessTime;
	
	/**
	 * The default constructor for Log
	 */
	public Log() {
		
	}
	
	/**
	 * Returns the number of checked out carts
	 * @return the number of checked out carts
	 */
	public int getNumCompleted() {
		return numCompleted;
	}
	
	/**
	 * Logs the information from a checked out cart
	 * @param cart the cart to be logged
	 */
	public void logCart(Cart cart) {
		totalWaitTime += cart.getWaitTime();
		totalProcessTime += cart.getProcessTime();
		numCompleted++;
	}
	
	/**
	 * Calculates the average wait time for checked out carts
	 * @return the average wait time for checked out carts
	 */
	public double averageWaitTime() {
		if (numCompleted > 0) {
			return (double) totalWaitTime / (double) numCompleted;
		}
		return 0.0;
	}
	
	/**
	 * Calculates the average process time for checked out carts
	 * @return the average process time for checked out carts
	 */
	public double averageProcessTime() {
		if (numCompleted > 0) {
			return (double) totalProcessTime / (double) numCompleted;
		}
		return 0.0;
	}
}

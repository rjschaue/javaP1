package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * @author Joey
 *
 */
public class Log {
	private int numCompleted;
	private int totalWaitTime;
	private int totalProcessTime;
	
	public Log() {
		
	}
	
	public int getNumCompleted() {
		return numCompleted;
	}
	
	public void logCart(Cart cart) {
		totalWaitTime += cart.getWaitTime();
		totalProcessTime += cart.getProcessTime();
		numCompleted++;
	}
	
	public double averageWaitTime() {
		if (numCompleted > 0) {
			return (double) totalWaitTime / (double) numCompleted;
		}
		return 0.0;
	}
	
	public double averageProcessTime() {
		if (numCompleted > 0) {
			return (double) totalProcessTime / (double) numCompleted;
		}
		return 0.0;
	}
}

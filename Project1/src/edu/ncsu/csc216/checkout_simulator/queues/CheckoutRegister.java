/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * This class handles values processes for a checkout register
 * 
 * @author Joey Schauer
 *
 */
public class CheckoutRegister implements LineOfItems{
	/** the time when the checkout register is available */
	private int timeWhenAvailable;
	/** a log to get the results of processing carts through the register */
	private Log log;
	/** the queue of carts in the line */
	private ShoppingCartQueue line;
	
	/**
	 * The constructor for CheckoutRegister
	 * @param log the log of results from processing carts
	 */
	public CheckoutRegister(Log log) {
		this.log = log;
		line = new ShoppingCartQueue();
	}
	
	/**
	 * Returns the size of the register line
	 * @return the size of the register line
	 */
	@Override
	public int size() {
		return line.size();
	}
	
	/**
	 * Processes the next cart in line
	 * @return the cart that was processed
	 */
	@Override
	public Cart processNext() {
		log.logCart(line.front());
		return line.remove();
	}
	
	/**
	 * Returns if the register line has any more carts in it
	 * @return if the register line has any more carts in it
	 */
	@Override
	public boolean hasNext() {
		return !line.isEmpty();
	}	

	/**
	 * Returns what the depart time is for the next cart
	 * @return what the depart time is for the next cart
	 */
	@Override
	public int departTimeNext() {
		if(hasNext()) {
			Cart cart = line.front();
			return (cart.getArrivalTime() + cart.getWaitTime() + cart.getProcessTime());
		}
		return Integer.MAX_VALUE;
	}

	/**
	 * Adds a given cart to the register's line
	 * @param cart the cart to be added
	 */
	public void addCartToLine(Cart cart) {
		line.add(cart);
		if (line.isEmpty()) {
			cart.setWaitTime(0);
		} else {
			cart.setWaitTime(timeWhenAvailable);			
		}
		timeWhenAvailable += cart.getProcessTime();
	}
}

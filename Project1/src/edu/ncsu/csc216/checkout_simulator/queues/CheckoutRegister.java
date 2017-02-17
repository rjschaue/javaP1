/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * @author Joey
 *
 */
public class CheckoutRegister implements LineOfItems{
	private int timeWhenAvailable;
	private Log log;
	private ShoppingCartQueue line;
	
	public CheckoutRegister(Log log) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Cart processNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}	

	@Override
	public int departTimeNext() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addCartToLine(Cart cart) {
		// TODO Auto-generated method stub
	}
}

/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * @author Joey
 *
 */
public class Store implements LineOfItems {
	private ShoppingCartQueue shopping;
	private CheckoutRegister[] register;
	
	public Store(int numCarts, CheckoutRegister[] checkoutRegister) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cart processNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int departTimeNext() {
		// TODO Auto-generated method stub
		return 0;
	}
}

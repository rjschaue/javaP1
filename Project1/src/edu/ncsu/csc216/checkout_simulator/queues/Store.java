/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.CartFactory;

/**
 * @author Joey
 *
 */
public class Store implements LineOfItems {
	private ShoppingCartQueue shopping;
	private CheckoutRegister[] register;
	
	public Store(int numCarts, CheckoutRegister[] register) {
		shopping = new ShoppingCartQueue();
		for (int i = 1; i <= numCarts; i++) {
			shopping.add(CartFactory.createCart());
		}
		this.register = register;
	}
	
	@Override
	public int size() {
		return shopping.size();
	}
	
	@Override
	public boolean hasNext() {
		return !shopping.isEmpty();
	}

	@Override
	public Cart processNext() {
		shopping.front().getInLine(register);
		register[shopping.front().getRegisterIndex()].addCartToLine(shopping.front());
		return shopping.remove();
	}

	@Override
	public int departTimeNext() {		
		if(hasNext()) {
			return shopping.front().getArrivalTime();
		}
		return Integer.MAX_VALUE;
	}
}

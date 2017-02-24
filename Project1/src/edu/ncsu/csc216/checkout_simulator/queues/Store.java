package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.CartFactory;

/**
 * This class handles processes for Carts in the Store
 * @author Joey Schauer
 */
public class Store implements LineOfItems {
	/** the queue of carts that are shopping */
	private ShoppingCartQueue shopping;
	/** the array of registers in the store */
	private CheckoutRegister[] register;
	
	/**
	 * The constructor for Store
	 * @param numCarts the number of carts in the store
	 * @param register the array of registers in the store
	 */
	public Store(int numCarts, CheckoutRegister[] register) {
		shopping = new ShoppingCartQueue();
		for (int i = 1; i <= numCarts; i++) {
			shopping.add(CartFactory.createCart());
		}
		this.register = register;
	}
	
	/**
	 * The size of the shopping queue
	 */
	@Override
	public int size() {
		return shopping.size();
	}
	
	/**
	 * Returns if the shopping queue has any carts left
	 * @return if the shopping queue has any carts left
	 */
	@Override
	public boolean hasNext() {
		return !shopping.isEmpty();
	}

	/**
	 * Processes the next cart at the front of the shopping queue
	 */
	@Override
	public Cart processNext() {
		shopping.front().getInLine(register);
		register[shopping.front().getRegisterIndex()].addCartToLine(shopping.front());
		return shopping.remove();
	}

	/**
	 * Returns the depart time of the next cart in the shopping queue or the max integer value if empty
	 * @return the depart time of the next cart in the shopping queue or the max integer value if empty
	 */
	@Override
	public int departTimeNext() {		
		if(hasNext()) {
			return shopping.front().getArrivalTime();
		}
		return Integer.MAX_VALUE;
	}
}

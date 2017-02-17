/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * This class represents regular shopping carts
 * 
 * @author Joey
 *
 */
public class RegularShoppingCart extends Cart{
	/** the color of the regular shopping cart */
	private static Color color = Color.BLUE;

	/**
	 * Constructor for RegularShoppingCart
	 * @param arrivalTime the time the cart arrives in line
	 * @param processTime the amount of time it takes the cart to be processed
	 */
	public RegularShoppingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

	/**
	 * Puts the RegularShoppingCart in the appropriate line (any line but the express line)
	 */
	@Override
	public void getInLine(CheckoutRegister[] checkoutRegister) {
		int line = Integer.MAX_VALUE;
		for (int i = 1; i < checkoutRegister.length; i++) {
			if (checkoutRegister[i].size() < line) {
				line = i;
			}
		}
		setRegisterIndex(line);
		
	}

	/**
	 * Returns the color of the RegularShoppingCart
	 * @return the color of the RegularShoppingCart
	 */
	@Override
	public Color getColor() {
		return color;
	}

}

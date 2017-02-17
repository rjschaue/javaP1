/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * This class represents special handling carts
 * 
 * @author Joey Schauer
 *
 */
public class SpecialHandlingCart extends Cart{
	/** the color of the special handling cart */
	private static Color color = Color.RED;

	/**
	 * Constructor for SpecialHandlingCart
	 * @param arrivalTime the time the cart arrives in line
	 * @param processTime the amount of time it takes the cart to be processed
	 */
	public SpecialHandlingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

	/**
	 * Puts the SpecialHandlingCart in the appropriate line (only special lines)
	 */
	@Override
	public void getInLine(CheckoutRegister[] checkoutRegister) {
		int line = Integer.MAX_VALUE;
		int specialStart = 0;
		if (checkoutRegister.length / 4 == 0) {
			specialStart = checkoutRegister.length - (checkoutRegister.length / 4);
		} else {
			specialStart = (checkoutRegister.length - (checkoutRegister.length / 4)) - 1;
		}
		for (int i = specialStart; i < checkoutRegister.length; i++) {
			if (checkoutRegister[i].size() < line) {
				line = i;
			}
		}
		setRegisterIndex(line);
	}

	/**
	 * Returns the color of the SpecialHandlingCart
	 * @return the color of the SpecialHandlingCart
	 */
	@Override
	public Color getColor() {
		return color;
	}

}

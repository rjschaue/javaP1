/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * This class represents express carts
 *
 * @author Joey Schauer
 *
 */
public class ExpressCart extends Cart{
	/** the color of the express cart */
	private static Color color = Color.GREEN;

	/**
	 * Constructor for ExpressCart
	 * @param arrivalTime the time the cart arrives in line
	 * @param processTime the amount of time it takes the cart to be processed
	 */
	public ExpressCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

	/**
	 * Puts the ExpressCart in the appropriate line (any line is valid)
	 */
	@Override
	public void getInLine(CheckoutRegister[] checkoutRegister) {
		int line = Integer.MAX_VALUE;
		for (int i = 0; i < checkoutRegister.length; i++) {
			if (checkoutRegister[i].size() < line) {
				line = i;
			}
		}
		setRegisterIndex(line);
	}

	/**
	 * Returns the color of the ExpressCart
	 * @return the color of the ExpressCart
	 */
	@Override
	public Color getColor() {
		return color;
	}

}

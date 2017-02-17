/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * @author Joey
 *
 */
public class ExpressCart extends Cart{
	private static Color color;

	/**
	 * @param arrivalTime
	 * @param processTime
	 */
	public ExpressCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

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

	@Override
	public Color getColor() {
		return color;
	}

}

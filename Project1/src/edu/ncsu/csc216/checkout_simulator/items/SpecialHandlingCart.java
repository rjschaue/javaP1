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
public class SpecialHandlingCart extends Cart{
	private static Color color;

	public SpecialHandlingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

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

	@Override
	public Color getColor() {
		return color;
	}

}

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
public class RegularShoppingCart extends Cart{
	private static Color color;

	public RegularShoppingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

	@Override
	public void getInLine(CheckoutRegister[] checkoutRegister) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		return color;
	}

}

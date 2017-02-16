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
		// TODO Auto-generated method stub	
	}

	@Override
	public Color getColor() {
		return color;
	}

}

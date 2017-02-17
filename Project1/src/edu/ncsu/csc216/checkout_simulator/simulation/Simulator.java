/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.Store;

/**
 * @author Joey
 *
 */
public class Simulator {
	public static final int MIN_NUM_REGISTERS = 3;
	public static final int MAX_NUM_REGISTERS = 12;
	private int numRegisters;
	private int numCarts;
	private int stepsTaken;
	private Log myLog;
	private EventCalendar theCalendar;
	private Store theStore;
	private CheckoutRegister[] register;
	private Cart currentCart;
	
	public Simulator(int numCarts, int numRegisters) {
		if (numRegisters < MIN_NUM_REGISTERS || numRegisters > MAX_NUM_REGISTERS || numCarts < 1) {
			throw new IllegalArgumentException();
		}
		this.numCarts = numCarts;
		this.numRegisters = numRegisters;
		register = new CheckoutRegister[7];
		theStore = new Store(numCarts, register);
		theCalendar = new EventCalendar(register, theStore);
		myLog = new Log();
	}
	
	public static Color[] simulationColors() {
		Color[] colors = new Color[3];
		return colors;
	}
	
	public static String[] simulationLabels() {
		String[] labels = new String[3];
		labels[0] = "Express Cart";
		labels[1] = "Regular Cart";
		labels[2] = "Special Handling Cart";
		return labels;
	}
	
	public void step() {
		// TODO Auto-generated method stub
	}
	
	public int getStepsTaken() {
		return stepsTaken;
	}
	
	public int totalNumberOfSteps() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean moreSteps() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getCurrentIndex() {
		if (currentCart == null) {
			return -1;
		}
		return currentCart.getRegisterIndex();
	}
	
	public Color getCurrentCartColor() {
		if (currentCart == null) {
			return null;
		}
		return currentCart.getColor();
	}
	
	public boolean itemLeftSimulation() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double averageWaitTime() {
		return myLog.averageWaitTime();
	}
	
	public double averageProcessTime() {
		return myLog.averageProcessTime();
	}
}

/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.LineOfItems;
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
	
	public Simulator(int numRegisters, int numCarts) {
		if (numRegisters < MIN_NUM_REGISTERS || numRegisters > MAX_NUM_REGISTERS || numCarts < 1) {
			throw new IllegalArgumentException("Number of registers must be between 3 and 12 inclusive.");
		}
		this.numCarts = numCarts;
		this.numRegisters = numRegisters;
		register = new CheckoutRegister[this.numRegisters];
		myLog = new Log();
		for (int i = 0; i < register.length; i++) {
			register[i]= new CheckoutRegister(myLog);
		}
		theStore = new Store(numCarts, register);
		theCalendar = new EventCalendar(register, theStore);
	}
	
	public static Color[] simulationColors() {
		Color[] colors = new Color[3];
		colors[0] = Color.GREEN;
		colors[1] = Color.BLUE;
		colors[2] = Color.RED;
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
		currentCart = null;
		LineOfItems next;
		try {
			next = theCalendar.nextToBeProcessed();
		} catch (IllegalStateException e) {
			throw new IllegalStateException();
		}		
		currentCart = next.processNext();
		stepsTaken++;
	}
	
	public int getStepsTaken() {
		return stepsTaken;
	}
	
	public int totalNumberOfSteps() {
		return numCarts * 2;
	}
	
	public boolean moreSteps() {
		if (stepsTaken < totalNumberOfSteps()) {
			return true;
		}
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
		return !currentCart.isWaitingInRegisterLine();
	}
	
	public double averageWaitTime() {
		return myLog.averageWaitTime();
	}
	
	public double averageProcessTime() {
		return myLog.averageProcessTime();
	}
}

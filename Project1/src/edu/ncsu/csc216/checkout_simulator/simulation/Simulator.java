package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.LineOfItems;
import edu.ncsu.csc216.checkout_simulator.queues.Store;

/**
 * The shopping cart checkout simulator
 * @author Joey Schauer
 *
 */
public class Simulator {
	/** The constant for minimum number of registers */
	public static final int MIN_NUM_REGISTERS = 3;
	/** The constant for maximum number of registers */
	public static final int MAX_NUM_REGISTERS = 12;
	/** The number of registers in the simulator */
	private int numRegisters;
	/** the number of carts in the simulator */
	private int numCarts;
	/** the number of steps taken by the simulator */
	private int stepsTaken;
	/** the log for carts that are processed */
	private Log myLog;
	/** the event calendar for the simulation */
	private EventCalendar theCalendar;
	/** the store for the simulation */
	private Store theStore;
	/** the array of registers in the simulation */
	private CheckoutRegister[] register;
	/** the current cart being processed by the simulation */
	private Cart currentCart;
	
	/**
	 * The constructor for Simulator
	 * @param numRegisters the number of registers in the simulation
	 * @param numCarts the number of carts in the simulation
	 * @throws IllegalArgumentException if the number of registers or carts are invalid
	 */
	public Simulator(int numRegisters, int numCarts) {
		if (numRegisters < MIN_NUM_REGISTERS || numRegisters > MAX_NUM_REGISTERS || numCarts < 1) {
			throw new IllegalArgumentException("Number of registers must be between 3 and 12 inclusive.");
		}
		this.numCarts = numCarts;
		this.numRegisters = numRegisters;
		register = new CheckoutRegister[this.numRegisters];
		myLog = new Log();
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(myLog);
		}
		theStore = new Store(numCarts, register);
		theCalendar = new EventCalendar(register, theStore);
	}
	
	/**
	 * Returns an array of cart colors for the simulation
	 * @return an array of cart colors for the simulation
	 */
	public static Color[] simulationColors() {
		Color[] colors = new Color[3];
		colors[0] = Color.GREEN;
		colors[1] = Color.BLUE;
		colors[2] = Color.RED;
		return colors;
	}
	
	/**
	 * Returns an array of cart labels for the simulation
	 * @return an array of cart labels for the simulation
	 */
	public static String[] simulationLabels() {
		String[] labels = new String[3];
		labels[0] = "Express Cart";
		labels[1] = "Regular Cart";
		labels[2] = "Special Handling Cart";
		return labels;
	}
	
	/**
	 * Processes a single cart either from the store or in a register line
	 * @throws IllegalStateException if the calendar can't process the step
	 */
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
	
	/**
	 * Returns the number of steps taken by the simulator
	 * @return the number of steps taken by the simulator
	 */
	public int getStepsTaken() {
		return stepsTaken;
	}
	
	/**
	 * Returns the total number of steps that can be taken by the simulator
	 * @return the total number of steps that can be taken by the simulator
	 */
	public int totalNumberOfSteps() {
		return numCarts * 2;
	}
	
	/**
	 * Returns if the simulator can take any more steps
	 * @return if the simulator can take any more steps (true) or not (false)
	 */
	public boolean moreSteps() {
		if (stepsTaken < totalNumberOfSteps()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the index of the current cart being processed
	 * @return the index of the current cart being processed
	 */
	public int getCurrentIndex() {
		if (currentCart == null) {
			return -1;
		}
		return currentCart.getRegisterIndex();
	}
	
	/**
	 * Returns the color of the current cart
	 * @return the color of the current cart
	 */
	public Color getCurrentCartColor() {
		if (currentCart == null) {
			return null;
		}
		return currentCart.getColor();
	}
	
	/**
	 * Returns if the current cart has been processed by the simulation
	 * @return if the current cart has been processed by the simulation (true) or not (false)
	 */
	public boolean itemLeftSimulation() {
		if (currentCart == null) {
			return false;
		}
		return !currentCart.isWaitingInRegisterLine();
	}
	
	/**
	 * Returns the average wait time for processed carts
	 * @return the average wait time for processed carts
	 */
	public double averageWaitTime() {
		return myLog.averageWaitTime();
	}
	
	/**
	 * Returns the average process time for processed carts
	 * @return the average process time for processed carts
	 */
	public double averageProcessTime() {
		return myLog.averageProcessTime();
	}
}

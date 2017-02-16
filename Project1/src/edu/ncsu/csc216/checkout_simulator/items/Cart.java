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
public abstract class Cart {
	public static final int INITIAL_REGISTER_IDX = 0;
	private int arrivalTime;
	private int waitTime;
	private int processTime;
	private int registerIndex;
	private boolean waitingProcessing;
	
	public Cart(int arrivalTime, int processTime) {
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public int getProcessTime() {
		return processTime;
	}
	
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	public void removeFromWaitingLine() {
		waitingProcessing = false;
	}
	
	protected void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
	}
	
	public abstract void getInLine(CheckoutRegister[] checkoutRegister);
	
	public abstract Color getColor();
}

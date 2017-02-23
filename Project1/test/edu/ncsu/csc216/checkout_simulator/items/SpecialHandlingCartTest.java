package edu.ncsu.csc216.checkout_simulator.items;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Test class for SpecialHandlingCart
 * @author Joey Schauer
 *
 */
public class SpecialHandlingCartTest {

	/**
	 * Test for getInLine
	 */
	@Test
	public void testGetInLine() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.isWaitingInRegisterLine(), false);
		
		CheckoutRegister[] register = new CheckoutRegister[7];
		Log log = new Log();
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		cart.getInLine(register);
		assertEquals(cart.isWaitingInRegisterLine(), true);
		assertEquals(cart.getRegisterIndex(), 5);
		
		register = new CheckoutRegister[8];
		log = new Log();
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		cart.getInLine(register);
		assertEquals(cart.isWaitingInRegisterLine(), true);
		assertEquals(cart.getRegisterIndex(), 6);
	}
	
	/**
	 * Test for getArrivalTime
	 */
	@Test
	public void testGetArrivalTime() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getArrivalTime(), 100);
		
		try {
			cart = new SpecialHandlingCart(-1, 100);
			fail("Should not reach this point.");
		} catch (IllegalArgumentException e) {
			assertEquals(cart.getArrivalTime(), 100);
		}
	}

	/**
	 * Test for getWaitTime
	 */
	@Test
	public void testGetWaitTime() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getWaitTime(), 0);
	}
	
	/**
	 * Test for setWaitTime
	 */
	@Test
	public void testSetWaitTime() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getWaitTime(), 0);
		cart.setWaitTime(300);
		assertEquals(cart.getWaitTime(), 300);
	}
	
	/**
	 * Test for getProcessTime
	 */
	@Test
	public void testGetProcessTime() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getProcessTime(), 200);
		
		try {
			cart = new SpecialHandlingCart(100, -1);
			fail("Should not reach this point.");
		} catch (IllegalArgumentException e) {
			assertEquals(cart.getProcessTime(), 200);
		}
	}

	/**
	 * Test for getRegisterIndex
	 */
	@Test
	public void testGetRegisterIndex() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getRegisterIndex(), -1);
	}

	/**
	 * Test for isWaitingInRegisterLine
	 */
	@Test
	public void testIsWaitingInRegisterLine() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.isWaitingInRegisterLine(), false);
		
		CheckoutRegister[] register = new CheckoutRegister[7];
		Log log = new Log();
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		cart.getInLine(register);
		assertEquals(cart.isWaitingInRegisterLine(), true);
	}
	
	/**
	 * Test for removeFromWaitingLine
	 */
	@Test
	public void testRemoveFromWaitingLine() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.isWaitingInRegisterLine(), false);
		
		CheckoutRegister[] register = new CheckoutRegister[7]; 
		Log log = new Log();
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		cart.getInLine(register);
		assertEquals(cart.isWaitingInRegisterLine(), true);
		
		cart.removeFromWaitingLine();
		assertEquals(cart.isWaitingInRegisterLine(), false);
	}
	
	/**
	 * Test for setRegisterIndex
	 */
	@Test
	public void testSetRegisterIndex() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getRegisterIndex(), -1);
		
		cart.setRegisterIndex(5);
		assertEquals(cart.getRegisterIndex(), 5);
	}

	/**
	 * Test for getColor
	 */
	@Test
	public void testGetColor() {
		SpecialHandlingCart cart = new SpecialHandlingCart(100, 200);
		assertEquals(cart.getColor(), Color.RED);
	}

}

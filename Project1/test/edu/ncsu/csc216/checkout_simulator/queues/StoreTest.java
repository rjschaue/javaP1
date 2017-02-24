package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Test class for Store
 * @author Joey
 *
 */
public class StoreTest {

	/**
	 * Test for size
	 */
	@Test
	public void testSize() {
		Log log = new Log();
		CheckoutRegister[] register = new CheckoutRegister[7];
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		
		Store store = new Store(100, register);
		assertEquals(store.size(), 100);
		
		store = new Store(500, register);
		assertEquals(store.size(), 500);
	}
	
	/**
	 * Test for hasNext
	 */
	@Test
	public void testHasNext() {
		Log log = new Log();
		CheckoutRegister[] register = new CheckoutRegister[7];
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		
		Store store = new Store(100, register);		
		assertTrue(store.hasNext());
		
		store = new Store(0, register);
		assertFalse(store.hasNext());
		
	}
	
	/**
	 * Test for processNext
	 */
	@Test
	public void testProcessNext() {
		Log log = new Log();
		CheckoutRegister[] register = new CheckoutRegister[7];
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		
		Store store = new Store(100, register);			
		store.processNext();
		assertEquals(store.size(), 99);
	}
	
	/**
	 * Test for departTimeNext
	 */
	@Test
	public void testDepartTimeNext() {
		Log log = new Log();
		CheckoutRegister[] register = new CheckoutRegister[7];
		for (int i = 0; i < register.length; i++) {
			register[i] = new CheckoutRegister(log);
		}
		
		Store store = new Store(100, register);	
		int departTime = store.departTimeNext();
		Cart cart = store.processNext();
		assertEquals(cart.getArrivalTime(), departTime);
		
		store = new Store(0, register);
		assertEquals(store.departTimeNext(), Integer.MAX_VALUE);
	}
}

package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.items.RegularShoppingCart;
import edu.ncsu.csc216.checkout_simulator.items.SpecialHandlingCart;

/**
 * Test class for Log
 * @author Joey Schauer
 *
 */
public class LogTest {

	/**
	 * Test for getNumCompleted
	 */
	@Test
	public void testGetNumCompleted() {
		Log log = new Log();
		Cart cart1 = new ExpressCart(100, 100);
		Cart cart2 = new RegularShoppingCart(200, 200);
		Cart cart3 = new SpecialHandlingCart(300, 300);
		assertEquals(log.getNumCompleted(), 0);
		
		log.logCart(cart1);
		assertEquals(log.getNumCompleted(), 1);
		
		log.logCart(cart2);
		assertEquals(log.getNumCompleted(), 2);
		
		log.logCart(cart3);
		assertEquals(log.getNumCompleted(), 3);
		
	}
	
	/**
	 * Test for averageWaitTime
	 */
	@Test
	public void testAverageWaitTime() {
		Log log = new Log();
		Cart cart1 = new ExpressCart(0, 200);
		Cart cart2 = new RegularShoppingCart(100, 200);
		Cart cart3 = new SpecialHandlingCart(200, 300);
		assertEquals(log.averageWaitTime(), 0.0, 0);
		
		log.logCart(cart1);
		assertEquals(log.averageWaitTime(), 0.0, 0);
		
		cart2.setWaitTime(100);
		log.logCart(cart2);
		assertEquals(log.averageWaitTime(), 50.0, 0);
		
		cart3.setWaitTime(200);
		log.logCart(cart3);
		assertEquals(log.averageWaitTime(), 100.0, 0);
	}

	/**
	 * Test for averageProcessTime
	 */
	@Test
	public void testAverageProcessTime() {
		Log log = new Log();
		Cart cart1 = new ExpressCart(0, 200);
		Cart cart2 = new RegularShoppingCart(100, 200);
		Cart cart3 = new SpecialHandlingCart(200, 200);
		assertEquals(log.averageProcessTime(), 0.0, 0);
		
		log.logCart(cart1);
		assertEquals(log.averageProcessTime(), 200.0, 0);
		
		log.logCart(cart2);
		assertEquals(log.averageProcessTime(), 200.0, 0);
		
		log.logCart(cart3);
		assertEquals(log.averageProcessTime(), 200.0, 0);
	}
}

/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Test class for CheckoutRegister
 * @author Joey Schauer
 *
 */
public class CheckoutRegisterTest {

	/**
	 * Test for size
	 */
	@Test
	public void testSize() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		assertEquals(register.size(), 0);
		
		Cart cart = new ExpressCart(100, 200);
		register.addCartToLine(cart);
		assertEquals(register.size(), 1);
	}

	/**
	 * Test for processNext
	 */
	@Test
	public void testProcessNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);		
		Cart cart = new ExpressCart(100, 200);
		register.addCartToLine(cart);
		
		Cart removedCart = register.processNext();
		assertEquals(cart, removedCart);
		assertEquals(register.size(), 0);
	}
	
	/**
	 * Test for hasNext
	 */
	@Test
	public void testHasNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);	
		
		assertEquals(register.hasNext(), false);
		
		Cart cart = new ExpressCart(100, 200);
		register.addCartToLine(cart);
		
		assertEquals(register.hasNext(), true);
	}
	
	/**
	 * Test for departTimeNext
	 */
	@Test
	public void testDepartTimeNext() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		
		assertEquals(register.departTimeNext(), Integer.MAX_VALUE);
		
		Cart cart = new ExpressCart(100, 200);
		register.addCartToLine(cart);
		
		assertEquals(register.departTimeNext(), 300);		
		
		Cart cart2 = new ExpressCart(200, 200);
		register.addCartToLine(cart2);
		register.processNext();
		
		System.out.println(register.departTimeNext());
		assertEquals(register.departTimeNext(), 500);
	}
	
	/**
	 * Test for addCartToLine
	 */
	@Test
	public void testAddCartToLine() {
		Log log = new Log();
		CheckoutRegister register = new CheckoutRegister(log);
		assertEquals(register.size(), 0);
		assertFalse(register.hasNext());
		
		Cart cart = new ExpressCart(100, 200);
		register.addCartToLine(cart);
		assertEquals(register.size(), 1);
		assertTrue(register.hasNext());
		
		Cart cart2 = new ExpressCart(200, 200);
		register.addCartToLine(cart2);
		assertEquals(register.size(), 2);
		assertTrue(register.hasNext());
	}
}

package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * Test class for Simulator
 * @author Joey Schauer
 *
 */
public class SimulatorTest {

	/**
	 * Test for Simulator
	 */
	@Test
	public void testSimulator() {
		Simulator simulator;
		try {
			simulator = new Simulator(2, 100);
			fail("Should not reach this step.");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Number of registers must be between 3 and 12 inclusive.");
		}
		
		try {
			simulator = new Simulator(13, 100);
			fail("Should not reach this step.");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Number of registers must be between 3 and 12 inclusive.");
		}
		
		try {
			simulator = new Simulator(6, 0);
			fail("Should not reach this step.");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Number of registers must be between 3 and 12 inclusive.");
		}
		
		simulator = new Simulator(3, 100);
		assertEquals(simulator.totalNumberOfSteps(), 200);
		simulator = new Simulator(12, 100);
		assertEquals(simulator.totalNumberOfSteps(), 200);
	}

	/**
	 * Test for simulationColors
	 */
	@Test
	public void testSimulationColors() {
		Color[] colors = Simulator.simulationColors();
		assertEquals(colors[0], Color.GREEN);
		assertEquals(colors[1], Color.BLUE);
		assertEquals(colors[2], Color.RED);
	}
	
	/**
	 * Test for simulationLabels
	 */
	@Test
	public void testSimulationLabels() {
		String[] labels = Simulator.simulationLabels();
		assertEquals(labels[0], "Express Cart");
		assertEquals(labels[1], "Regular Cart");
		assertEquals(labels[2], "Special Handling Cart");
	}
	
	/**
	 * Test for step
	 */
	@Test
	public void testStep() {
		Simulator simulator = new Simulator(3, 1);
		assertEquals(simulator.getStepsTaken(), 0);
		assertEquals(simulator.totalNumberOfSteps(), 2);
		assertTrue(simulator.moreSteps());
		
		simulator.step();
		assertEquals(simulator.getStepsTaken(), 1);
		assertTrue(simulator.moreSteps());
		
		simulator.step();
		assertEquals(simulator.getStepsTaken(), 2);
		assertFalse(simulator.moreSteps());
		
		try {
			simulator.step();
			fail("Should not reach this step.");
		} catch (IllegalStateException e) {
			assertEquals(simulator.getStepsTaken(), simulator.totalNumberOfSteps());
		}
	}
	
	/**
	 * Test for getCurrentIndex
	 */
	@Test
	public void testGetCurrentIndex() {
		Simulator simulator = new Simulator(3, 100);
		assertEquals(simulator.getCurrentIndex(), -1);
		
		simulator.step();
		assertNotEquals(-1, simulator.getCurrentIndex());
	}
	
	/**
	 * Test for currentCartColor
	 */
	@Test
	public void testCurrentCartColor() {
		Simulator simulator = new Simulator(3, 100);
		assertEquals(simulator.getCurrentCartColor(), null);
		
		simulator.step();
		assertNotEquals(simulator.getCurrentCartColor(), null);
	}
	
	/**
	 * Test for itemLeftSimulation
	 */
	@Test
	public void testItemLeftSimulation() {
		Simulator simulator = new Simulator(3, 1);
		assertFalse(simulator.itemLeftSimulation());
		
		simulator.step();
		assertFalse(simulator.itemLeftSimulation());
		
		simulator.step();
		assertTrue(simulator.itemLeftSimulation());
	}
	
	/**
	 * Test for averageWaitTime
	 */
	@Test
	public void testAverageWaitTime() {
		Simulator simulator = new Simulator(3, 1);
		assertEquals(simulator.averageWaitTime(), 0.0, 0);
		simulator.step();
		assertEquals(simulator.averageWaitTime(), 0.0, 0);
		simulator.step();
		assertEquals(simulator.averageWaitTime(), 0.0, 0);
	}
	
	/**
	 * Test for averageProcessTime
	 */
	@Test
	public void testAverageProcessTime() {
		Simulator simulator = new Simulator(3, 1);
		assertEquals(simulator.averageProcessTime(), 0.0, 0);
		simulator.step();
		assertEquals(simulator.averageProcessTime(), 0.0, 0);
		simulator.step();
		assertEquals(simulator.averageProcessTime(), 266.0, 0);
	}
}

/**
 * 
 */
package com.bookstrore.entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author vinod
 *
 */
public class CalculatorTest {

	/**
	 * Test method for {@link com.bookstrore.entity.Calculator#addNumber(int, int)}.
	 */
	@Test
	public void testAddNumber() {
		Calculator calculator = new Calculator();
		
		int sum = calculator.addNumber(10, 12);
		int expected = 222;
		assertEquals(expected, sum);
	}

}

package at.edu.c02.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.CalculatorException;

public class CalculatorTest {

	@Test
	public void testSimpleAddOperation() throws Exception {

		// setup
		Calculator calc = new CalculatorImpl();

		// execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.add);

		// verify
		assertEquals(5, result, 0);

	}

	@Test
	public void testSimpleMulOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.mul);

		assertEquals(6, result, 0);

	}

	@Test
	public void testSimpleDivOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(6.0);
		calc.push(2);
		double result = calc.perform(Operation.div);

		assertEquals(3, result, 0);

	}

	//
	@Test(expected = CalculatorException.class)
	public void testPopOnEmptyStack() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.pop();

	}

	@Test
	public void testDivisionByZero() throws Exception {

		// Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.div);

			fail("Exception expected");

		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}

	}

	@Test
	public void testSimpleMod() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(2);
		calc.push(3);
		double result = calc.perform(Operation.modulo);

		assertEquals(2, result, 0);

	}

	@Test
	public void testHighMod() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(198273);
		calc.push(7);
		double result = calc.perform(Operation.modulo);

		assertEquals(5, result, 0);

	}

}

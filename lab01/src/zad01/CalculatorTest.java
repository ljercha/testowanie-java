package zad01;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
public class CalculatorTest {

	
	@Test
	public void checkAdd()
	{
		Calculator calculator = new Calculator();
		assertEquals(5, calculator.add(2, 3)
				);
	}
	
	@Test
	public void checkSub()
	{
		Calculator calculator = new Calculator();
		assertEquals(-2, calculator.sub(2, 4)
				);
	}
	
	@Test
	public void checkDiv()
	{
		Calculator calculator = new Calculator();
		assertTrue(Integer.signum(calculator.div(2, 3))== 0);
		assertEquals(3, calculator.div(6, 2)
				);
	}
	@Test(expected=ArithmeticException.class)
	public void checkDivByZero()
	{
		Calculator calculator = new Calculator();
		calculator.div(6, 0);
	}
	
	@Test
	public void checkMulti()
	{
		Calculator calculator = new Calculator();
		assertEquals(8, calculator.multi(4, 2)
				);
	}
	
	@Test
	public void checkGreater()
	{
		Calculator calculator = new Calculator();
		assertThat("1 should be greater tha 0.", calculator.greater(1, 0));
		assertFalse(calculator.greater(-5, 5));
	}
	
	
}

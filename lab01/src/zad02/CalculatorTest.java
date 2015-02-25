package zad02;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
public class CalculatorTest {

	
	@Test
	public void checkAdd()
	{
		CalculatorDouble calculator = new CalculatorDouble();
		assertEquals(4.66, calculator.add(1.25, 3.41),0.10
				);
	}
	
	@Test
	public void checkSub()
	{
		CalculatorDouble calculator = new CalculatorDouble();
		assertEquals(-2, calculator.sub(2, 4),0.50
				);
	}
	
	@Test
	public void checkDiv()
	{
		CalculatorDouble calculator = new CalculatorDouble();
		assertEquals(16.0, calculator.div(8.0, 0.5),0.10
				);
	}
	@Test
	public void checkDivByZero()
	{
		CalculatorDouble calculator = new CalculatorDouble();
		calculator.div(6, 0);
	}
	
	@Test
	public void checkMulti()
	{
		CalculatorDouble calculator = new CalculatorDouble();
		assertEquals(8, calculator.multi(4, 2),0.50
				);
	}
	
	@Test
	public void checkGreater()
	{
		CalculatorDouble calculator = new CalculatorDouble();
		assertThat("1 should be greater tha 0.", calculator.greater(1, 0));
	}
	
	
}

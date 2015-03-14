package zad03;

import org.junit.Test;

public class RomanSpecialTest
	{
		
		@Test(expected=Error.class)
		public void checkRomeNumberLessThanZero()
		{
			RomeNumber exampleNumber = new RomeNumber(-3);
			exampleNumber.toString();
		}
		
		@Test(expected=Error.class)
		public void checkRomeNumberZero()
		{
			RomeNumber exampleNumber = new RomeNumber(0);
			exampleNumber.toString();
		}
		
		@Test(expected=Error.class)
		public void checkRomeNumberOutOfRange()
		{
			RomeNumber exampleNumber = new RomeNumber(50000);
			exampleNumber.toString();
		}
	}

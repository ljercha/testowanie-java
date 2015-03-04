package zad03;

import org.junit.Test;

public class RomanSpecialTest
	{
		
		@Test(expected=Error.class)
		public void checkRomeNumberLessThanZero()
		{
			RomeNumber test = new RomeNumber(-3);
			test.toString();
		}
		
		@Test(expected=Error.class)
		public void checkRomeNumberZero()
		{
			RomeNumber test = new RomeNumber(0);
			test.toString();
		}
		
		@Test(expected=Error.class)
		public void checkRomeNumberOutOfRange()
		{
			RomeNumber test = new RomeNumber(50000);
			test.toString();
		}
	}

package lab02ljercha;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class PsikusTest {
	
	@Test
	public void cyfrokrad0()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		assertNull(psikus.cyfrokrad(0));
	}
	@Test
	public void cyfrokrad3()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		assertNull(psikus.cyfrokrad(3));
	}
	@Test
	public void cyfrokrad9()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		assertNull(psikus.cyfrokrad(9));
	}
	@Test
	public void cyfrokradziez()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 111;
		assertEquals(11, psikus.cyfrokrad(number).intValue());
	}
	@Test
	public void cyfrokradziezLosowa3()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 259;
		int result = psikus.cyfrokrad(number).intValue();
		assertThat("Losowa cyfrokradziez powina wynosic 25 lub 29 lub 59.",
				result == 25 || 
				result == 29 ||
				result == 59 );
	}
	@Test
	public void cyfrokradziezLosowa1()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 17;
		int result = psikus.cyfrokrad(number).intValue();
		assertThat("Losowa cyfrokradziez powina wynosic 1 lub 7.",
				result == 1 || 
				result == 7 );
	}
	
	@Test(expected = NieudanyPsikusException.class)
	public void hultajchochlaExpection() throws NieudanyPsikusException
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		psikus.hultajchochla(5);

	}
	@Test
	public void hultajchochla2() throws NieudanyPsikusException
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
			assertEquals(53,psikus.hultajchochla(35).intValue());
	}
	@Test
	public void hultajchochla3() throws NieudanyPsikusException
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 468;
		int result = psikus.hultajchochla(number).intValue();
			assertThat("Losowa cyfrokradziez powina wynosic 864 lub 648 lub 486.",
					result == 864 || 
					result == 648 ||
					result == 486 );
	}
	@Test
	public void niekształtek()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 1234567;
		int result = psikus.nieksztaltek(number).intValue();
		assertThat("Losowa cyfrokradziez powina wynosic 1284567 lub 1234561 lub 1234597.",
				result == 1284567 || 
				result == 1234561 ||
				result == 1234597 );
	}
	@Test
	public void niekształtekSame()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 1245;
		assertEquals(1245,psikus.nieksztaltek(number).intValue());
	}
	@Test
	public void niekształtekJednaliczba()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 135;
		assertEquals(185,psikus.nieksztaltek(number).intValue());
	}
	
}

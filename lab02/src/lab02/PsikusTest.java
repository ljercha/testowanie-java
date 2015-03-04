package lab02;

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
		assertThat("Losowa cyfrokradziez powina wynosic 25 lub 29 lub 59.",
				psikus.cyfrokrad(number).intValue() == 25 || 
				psikus.cyfrokrad(number).intValue() == 29 ||
				psikus.cyfrokrad(number).intValue() == 59 );
	}
	@Test
	public void cyfrokradziezLosowa1()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 17;
		assertThat("Losowa cyfrokradziez powina wynosic 1 lub 7.",
				psikus.cyfrokrad(number).intValue() == 1 || 
				psikus.cyfrokrad(number).intValue() == 7 );
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
		int number = 35;
			assertEquals(53,psikus.hultajchochla(35).intValue());
	}
	@Test
	public void hultajchochla3() throws NieudanyPsikusException
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 468;
			assertThat("Losowa cyfrokradziez powina wynosic 864 lub 648 lub 486.",
					psikus.hultajchochla(number).intValue() == 864 || 
					psikus.hultajchochla(number).intValue() == 648 ||
					psikus.hultajchochla(number).intValue() == 486 );
	}
	@Test
	public void niekształtek()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		int number = 1234567;
		assertThat("Losowa cyfrokradziez powina wynosic 1284567 lub 1234561 lub 1234597.",
				psikus.nieksztaltek(number).intValue() == 1284567 || 
				psikus.nieksztaltek(number).intValue() == 1234561 ||
				psikus.nieksztaltek(number).intValue() == 1234597 );
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

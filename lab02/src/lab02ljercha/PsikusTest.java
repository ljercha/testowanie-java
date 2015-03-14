package lab02ljercha;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class PsikusTest {
	
	PsikusImplemetation psikus;
	int result;
	@Before
	public void setup(){
		psikus = new PsikusImplemetation();
	}
	
	@Test
	public void cyfrokradReturnNullBottomLimit()
	{ 
		assertThat(psikus.cyfrokrad(0),org.hamcrest.CoreMatchers.nullValue());
		
	}
	@Test
	public void cyfrokradReturnNull()
	{
		assertThat(psikus.cyfrokrad(5),org.hamcrest.CoreMatchers.nullValue());	}
	@Test
	public void cyfrokradReturnNullTopLimit()
	{
		assertThat(psikus.cyfrokrad(9),org.hamcrest.CoreMatchers.nullValue());	}
	@Test
	public void cyfrokradziez()
	{
		int exampleNumber = 111;
		assertThat(11, is(psikus.cyfrokrad(exampleNumber)));
	}
	@Test
	public void cyfrokradziezThreeDigit()
	{
		int number = 259;
		result = psikus.cyfrokrad(number).intValue();
		assertThat(result, is(anyOf(equalTo(25),equalTo(29),equalTo(59))));
	}
	@Test
	public void cyfrokradziezDoubleDigit()
	{
		int number = 17;
		result = psikus.cyfrokrad(number);
		//assertThat(result, isOneOf(1,7));
	}
	
	@Test(expected = NieudanyPsikusException.class)
	public void hultajchochlaExpection() throws NieudanyPsikusException
	{
		psikus.hultajchochla(5);
	}
	@Test
	public void hultajchochlaDoubleDigit() throws NieudanyPsikusException
	{
		int number = 35;
		result = psikus.hultajchochla(35);
		assertThat(53, is(result));
	}
	@Test
	public void hultajchochlaThreeDigit() throws NieudanyPsikusException
	{
		int number = 468;
		result = psikus.hultajchochla(number);
		assertThat(result, is(anyOf(equalTo(864),
									equalTo(648),
									equalTo(486))));
	}
	@Test
	public void nieksztaltekEveryVariant()
	{
		int number = 1234567;
		result = psikus.nieksztaltek(number);
		assertThat(result, is(anyOf(equalTo(1284567),
									equalTo(1234561),
									equalTo(1234597))));
	}
	@Test
	public void nieksztaltekSameResult()
	{
		int number = 1245;
		result = psikus.nieksztaltek(number);
		assertThat(1245, is(result));
	}
	@Test
	public void nieksztaltekThreeToEight()
	{
		int number = 135;
		result = psikus.nieksztaltek(number);
		assertThat(185,is(result));
	}
	@Test
	public void nieksztaltekSixToNine()
	{
		int number = 926;
		result = psikus.nieksztaltek(number);
		assertThat(929,is(result));
	}
	
}

package lab02ljercha;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class NieksztaltekParametrized {
	private int number;
	private int result;
	
	public NieksztaltekParametrized(int  number, int result) {
		  this.number = number;
	      this.result = result;
	   }
	
	@Test
	public void nieksztaltekTest()
	{
		PsikusImplemetation psikus = new PsikusImplemetation();
		assertThat(result,is(psikus.nieksztaltek(number)));
	}
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] 
				{{0, 0},
				{9, 9},
				{13, 18},
				{17, 11},
				{16, 19},
				{839, 889},
				{645, 945},
				{527, 521}
				});
	};
};
	
	
package lab02tdd;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GraLab02Test {

	
	@Test
	public void CyfrokradTest(){
		GraLab02 psikus = new GraLab02();
		int number = 12343211;
		int actual = psikus.cyfrokrad(number);
		assertNotEquals(number,actual);
	}
	
	@Test
	public void CyfrokradTest2(){
		GraLab02 psikus = new GraLab02();
		int number = 0;
		assertNull("should be null", psikus.cyfrokrad(number));
	}
	
	@Test
	public void CyfrokradTest3(){
		GraLab02 psikus = new GraLab02();
		int number = 9;
		assertNull("should be null", psikus.cyfrokrad(number));
	}
	
	@Test
	public void CyfrokradTest4(){
		GraLab02 psikus = new GraLab02();
		int number = 10;
		int actual = psikus.cyfrokrad(number).intValue();
		assertNotNull("shouldn't be null", actual);
	}
	
	@Test
	public void CyfrokradTest5(){
		GraLab02 psikus = new GraLab02();
		int number = 56;
		int actual = psikus.cyfrokrad(number).intValue();
		assertThat("should be equal", actual==5 || actual==6);
	}
	
	@Test
	public void CyfrokradTest6(){
		GraLab02 psikus = new GraLab02();
		int number = 567;
		int actual = psikus.cyfrokrad(number);
		assertThat("should be equal", actual==56 || actual==57 || actual==67);
	}
	
	@Test
	public void HultajchochlaTest() throws NieudanyPsikusException{
		GraLab02 psikus = new GraLab02();
		int number = 12345678;
		int actual = psikus.hultajchochla(number);
		assertNotEquals(number,actual);
	}
	
	@Test(expected = NieudanyPsikusException.class)
	public void HultajchochlaTest2() throws NieudanyPsikusException{
		GraLab02 psikus = new GraLab02();
		int number = 1;
		int actual = psikus.hultajchochla(number);
	}
	
	@Test()
	public void HultajchochlaTest3() throws NieudanyPsikusException{
		GraLab02 psikus = new GraLab02();
		int number = 43;
		int actual = psikus.hultajchochla(34);
		assertEquals(number,actual);
	}
	
	@Test()
	public void HultajchochlaTest4() throws NieudanyPsikusException{
		GraLab02 psikus = new GraLab02();
		int actual = psikus.hultajchochla(345);
		assertThat("Should be euqal", actual==435 || actual==354 || actual==543);
	}
	
	@Test
	public void NieksztalekTest(){
		GraLab02 psikus = new GraLab02();
		int actual = psikus.nieksztaltek(71236);
		assertThat("Should be equal",actual==11236 || actual==71286 || actual==71239);
	}
	
	@Test
	public void NieksztalekTest2(){
		GraLab02 psikus = new GraLab02();
		int actual = psikus.nieksztaltek(77);
		assertThat("Should be equal " + actual,actual==71 || actual==17);
	}
	
	@Test
	public void NieksztalekTest3(){
		GraLab02 psikus = new GraLab02();
		int number = 1024589;
		int actual = psikus.nieksztaltek(1024589);
		assertEquals(number,actual);
	}
	
	@Test
	public void NieksztalekTest4(){
		GraLab02 psikus = new GraLab02();
		int number = 9;
		int actual = psikus.nieksztaltek(6);
		assertEquals(number,actual);
	}
	
	@Test
	public void NieksztalekTest5(){
		GraLab02 psikus = new GraLab02();
		int number = 8;
		int actual = psikus.nieksztaltek(3);
		assertEquals(number,actual);
	}
	
	@Test
	public void NieksztalekTest6(){
		GraLab02 psikus = new GraLab02();
		int actual = psikus.nieksztaltek(1234567890);
		assertThat("Should be equal" + actual,actual==1234561890 || actual==1284567890 || actual==1234597890);
	}
	
}

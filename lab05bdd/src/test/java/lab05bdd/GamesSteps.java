package lab05bdd;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;


public class GamesSteps {
	
	public PsikusImplemetation psikus;

	public int number = 0;

	@Given("a psikus")
	public void psikusSetup(){
		psikus = new PsikusImplemetation();
	}
	
	@When("set number to $number")
	public void setServer(int number){
		this.number = number;
	}
	
	@Then("jajca")
	public void jajca()
	{
		assertThat(psikus.cyfrokrad(number), is(nullValue()));
		assertThat("jajca", containsString("jaj"));
	}

	@Then("cyfrokrad2 should return $result1 or $result2")
	public void cyfrokad2(int result1, int result2){
	assertThat(psikus.cyfrokrad(number), either(is(result1)).or(is(result2)));
	}
	@Then("cyfrokrad3 should return $result1 or $result2 or $result3")
	public void cyfrokad3(int result1,int result2, int result3){
	assertThat(psikus.cyfrokrad(number), is(anyOf(equalTo(result1),equalTo(result2),equalTo(result3))));
	}
	@Then("cyfrokrad should return null")
	public void cyfrokad(){
		assertThat(psikus.cyfrokrad(number), is(nullValue()));
	}
	
	@Then("hultajchochla1 should return $result1")
	public void hultajchochla1(int result1) throws NieudanyPsikusException{
	assertThat(psikus.hultajchochla(number), is(result1));
	}
	@Then("hultajchochla3 should return $result1 or $result2 or $result3")
	public void hultajchochla3(int result1,int result2, int result3) throws NieudanyPsikusException{
	assertThat(psikus.hultajchochla(number), is(anyOf(equalTo(result1),equalTo(result2),equalTo(result3))));
	}
	@Then("hultajchochla should throw exception")
	public void hultajchochla(){
		psikus = new PsikusImplemetation();
		int exception = 0;
		try
		{
		psikus.hultajchochla(number);
		}
		catch(NieudanyPsikusException e)
		{
			exception = 1;
		}
		assertThat(exception, is(1));
	}
	
	@Then("nieksztaltek2 should return $result1 or $result2")
	public void nieksztaltek2(int result1, int result2){
	assertThat(psikus.nieksztaltek(number), either(is(result1)).or(is(result2)));
	}
	
	@Then("nieksztaltek1 should return $result1")
	public void nieksztaltek1(int result1){
	assertThat(psikus.nieksztaltek(number), is(result1));
	}
	@Then("nieksztaltek3 should return $result1 or $result2 or $result3")
	public void nieksztaltek3(int result1,int result2, int result3){
	assertThat(psikus.nieksztaltek(number), is(anyOf(equalTo(result1),equalTo(result2),equalTo(result3))));

	}
}


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

	@Then("cyfrokad should return $result1 or $result2")
	public void cyfrokad(int result1, int result2){
	assertThat(psikus.cyfrokrad(number), either(is(result1)).or(is(result2)));
	}
	@Then("cyfrokad should return $result1 or $result2 or $result3")
	public void cyfrokad(int result1,int result2, int result3){
	assertThat(psikus.cyfrokrad(number), is(anyOf(equalTo(result1),equalTo(result2),equalTo(result3))));
	}
	@Then("cyfrokad should return null")
	public void cyfrokad(){
		assertThat(psikus.cyfrokrad(number), is(nullValue()));
	}
	
	@Then("hultajchochla should return $result1")
	public void hultajchochla(int result1) throws NieudanyPsikusException{
	assertThat(psikus.hultajchochla(number), is(result1));
	}
	@Then("hultajchochla should return $result1 or $result2 or $result3")
	public void hultajchochla(int result1,int result2, int result3) throws NieudanyPsikusException{
	assertThat(psikus.hultajchochla(number), is(anyOf(equalTo(result1),equalTo(result2),equalTo(result3))));
	}
	@Then("hultajchochla should throw exception")
	@Test(expected=NieudanyPsikusException.class)
	public void hultajchochla() throws NieudanyPsikusException{
		psikus = new PsikusImplemetation();
		psikus.hultajchochla(number);
	}
	
	@Then("nieksztaltek should return $result1 or $result2")
	public void nieksztaltek(int result1, int result2){
	assertThat(psikus.nieksztaltek(number), either(is(result1)).or(is(result2)));
	}
	
	@Then("nieksztaltek should return $result1")
	public void nieksztaltek(int result1){
	assertThat(psikus.nieksztaltek(number), is(result1));
	}
	@Then("nieksztaltek should return $result1 or $result2 or $result3")
	public void nieksztaltek(int result1,int result2, int result3){
	assertThat(psikus.nieksztaltek(number), is(anyOf(equalTo(result1),equalTo(result2),equalTo(result3))));

	
	}
}


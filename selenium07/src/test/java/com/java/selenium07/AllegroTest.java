package com.java.selenium07;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AllegroTest {

	WebDriver driver;
	WebDriverWait wait;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.last.fm/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void registerValidation() {
		
		wait = new WebDriverWait(driver, 10);
		WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Join")));
		
		signUpLink.click();
		wait = new WebDriverWait(driver, 10);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password_confirmation")));
		WebElement userName = driver.findElement((By.id("username")));
	WebElement emailInputfield = driver.findElement(By.id("email"));
	WebElement passwordInputfield = driver.findElement(By.id("password"));

	
	
	userName.sendKeys("testeremchcebyc");
	emailInputfield.sendKeys("testerUG@sigma.pl");
	passwordInputfield.sendKeys("ugtest1234");
	userName.click();
	
	List<WebElement> okDivs = null;
	try
	{
		 okDivs = driver.findElements(By.className("ok"));
	}
	catch(Exception e)
	{
		fail();
	}
	assertThat(okDivs.size(), greaterThanOrEqualTo(2));
	
	makeScreenshot("registerValidation");
	
	
	}
	
	
	@Test
	public void registerTest()
	{
		driver.get("https://asi-rails-i.herokuapp.com/signup");
		wait = new WebDriverWait(driver, 10);

		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		
		WebElement userName = driver.findElement((By.xpath(".//*[@id='user_name']")));
		WebElement userEmail = driver.findElement((By.xpath(".//*[@id='user_email']")));
		WebElement passwordInputfield = driver.findElement(By.id("user_password"));
		WebElement passwordConfirmationInputfield = driver.findElement(By.id("user_password_confirmation"));
	
		int random = RandomUtils.nextInt(0, 100000);
		userName.sendKeys("ugtester" + random);
		userEmail.sendKeys("testerUG" + random + "@sigma.pl");
		passwordInputfield.sendKeys("ugtest1234");
		passwordConfirmationInputfield.sendKeys("ugtest1234");
		
		WebElement registerButton = driver.findElement(By.xpath(".//input[@type='submit']"));
		registerButton.submit();
		
		WebElement loggedHeader = driver.findElement(By.xpath(".//*[@id='Wraper']/div/div/div[1]"));
		
		assertThat(loggedHeader.getText(), containsString("Welcome to service dashboard!"));
		makeScreenshot("registerTest");
	}
	
	
	@Test
	public void loginValidation() {
		
		wait = new WebDriverWait(driver, 10);
		WebElement logInLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Login")));
		logInLink.click();
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passwordInputfield = driver.findElement(By.id("password"));
		
		userName.sendKeys("ugtester");
		passwordInputfield.sendKeys("h3h3h3h3");
		
		WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@type='submit']")));
		logInButton.submit();
		//wait = new WebDriverWait(driver, 10);
		//WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Join")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[5]/header/nav/div/a[1]")));
		
		makeScreenshot("loginValidation");
		assertThat(driver.getCurrentUrl(), containsString("home"));
		

		
	}
	
	
	@Test
	public void settingsValidation() {
		
		wait = new WebDriverWait(driver, 10);
		WebElement logInLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Login")));
		logInLink.click();
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passwordInputfield = driver.findElement(By.id("password"));
		
		userName.sendKeys("ugtester");
		passwordInputfield.sendKeys("h3h3h3h3");
		
		WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@type='submit']")));
		logInButton.submit();

		WebElement userDropdown = driver.findElement(By.xpath(".//a[@href='#user-dropdown']"));
		userDropdown.click();
		WebElement settings = driver.findElement(By.partialLinkText("Settings"));
		settings.click();
		
		WebElement avatar = driver.findElement(By.id("avatar"));
		avatar.sendKeys("C:\\avatar.png");
		
		WebElement uploadImage = driver.findElement(By.xpath(".//input[@value='Upload picture']"));
		uploadImage.click();
		
		
		WebElement selectSexToMale = driver.findElement(By.xpath(".//input[@value='M']"));
		selectSexToMale.click();
		
		Select selectTimezone = new Select(driver.findElement(By.id("timezone")));
		selectTimezone.selectByValue("Europe/Warsaw");
		
		Select selectCountry = new Select(driver.findElement(By.id("country")));
		selectCountry.selectByValue("174");
		
		WebElement saveDetails = driver.findElement(By.xpath(".//input[@value='Save Details']"));
		saveDetails.click();
		
		WebElement success = driver.findElement(By.className("messageWrapper"));

		assertThat(success.getText(), containsString("Settings saved successfully."));
		
		makeScreenshot("settingsValidation");
		
	}
	
	private void makeScreenshot(String fileName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}

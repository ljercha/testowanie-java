package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://www.teleman.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//@FindBy(xpath = "//*[@id='search-form']/input[1]")
	WebElement searchBox;
	
	public void search(String text)
	{
		searchBox = findElement(By.xpath("//*[@id='search-form']/input[1]"));
		searchBox.click();
		searchBox.sendKeys(text);
		searchBox.submit();
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}

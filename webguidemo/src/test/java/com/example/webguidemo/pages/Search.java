package com.example.webguidemo.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends WebDriverPage {

	// @FindBy(xpath = "//*[@id='search-navig']/a[2]/em")
	WebElement searchResultCount;
	public Search(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public String getSearchResult()
	{
		searchResultCount = findElement(By.xpath("//*[@id='search-navig']/a[2]/em"));
		return searchResultCount.getText();
	}
}

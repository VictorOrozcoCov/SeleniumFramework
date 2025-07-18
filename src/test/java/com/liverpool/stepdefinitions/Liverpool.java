package com.liverpool.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liverpool.globalenums.Paths;
import com.liverpool.utils.Common;
import com.liverpool.utils.MyWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Liverpool {

	Common base;
	
	public Liverpool(Common base) {
		this.base = base;
	}
	
	@Given("^I open liverpool webpage$")
	public void i_open_liverpool_webpage() throws Throwable {
		MyWebDriver.loadPage(Paths.LIVERPOOL_HOME);
	}
	
	@Given("^I want to look for availbility of \"([^\"]*)\"$")
	public void i_want_to_look_for_availbility_of(String article) throws Throwable {
		WebElement element = base.myBrowser.findElement(By.xpath(Paths.HOME_SEARCHBOX));
		element.sendKeys(article+Keys.ENTER);
		Thread.sleep(5000);
		base.wait.until(ExpectedConditions.titleContains(article));
		MyWebDriver.elementIsNotVisible(Paths.LABEL_NO_RESULTS, base.wait);
	}
	
	@Given("^I validate the article \"([^\"]*)\" is not available$")
	public void i_validate_the_article_is_not_available(String article) throws Throwable {
		WebElement element = base.myBrowser.findElement(By.xpath(Paths.HOME_SEARCHBOX));
		element.sendKeys(article+Keys.ENTER);
		Thread.sleep(5000);
		base.wait.until(ExpectedConditions.titleContains(article));
		try {
			if(base.myBrowser.findElement(By.xpath(Paths.LABEL_NO_RESULTS)).isDisplayed())
				throw new Exception(" = = = = = Article is not available = = = = == ");
		}catch (Exception e) {
			
		}
	}

	@When("^I search I want to sort by \"([^\"]*)\" brand$")
	public void i_search_I_want_to_sort_by_brand(String brand) throws Throwable {
		WebElement element = base.myBrowser.findElement(By.xpath(String.format(Paths.STORE_BRAND_FILTER, brand)));
		element.click();
		Thread.sleep(5000);
	}

	@When("^size \"([^\"]*)\"$")
	public void size(String size) throws Throwable {
		System.out.println("element|"+String.format(Paths.STORE_SIZE_FILTER, size)+"|");
		WebElement element = base.myBrowser.findElement(By.xpath(String.format(Paths.STORE_SIZE_FILTER, size)));
		element.click();
		Thread.sleep(5000);
	}

	@Then("^I open the first article in the screen$")
	public void i_open_the_first_article_in_the_screen() throws Throwable {
		WebElement item = base.myBrowser.findElement(By.xpath(Paths.CATALOG_1ST_ITEM));
		MyWebDriver.clickInput(item);
		Thread.sleep(5000);
	}

	
}

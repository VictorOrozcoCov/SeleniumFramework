package com.liverpool.stepdefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.liverpool.utils.Common;
import com.liverpool.utils.MyWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;


public class CommonSteps {

	Common base; 
	
	public CommonSteps() {}
	
	public CommonSteps(Common base) {
		this.base = base;
	}
	
	@Given("^I start my browser$")
	public void i_start_my_browser() throws Throwable {
		base.myBrowser = MyWebDriver.initializeWebDriver();
		base.isActive = true;
		base.wait = new WebDriverWait(MyWebDriver.getCurrentDriver(), java.time.Duration.ofSeconds(15));
	}
	
	@After
	public void closeWebDriver() {
		if(base.isActive)
			base.myBrowser.quit();
	}
	
}

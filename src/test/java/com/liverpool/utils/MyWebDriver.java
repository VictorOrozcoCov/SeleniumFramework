package com.liverpool.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;;

public class MyWebDriver {

	public static Common base;
	
	public MyWebDriver(Common base) {
		this.base = base;
	}
	
	public static WebDriver initializeWebDriver() {
		
		ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"); // cambia esta ruta según tu SO

        WebDriver driver = new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver95.exe");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver getCurrentDriver() {
		return base.myBrowser;
	}
	
	/***
	 * Load page 
	 * @param page url
	 */
	public static void loadPage(String page) {
		base.myBrowser.get(page);
	}
	
	public void clearTextBox(String path) {
		WebElement element = base.myBrowser.findElement(By.xpath(path));
		element.clear();
	}

	public void clearTextBox(WebElement element) {
		element.clear();
	}
	
	public static void clickInput(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) base.myBrowser;
			executor.executeScript("arguments[0].click();", element);
		}catch(Exception ex) {
			ex.getStackTrace();
			System.err.println("Error executing javascript executor");
		}
	}
	
	public static void clickWebElement(WebElement element, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void elementIsNotVisible(String elementPath, WebDriverWait wait) {
		try {
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementPath)));
			if(e!= null) {
				System.out.println("wait: "+e);
				throw new Exception("Product not available");
			}
		}catch(Exception ex) {
			ex.getStackTrace();
		}
	}

}

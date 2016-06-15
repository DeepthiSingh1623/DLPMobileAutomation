package gov.snsw.framework.pageobjects;


import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
public class DriverPage {
	
	protected static WebDriver driver; 
	
	public DriverPage(WebDriver driver)
	{
		this.driver=driver;   
		//System.out.println("Driver title from super class:"+driver.getCurrentUrl());
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		SwitchtoContext(driver,"NATIVE_APP");
		}	
		

		private void SwitchtoContext(WebDriver driver, String string) {
			// TODO Auto-generated method stub
			
		}		
		

		String resourceid = "au.gov.nsw.onegov.app.holder.uat";
	
		public WebElement explicitWait(By element){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
		return element1;
	}
	
	
		public WebElement fluentWait(final By element)
		{
		Wait<WebDriver> pwait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
																			.pollingEvery(5, TimeUnit.SECONDS)
																			.ignoring(NoSuchElementException.class);
			WebElement element1 = pwait.until(new Function<WebDriver , WebElement>(){
				public WebElement  apply(WebDriver driver) {
					// TODO Auto-generated method stub
					return driver.findElement(element);
				}
			});
			
			return element1;
		}




	
}

package gov.snsw.framework.utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.base.Function;
public class DriverPage {
	
	protected WebDriver driver; 
	
	public DriverPage(WebDriver driver)
	{
		this.driver=driver;   
		//System.out.println("Driver title from super class:"+driver.getCurrentUrl());
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		}	
		
		

		protected String holder_android_resourceid = "au.gov.nsw.onegov.app.holder.psm";
															  		
		protected String checker_android_resourceid = "au.gov.nsw.onegov.app.checker.psm";
		
		protected String holder_ios_resourceid = "au.gov.nsw.onegov.MyLicences.uat";
		
		protected String checker_ios_resourceid = "au.gov.nsw.onegov.LicenceChecker.uat";
	
		public WebElement explicitWait(By element){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
		return element1;
	}
	

		
	public WebElement fluentWait(final By element) {
		Wait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(50, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		try {
			WebElement element1 = pwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement result = driver.findElement(element);
					return result;

				}
			});
			return element1;
		} catch (NoSuchElementException e) {
			Reporter.log("Unable to find " + element, 1, true);
			throw(e);
		}
	}

		By titlePg = By.xpath("//*[@resourceid='"+checker_ios_resourceid+":id/toolbarTitle']");

		public String getiOSCheckerPageTitle(){
			
			fluentWait(titlePg);
			return driver.findElement(titlePg).getText();
			
		}
		
		By checkTle = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/toolbarTitle']");
		public String getAndroidCheckerPageTitle(){
			
			fluentWait(checkTle);
			return driver.findElement(checkTle).getText();
			
		}
		

		public boolean  isContentPresentOnScreen(String text) {
		
		boolean txtPres= false;
		
		try{
			txtPres = driver.findElement(By.xpath("//*[contains(@contentDesc,'" + text + "')]")).isDisplayed();
					}
		
		catch(Exception e){
			txtPres= false;
		}
		
		return txtPres;
	}
		
		
		public boolean  isTextPresentOnScreen(String text) {
			
			boolean txtPres= false;
			
			try{
				txtPres = driver.findElement(By.xpath("//text[contains(text(),'" + text + "')]")).isDisplayed();
			}
			
			catch(Exception e){
				txtPres= false;
			}
			
			return txtPres;
		}
		
		By hamBurgerMenu = By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/imgLeft']");
		
		public void clickHamburgerMenu(){
			
			fluentWait(hamBurgerMenu);
			driver.findElement(hamBurgerMenu).click();
			
		}
		
		public boolean isMenuItemPresent(){
			
			boolean menu=false;
			
			try{
				fluentWait(hamBurgerMenu);
				menu = true;
			}
			
			catch(Exception e){
				
			}
				return menu;	
		}
		
		//Notification
		By notificationPop = By.xpath("//*[@label='No']");
		
		public void selectNo()
		{
			driver.findElement(notificationPop).click();
		}
		
		public String activityHelpLink(By element,String name)
		{
			String el = driver.findElement(element).getAttribute(name);
			return el;
			
		}
		
}


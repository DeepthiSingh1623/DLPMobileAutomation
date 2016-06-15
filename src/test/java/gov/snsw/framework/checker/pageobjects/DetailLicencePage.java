package gov.snsw.framework.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailLicencePage extends DriverPage{

	public DetailLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Capture the Licence Name  
	
	
	//Capture Licence Status
	
	//Capturing the Licence Number   
	By LicNum = By.xpath("//*[text() = 'Licence Number']/../text[2]");
	
	// Capture Licence Classes
	
	//Capturing the Start Date  
	By licStartDate = By.xpath("//*[text() = 'Start Date']/../text[2]");
	
	//Capture the Expiry Date
	
	
	
	//Click Back Icon
	By backIcon = By.xpath("//*[@resourceid=\"au.gov.nsw.onegov.app.holder.uat:id/imgLeft\"]");
	
	
	
	public void getLicDetails()
	{
		driver.findElement(LicNum);
		driver.findElement(licStartDate);
		driver.findElement(backIcon);
		
	}
	

}

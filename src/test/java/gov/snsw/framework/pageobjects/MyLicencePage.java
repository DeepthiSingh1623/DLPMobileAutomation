package gov.snsw.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyLicencePage extends DriverPage{

	public MyLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Fishing fee Current Text
	By fishingFee =  By.xpath("//*[text()='Current']");
	
	//Click on Sign out  
	By signOut = By.xpath("//*[text()='Sign Out']");
		
	//Click on the Sign out OK Confirm Button  
	By ok = By.xpath("//*[text()='OK']");
	
	public DetailLicencePage clickLicStatus()
	{	
		explicitFluentWait(fishingFee);
		driver.findElement(fishingFee).click();
		return new DetailLicencePage(driver);
	}
	

}

package gov.snsw.framework.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyLicencePage extends DriverPage{

	public MyLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//License Name
	By LicName = By.xpath("//*[text()='Recreational Fishing Fee']");
	
	//Fishing fee Current Text
	By fishingFee =  By.xpath("//*[text()='Current']");
	
	
	//Click on Sign out  
	By signOut = By.xpath("//*[text()='Sign Out']");
		
	//Click on the Sign out OK Confirm Button  
	By ok = By.xpath("//*[text()='OK']");
	
	//Click 3bars Setting	
	By setting3Bars = By.xpath("//*[@resourceid='"+resourceid+":id/imgLeft']");
	
	
	public DetailLicencePage clickLicStatus()
	{	
		fluentWait(fishingFee);
		driver.findElement(fishingFee).click();
		return new DetailLicencePage(driver);
	}
	
	public void settings()
	{
		fluentWait(setting3Bars);
		driver.findElement(setting3Bars).click();
		driver.findElement(signOut).click();
		driver.findElement(ok).click();
	}
	

}

package gov.snsw.framework.android.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class LicenceSearch extends DriverPage{

	public LicenceSearch(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By licNo= By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/etxtLicenceNumber']");
	By chkBtn= By.xpath("//*[@resourceid='"+checker_android_resourceid+":id/btnCheck']");

	
	public void enterLicenceNumber(String licNum){
		
		fluentWait(licNo);
		driver.findElement(licNo).sendKeys(licNum);
		
	
	}
	
	public CheckerLicenceDetails clickCheckBtn(){
		
		driver.findElement(chkBtn).click();
		return new CheckerLicenceDetails(driver);
	}
}

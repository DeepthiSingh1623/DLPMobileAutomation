package gov.snsw.framework.ios.checker.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.snsw.framework.utils.DriverPage;

public class LicenceSearchPage extends DriverPage{

	public LicenceSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By licNo= By.xpath("//*[@value='Licence Number']");
	By searchBtn= By.xpath("//*[@label='SEARCH']");
	By doneBtn = By.xpath("//*[@label='Done']");
	
	public void enterLicenceNumber(String licNum){
		
		fluentWait(licNo);
		driver.findElement(licNo).click();
		driver.findElement(licNo).sendKeys(licNum);
		
		driver.findElement(doneBtn).click();
		
	
	}
	
	public void searchLicence(){
		driver.findElement(searchBtn).click();
	}

}

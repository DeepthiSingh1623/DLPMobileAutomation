package gov.snsw.framework.holder.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLicencePage extends DriverPage{

	public MyLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//License Name
	//public By LicName = By.xpath("//*[text()='Recreational Fishing Fee']");
	
	//Fishing fee Current Text
	By fishingFee =  By.xpath("//*[text()='Current']");	
	
		
	//Fishing Fee Share
	public By shareLic = By.xpath("//*[@resourceid='"+holder_resourceid+":id/recycler']/group[1]/group[1]/group[1]/text[2]");
	
	//Click on Sign out  
	By signOut = By.xpath("//*[text()='Sign Out']");
	
	//Click My Activity
	By log = By.xpath("//*[text()='My Activity']");
		
	//Click on the Sign out OK Confirm Button  
	By ok = By.xpath("//*[text()='OK']");
	
	//Click 3bars Setting	
	By setting3Bars = By.xpath("//*[@resourceid='"+holder_resourceid+":id/imgLeft']");
	
	//Add License button
	By addLic = By.xpath("//*[@resourceid='"+holder_resourceid+":id/btnFloatingActionButton']");
	
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
	
	public void MyActivity()
	{
		driver.findElement(setting3Bars).click();
		driver.findElement(log).click();
	}
	
	public void clickShareLic()
	{	
		fluentWait(shareLic);
		driver.findElement(shareLic).click();
	}
	
	public DetailLicencePage clickOnLicNumber(String licence_Number)
	{
		By licNo = By.xpath("//*[text()='"+licence_Number+"']");
		driver.findElement(licNo).click();
		return new DetailLicencePage(driver);
	}
	
	public String viewLicName(String licence_Name)
	{
		By LicName = By.xpath("//*[text()='"+licence_Name+"']");
		fluentWait(LicName);
		String licName = driver.findElement(LicName).getText();
		return licName;
	}
	
	//Add License
	public AddLicencePage clickAddLicense()
	{	
		fluentWait(addLic);
		driver.findElement(addLic).click();
		return new AddLicencePage(driver);
	}
	
	//Click My Activity
	public LogPage clickMyActivity()
	{
		MyActivity();
		return new LogPage(driver);
	}
	
	
	
	
	

}

package gov.snsw.framework.android.holder.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.snsw.framework.utils.DriverPage;

public class MyLicencePage extends DriverPage{

	public MyLicencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//My Licence Title
	//public By LicName = By.xpath("//*[text()='Recreational Fishing Fee']");
	
	//Fishing fee Current Text
	By fishingFee =  By.xpath("//*[text()='Current']");	
	
	By aboutOption = By.xpath("//*[text()='About']");
	
	//Back Button on the About this App Option
	By backBtnAbout = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");
		
	//Fishing Fee Share
	public By shareLic = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/recycler']/group[1]/group[1]/group[1]/text[2]");
	
	//Click on Sign out  
	By signOut = By.xpath("//*[text()='Sign Out']");
	
	//Click My Activity
	By log = By.xpath("//*[text()='My Activity']");
	
	//Click Settings to ChangePIN
	By settingOption = By.xpath("//*[text()='Settings']");
		
	//Click on the Sign out OK Confirm Button  
	By ok = By.xpath("//*[text()='OK']");
	
	//Click 3bars Setting	
	By setting3Bars = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/imgLeft']");
								
	//Add License button
	By addLic = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/btnFloatingActionButton']");
	
	//app Details title 
	By appDetailsTitle = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");
	
	//App Name 
	By appName = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/txtAppName']");
	
	//Activity Option
	By activityOption = By.xpath("//*[text()='Activity']");
	
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
		fluentWait(signOut);
		driver.findElement(signOut).click();
		fluentWait(ok);
		driver.findElement(ok).click();
	}
	
	public void MyActivity()
	{
		driver.findElement(setting3Bars).click();
		driver.findElement(log).click();
	}
	
	public void settingsOpt()
	{
		driver.findElement(setting3Bars).click();
		driver.findElement(settingOption).click();
	}
	
	public void clickShareLic()
	{	
		fluentWait(shareLic);
		driver.findElement(shareLic).click();
	}
	
	public DetailLicencePage clickOnLicNumber(String licence_Number)
	{
		By licNo = By.xpath("//*[text()='"+licence_Number+"']");
		fluentWait(licNo);
		driver.findElement(licNo).click();
		return new DetailLicencePage(driver);
	}
	
	public String viewLicName()
	{
		By LicName = By.xpath("//*[text()='NSW Recreational Fishing Fee']");
		fluentWait(LicName);
		String licenseName = driver.findElement(LicName).getText();
		return licenseName;
	}
	
	//Add License
	public AddLicencePage clickAddLicense()
	{	
		fluentWait(addLic);
		driver.findElement(addLic).click();
		return new AddLicencePage(driver);
	}
	
	
	
	//Setting Menu to change PIN
	public AppSettingPage clickSettings()
	{
		fluentWait(setting3Bars);
		settingsOpt();
		return new AppSettingPage(driver);
	}
	
	public String verifyMyLicTitle()
	{
		By licTitile = By.xpath("//*[@resourceid='"+holder_android_resourceid+":id/toolbarTitle']");
		
        String licPgTitile = driver.findElement(licTitile).getText();
		return licPgTitile;
	}
	
	public void clickSettingHamburger()
	{
		fluentWait(setting3Bars);
		driver.findElement(setting3Bars).click();
	}
	
	public void clickAbout()
	{
		fluentWait(aboutOption);
		driver.findElement(aboutOption).click();
		
	}
	
	public String verifyAppName()
	{
		fluentWait(appName);
		String buildName = driver.findElement(appName).getText();
		return buildName;
	}
	
	public boolean verifyappDetailsTitle()
	{
		boolean buildTitle  = false;
		try
		{	fluentWait(appDetailsTitle);
			buildTitle = driver.findElement(appDetailsTitle).isDisplayed();
		}
		catch(Exception e)
		{
			
		}
       	return buildTitle;
	}
	
	public void clickBackBtnAboutOption()
	{
		fluentWait(backBtnAbout);
		driver.findElement(backBtnAbout).click();
	}
	
	public ActivityPage clickActivityOption()
	{
		fluentWait(activityOption);
		driver.findElement(activityOption).click();
		return new ActivityPage(driver); 
		
	}
	
		

}

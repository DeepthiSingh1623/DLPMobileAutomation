package gov.snsw.framework.holder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogDetailPage extends DriverPage{

	public LogDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Click BackButton
	By backBtn = By.xpath("//*[@resourceid='"+holder_resourceid+":id/imgLeft']");
	
	public void BackBtnLogPgDetail()
	{
		driver.findElement(backBtn).click();
	}
	
	public LogPage clickBackBtnLogPgDetail()
	{		
		BackBtnLogPgDetail();
		return new LogPage(driver);
	}
	
	public String verifylogsDetailsPageTitle()
	{
		By logsTitle = By.xpath("//*[@resourceid='"+holder_resourceid+":id/toolbarTitle']");
		String logsTitleBar = driver.findElement(logsTitle).getText();
		return logsTitleBar;
	}
	

}

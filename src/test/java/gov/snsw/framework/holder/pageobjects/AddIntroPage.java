package gov.snsw.framework.holder.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import gov.snsw.framework.holder.pageobjects.DriverPage;

public class AddIntroPage extends DriverPage {
	
	
		public AddIntroPage(WebDriver driver) 
		{
		super(driver);
		// TODO Auto-generated constructor stub
		}

		//Introduction with Add Page
		By addIntroMsg = By.xpath("//*[text()='Add']");	
		
		///Start Button		
		By addIntroStartBtn = By.xpath("//*[@resourceid='"+holder_resourceid+":id/btnStart']");

		public TermsAndConditionsPage addStartBtn()
		{	
		fluentWait(addIntroStartBtn);
		driver.findElement(addIntroStartBtn).click();
		return new TermsAndConditionsPage(driver);
		}
	
	

}

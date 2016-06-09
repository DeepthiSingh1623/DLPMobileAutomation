package gov.snsw.framework.testng;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.pageobjects.AddIntroPage;
import gov.snsw.framework.pageobjects.ConfirmPINPage;
import gov.snsw.framework.pageobjects.DetailLicencePage;
import gov.snsw.framework.pageobjects.EnterPINPage;
import gov.snsw.framework.pageobjects.MyLicencePage;
import gov.snsw.framework.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.pageobjects.TermsAndConditionsPage;

public class ViewLicenceDetailsTest extends BasicTest {


	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
	 	try{
	 		//reportPass("success", "param");
	 		//reportFail("expected", "actual","params");	
		 		
		 		
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		//Click on the Start button on introduction page
		 		TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
		 		
		 		//Click Accept Button on the Terms and Condition Page
		 		SignInNSWAcctPage signIn = tcPg.termsAndConditionAcceptBtn();
		 		
		 		//Enter the login details in the Sign In Page
		 		EnterPINPage enterPIN = signIn.signInNswAcct(username,password);
		 		 		
		 		//Enter 4 digit PIN
		 		ConfirmPINPage confirmPg = enterPIN.enter4DigitPin(pin);
		 		
		 		//Enter 4 digit PIN confirmation
		 		MyLicencePage LicPg = confirmPg.enter4DigitConfirmNumber(pin);
		 		
		 		//Click the Fishing Fee License 
		 		DetailLicencePage detailLicPg = LicPg.clickLicStatus();
		 		
		 		
		 		
		 		//close App
		 		driver.close();
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();

	 	}
		
        if(testFail){
        	Assert.fail();
        }
	}

	@DataProvider (name = "logInData", parallel = false)
	public Object[][] searchItemsData(){
		 Object[][] s = null;
		try {
		  ExcelDriver ed = new ExcelDriver(sysProp.get("inputWorkbook"), sysProp.get("signInSheet"), false);
		  s = ed.getData(3);
		} catch(IOException e) {
			System.out.println("Not able to search data from excel: " + sysProp.get("inputWorkbook"));
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	@Factory(dataProvider="factoryData")
	public ViewLicenceDetailsTest(DesiredCapabilities caps) {
		super(caps);
	}
}
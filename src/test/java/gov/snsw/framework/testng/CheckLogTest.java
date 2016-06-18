package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.holder.pageobjects.ConfirmPINPage;

import gov.snsw.framework.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.holder.pageobjects.LogDetailPage;
import gov.snsw.framework.holder.pageobjects.LogPage;
import gov.snsw.framework.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.holder.pageobjects.TermsAndConditionsPage;

public class CheckLogTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
	 	try{
	 			//reportPass("success", "param");
	 			 			
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
		 		
		 		//Verify My Licences Page is displayed
		 		String licenseName = LicPg.viewLicName();
		 		assertTrue(licenseName.contains(licence_Name));
		 		
		 		//Click on the Settings and then My Activity
		 		LogPage logPg = LicPg.clickMyActivity();
		 		
		 		//Verify Log page is displayed
		 		String logPgTitle = logPg.verifylogsTitle();
		 		System.out.println("The title of the page is "+logPgTitle);
		 		assertTrue(logPgTitle.contains("Logs"));
		 		
		 		//Click the first / latest log with required Lic Number
		 		LogDetailPage logPgDetail = logPg.clickOnLicNumber(licence_Number);
		 		
		 		//Verify Logs Detailed Page is displayed
		 		String logsTitle = logPgDetail.verifylogsDetailsPageTitle();
		 		System.out.println("The title of the Detailed Log page is "+logsTitle);
		 		assertTrue(logsTitle.contains("Logs"));
		 		
		 		//Verify the Event Type
		 		String liceventType = logPg.checklogDetails();
		 		assertTrue(liceventType.contains(LogEvent_Type));
		 		
		 		//click the Back Button on the Log Detail Page
		 		logPg = logPgDetail.clickBackBtnLogPgDetail();
		 		
		 		//Click log Page Back Button
		 		logPg.clickBackBtnLogPg();
		 		
		 		// Click on the Settings and Sign out
		 		LicPg.settings();
		 		
		 		//clean app
		 		Map  params = new HashMap();
	 			params.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 			Object result = driver.executeScript("mobile:application:clean", params);
		 		
	 			//close App
		 		driver.close();
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

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
		  s = ed.getData(9);
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
	public CheckLogTest(DesiredCapabilities caps) {
		super(caps);
	}	

}

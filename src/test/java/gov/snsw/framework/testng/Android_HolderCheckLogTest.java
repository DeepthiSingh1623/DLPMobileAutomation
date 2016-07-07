package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.android.holder.pageobjects.AddIntroPage;

import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.LogDetailPage;
import gov.snsw.framework.android.holder.pageobjects.LogPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;

public class Android_HolderCheckLogTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void checkLogTest(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("appPackage");
	 	try{
	 			//reportPass("success", "param");
	 			 			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		//Enter PIN
		 		EnterPINPage enterPIN = null;
		 		
		 		if(AddInPg.isStartBtnExist())
		 		{		 			
		 		
		 		//Click on the Start button on introduction page
		 		TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
		 		
		 		//Click Accept Button on the Terms and Condition Page
		 		SignInNSWAcctPage signIn = tcPg.termsAndConditionAcceptBtn();
		 		
		 		//Enter the login details in the Sign In Page
		 		signIn.signInNswAcct(username,password);
		 		
		 		//Keyboard Remove
		 		Utilities.BackBtn(driver);
		 		
		 		//click Sign In Button
		 		enterPIN = signIn.clickSignInBtn();
		 		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enter4DigitPin(pin);
		 		
		 		//Enter 4 digit PIN confirmation
		 		enterPIN.enter4DigitPin(pin);
		 		}
		 		
		 		else
		 		{
		 			enterPIN = new EnterPINPage(driver);
		 			
		 			//Enter 4 digit PIN
		 			enterPIN.enter4DigitPin(pin);
		 		}
		 		
		 		MyLicencePage LicPg = new MyLicencePage(driver);
		 		
		 		//Verify My License Page is displayed
		 		assertEquals("My Licences",LicPg.verifyMyLicTitle());
		 		
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
		 		
		 		
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	finally{
	 		

	 		//Clean App
	 		Utilities.cleanApp(driver, appName);
	 		
	 		
	 		//close app
	 		Utilities.closeApp(driver, appName);
	 		
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
	public Android_HolderCheckLogTest(DesiredCapabilities caps) {
		super(caps);
	}	

}

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

import gov.snsw.framework.ios.holder.pageobjects.ActivityPage;
import gov.snsw.framework.ios.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.ios.holder.pageobjects.EnterPinPage;

import gov.snsw.framework.ios.holder.pageobjects.MyLicencesPage;

import gov.snsw.framework.ios.holder.pageobjects.SettingsPage;
import gov.snsw.framework.ios.holder.pageobjects.SignInPage;

import gov.snsw.framework.ios.holder.pageobjects.TermsAndCondPage;
import gov.snsw.framework.utils.Utilities;

public class IOS_HolderActivityTest extends BasicTest
{
	@Test (dataProvider="logInData")
	public void ActivityIOS(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("bundleId");	
	 	try{
	 			//reportPass("success", "param");
	 			 
	 			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		//Enter PIN
		 		EnterPinPage enterPIN = null;
		 		
		 		if(AddInPg.isStartBtnExist())
		 		{		 			
		 		
		 		//Click on the Start button on introduction page
		 		TermsAndCondPage tcPg = AddInPg.pressStartBtn();
		 		
		 		//Click Accept Button on the Terms and Condition Page
		 		SignInPage signIn = tcPg.pressAgreeBtn();
		 		
		 		//Enter the login details in the Sign In Page
		 		enterPIN = signIn.pressSignIn(username,password);
		 		 		
		 		//Verify Enter Pin is displayed
		 		assertTrue(enterPIN.verifyPinEnterTitle().contains("You are required to set up a PIN.  You can change this in your App Settings."));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enterPin();
		 		
		 		//Verify Confirm PIN is displayed
		 		assertTrue(enterPIN.verifyPinConfirmTitle().contains("Confirm PIN"));
		 		
		 		//Enter 4 digit PIN confirmation
		 		enterPIN.enterPin();
		 		}
		 		
		 		else
		 		{
		 			enterPIN = new EnterPinPage(driver);
		 			
		 			//Verify Enter Pin is displayed
			 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Unlock with PIN"));
			 		
		 			//Enter 4 digit PIN
		 			enterPIN.enterPINUnlock();
		 		}
		 				 		
		 		
		 		MyLicencesPage LicPg = new MyLicencesPage(driver);
		 		
		 		if(LicPg.isTextPresentOnScreen("Notifications have been disabled"))
		 		{
		 			LicPg.selectNo();
		 		}		 		
		 		
		 		//Verify My License Page is displayed
		 		assertTrue(LicPg.myLicPgTitle().contains(licence_Name));
		 		
		 		SettingsPage settingPg = new SettingsPage(driver);
		 		
		 		//Click on Activity Option
		 		ActivityPage activityPg = settingPg.clickActivityOption();		
		 		
		 		//Assertion 
		 		assertTrue("Licence Number Does not match",activityPg.verifyActivityTitle().contains("Activity"));
		 		//assertTrue("The Date is not matched",activityPg.isTextPresentOnScreen(Utilities.getCurrentDate()));
		 		assertTrue("Licence Number Does not match",activityPg.isTextPresentOnScreen(licence_Number));
		 		assertTrue("The Licence Type does not match",activityPg.isTextPresentOnScreen("Recreational Fishing Fee"));
		 		assertTrue("The Event Type does not match",activityPg.isTextPresentOnScreen("Add"));
		 		
		 		//Click the Licence Number
		 		activityPg.clickLicNum(licence_Number);
		 		
		 		//Assert Activity Detail Page
		 		assertTrue("The Activity Detail Page is not displayed",activityPg.verifyActivityDetailTitle().contains("Activity Detail"));
		 		//assertTrue("The Date is not matched",activityPg.isTextPresentOnScreen(Utilities.getCurrentDate()));
		 		assertTrue("Licence Number Does not match",activityPg.isTextPresentOnScreen(licence_Number));
		 		assertTrue("The Licence Type does not match",activityPg.isTextPresentOnScreen("Recreational Fishing"));
		 		assertTrue("The Event Type does not match",activityPg.isTextPresentOnScreen("Add"));
		 	
		 		
		 		assertEquals("Enabled attribute is false:","true",activityPg.activityHelpLink(activityPg.activityHelp,"enabled"));
		 		
		 		//Click on Settings
		 		activityPg.clickSettings();
		 		
		 		//Verify Settings Page is displayed
		 		settingPg.verifySettingsPageTitile();
		 		
		 		//Click SignOut
		 		AddInPg = settingPg.pressSigoutButton();
		 		
		 		//Verify Add Intro Page is displayed
		 		assertTrue(AddInPg.verifyAddPageTitle());
		 		
	 	}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	
	 	finally{

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
		  s = ed.getData(10);
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
	public IOS_HolderActivityTest(DesiredCapabilities caps) {
		super(caps);
	}

}

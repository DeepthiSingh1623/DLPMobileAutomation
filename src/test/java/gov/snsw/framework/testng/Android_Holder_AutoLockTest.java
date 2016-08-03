package gov.snsw.framework.testng;


import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;
import com.perfectomobile.utils.PerfectoUtils;

import gov.snsw.framework.android.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.android.holder.pageobjects.AppSettingPage;
import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.android.holder.pageobjects.QuickViewPage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.SupportPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;


public class Android_Holder_AutoLockTest extends BasicTest{

	
	
	@Test (dataProvider="logInData")
	public void autoLockAndroid(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("appPackage");
	 	try{
	 		
	 			//close App
	 			Utilities.closeApp(driver, appName);
 			
	 			//open App
	 			Utilities.openApp(driver, appName);
	 				 			
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
		 		
		 		//Verifying Show Password Exist
		 		assertTrue(signIn.verifyShowPwd());
		 		
		 		//Keyboard Remove
		 		Utilities.BackBtn(driver);
		 		
		 		//click Sign In Button
		 		enterPIN = signIn.clickSignInBtn();
		 		 		
		 		//Verify the Enter PIN is displayed
		 		assertTrue(enterPIN.verifyPinEnterTitle().contains("myLicences"));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enter4DigitPin(pin);
		 		
		 		//Verify Confirm PIN is displayed
		 		assertTrue(enterPIN.verifyPinConfirmTitle().contains("Confirm PIN"));
		 		
		 		//Enter 4 digit PIN confirmation
		 		enterPIN.enter4DigitPin(pin);
		 		}
		 		
		 		else
		 		{
		 			enterPIN = new EnterPINPage(driver);
		 			
		 			//Verify Unlock Enter Pin is displayed
			 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Enter PIN"));
		 			
		 			//Enter 4 digit PIN
		 			enterPIN.enter4DigitPin(pin);
		 		}	 	
		 		
		 		MyLicencePage LicPg = new MyLicencePage(driver);		 		
		 		
		 		//Verify My Licences Page is displayed
		 		assertTrue(LicPg.viewLicName().contains("NSW Recreational Fishing Fee"));
		 		
		 		//Click on the AppSettings
		 		AppSettingPage appSettingPg = LicPg.clickSettings();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		//Click AutoLock		 		
		 		appSettingPg.clickAutoLock();
		 		
		 		//assert AutoLock title is displayed
		 		assertTrue(appSettingPg.alertAutoLock());
		 		
		 		//select Immediately Radio button
		 		appSettingPg.clickImmediatelyRadioButton();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		//Press Home Key
		 		Utilities.homeBtn(driver, appName);
		 		Thread.sleep(2000);
		 		
		 		//open App
	 			Utilities.openApp(driver, appName);
	 			Thread.sleep(4000);
	 			
	 			//Verify the Enter PIN is displayed
		 		assertTrue(enterPIN.verifyPinEnterPg().contains("Enter PIN"));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enter4DigitPin(pin);
	 			
	 			//Verify My Licences Page is displayed
		 		assertTrue(LicPg.viewLicName().contains("NSW Recreational Fishing Fee"));
		 		
		 		//Click on the AppSettings
		 		appSettingPg = LicPg.clickSettings();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		//Click AutoLock		 		
		 		appSettingPg.clickAutoLock();
		 		
		 		//assert AutoLock title is displayed
		 		assertTrue(appSettingPg.alertAutoLock());
		 		
		 		//select Immediately Radio button
		 		appSettingPg.clickFiveMinutesRadioButton();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		//Press Home Key
		 		Utilities.homeBtn(driver, appName);
		 		Thread.sleep(2000);
		 		
		 		//open App
	 			Utilities.openApp(driver, appName);		
	 			Thread.sleep(3000);
	 			
	 			//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		
		 		//Checking after 5 minutes 
		 		//Click AutoLock		 		
		 		appSettingPg.clickAutoLock();
		 		
		 		//assert AutoLock title is displayed
		 		assertTrue(appSettingPg.alertAutoLock());
		 		
		 		//select Immediately Radio button
		 		appSettingPg.clickFiveMinutesRadioButton();
		 		
		 		//Verify app Settings Page is displayed 
		 		assertTrue(appSettingPg.verifyAppSettingTitleBar().contains("App Settings"));
		 		
		 		//Press Home Key
		 		Utilities.homeBtn(driver, appName);
		 		Thread.sleep(310000);		 		
		 		
		 		//open App
	 			Utilities.openApp(driver, appName);
		 		Thread.sleep(1000);
	 			
	 			//Verify the Enter PIN is displayed
		 		assertTrue(enterPIN.verifyPinEnterPg().contains("Enter PIN"));
		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enter4DigitPin(pin);	 			
		 		
		 		
		 		//Verify My Licences Page is displayed
		 		assertTrue(LicPg.viewLicName().contains("NSW Recreational Fishing Fee"));
		 		
		 		//click Settings 
		 		LicPg.settings();
		 		
		 		//Verify Add Intro Page is displayed
		 		assertTrue(AddInPg.verifyAddPg().contains("Add"));
		 			 		
		 		
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
	public Android_Holder_AutoLockTest(DesiredCapabilities caps) {
		super(caps);
	}
}
	



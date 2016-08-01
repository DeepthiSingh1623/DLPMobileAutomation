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
	 			Map<String, Object> params12 = new HashMap<>();
	 			params12.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 			Object result12 = driver.executeScript("mobile:application:close", params12);
		
	 			//open App
	 			Map<String, Object> params11 = new HashMap<>();
	 			params11.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 			Object result11 = driver.executeScript("mobile:application:open", params11);
	 				 			
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
		 		Map<String, Object> params2 = new HashMap<>();
		 		params2.put("keySequence", "HOME");
		 		Object result2 = driver.executeScript("mobile:presskey", params2);
		 		
		 		Thread.sleep(2000);
		 		
		 		//Open App
		 		Map<String, Object> params13 = new HashMap<>();
		 		params13.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 			Object results13 = driver.executeScript("mobile:application:open", params13);			
	 			
		 				
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
		 		Map<String, Object> params32 = new HashMap<>();
		 		params32.put("keySequence", "HOME");
		 		Object result32 = driver.executeScript("mobile:presskey", params32);
		 		
		 		Thread.sleep(2000);
		 		
		 		//Open App
		 		Map<String, Object> params33 = new HashMap<>();
		 		params33.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 			Object results33 = driver.executeScript("mobile:application:open", params33);			
	 					 		
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
		 		Map<String, Object> params52 = new HashMap<>();
		 		params52.put("keySequence", "HOME");
		 		Object result52 = driver.executeScript("mobile:presskey", params52);
		 		
		 		Thread.sleep(310000);		 		
		 		
		 		//Open App
		 		Map<String, Object> params53 = new HashMap<>();
		 		params53.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 			Object results53 = driver.executeScript("mobile:application:open", params53);			
		 		
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
	 		//Utilities.cleanApp(driver,appName);
	 		Map<String, Object> params3 = new HashMap<String, Object>();
	 		params3.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 		Object result3 = driver.executeScript("mobile:application:clean", params3);
	 				
	 		
	 		//close app
	 		//Utilities.closeApp(driver,appName);
	 		Map<String, Object> params1 = new HashMap<String, Object>();
	 		params1.put("identifier", "au.gov.nsw.onegov.app.holder.uat");
	 		Object result1 = driver.executeScript("mobile:application:close", params1);
	 		
	 		
	 		
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
	



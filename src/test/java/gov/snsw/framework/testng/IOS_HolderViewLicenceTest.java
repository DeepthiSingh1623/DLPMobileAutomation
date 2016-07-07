package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertEquals;
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

import gov.snsw.framework.ios.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.ios.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.ios.holder.pageobjects.EnterPinPage;
import gov.snsw.framework.ios.holder.pageobjects.MyLicencesPage;
import gov.snsw.framework.ios.holder.pageobjects.SettingsPage;
import gov.snsw.framework.ios.holder.pageobjects.SignInPage;
import gov.snsw.framework.ios.holder.pageobjects.TermsAndCondPage;
import gov.snsw.framework.utils.Utilities;

public class IOS_HolderViewLicenceTest extends BasicTest
{
	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin, String postal_Address,String lic_OwnerName) throws Exception{
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
		 		 		
		 		//Enter 4 digit PIN
		 		enterPIN.enterPin();
		 		
		 		//Enter 4 digit PIN confirmation
		 		enterPIN.enterPin();
		 		}
		 		
		 		else
		 		{
		 			enterPIN = new EnterPinPage(driver);
		 			
		 			//Enter 4 digit PIN
		 			enterPIN.enterPINUnlock();
		 		}
		 				 		
		 		MyLicencesPage LicPg = new MyLicencesPage(driver);
		 		
		 		if(LicPg.isTextPresentOnScreen("Notifications have been disabled"))
		 		{
		 			LicPg.selectNo();
		 		} 
		 		
		 		//Verify My Licence Page is displayed
		 		//assertEquals(licence_Name,LicPg.myLicPgTitle());
		 		assertTrue(LicPg.isTextPresentOnScreen("NSW Recreational Fishing Fee"));
		 		
		 		//Click Licence Number
		 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);
		 		
		 		
		 		assertEquals(lic_OwnerName,detailLicPg.getLicName());
		 		
		 		
		 		assertEquals(licence_Number,detailLicPg.getLicNum());
		 		
		 		
		 		assertEquals(licence_StartDate,detailLicPg.getLicStartDate());
		 		
		 		
		 		assertEquals(licence_ExpireDate,detailLicPg.getLicExpireDate());
		 		
		 		
		 		//Click Back Button on the Licence Details Page
		 		LicPg = detailLicPg.clickBackBtn();
		 		
		 		//Back Button on detailed Lic page used TAP
		 		//Map<String, Object> params1 = new HashMap<String, Object>();
		 		//params1.put("location", "29,79");
		 		//Object result1 = driver.executeScript("mobile:touch:tap", params1); 		
		 		
		 		
		 			 		
		 		//Verify My Licence Page is displayed
		 		assertTrue(LicPg.isTextPresentOnScreen("NSW Recreational Fishing Fee"));
		 				 		
		 		//Click on the Settings and then sign out
		 		SettingsPage settingPg = LicPg.clickSettingsBtn();
		 		
		 		//Verify Settings Page is displayed
		 		assertTrue(settingPg.isTextPresentOnScreen("Settings"));
		 		//settingPg.verifySettingsPageTitile();
		 		
		 		//Click SignOut
		 		AddInPg = settingPg.pressSigoutButton();
		 		
		 		//Verify Add Intro Page is displayed
		 		//assertEquals("Add",AddInPg.verifyAddPageTitle());
		 		assertTrue(AddInPg.isTextPresentOnScreen("Add"));
		 		
		 		
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	
	 	finally{
	 		
	 		//clean app
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
		  s = ed.getData(12);
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
	public IOS_HolderViewLicenceTest(DesiredCapabilities caps) {
		super(caps);
	}

}

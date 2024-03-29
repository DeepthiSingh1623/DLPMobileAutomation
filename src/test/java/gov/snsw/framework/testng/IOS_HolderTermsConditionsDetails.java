package gov.snsw.framework.testng;


import static org.testng.AssertJUnit.*;

import java.io.IOException;

 

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;


import gov.snsw.framework.ios.holder.pageobjects.AddIntroPage;
import gov.snsw.framework.ios.holder.pageobjects.EnterPinPage;
import java.util.Map;
import java.util.HashMap;
import gov.snsw.framework.ios.holder.pageobjects.MyLicencesPage;
import gov.snsw.framework.ios.holder.pageobjects.QuickViewPage;
import gov.snsw.framework.ios.holder.pageobjects.SettingsPage;
import gov.snsw.framework.ios.holder.pageobjects.SignInPage;
import gov.snsw.framework.ios.holder.pageobjects.SupportPage;
import gov.snsw.framework.ios.holder.pageobjects.TermsAndCondPage;
import gov.snsw.framework.utils.Utilities;

public class IOS_HolderTermsConditionsDetails extends BasicTest
{
	@Test (dataProvider="logInData")
	public void supportIOS(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("bundleId");	
	 	try{
	 			//reportPass("succes", "param");
	 			 
	 			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		//Enter PIN
		 		EnterPinPage enterPIN = null;
		 		
		 	
		 		
		 		if(AddInPg.isStartBtnExist())
		 		{		 			
		 		
		 		//Click on the Start button on introduction page
		 		TermsAndCondPage tcPg = AddInPg.pressStartBtn();
		 		
		 		/*
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
		 		*/
		 		}
		 		/*
		 		else
		 		{
		 			enterPIN = new EnterPinPage(driver);
		 			
		 			//Verify Enter Pin is displayed
			 		assertTrue(enterPIN.verifyUnlockPINTitle().contains("Unlock with PIN"));
			 		
		 			//Enter 4 digit PIN
		 			enterPIN.enterPINUnlock();
		 		}
		 					
		 		*/
		 		MyLicencesPage LicPg = new MyLicencesPage(driver);
		 		
		 		if(LicPg.isTextPresentOnScreen("Notifications have been disabled"))
		 		{
		 			LicPg.selectNo();
		 		}		 		
		 		
		 	
		 		//Verify My Licence Page is displayed
		 		//assertTrue(LicPg.myLicPgTitle().contains(licence_Name));
		 		
		 		//Click on the Settings Button
		 		//SettingsPage settingPg = LicPg.clickSettingsBtn();
		 		
		 		//Verify Settings Page is displayed
		 		//settingPg.verifySettingsPageTitile();
		 		/*
		 		//Click on Support Option
		 		SupportPage suppPg = settingPg.clickSupportOption();
		 		
		 		//Support Page is displayed
		 		assertTrue(suppPg.verifySupportPgTitle().contains("Support"));
		 		assertTrue(suppPg.verifyCustomerService().contains("CUSTOMER SERVICE"));
		 		assertTrue(suppPg.verifyAssistedService().contains("ASSISTED SERVICES"));
		 		assertTrue(suppPg.verifyFeedBack().contains("info@service.nsw.gov.au"));		 				 		
		 		//Click on Settings
		 		suppPg.clickSettings();		 				 		
		 		*/
		 		//click the terms and conditions to go the T&C page
		 	//	settingPg.ClickTermsCondText();
		 		
		 		TermsAndCondPage tcPg = new TermsAndCondPage(driver);
		 		
		 		//1 swipe
				Map<String, Object> params55 = new HashMap<>();
				params55.put("start", "276,1093");
				params55.put("end", "588,0");
				Object result55 = driver.executeScript("mobile:touch:swipe", params55);
				
				//2 swipe
				
				Map<String, Object> params56 = new HashMap<>();
				params56.put("start", "280,916");
				params56.put("end", "320,141");
				Object result56 = driver.executeScript("mobile:touch:swipe", params56);
					
				//3 swipe
				
				Map<String, Object> params57 = new HashMap<>();
				params57.put("start", "331,1136");
				params57.put("end", "402,283");
				Object result57 = driver.executeScript("mobile:touch:swipe", params57);
				
				//4 swipe
				
				Map<String, Object> params58 = new HashMap<>();
				params58.put("start", "348,1127");
				params58.put("end", "341,236");
				Object result58 = driver.executeScript("mobile:touch:swipe", params58);
				
				//5 swipe
				
				Map<String, Object> params59 = new HashMap<>();
				params59.put("start", "343,1114");
				params59.put("end", "396,247");
				Object result59 = driver.executeScript("mobile:touch:swipe", params59);
				
				
				//6 swipe
				
				Map<String, Object> params60 = new HashMap<>();
				params60.put("start", "371,1127");
				params60.put("end", "379,245");
				Object result60 = driver.executeScript("mobile:touch:swipe", params60);
				
				//7 swipe
				Map<String, Object> params61 = new HashMap<>();
				params61.put("start", "369,1131");
				params61.put("end", "404,196");
				Object result61 = driver.executeScript("mobile:touch:swipe", params61);
				
				
				//8 swipe
				Map<String, Object> params62 = new HashMap<>();
				params62.put("start", "335,1129");
				params62.put("end", "369,82");
				Object result62 = driver.executeScript("mobile:touch:swipe", params62);
				
				//9 swipe
				
				Map<String, Object> params63 = new HashMap<>();
				params63.put("start", "335,1129");
				params63.put("end", "369,82");
				Object result63 = driver.executeScript("mobile:touch:swipe", params63);
				
				//tcPg.emailLinkText();
				
				//String Actual = tcPg.emailLinkText(tcPg.emailLink, "url");
				//System.out.println(Actual);
			
			
				 assertEquals("Email Link is not as expected","mailto:info@service.nsw.gov.au",tcPg.emailLinkText(tcPg.emailLink, "url"));
				 assertEquals("Cust Link is not as expected","mailto:info@service.nsw.gov.au",tcPg.CustLinkText(tcPg.custLink, "url"));
				 assertEquals("Telephone Link is not as expected","tel:13%2077%2088",tcPg.TeleLinkText(tcPg.teleLink, "url"));
				 assertEquals("Overseas telephone Link is not as expected","tel:+61%202%208894%201555",tcPg.ovTeleLinkText(tcPg.ovTeleLink, "url"));


		 	//	assertTrue(tcPg.emailLinkText().contains("info@service.nsw.gov.au"));
		 		//click settings to go back after validating the T&C links
		 		
		 		//tcPg.clickSettings();
		 		
		 		
		 		//Verify Settings Page is displayed
		 	//	settingPg.verifySettingsPageTitile();
		 		
		 		//Click SignOut
		 	//	AddInPg = settingPg.pressSigoutButton();
		 		
		 		//Verify Add Intro Page is displayed
		 		//assertTrue(AddInPg.verifyAddPageTitle());		 		
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
	public IOS_HolderTermsConditionsDetails(DesiredCapabilities caps) {
		super(caps);
	}

}

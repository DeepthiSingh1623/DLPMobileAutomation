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

import gov.snsw.framework.android.holder.pageobjects.AddIntroPage;

import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;


public class Android_HolderSignInTest extends BasicTest{

	
	
	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin) throws Exception{
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
		 		enterPIN = signIn.signInNswAcct(username,password);
		 		 		
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
		 		
		 		//Verify My Licence Page is displayed
		 		assertEquals("My Licences",LicPg.verifyMyLicTitle());
		 		
		 		//Verify My Licences Page is displayed
		 		String ActuallicenseName = LicPg.viewLicName();
		 		System.out.println("The Actual Lic Name is "+ActuallicenseName);
		 		String ExpectedlicenseName = licence_Name;
		 		System.out.println("The Expected Lic Name is "+ExpectedlicenseName);
		 		assertTrue(ExpectedlicenseName.contains(ActuallicenseName));		 		 		
		 		
		 		//close app
		 		Utilities.closeApp(driver, appName);
		 		
		 		//Open App
		 		Utilities.openApp(driver, appName);
		 		
		 		
		 		//Verify the Re-Enter PIN Page is displayed
		 		String pinPg = enterPIN.enterPINPgExist();
		 		System.out.println("The re-enter PIN text is "+pinPg);
		 		assertTrue(pinPg.contains("Enter PIN"));
		 		
		 		//Re-enter 4 digit PIN Number
		 		enterPIN.enter4DigitPin(pin);
		 				 		
		 		//Verify PinPage is displayed
		 		assertTrue(ExpectedlicenseName.contains(ActuallicenseName));	
		 		
		 		//Click on the Settings and then sign out
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
	public Android_HolderSignInTest(DesiredCapabilities caps) {
		super(caps);
	}
}
	


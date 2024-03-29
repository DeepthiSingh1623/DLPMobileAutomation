package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.android.checker.pageobjects.AddIntroPage;
import gov.snsw.framework.android.checker.pageobjects.AppSettingPage;
import gov.snsw.framework.android.checker.pageobjects.AppUsageAgreementPage;
import gov.snsw.framework.android.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.android.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.android.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.checker.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;



public class CheckerChangePINTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void checkerChangePInSettingsAndroid(String username, String password,String pin) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("appPackage");
	 	try{
	 			//reportPass("success", "param");
	 		Reporter.log("Test: checkerChangePInSettingsAndroid "+ 
	 		 		driver.getCapabilities().asMap().get("deviceName"),true);			
		 		switchToContext(driver, "NATIVE_APP");
		 		//Driver initialization	 		
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		TermsAndConditionsPage tcPg = new TermsAndConditionsPage(driver);
		 			 		
		 		EnterPINPage enterPIN = null;
		 		
		 		if(tcPg.isAgreeBtnExist()){
		 			
		 			//TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
		 			
		 			//Click Accept Button on the Terms and Condition Page
		 			AppUsageAgreementPage appAgree = tcPg.termsAndConditionAcceptBtn();
		 			SignInNSWAcctPage signIn = appAgree.pressAcceptBtn();
			 		
			 		//Enter the login details in the Sign In Page
			 		enterPIN = signIn.signInNswAcct(username,password);
			 		 
				 		//Enter 4 digit PIN
				 		 enterPIN.enterPin(pin);
				 		 enterPIN.enterPin(pin);

		 		}
		 		else{
		 			
		 			enterPIN = new EnterPINPage(driver);
		
		 			//Enter 4 digit PIN confirmation
			 		 enterPIN.enterPin(pin);
		 		}
		 		SNSWCheckerPage chkPg = new SNSWCheckerPage(driver);
		 		
		 		assertTrue(chkPg.isMenuItemPresent());	 		
		 		
		 		//Click on the AppSettings
		 		AppSettingPage appSettingPg = chkPg.clickSettings();
		 		
		 		assertEquals("App Settings",appSettingPg.getAndroidCheckerPageTitle());
		 		
		 		//Click on the Change PIN Button
		 		 appSettingPg.clickChangePinBtn();
		 		
		 		//click Ok Button
		 		//enterPIN = appSettingPg.okBtn();
		 		
		 		assertEquals("Enter your current PIN",enterPIN.getPINPageTitle());
		 		
		 		//enter 4 digit current Pin
		 		enterPIN.enterPin(pin);
		 		
		 		//assertEquals("You are required to setup a new PIN",enterPIN.getPINPageTitle());
		 		enterPIN.enterPin("2222");
		 		 enterPIN.enterPin("2222");

		 		
		 		//Close App
		 		Map<String, Object> params = new HashMap();
		 		params.put("identifier", appName);
		 		Object result1 = driver.executeScript("mobile:application:close", params);
		 		params.clear();
		 		
		 		//Open App		 				 		
		 		Map<String, Object> params1 = new HashMap();
		 		params.put("identifier", appName);
		 		Object result2 = driver.executeScript("mobile:application:open", params);
		 		params.clear();	
		 		
		 		//Re-enter 4 digit PIN Number
		 		enterPIN.enterPin(pin);		
		 		
		 		//assert Error Message
		 		assertTrue(enterPIN.isTextPresentOnScreen("PIN error, please try again."));
		 		
		 		// enter Newly created PIN
		 		enterPIN.enterPin("2222");		 		 		
		 	
		 		
		 		assertEquals("Scan Licence",chkPg.getAndroidCheckerPageTitle());
		 		
		 		// Click on the Settings and Sign out
		 		chkPg.signOut();
		 		assertTrue(tcPg.isAgreeBtnExist());
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	finally{
	 		
		
	 		Utilities.closeApp(driver, appName);

	 	}
        if(testFail){
        	Assert.fail();
        }
	}


	private void assertEquals(String expected, Object menuItemPresent) {
		// TODO Auto-generated method stub
		
	}


	@DataProvider (name = "logInData", parallel = false)
	public Object[][] searchItemsData(){
		 Object[][] s = null;
		try {
		  ExcelDriver ed = new ExcelDriver(sysProp.get("inputWorkbook"), sysProp.get("checkerSingInSheet"), false);
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
	public CheckerChangePINTest(DesiredCapabilities caps) {
		super(caps);
	}	

}

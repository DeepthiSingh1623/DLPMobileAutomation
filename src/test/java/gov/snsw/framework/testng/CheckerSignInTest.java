package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertEquals;

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

import gov.snsw.framework.android.checker.pageobjects.AddIntroPage;
import gov.snsw.framework.android.checker.pageobjects.EnterPINPage;
import gov.snsw.framework.android.checker.pageobjects.SNSWCheckerPage;
import gov.snsw.framework.android.checker.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.checker.pageobjects.TermsAndConditionsPage;
import gov.snsw.framework.utils.Utilities;


public class CheckerSignInTest extends BasicTest{

	
	
	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin) throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
		String appName = (String) caps.getCapability("appPackage");
	 	try{
	 			 			
		 		switchToContext(driver, "NATIVE_APP");
		 	
		 		AddIntroPage AddInPg = new AddIntroPage(driver);
		 		
		 		EnterPINPage enterPIN = null;
		 		
		 		if(AddInPg.isStartBtnExists()){
		 			
		 			TermsAndConditionsPage tcPg = AddInPg.addStartBtn();
		 			
		 			//Click Accept Button on the Terms and Condition Page
		 			SignInNSWAcctPage signIn = tcPg.termsAndConditionAcceptBtn();
			 		
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
		 		
		 		assertEquals("UAT-Checker", chkPg.getAndroidCheckerPageTitle());	
		 		
		 		Utilities.closeApp(driver, appName);
		 		
		 		Utilities.openApp(driver, appName);
		 		
		 		//Verify the Re-Enter PIN Page is displayed
		 		assertEquals("Enter PIN",enterPIN.getPINPageTitle());
		 		
		 		//Re-enter 4 digit PIN Number
		 		enterPIN.enterPin(pin);
		 		assertEquals("UAT-Checker", chkPg.getAndroidCheckerPageTitle());		 		
		 		chkPg.signOut();
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
		
	 	finally{
	 		
	 		Utilities.cleanApp(driver, appName);
	 		
	 		Utilities.closeApp(driver, appName);
	 		
	 		driver.close();
	 	}
	 	
        if(testFail){
        	Assert.fail();
        }
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
	public CheckerSignInTest(DesiredCapabilities caps) {
		super(caps);
	}
}
	



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
import gov.snsw.framework.holder.pageobjects.AppSettingPage;
import gov.snsw.framework.holder.pageobjects.ChangeNewPINPage;
import gov.snsw.framework.holder.pageobjects.ChangePINPage;
import gov.snsw.framework.holder.pageobjects.ConfirmNewPINPage;
import gov.snsw.framework.holder.pageobjects.ConfirmPINPage;
import gov.snsw.framework.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.holder.pageobjects.ManageYourLicPage;
import gov.snsw.framework.holder.pageobjects.MyLicencePage;
import gov.snsw.framework.holder.pageobjects.RenewLicencePage;
import gov.snsw.framework.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.holder.pageobjects.TermsAndConditionsPage;

public class RenewLicenceTest extends BasicTest{

	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin,String appName) throws Exception{
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
	 		
	 		//Click the License to view the detailed Licence	 						
	 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);		 	
	 		
	 		//Click on the Manage License Button
	 		ManageYourLicPage mngLic = detailLicPg.clickManageLicenceBtn();
	 		
	 		//click on renew lic
	 		RenewLicencePage renewLicPg = mngLic.clickRenewLic();
		 	
	 		//
	 		
		   // Click on the Settings and Sign out
		   LicPg.settings();
		 		
		  //clean app
		  Map  params2 = new HashMap();
		  params2.put("identifier", appName);
	 	  Object result = driver.executeScript("mobile:application:clean", params2);
		 		
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
		  s = ed.getData(11);
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
	public RenewLicenceTest(DesiredCapabilities caps) {
		super(caps);
	}	

}

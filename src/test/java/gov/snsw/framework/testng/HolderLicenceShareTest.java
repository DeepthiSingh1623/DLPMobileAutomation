package gov.snsw.framework.testng;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.perfectomobile.dataDrivers.excelDriver.ExcelDriver;
import com.perfectomobile.test.BasicTest;

import gov.snsw.framework.android.holder.pageobjects.AddIntroPage;

import gov.snsw.framework.android.holder.pageobjects.DetailLicencePage;
import gov.snsw.framework.android.holder.pageobjects.EnterPINPage;
import gov.snsw.framework.android.holder.pageobjects.MyLicencePage;

import gov.snsw.framework.android.holder.pageobjects.SharingLicencePage;
import gov.snsw.framework.android.holder.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.android.holder.pageobjects.TermsAndConditionsPage;


public class HolderLicenceShareTest extends BasicTest{

	

	@Test (dataProvider="logInData")
	public void licenceShareAsHolder(String username, String password,String pin,String licence_Number,String licence_StartDate,String licence_ExpireDate,String class_Type,String licence_Name,String LogEvent_Type,String new_Pin, String appName)  throws Exception{
		boolean testFail = false;
		if(this.driver == null){
			throw new IllegalMonitorStateException("Device not allocated");
		}
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
		 		
		 		//Click the License Number		 				 				
		 		DetailLicencePage detailLicPg = LicPg.clickOnLicNumber(licence_Number);
		 		
		 		//click on Share License Button
		 		SharingLicencePage shareLicPg = detailLicPg.clickShareLicenceBtn();
		 		
		 		//verify the License Share Page - Title is displayed
		 		String shareTitle = shareLicPg.verifySharePageTitle();
		 		assertTrue(shareTitle.contains("Sharing Licence"));
		 		
		 		//verify the License Share Page - Lic Name is displayed
		 		String shareLicName = shareLicPg.verifyShareLicName();
		 		assertTrue(shareLicName.contains("Fishing licence"));
		 		
		 		//verify the License Share Page - Lic Num is displayed
		 		String shareLicNum = shareLicPg.verifyShareLicNum();
		 		assertTrue(shareLicNum.contains(licence_Number));
		 		
		 		//verify the License Share Page - Scan Img is displayed
		 		//assertTrue(shareLicPg.verifyShareQRScan());
		 		
		 		//Click Back Button on the QR Scan Page
		 		
		 		Map<String, Object> params1 = new HashMap();
				params1.put("keySequence", "BACK");
				driver.executeScript("mobile:presskey", params1);
		 		
		 		//click the back button on the License Detailed Page
		 		LicPg = detailLicPg.pressBackBtn();
		 		
		 		//Click on the Settings and then sign out
		 		LicPg.settings();	
		 		
		 		
		 		
		}
	 	catch(Exception e){
	 		
	 		e.printStackTrace();
	 		reportFail("expected", "actual","params");	

	 	}
	 	
	 	finally{
	 		
	 		Map<String, Object> params = new HashMap();
	 		params.put("identifier", appName);
	 		Object result1 = driver.executeScript("mobile:application:clean", params);
	 		params.clear();
	 		
	  		params.put("identifier", appName);
	 		result1 = driver.executeScript("mobile:application:close", params);
	 		params.clear();
	 		
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
	
	public HolderLicenceShareTest(DesiredCapabilities caps) {
		super(caps);
	}
}

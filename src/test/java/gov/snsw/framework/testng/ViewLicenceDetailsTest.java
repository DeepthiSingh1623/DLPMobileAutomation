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

import gov.snsw.framework.pageobjects.AddIntroPage;
import gov.snsw.framework.pageobjects.ConfirmPINPage;
import gov.snsw.framework.pageobjects.DetailLicencePage;
import gov.snsw.framework.pageobjects.EnterPINPage;
import gov.snsw.framework.pageobjects.MyLicencePage;
import gov.snsw.framework.pageobjects.SignInNSWAcctPage;
import gov.snsw.framework.pageobjects.TermsAndConditionsPage;

public class ViewLicenceDetailsTest extends BasicTest {


	@Test (dataProvider="logInData")
	public void signIn(String username, String password,String pin,String licence_Number, String class_Type, String licence_StartDate, String licence_ExpireDate) throws Exception{
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
		 		
		 		//Click the Fishing Fee License 
		 		DetailLicencePage detailLicPg = LicPg.clickLicStatus();		 				
		 		
		 		//
		 		//Capturing the Lic Num
		 		String licenceNumber = detailLicPg.getLicNum();	
		 		
		 		assertTrue(licenceNumber.equalsIgnoreCase(licence_Number));
		 		/*if(licenceNumber.equalsIgnoreCase(licence_Number))
		 		{
		 			System.out.println("The Lic matched, The Expected lic no#" +licence_Number+"The Actual lic No#"+licenceNumber);
		 		}
		 		else
		 		{
		 			System.out.println("The Lic not matched, The Expected lic no#" +licence_Number+"The Actual lic No#"+licenceNumber);
		 		}*/
		 		
		 		//Capture Class Type
		 		String classType = detailLicPg.getLicClass();
		 		
		 		//assert licenceExpireDate
		 		assertTrue(classType.equalsIgnoreCase(class_Type));
		 		/*if(classType.equalsIgnoreCase(class_Type))
		 		{
		 			System.out.println("The Lic class_Type  matched, The Expected Class Type#"+class_Type+ "The Actual lic No#"+classType);
		 		}
		 		else
		 		{
		 			System.out.println("The Lic class_Type  not matched, The Expected lic no#" +class_Type+"The Actual lic No#"+classType);
		 		}		 */
		 		
		 		//Capturing the Lic Start Date		 		
		 		String licenceStartDate = detailLicPg.getLicStartDate();
		 		//assert LicStartDate
		 		assertTrue(licenceStartDate.equalsIgnoreCase(licence_StartDate));		 		
		 		
		 		/*if(licenceStartDate.equalsIgnoreCase(licence_StartDate))
		 		{
		 			System.out.println("The Lic Start Date matched, The Expected lic Start Date #" +licence_StartDate+"The Actual lic Start Date#"+licenceStartDate);
		 		}
		 		else
		 		{
		 			System.out.println("The Lic Start Date not matched, The Expected lic Start Date#" +licence_StartDate+"The Actual lic Start Date#"+licenceStartDate);	 		}
		 		*/
		 		
		 		//capturing the Lic Expire Date
		 		String licenceExpireDate = detailLicPg.getLicExpireDate();
		 		 		
		 		//assert licenceExpireDate
		 		assertTrue(licenceExpireDate.equalsIgnoreCase(licence_ExpireDate));		 		
		 		/*if(licenceExpireDate.equalsIgnoreCase(licence_ExpireDate))
		 		{
		 			System.out.println("The Lic Expire Date matched, The Expected lic Expire Date #"+licenceExpireDate+"The Actual lic Expire Date #"+licenceExpireDate);
		 		}
		 		else
		 		{
		 			System.out.println("The Lic Expire Date not matched, The Expected Lic Expire Date #"+licenceExpireDate+"The Actual lic Expire Date #"+licenceExpireDate);
		 		}*/

		 		//
		 		/*String detailsLic = detailLicPg.getLicDetails();
		 				 		 
		 		System.out.println("The results :"+detailsLic);
		 		
		 		assertTrue(licence_Number.equalsIgnoreCase(detailsLic));
		 		
		 		assertTrue(class_Type.equalsIgnoreCase(detailsLic));
		 		
		 		assertTrue(licence_StartDate.equalsIgnoreCase(detailsLic));
		 		
		 		assertTrue(licence_ExpireDate.equalsIgnoreCase(detailsLic));	*/	 		
		 	 		
		 		//click Back button to go to my license page
		 		LicPg = detailLicPg.pressBackBtn();
		 		
		 		//Click on the Settings and then sign out
		 		LicPg.settings();	
		 		
		 		//clean app
		 		Map  params = new HashMap();
	 			params.put("identifier", "+resourceid+");
	 			Object result = driver.executeScript("mobile:application:clean", params);
		 		
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
		  s = ed.getData(7);
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
	public ViewLicenceDetailsTest(DesiredCapabilities caps) {
		super(caps);
	}
}

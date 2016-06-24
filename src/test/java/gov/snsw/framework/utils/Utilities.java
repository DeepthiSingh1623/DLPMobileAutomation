package gov.snsw.framework.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Utilities {
	
	
	static Map<String, Object> params = new HashMap<String, Object>();
	
	public static void closeApp(RemoteWebDriver driver,String appName){
	
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:close", params);
 		params.clear();
	}
	
	public static void openApp(RemoteWebDriver driver,String appName){
		
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:open", params);
 		params.clear();
	}
	
	public static void cleanApp(RemoteWebDriver driver,String appName){
		
 		params.put("identifier", appName);
 		driver.executeScript("mobile:application:clean", params);
 		params.clear();
	}

}

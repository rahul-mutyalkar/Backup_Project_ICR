package com.qa.MainFunctions;

import java.io.File;
import java.io.IOException;

/**
 * @author pbhattacharjee
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.ExcelUtil;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class DriverCalling extends ExcelHandling{
	
public static WebDriver driver;
    
    public static ExtentTest test;
   
    
    static String Browser="";
    
    static String URL="";
    static String VideoRecording="";
    public static String TestCase;
    
    public static ExtentReports report;
    public static ExtentReports report1;
    public static ATUTestRecorder recorder;
    
   
    
    public static Logger log = Logger.getLogger("BaseClass");
    
    
       @BeforeSuite
	   public void SetExtentReportAndLogger() throws Exception
	   {
    	   File file4 = new File(System.getProperty("user.dir") + "\\Reports\\HTML");
    	   FileUtils.deleteDirectory(file4);
    	   File file = new File(GlobalConstant.ScreenShot_Path);
    	   FileUtils.deleteDirectory(file);
    	//   File file1 = new File(GlobalConstant.Video_Path);
    	//   FileUtils.deleteDirectory(file1);
    	   ExcelUtil.CreateFile();
    	   report=new ExtentReports(GlobalConstant.ExtentReport_Path,false);
		   PropertyConfigurator.configure(GlobalConstant.Log4j_Path);
		   
	   }
    
      
      public static WebDriver launchbrowser(String testname)
      {
    	 
    	 try{
    		 
    		 test=report.startTest(testname);
    		 TestCase=testname;
    		 VideoRecording = ExcelHandling.GetExcelData(testname, "Video_Report");
    		 if(VideoRecording.equalsIgnoreCase("Y"))
    		 {
    		 recorder=new ATUTestRecorder(GlobalConstant.Video_Path,testname+"_"+JavaUtilities.datetime("ddMMhhmmss"),false);
    		 recorder.start();
    		 }
    		 Extent_Reporting.createPdfFile(testname);
    		 Extent_Reporting.createDocxFile(testname);
    		 Browser=ExcelHandling.GetExcelData(testname, "BrowserType");
    		 URL=ExcelHandling.GetExcelData(testname, "URL");
    	     driver=InitateDriver(Browser);
    		 driver.get(URL);
    		 Extent_Reporting.Log_Pass("Launch", "User Is Navigated To Site : " + URL, test,driver);
    		 driver.manage().timeouts().pageLoadTimeout(GlobalConstant.Global_Wait,TimeUnit.SECONDS);
    		 driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
    	 }
    	 catch(Exception e)
    	 {}
		 
		 return driver;	
	}
      
      public static WebDriver InitateDriver(String browsername) 
    	{
    	  
    		if(browsername.equalsIgnoreCase("chrome"))
    		{
    			driver=InitalizeChromeBrowser();
    		}
    		else if(browsername.equalsIgnoreCase("ie"))
    		{
    			driver= InitalizeIEBrowser();
    		}
    		else if(browsername.equalsIgnoreCase("firefox"))
    		{
    			driver=InitalizeFireFoxBrowser();
    		}
    		else
    		{
    			throw new NoSuchSessionException("********* Browser Is Not Specified ***********"); 
    		}
    		return driver;
    		
    	}
    	
    	
    	@SuppressWarnings({ "unchecked", "rawtypes" })
    	public static WebDriver InitalizeChromeBrowser()
    	{
    		
    		Map prefsMap=new HashMap();
    		System.setProperty("webdriver.chrome.driver",GlobalConstant.ChromedriverPath);
    		ChromeOptions chromeOptions = new ChromeOptions();   
    		chromeOptions.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
    		chromeOptions.addArguments("force-device-scale-factor=0.75");
            chromeOptions.addArguments("high-dpi-support=0.75");
            chromeOptions.addArguments("headless");           
            chromeOptions.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
            chromeOptions.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
            chromeOptions.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
            chromeOptions.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
            chromeOptions.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
            chromeOptions.addArguments("--disable-gpu");
            
            
            prefsMap.put("profile.default_content_settings.popups", 0);  //Handle download notification bar
            prefsMap.put("download.default_directory",System.getProperty("user.dir")+"\\Downloads"); //sets the path of downloaded file.
            chromeOptions.setExperimentalOption("prefs", prefsMap);        
            driver = new ChromeDriver(chromeOptions);
            driver.manage().deleteAllCookies();
            //driver.manage().window().maximize();
            return driver;
    	}
    	
    	
    	
    	public static WebDriver InitalizeFireFoxBrowser()
    	{
    		System.setProperty("webdriver.gecko.driver",GlobalConstant.FireFoxdriverPath);
    		FirefoxOptions options = new FirefoxOptions();
    		options.addPreference("browser.helperapps.neverAsk.saveToDisk" , "application/octet-stream;application/pdf;application/excel"); 
    		options.addPreference("browser.helperApps.alwaysAsk.force", false);
    		options.addPreference("browser.download.manager.showWhenStarting",false);
    		options.addPreference("browser.download.folderList", 2); 
    		options.addPreference("browser.download.dir",System.getProperty("user.dir")+"\\Downloads\\savedPDFs");
    		options.addPreference("browser.download.manager.closeWhenDone", false);
    		driver= new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            return driver;
    	}
    	
    	public static WebDriver InitalizeIEBrowser()
    	{
    		    System.setProperty("webdriver.ie.driver",GlobalConstant.IEdriverPath);
    		    InternetExplorerOptions options = new InternetExplorerOptions();
    		    options.disableNativeEvents();//Define to ignore 
    		    options.setCapability("enablePersistentHover", true);
    		    options.setCapability("disable-popup-blocking", true);//
    		    options.setCapability("ignoreProtectedModeSettings", true);  //Define to ignore protected mode settings during start of IE driver.
    		    options.setCapability("ignoreZoomSetting", true);//Capability that defines ignore browser zoom settings
    		    driver = new InternetExplorerDriver(options);	
    		    driver.manage().deleteAllCookies();
    		    driver.manage().window().maximize();
    		    return driver;
    		
    	}
    	
    	public static void EndExcelReport(long EndTime,long StartTime,String Status,String testcasename) throws Exception
  	   {
  		     long total=EndTime-StartTime;
  			 ExcelUtil.WriteInExcel("Status", Status, testcasename);
  			 ExcelUtil.WriteInExcel("Start_Time",ExcelUtil.GetTime(StartTime), testcasename);
  			 ExcelUtil.WriteInExcel("End_Time",ExcelUtil.GetTime(EndTime), testcasename);
  			 ExcelUtil.WriteInExcel("TC_Time",ExcelUtil.timeDifference(total), testcasename);
  	   }
    	
    	public static void EndExcelReport1(long EndTime,long StartTime,String testcasename) throws Exception
   	   {
    		 ExcelUtil.WriteInExcel("Status",test.getRunStatus().toString().toUpperCase(), TestCase); 
    		long total=EndTime-StartTime;
   			 ExcelUtil.WriteInExcel("Start_Time",ExcelUtil.GetTime(StartTime), testcasename);
   			 ExcelUtil.WriteInExcel("End_Time",ExcelUtil.GetTime(EndTime), testcasename);
   			 ExcelUtil.WriteInExcel("TC_Time",ExcelUtil.timeDifference(total), testcasename);
   	   }
       
      // @AfterSuite
	   public void EndReport()
	   {
		   try
		   {
			 if(test != null)
			 {
			  report.endTest(test);  
			  report.flush();
			  if(VideoRecording.equalsIgnoreCase("Y"))
   		 	  {
   		 		recorder.stop();
   		 	  }
			  Extent_Reporting.addEndTimetoPDF();
			  Extent_Reporting.closePdf();
			  Extent_Reporting.addEndTimeToDocx();	
			 driver.quit();
			  }
			 
		    }
		   catch (Exception e)
		   {
			e.printStackTrace();
		   }    
	   }
	


}

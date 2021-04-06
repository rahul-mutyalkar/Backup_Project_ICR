package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.BusinessLogic.AddressAllocationActions_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;

public class AddressAllocationScreenTest2 extends DriverCalling
{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;


	public static WebDriver webDriver = null;
	public static String tcID = null;
	ICRA_BusinessLogic_Niketan BL = null;
	AddressAllocationActions_Niketan AL=null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	
	@BeforeMethod
	public void SetUp()
	{
		tcID = this.getClass().getSimpleName();
		webDriver = launchbrowser(tcID);
		BL = new ICRA_BusinessLogic_Niketan(webDriver,tcID);
		AL = new AddressAllocationActions_Niketan(webDriver,tcID);
		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
	}

		
		
	@Test
	public void AdrsAllocScreenTest() throws Throwable
	{
//		file = new File(GlobalConstant.ExcelPath);
//	    fis = new FileInputStream(file);
//	    wb = new XSSFWorkbook(fis);
//	    for(int i=0;i<wb.getNumberOfSheets();i++)
//        {
//        	sheet = wb.getSheetAt(i);
//        	for (int j = 1; j <= sheet.getLastRowNum(); j++) 
//           		{
//        			if((sheet.getRow(j).getCell(2).toString()).equalsIgnoreCase(this.getClass().getSimpleName()) 
//            			&& (sheet.getRow(j).getCell(4).toString()).equalsIgnoreCase("Y"))
//            		{   		
//        				StartTime=System.currentTimeMillis();
//        				try
//        				{
//        				tcID = this.getClass().getSimpleName();
//        				webDriver = launchbrowser(tcID);
//        				BL = new ICRA_BusinessLogic_Niketan(webDriver,tcID);
//        				AL = new AddressAllocationActions_Niketan(webDriver,tcID);
//        				PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		BL.ICRA_Login();
                		//BL.Click_On_Login();
                		BL.SelectClient();
            			PBL.ICRA_Menu_Selection("");
        			    AL.ChkHeaderElements();
        			    Extent_Reporting.Log_Message("Header Elements are Checked.......", test, webDriver);
        			    AL.ChkAreatablevisibility();
        			    Extent_Reporting.Log_Message("Checked Area Code table visbility", test, webDriver);
        			    AL.ChkZipCodetable();
        			    Extent_Reporting.Log_Message("Zip Code tables colums are checked", test, webDriver);
        			    AL.ClkAreaCodeRadio();
        			    AL.ChkZiptablevisibility();
        			    Extent_Reporting.Log_Message("Checked Zip Code table visbility", test, webDriver);
        			    AL.ChkAreaCodetable();
        			    Extent_Reporting.Log_Message("Area Code tables colums are checked", test, webDriver);
        			    AL.ChkSpecHandDrpAftrClkFlterChkBox();
        			    Extent_Reporting.Log_Message("Chked Special Handling drpdown after clicking filter code chkbox", test, webDriver);
        		        AL.ChkReassignAlertMsg();
        			    AL.ChkOtherButtons();
        			    Extent_Reporting.Log_Message("Chked Other Fields or button display or not.....", test, webDriver);
        			    Extent_Reporting.Log_Message("*****" + tcID + " is Ended *****", test, webDriver);
        			    EndTime=System.currentTimeMillis();
                        EndExcelReport1(EndTime,StartTime,tcID);
                        EndReport();
						}
        				//catch(Exception e)
        				//{
						//	EndTime=System.currentTimeMillis();
	                    //    EndExcelReport(EndTime,StartTime,"Fail",tcID);
	                   //     EndReport();
						//}          		
        			   
            	//	}
        			
           		//}
      //  }
	  //	}
	
	@AfterMethod
	public void CloseDriver()
	{
       if(webDriver != null)
        {	
         webDriver.quit();
        } 
	}
	
}


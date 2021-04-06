package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.ICRA_BusinessLogic_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.BusinessLogic.ProviderManageMentAction_Niketan;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;

public class ContactTest extends DriverCalling
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
	ProviderManageMentAction_Niketan PM=null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	
	
	@Test
	public void ContactFlowTest() throws Throwable
	 {
		file = new File(GlobalConstant.ExcelPath);
	    fis = new FileInputStream(file);
	    wb = new XSSFWorkbook(fis);
	    for(int i=0;i<wb.getNumberOfSheets();i++)
        {
        	sheet = wb.getSheetAt(i);
        	for (int j = 1; j <= sheet.getLastRowNum(); j++) 
           		{
        			if((sheet.getRow(j).getCell(2).toString()).equalsIgnoreCase(this.getClass().getSimpleName()) 
            			&& (sheet.getRow(j).getCell(4).toString()).equalsIgnoreCase("Y"))
            		{  
        				StartTime=System.currentTimeMillis();
        				try
        				{
        				tcID = this.getClass().getSimpleName();
        				webDriver = launchbrowser(tcID);
        				BL = new ICRA_BusinessLogic_Niketan(webDriver,tcID);
        				PM=new ProviderManageMentAction_Niketan(webDriver,tcID);
        				PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        				Extent_Reporting.Log_Message("*****" + tcID + " is Started *****", test, webDriver);
        				BL.ICRA_Login();
        			    BL.SelectClient();
        			    //BL.ClickMenus();
        			    PBL.ICRA_Menu_Selection("");
        			    PM.clickProviderManagementTab();
        			    PM.CheckAllTabsInProviderDetailssection();
        			    PM.CheckAllFieldsinContactTab();
        			    PM.ChkWaterMarkContactTab();
        			    PM.EnterAllDetailsInContactTab();
        			    PM.CheckTextFieldsInTabs();
        			    Extent_Reporting.Log_Message("*****" + tcID + " is Ended *****", test, webDriver);
        			    EndTime=System.currentTimeMillis();
                        EndExcelReport1(EndTime,StartTime,tcID);
                        EndReport();                        
						}catch(Exception e){
							EndTime=System.currentTimeMillis();
	                        EndExcelReport(EndTime,StartTime,"Fail",tcID);
	                        EndReport();
						}
						

            			
            		}
        			
           		}
        }
		
	 }
	@AfterTest
	public void tearDown()
	{
		
		if(webDriver != null)
		{
			webDriver.quit();
		}
	}
}

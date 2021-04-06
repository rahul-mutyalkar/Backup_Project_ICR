package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;

import com.qa.BusinessLogic.ICRA_PNPExecption_BL_Dhanshri;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;

public class ICRA_PNPException extends DriverCalling {

	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;
    
	public static WebDriver webDriver = null;
	public static String tcID = null;

	ICRA_PNPExecption_BL_Dhanshri DBL = null;
	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;



	@Test
	public void TC_ICRA_PNPException() throws Throwable {
		try {
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
                		tcID = sheet.getRow(j).getCell(1).toString();
                		webDriver = launchbrowser(tcID);
        				DBL = new ICRA_PNPExecption_BL_Dhanshri(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        						  
                		BL.ICRA_Login();
                		//BL.Click_On_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
            			
            			
            			
            			
            			if(tcID.equalsIgnoreCase("Verify send functionality"))
              			{
            				DBL.SelectProject();
            				
            				DBL.SendChase();
            				DBL.Validation();
              				
              			}
            			if(tcID.equalsIgnoreCase("Verify Export Excel"))
              			{
            				DBL.SelectProject();
            				DBL.ExportToExcel();
            				
              				
              			}
            			

            			if(tcID.equalsIgnoreCase("Verify Release functionality"))
              			{
            				DBL.SelectProject();
            				DBL.ReleaseChase();
            				DBL.Validation();
              				
              			}
            			
            			if(tcID.equalsIgnoreCase("Verify send functionality without selecting checkbox"))
              			{
            				DBL.SelectProject();
            				DBL.SendChaseWSCB();
            				//DBL.ValidateWSCB();
              				
              			}
            			
            			
            			if(tcID.equalsIgnoreCase("Verify Release functionality without selecting checkbox"))
              			{
            				DBL.SelectProject();
            				DBL.ReleaseChaseWSCB();
            				DBL.ValidateWSCB();
              				
              			}
            			
            			if(tcID.equalsIgnoreCase("Verify send functionality without Resolution Note"))
              			{
            				DBL.SelectProject();
            				DBL.SendChaseWRN();
            				DBL.ValidateWRN();
              				
              			}
            			
            			
            			if(tcID.equalsIgnoreCase("Verify Release functionality without Resolution Note"))
              			{
            				DBL.SelectProject();
            				DBL.ReleaseChaseWRN();
            				DBL.ValidateWRN();
              				
              			}
            			
            			if(tcID.equalsIgnoreCase("Verify send functionality without Selecting anything"))
              			{
            				DBL.SelectProject();
            				DBL.SendChaseWAD();
            				DBL.ValidateWAD();
              				
              			}
            			
            			
            			if(tcID.equalsIgnoreCase("Verify Release functionality without Selecting anything"))
              			{
            				DBL.SelectProject();
            				DBL.ReleaseChaseWAD();
            				DBL.ValidateWAD();
              				
              			}
            			if(tcID.equalsIgnoreCase("Verify the Filter for table 1"))
              			{
            				DBL.SelectProject();
            				//DBL.FilterTB1();
            				DBL.DFilter();
            				
              			}
            			if(tcID.equalsIgnoreCase("Verify the Filter for table 2"))
              			{
            				DBL.SelectProject();
            				DBL.FilterTB2();
              				
              			}
            			
            			if(tcID.contains("Verify the Filter for table 1 of PNP Sent To Client"))
              			{
            				DBL.SelectProject();
            				DBL.PNPSent2Client();
            				DBL.DFilter();
            				//DBL.FilterTB1();
              				
              			}
            			if(tcID.equalsIgnoreCase("Verify the Filter for table 2 of PNP Sent To Client"))
              			{
            				DBL.SelectProject();
            				DBL.PNPSent2Client();
            				           				
            				DBL.FilterTB2();
              				
              			}
            			
            			if(tcID.equalsIgnoreCase("Verify the Filter for table 1 of PNP Client Response"))
              			{
            				DBL.SelectProject();
            				DBL.PNPclientResponse();
            				DBL.DFilter();
            				//DBL.FilterTB1();
              				
              			}
            			if(tcID.equalsIgnoreCase("Verify the Filter for table 2 of PNP Client Response"))
              			{
            				DBL.SelectProject();
            				DBL.PNPclientResponse();
            				           				
            				DBL.FilterTB2();
              				
              			}
            			
            			else if(tcID.equalsIgnoreCase("Verify the export to excel functionality"))
              			{
            				DBL.SelectProject();
            				DBL.ExportToExcel();
              			}  
            			EndTime=System.currentTimeMillis();
                        EndExcelReport1(EndTime,StartTime,tcID);
                        EndReport();
						}
                  		catch(Exception e)
                  		{
							EndTime=System.currentTimeMillis();
	                        EndExcelReport(EndTime,StartTime,"Fail",tcID);
	                        EndReport();
						}
                  	}
                  	

                }
            } 

            			//TODO Test Case Step Function
            		} catch (Exception e) {
            			System.out.println(e);
            		}
            	}
	@AfterTest
	public void CloseDriver()
	{
       if(webDriver != null)
        {	
         webDriver.quit();
        } 
	}
}

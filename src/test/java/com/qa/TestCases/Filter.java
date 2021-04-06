package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.AddressRollup_Logic;
import com.qa.BusinessLogic.ICRA_BL_Intake_Dhanshri;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

public class Filter extends DriverCalling{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	public static String startTime;
    public static String endTime;
    Long StartTime;
    Long EndTime;
    
	public static WebDriver webDriver = null;
	public static String tcID = null;
	AddressRollup_Logic ABL = null;
	ICRA_BL_Intake_Dhanshri DBL = null;
	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	public static String Button = null;



	@Test
	public void TC_Filter() throws Throwable {
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
                		
                		startTime = JavaUtilities.datetime("dd/MM/yyyy HH:mm:ss");
        				webDriver = launchbrowser(tcID);
        				ABL = new AddressRollup_Logic(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        				DBL = new ICRA_BL_Intake_Dhanshri(webDriver,tcID);  
        				BL.ICRA_Login();
                		//BL.Click_On_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
      				    ABL.Projectsubmit();
      				    
      				    if(tcID.equalsIgnoreCase("Verify_PreviousNext")) 
  				        {	
      				    	ABL.ClickFirstAddress();
      				        ABL.Previous_Next_Untouched();	
  				        }
      				  if(tcID.equalsIgnoreCase("Verify_PDF")) 
				        {	
      					    ABL.ClickFirstAddress();
      					    ABL.PrintBtn();
    				    	DBL.gotofirstpage();
				        }
      				    
      				   if(tcID.equalsIgnoreCase("Verify_AddressRollFilter_Untouched")) 
				        {	
    				        ABL.AddressIDFilter();	
    				        ABL.TotalchaseFilter();
    				        ABL.ProviderFilter();
    				        ABL.Adress1Filter();
    				        //ABL.Adress2Filter();
    				        ABL.CityFilter();
    				        ABL.StateFilter();
    				        ABL.ZipFilter();
    				        //ABL.ContactFilter();
    				        //ABL.FaxFilter();
    				        //ABL.EmailFilter();
				        }
      				 if(tcID.equalsIgnoreCase("Verify_AddressRollFilter_Inprocess")) 
				        {
      					ABL.InprocessTAB();
 				        ABL.AddressIDFilter();	
 				        ABL.TotalchaseFilter();
 				        ABL.ProviderFilter();
 				        ABL.Adress1Filter();
 				        ABL.Adress2Filter();
 				        ABL.CityFilter();
 				        ABL.StateFilter();
 				        ABL.ZipFilter();
 				        ABL.ContactFilter();
 				        ABL.FaxFilter();
 				        ABL.EmailFilter();
 				        ABL.LastCallFilter();
 				        ABL.StatusFilter();
 				        ABL.Call_DispositionFilter();
 				        ABL.Follow_up_DateFilter();
				        }
      				 
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

			//TODO Test Case Step Function
		} catch (Exception e) {
			System.out.println(e);
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

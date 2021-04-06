package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.AddressRollup_Logic;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;

public class Address_Contact extends DriverCalling{
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

	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	
	public static String Button = null;



	@Test
	public void TC_Address_Contact() throws Throwable {
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
        				ABL = new AddressRollup_Logic(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		BL.ICRA_Login();
                		//BL.Click_On_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
      				    ABL.Projectsubmit();
      				    ABL.ClickFirstAddress();
      				    ABL.ProviderDetailsTab();
      				    if(tcID.equalsIgnoreCase("Verify_ContactValidation")) 
  				        {
      				    	
      				    	ABL.AddContactValidation();
      				        ABL.Contact_Watermark();
      				    	
  				        }
      				  if(tcID.equalsIgnoreCase("Verify_Contact")) 
				        {
      					    ABL.AddContactPrimary();
      					    ABL.EditContact();
      					    ABL.AddContact();
      					    ABL.ViewContact();
      					    ABL.Contact_Delete();
				        }
      				if(tcID.equalsIgnoreCase("Verify_AddressValidation")) 
			        {
      					//ABL.Address_Validation();
      					ABL.Address_Watermark();
			        }
      				if(tcID.equalsIgnoreCase("Verify_Address")) 
			        {
      					ABL.AddAddress();
      					ABL.EditAddress();
			        }
      				if(tcID.equalsIgnoreCase("Verify_NPPES")) 
			        {
      					ABL.NPPES_Watermark();
      					ABL.NPPES_Search();
			        }
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
	public void CloseDriver()
	{
       if(webDriver != null)
        {	
         webDriver.quit();
        } 
	}
	
	
}

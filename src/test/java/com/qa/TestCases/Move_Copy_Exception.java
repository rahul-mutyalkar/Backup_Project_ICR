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

public class Move_Copy_Exception extends DriverCalling{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;

	public static WebDriver webDriver = null;
	public static String tcID = null;
	AddressRollup_Logic ABL = null;

	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	public static String Button = null;



	@Test
	public void TC_Move_Copy_Exception() throws Throwable {
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
      				    if(tcID.equalsIgnoreCase("Verify_Move_Copy")) 
  				        {
      				    	ABL.Move_Copy();
  				        }
      				    if(tcID.equalsIgnoreCase("Verify_MoveSearch")) 
				        {
      				    	Button="Move";
      				        ABL.ClickFirstAddress();
      				    	ABL.ChaseDetailsTab();
      				    	ABL.GlobalSearch();
      				    	ABL.Checkbox1();
      				    	ABL.Move_Button();				 
      				    	ABL.Move_Copy_Watermark();
    				    	ABL.Move_Copy_SearchValidation(Button);
				        }
      				    if(tcID.equalsIgnoreCase("Verify_CopySearch")) 
				        {
      				    	Button="Copy";
      				        ABL.ClickFirstAddress();
      				    	ABL.ChaseDetailsTab();
      				    	ABL.GlobalSearch();
      				    	ABL.Checkbox1(); 
      				    	ABL.Copy_Button();      				    	
      				    	ABL.Move_Copy_Watermark();
      				    	ABL.Move_Copy_SearchValidation(Button);
				        }
      				    if(tcID.equalsIgnoreCase("Verify_Chase_Exception")) 
				        {
      				    	ABL.ClickFirstAddress();
       				    	ABL.ChaseDetailsTab();
       				    	ABL.GlobalSearch();
      				        ABL.Exception();
				        }
      				  if(tcID.equalsIgnoreCase("Verify_Address_Exception")) 
				        {
    				    	ABL.ClickFirstAddress();
     				    	ABL.ChaseDetailsTab();
     				    	ABL.GlobalSearch();
    				        ABL.Exception();
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

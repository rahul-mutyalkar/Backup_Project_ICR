package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.ICRA_BL_Intake_Dhanshri;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.BusinessLogic.RecordQAAction_Niketan;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;

public class RecordQA_PDFFunction extends DriverCalling
{
	static XSSFWorkbook wb;
	  static XSSFSheet sheet;
	  static File file;
	  static FileInputStream fis;
	    
	  
	  public static String tcID = null;
	  ICRA_BusinessLogic_Niketan BL=null;
	  RecordQAAction_Niketan  RQ=null;
	  ICRA_BusinessLogic_Priyanka PBL=null;
	  ICRA_BL_Intake_Dhanshri DBL=null;
	  int a=0;
	  String Pdf_TotalPages1="0";
	  boolean status;
	  String chase;
	  Long StartTime;
	  Long EndTime;
	  
	 

	  @Test
	  public void RecordQATestflow() throws Throwable
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
	        		tcID = sheet.getRow(j).getCell(1).toString();
	               driver=launchbrowser(tcID);
	               Extent_Reporting.Log_Message("*****" + tcID + " is Started *****", test, driver);
	               BL = new ICRA_BusinessLogic_Niketan(driver,tcID);
	               RQ = new RecordQAAction_Niketan(driver,tcID);
	               PBL=new ICRA_BusinessLogic_Priyanka(driver,tcID);
	               DBL = new ICRA_BL_Intake_Dhanshri(driver,tcID);  
	               BL.ICRA_Login();
	               BL.SelectClient();
	               BL.PageLoad(1000, 20000000);
	               PBL.ICRA_Menu_Selection("");
	               BL.PageLoad(2000,30000000);
	               RQ.ClkDateReceviedCol();
	        	   chase=RQ.GetChaseForDeletePag();	        	
	               RQ.SendTxtGolbalFilter(chase);
	               Thread.sleep(4000);
	               String NumberOfPages=RQ.GetNoOfPages();
	               Thread.sleep(4000); 
	               RQ.ClkChase(); 
	               RQ.ChkPDFOpenOrNot();
	               driver.switchTo().defaultContent();
	               DBL.Zoomin();
	               DBL.Zoomout();
	               BL.RefreshPage();
	               RQ.SwitchPDFFrame();	               
	               RQ.RotatePDFCW();
	               RQ.RotatePDFCCW();
	               RQ.GotoLastPge(NumberOfPages);
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ClkPDFTools();
	               RQ.GotoFirstPge();
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ClkPDFTools();
	               RQ.HorizontalScrolling();
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();	 
	               RQ.ClkPDFTools();
	               RQ.VerticalScrolling();
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ClkPDFTools();
	               RQ.ChkSpread("Odd");
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ClkPDFTools();
	               RQ.ChkSpread("No spread");
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ClkPDFTools();
	               RQ.ChkSpread("even");
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ClkPDFTools();
	               RQ.ChkPDFDocProp();
	               driver.switchTo().defaultContent();
	               RQ.SwitchPDFFrame();
	               RQ.ChkThumbnailFunctionPDF();
	               RQ.ClkPDFTools();
	               RQ.PresentationMode(); 
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
     }
 @AfterTest
 public void tearDown()
 {
	if(driver != null)
     {
      driver.quit();
     } 
 }
}

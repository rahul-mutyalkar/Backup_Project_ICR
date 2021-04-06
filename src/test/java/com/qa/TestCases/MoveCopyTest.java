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
import com.qa.BusinessLogic.RecordQAAction_Niketan;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.Extent_Reporting;

public class MoveCopyTest extends DriverCalling
{
  static XSSFWorkbook wb;
  static XSSFSheet sheet;
  static File file;
  static FileInputStream fis;
    
  public static WebDriver webDriver = null;
  public static String tcID = null;
  ICRA_BusinessLogic_Niketan BL=null;
  RecordQAAction_Niketan  RQ=null;
  ICRA_BusinessLogic_Priyanka PBL=null;
  int a=0;
  String Pdf_TotalPages1="0";
  Long StartTime;
  Long EndTime;

  @Test
  public void MoveCopyTestflow() throws Throwable
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
        	   log.info(tcID);
               driver=launchbrowser(tcID);
               Extent_Reporting.Log_Message("*****" + tcID + " is Started *****", test, driver);
               BL = new ICRA_BusinessLogic_Niketan(driver,tcID);
               RQ = new RecordQAAction_Niketan(driver,tcID);
               PBL=new ICRA_BusinessLogic_Priyanka(driver,tcID);
               BL.ICRA_Login();
               BL.SelectClient();
               BL.PageLoad(1000, 20000000);
               PBL.ICRA_Menu_Selection("");
               if(tcID.contains("Move")||tcID.contains("Copy"))
               {
                 RQ.ChkGridColmsDtaRecordQA();
                 BL.RefreshPage();
                 RQ.ClkDateReceviedCol();
            	 String chase=RQ.GetChaseId();
            	 RQ.SendTxtGolbalFilter(chase);
                 String NoPage=RQ.GetNoOfPages();
                 BL.RefreshPage();
                 RQ.ClkDateReceviedCol();
                 String chase1=RQ.GetChaseId1(chase);
                 RQ.SendTxtGolbalFilter(chase1);
                 String NoPage1=RQ.GetNoOfPages();                                    
                 Extent_Reporting.Log_Message("The old chase for move or copy:" + chase,test,driver);
                 Extent_Reporting.Log_Message("Total pages of old chase in grid before move or copy:" + NoPage,test,driver);                
                 Extent_Reporting.Log_Message("The new chase for move or copy:" + chase1,test,driver);                 
                 Extent_Reporting.Log_Message("Total pages of new chase in grid before move or copy:" + NoPage1,test,driver);
                 String[] Mname=RQ.GetMemName().split(",");
                 String[] Pname=RQ.GetProvName().split(",");
                 BL.RefreshPage();
                 RQ.SendTxtGolbalFilter(chase);
                 RQ.ClkChase();
                 RQ.ChkPDFOpenOrNot();
                 driver.switchTo().defaultContent();
                 BL.PageLoad(1000, 40000000);
                 String Pdf_TotalPages=RQ.GetMaxPageNo_Chase();
                 driver.switchTo().defaultContent();                
                 RQ.ChkMandMsg_FillDtaMoveCopy(Mname[0], Pname[0],chase1);
                 Extent_Reporting.Log_Message("Filled all data",test,driver);
                 RQ.ClkMoveCopy_MoveWin_ChkMsg(); 
                 Extent_Reporting.Log_Message("Clicked move and checked alert",test,driver);
                 Pdf_TotalPages1=RQ.GetMaxPageNo_Chase();
                 if(tcID.contains("Move"))
                 {	
                   a=Integer.parseInt(Pdf_TotalPages)-1;                  
                 }
                 else if(tcID.contains("Copy"))
                 {
                   a=Integer.parseInt(Pdf_TotalPages);                   
                 }
                 Extent_Reporting.Log_Message("Total PDF pages before move or copy inside chase" + Pdf_TotalPages,test,driver);
                 Extent_Reporting.Log_Message("Total PDF pages after move or copy inside chase" + Pdf_TotalPages1,test,driver);
                 Extent_Reporting.Log_Message("Checking of count of pdf pages inside chase after move or copy",test,driver); 
                 RQ.ChkCnt(a, Pdf_TotalPages1,"Pdf_Cnt","Page count correct","Page count not correct");
                 Extent_Reporting.Log_Message("Checked count of pdf pages inside old chase after move or copy",test,driver);  
                 driver.switchTo().defaultContent();
                 BL.PageLoad(2000,30000000);
                 BL.ClickWelCmeUser();
                 BL.ICRA_Logout();
                 BL.ICRA_Login();
                 BL.SelectClient();
                 BL.PageLoad(1000,20000000);
                 PBL.ICRA_Menu_Selection("");
                 RQ.SendTxtGolbalFilter(chase);
                 String NoPage2=RQ.GetNoOfPages();                
                 Extent_Reporting.Log_Message("Total Pages in grid of old chase after move or copy:"+ NoPage2,test,driver); 
                 if(tcID.contains("Move"))
                 {	
                   a=Integer.parseInt(NoPage)-1;                  			 
                 }
                 else if(tcID.contains("Copy"))
                 {
                   a=Integer.parseInt(NoPage);                    			
                 }  
                 Extent_Reporting.Log_Message("Checking of total count of pages in grid for old chase",test,driver); 
                 RQ.ChkCnt(a, NoPage2,"PageNo","Page count correct","Page count not correct");
                 Extent_Reporting.Log_Message("Checked total count of pages in grid for old chase",test,driver); 
                 BL.RefreshPage();
                 RQ.SendTxtGolbalFilter(chase1);
                 String NoPage4=RQ.GetNoOfPages();
                 Extent_Reporting.Log_Message("Total Pages in grid of new chase after move or copy:"+ NoPage4,test,driver); 
                 if(tcID.contains("Move"))
                 {	
                   a=Integer.parseInt(NoPage1)+1;                  			 
                 }
                 else if(tcID.contains("Copy"))
                 {
                   a=Integer.parseInt(NoPage1)+1;  
                 }
                 Extent_Reporting.Log_Message("Checking of total count of pages in grid for New chase",test,driver);
                 RQ.ChkCnt(a, NoPage4,"PageNo","Page count correct","Page count not correct"); 
                 Extent_Reporting.Log_Message("Checked total count of pages in grid for New chase",test,driver);
               }
                 Extent_Reporting.Log_Message("***************" + tcID + " is Ended ***************", test, driver);
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
		 if(webDriver != null)
	     {
	        webDriver.quit();
	     }
	}	
}



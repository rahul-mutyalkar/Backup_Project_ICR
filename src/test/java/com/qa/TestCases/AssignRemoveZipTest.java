package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.qa.BusinessLogic.AddressAllocationActions_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Niketan;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;

public class AssignRemoveZipTest extends DriverCalling
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
	String[] ZipCntHeader;
	String[] AdrCntHeader;
	String[] ChaseCntHeader;
	String[] TtlAdrChaseCnt;
	String[] CodeDetChild;
	String[] ZipCntHeader1;
	String[] AdrCntHeader1;
	String[] ChaseCntHeader1;
	String[] Zipdet;
	String[] TtlAdrChaseCnt1;
	String[] chcnt;
	
	
	@Test
	public void AssignRemoZipTest() throws Throwable
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
        				AL = new AddressAllocationActions_Niketan(webDriver,tcID);
        				PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
                		String Agent=ExcelHandling.GetExcelData(tcID, "Agent");
                		BL.ICRA_Login();
                		//BL.Click_On_Login();
            		    BL.SelectClient();
            			PBL.ICRA_Menu_Selection("");        				
        			    chcnt=AL.GetAdr_ChaseCntOfSumm(Agent);
        			    Zipdet=AL.AssignZip_ChkHdrCnt();
        			    Extent_Reporting.Log_Message("Zip id assigned and checked Header Count",test,webDriver);
        		        AL.ChkCodeInCodeTblAftrAssign();
        		        Extent_Reporting.Log_Message("Checked Zip Id in zip code table",test,driver);
        			    AL.ChkTtlCntInSum();
        			    Extent_Reporting.Log_Message("Checked total Untouch and Chase Count in Allocation Summary table",test,webDriver);	    
        			    AL.ChkIdDetailInSumTbl(Zipdet[1], Agent);
        			    BL.ClickWelCmeUser();
        			    BL.ICRA_Logout();
        			    BL.PageLoad(500,30000000);
        			    BL.ICRA_Login1();
        			    BL.SelectClient();
        			    BL.PageLoad(500, 20000000);
        			    BL.ClickMenus();
        			    BL.ClickAdrRollup();
        			    AL.ChkAdrRollUp(Zipdet[1]);        			 
        			    Extent_Reporting.Log_Message("Checked in RollUp screen",test,webDriver);   
        			    BL.ClickWelCmeUser();
        			    BL.ICRA_Logout();
        			    BL.PageLoad(500, 30000000);
        			    Extent_Reporting.Log_Message("*************** Assiging ZipCode Test Is Ended **********",test,webDriver);
        			    Extent_Reporting.Log_Message("*************** Remove ZipCode Test Is Started **********",test,webDriver);
        			    BL.ICRA_Login();
        			    BL.SelectClient();
        			    BL.ClickMenus();
        			    BL.PageLoad(500,10000000);	
        				ZipCntHeader=AL.GetZipCntOfHeader();
        				AdrCntHeader=AL.GetAdrCntOfHeader();
        				ChaseCntHeader=AL.GetChaseCntOfHeader();
        				TtlAdrChaseCnt=AL.GetAdr_ChaseCntOfSumm(Agent);
        				AL.ClickAgent(Agent);
        				CodeDetChild=AL.GetUntouchedChaseCnt(Zipdet[1]);
        			    AL.ClickRemove();
        			    AL.ChkChaseCntInRemoveWindow(CodeDetChild[0]);
        			    AL.ClkSbmtOfRemoveAndChkRemoveMsg();
        			    ZipCntHeader1=AL.GetZipCntOfHeader();
        				AdrCntHeader1=AL.GetAdrCntOfHeader();
        				ChaseCntHeader1=AL.GetChaseCntOfHeader();
        				TtlAdrChaseCnt1=AL.GetAdr_ChaseCntOfSumm(Agent);
        				ChkCntAftrRemove();
        				Extent_Reporting.Log_Message("Cheking in Code table....", test, webDriver);
        				AL.ChkChaseCntInCodeTblAftrRemove(Zipdet[1],CodeDetChild[0]);
        				Extent_Reporting.Log_Message("*************** Remove ZipCode Test Is Ended **********",test,webDriver);
        				Extent_Reporting.Log_Message("*****" + tcID + " is Ended *****", test, webDriver);	 
        				EndTime=System.currentTimeMillis();
                        EndExcelReport1(EndTime,StartTime,tcID);
                        EndReport();
						}
        				catch(Exception e)
        				{
							EndTime=System.currentTimeMillis();
	                        EndExcelReport(EndTime,StartTime,"Fail",tcID);
	                        EndReport();
	                        e.printStackTrace();
						}
            		}

            		
           		}
           		}
        
	}
	
	public void ChkCntAftrRemove() throws NumberFormatException, Exception
	{
		Extent_Reporting.Log_Message("Zip Count in header before remove operation:"+ ZipCntHeader[1],test,webDriver);
		Extent_Reporting.Log_Message("Address Count in header before remove operation:"+ AdrCntHeader[1],test,webDriver);
		Extent_Reporting.Log_Message("Chase Count in header before remove operation:"+ChaseCntHeader[1],test,webDriver);
		Extent_Reporting.Log_Message("Zip Count in header after remove operation:"+ ZipCntHeader1[1],test,webDriver);
		Extent_Reporting.Log_Message("Address Count in header after remove operation:"+ AdrCntHeader1[1],test,webDriver);
		Extent_Reporting.Log_Message("Chase Count in header after remove operation:"+ChaseCntHeader1[1],test,webDriver);		
		
		Extent_Reporting.Log_Message("Total Untouch Address Count In Summary Table before add:"+chcnt[0],test,webDriver);
		Extent_Reporting.Log_Message("Total Chase Count In Summary Table Before add:"+chcnt[1],test,webDriver);
		Extent_Reporting.Log_Message("Total Untouch Address Count In Summary Table Before Remove is:"+TtlAdrChaseCnt[0],test,webDriver);
		Extent_Reporting.Log_Message("Total Chase Count In Summary Table Before Remove is:"+TtlAdrChaseCnt[1],test,webDriver);
		
		Extent_Reporting.Log_Message("Chase Count of individual code In Summary table before remove is:"+CodeDetChild[0],test,webDriver);
		Extent_Reporting.Log_Message("Total Untouch Address Count In Summary Table After Remove is:"+TtlAdrChaseCnt1[0],test,webDriver);
		Extent_Reporting.Log_Message("Total Chase Count In Summary Table After Remove is:"+TtlAdrChaseCnt1[1],test,webDriver);
		
	   //Validating Count Of Zip Count of Header.
	   int x=Integer.parseInt(ZipCntHeader[1].trim())+1; //Zip Count Before addition +1 and total stored in x.
	    //Latest Zip Count==x
       AL.ChkCnt(Integer.parseInt(ZipCntHeader1[1].trim()),x,"ZipCntHdr_AfterRemove","zip count in header is correct after remove","zip count in header is not correct after remove");
       
       //Validating Count Of Address Count of Header.
       //Address Count Before addition +Total AddressCount Of zip code of summary table;
       int y=Integer.parseInt(AdrCntHeader[1].trim())+1;  //Stored in y
       //Latest Address Count==y
       AL.ChkCnt(Integer.parseInt(AdrCntHeader1[1].trim()),y,"AdrCntHdr_AfterRemove",
				"Address count in header is correct after remove","Address count in header is not correct after remove");
       //Validating Count Of Chase Count of Header
       //Chase Count Before addition +Total Chase Count Of zip code of summary table;
       int z=Integer.parseInt(ChaseCntHeader[1].trim())+Integer.parseInt(CodeDetChild[0]);  //stored in z
       AL.ChkCnt(Integer.parseInt(ChaseCntHeader1[1].trim()),z,"ChaCntHdr_AfterRemove","Chase count in header is correct after remove","Chase count in header is not correct after remove");
       
      //Validating Total Untouch Address Count of Summary
      //Total Untouch Address Count before remove-1=Latest Untouched count;     
       int k=Integer.parseInt(TtlAdrChaseCnt[0])-1;
	   AL.ChkCnt(Integer.parseInt(TtlAdrChaseCnt1[0]),k,"UntouchAdrCntSumm_AfterRemove",
				"Untouch address count in summary is correct after remove","Untouch address count in summary is not correct after remove");
	 //Validating Total Chases Count of Summary
	 //Latest Total Chase count =Original chase count which was before remove - Chase Count Of addressid;
	   int j=Integer.parseInt(TtlAdrChaseCnt[1])-Integer.parseInt(CodeDetChild[0]);
	   AL.ChkCnt(Integer.parseInt(TtlAdrChaseCnt1[1]),j,"ChaseCntSumm_AfterRemove",
				"Total chase count in summary is correct after remove","Total chase count in summary is not correct after remove");   
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

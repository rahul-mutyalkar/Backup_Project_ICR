package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.BusinessLogic.ICRA_BL_Intake_Dhanshri;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;

import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;

public class ICRA_Intake_Dhanshri extends DriverCalling {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	Long StartTime;
    Long EndTime;
    
	public static WebDriver webDriver = null;
	public static String tcID = null;

	ICRA_BL_Intake_Dhanshri DBL = null;
	ICRA_BusinessLogic_Pooja BL = null;
	ICRA_BusinessLogic_Priyanka PBL = null;



	@Test
	public void TC_ICRA_Intake_Dhanshri() throws Throwable {
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
        				DBL = new ICRA_BL_Intake_Dhanshri(webDriver,tcID);  
        				BL = new ICRA_BusinessLogic_Pooja(webDriver,tcID);
                		PBL = new ICRA_BusinessLogic_Priyanka(webDriver,tcID);
        				BL.ICRA_Login();
                		//BL.Click_On_Login();
            			PBL.ICRA_Client_Select();
            			PBL.ICRA_Menu_Selection("");
      

            			if(tcID.equalsIgnoreCase("Verify the pdf is access to login user")) {
            				
            				//DBL.accesspdf();
            				DBL.AccesspdfHoldtab();
            				//DBL.clickOnChaseid();
            			
            				
            				}
	                          else if(tcID.equalsIgnoreCase("Verify the pdf is not  access to login user when it locked by other user")) {
	                         
	                        	  DBL.pdfCheck();
	                          }
            			
	                          else if(tcID.equalsIgnoreCase("Verify the global Filter")) {
	                        	
	                        	DBL.GlobalFilt();
	                          }
	                          else if(tcID.equalsIgnoreCase("Verify the total count of pdf")) {
	                        	  
	                        	 
	                        	  DBL.verifytotalcount();
	  	                        
	                          }
	                          else if(tcID.equalsIgnoreCase("verify pdf functionality")) {
	                        	  DBL.accesspdf();
	                                                    	                        	
	                        	  DBL.gotofirstpage();
		                        	
		                          }
            			
            			
						
						  else if(tcID.equalsIgnoreCase("Verify  no of pages")) {
							
						  DBL.NoofPages();
						  
						  }
						 
	                          else if(tcID.equalsIgnoreCase("verify_finishbuttonfunctionality with Chase not Found")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.FinishWCNF();
	                          }
	                          else if(tcID.equalsIgnoreCase("verify_finishbuttonfunctionality with Duplicate Document")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.FinishWDD();
	                          }
            			
	                          else if(tcID.equalsIgnoreCase("Verify Reoder Functionality")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.Reorder();
	                          }
	                          else if(tcID.equalsIgnoreCase("verify Hold functionlity")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.Hold();
	                          }
            			
            			
            			
	                          else if(tcID.equalsIgnoreCase("Verify Reoder Functionality with out any value")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.ReorderWAV();
	                          }
	                          else if(tcID.equalsIgnoreCase("verify Hold functionlity with out any value")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.HoldWAV();
	                          }
            			

	                         
            			
	                          else if(tcID.equalsIgnoreCase("verify that clear button functionality")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.clearButton();
	                          }
            			

	                          else if(tcID.equalsIgnoreCase("verify Spilt page functionality with all member Details")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.SearchByAllMemberDtails();
	                        	  DBL.Splitpage();
	                        	  
	                          }
	                          else if(tcID.equalsIgnoreCase("verify Spilt page functionality with all provider Details")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.SearchByAllProviderDtails();
	                        	  DBL.Splitpage();
	                          }
	                          else if(tcID.equalsIgnoreCase("verify Search functionality with all member Details")) {
	                        	  DBL.accesspdf(); 
	                        	DBL.memberFnameSerach();
	                        	 DBL.clickOnChaseid();
	                        	DBL.clearButton();
	                        	DBL.memberLnameSerach();
	                        	 DBL.clickOnChaseid();
	                        	DBL.clearButton();
	                        	DBL.memberDOBSerach();
	                        	 DBL.clickOnChaseid();
	                        	  
	                          }
	                          else if(tcID.equalsIgnoreCase("verify Search functionality with all provider Details")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.searchPfirstname();
	                        	  DBL.clickOnChaseid();
	                        	  DBL.clearButton();
	                        	  DBL.searchplastname();
	                        	  DBL.clickOnChaseid();
	                        	  DBL.clearButton();
	                        	  DBL.searchPNPI();
	                        	  DBL.clickOnChaseid();
	                        	  DBL.clearButton();
	                        	  DBL.searchPAddress();
	                        	  DBL.clickOnChaseid();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("verify_finishbuttonfunctionality")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.verify_finishbuttonfunctionality();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("verifynumberofpages")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.verifynumberofpages();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("Verify_Projectdetails")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.Verify_Projectdetails();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("Verify_View_Originallink")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.verifynumberofpages();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("verify_ChaseNotFoundFunctionality")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.verify_ChaseNotFoundFunctionality();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("verify_DuplicateDocumentFunctionality")) {
	                        	  DBL.accesspdf(); 
	                        	  DBL.verify_DuplicateDocumentFunctionality();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("Verify the pdf is access to login user for Hold Tab")) {
            				
            				            				DBL.AccesspdfHoldtab();
            				
            			
            				
            				}
	                          else if(tcID.equalsIgnoreCase("Verify the pdf is not  access to login user when it locked by other user for Hold Tab")) {
	                         
	                        	  DBL.pdfCheck();
	                          }
            			
	                          else if(tcID.equalsIgnoreCase("Verify the global Filter for Hold Tab")) {
	                        	
	                        	DBL.GlobalFilt();
	                          }
	                          else if(tcID.equalsIgnoreCase("Verify the total count of pdf for Hold Tab")) {
	                        	  
	                        	 
	                        	  DBL.verifytotalcount();
	  	                        
	                          }
	                          else if(tcID.equalsIgnoreCase("verify pdf functionality  for Hold Tab")) {
	                        		DBL.AccesspdfHoldtab();
	                                                    	                        	
	                        	  DBL.gotofirstpage();
		                        	
		                          }
	                          else if(tcID.equalsIgnoreCase("verify Reorder functionlity  for Hold Tab")) {
	                        		DBL.AccesspdfHoldtab();
	                        		DBL.Reorder();
	                          }
            			
	                         
	                          else if(tcID.equalsIgnoreCase("verify Spilt page functionality with all member Details for Hold Tab")) {
	                        	  
	                        		DBL.AccesspdfHoldtab();
	                        		DBL.memberFnameSerach();
		                        	 DBL.clickOnChaseid();
		                        	DBL.clearButton();
		                        	DBL.memberLnameSerach();
		                        	 DBL.clickOnChaseid();
		                        	DBL.clearButton();
		                        	DBL.memberDOBSerach();
		                        	 DBL.clickOnChaseid();
	  	                        
	                          }
	                          else if(tcID.equalsIgnoreCase("verify Spilt page functionality with all provider Details For Hold tab")) {
	                        		DBL.AccesspdfHoldtab();
	                                                    	                        	
	                        		  
		                        	  DBL.searchPfirstname();
		                        	  DBL.clickOnChaseid();
		                        	  DBL.clearButton();
		                        	  DBL.searchplastname();
		                        	  DBL.clickOnChaseid();
		                        	  DBL.clearButton();
		                        	  DBL.searchPNPI();
		                        	  DBL.clickOnChaseid();
		                        	  DBL.clearButton();
		                        	  DBL.searchPAddress();
		                        	  DBL.clickOnChaseid();
		                        	
		                          }
	                          else if(tcID.equalsIgnoreCase("verify_finishbuttonfunctionality for Hold tab")) {
	                        	  DBL.AccesspdfHoldtab(); 
	                        	  DBL.verify_finishbuttonfunctionality();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("verify_ChaseNotFoundFunctionality for Hold tab")) {
	                        	  DBL.AccesspdfHoldtab(); 
	                        	  DBL.verify_ChaseNotFoundFunctionality();
	                        	
	                          }
	                          else if(tcID.equalsIgnoreCase("verify_DuplicateDocumentFunctionality for Hold tab")) {
	                        	  DBL.AccesspdfHoldtab();  
	                        	  DBL.verify_DuplicateDocumentFunctionality();
	                        	
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

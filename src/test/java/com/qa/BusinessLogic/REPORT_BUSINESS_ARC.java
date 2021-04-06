package com.qa.BusinessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.PageObjects.REPORT_PAGEOBJECT;
import com.qa.Utilities.DatabaseWork;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

public class REPORT_BUSINESS_ARC extends Extent_Reporting
{

	ElementAction action = new ElementAction();
	String TC_ID = null;	
	WebDriver driver;
	REPORT_PAGEOBJECT Rep; 
	String address2 = null;
	String newDate1 =null;
	DatabaseWork DBW = null; 
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;

	public REPORT_BUSINESS_ARC(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		Rep= new REPORT_PAGEOBJECT(driver);
		DBW = new DatabaseWork(driver, TC_ID);  
	}
	
	public void RunButton(){
		action.clickButton(Rep.Run, "Run Report");
		log.info("Run report is clicked");
	}
		
		
	public void Quality_Validation() throws Throwable{
		
		try {
			RunButton();
			if(Rep.ProjectSel.isDisplayed())
			{
			log.info("Project validation"+Rep.ProjectSel.getText());
			}
			if(Rep.AudSel.isDisplayed())
			{
			log.info("AudSel validation"+Rep.AudSel.getText());
			}
			if(Rep.CodSel.isDisplayed())
			{
			log.info("CodSel validation"+Rep.CodSel.getText());
			}
			if(Rep.ProjectSel.isDisplayed())
			{
			log.info("DataSel validation"+Rep.ProjectSel.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "Quality_Validation is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());

		}
	}
	public void Quality_Function() throws Throwable{
		
		try {
			action.clickButton(Rep.ProjectCombox, "ProjectCombox");
			WebElement Pro =driver.findElement(By.xpath("//li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "ProjectType")+"']/div[1]"));
			action.clickButton(Pro, " type is selectedproject");
			log.info("Project Type is selected");
			
			WebElement Aud =driver.findElement(By.xpath("//select[@id='ddlAuditee']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Auditte")+"')]"));	
			action.clickButton(Aud, "Select Auditte");
			
			WebElement DataTy =driver.findElement(By.xpath("//select[@id='ddlDateType']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "DataType")+"')]"));	
			action.clickButton(DataTy, "Select DataType");
			
			WebElement DataRa =driver.findElement(By.xpath("//select[@id='ddlDateRange']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "DateRan")+"')]"));	
			action.clickButton(DataRa, "Select DataRange");
			
			//submit run
			RunButton();
			//Verify Report and print message
			VerifyReport(Rep.Grid,Rep.Alert);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "Quality_Function is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());

		}//end catch
		
		
	}
	public void VerifyReport(WebElement Grid,WebElement Alert) throws Throwable
	    {
		try
		    {
		  if(Alert.isDisplayed())
		   {
			  //check db
			 // DBW.sqlDatabaseConnectionEstablish("172.30.54.99", "1433", "iCRA_Master", "nicra_test", "nicra_test@321!");
				   
				//String c=DBW.sqlQueryExecution(System.getProperty("user.dir") + "\\src\\tempfile.csv", "select * from [iCRA_CallCenter_ClientName].[dbo].[RetrievedChaseGLO] where StatusCode = '"+ExcelHandling.GetExcelData(TC_ID, "LoginUsername")+"' and ProjectID='"+ExcelHandling.GetExcelData(TC_ID, "LoginUsername")+"';");
		
  				  Extent_Reporting.Log_Pass(TC_ID, "No data available", test, driver);

			
		   }
		     }//end 1 try
		catch (Exception e) {
              if(Grid.isDisplayed())
              {
				  Extent_Reporting.Log_Pass(TC_ID, "Data is available ", test, driver);
	
              }//end if
              else
              {
				  Extent_Reporting.Log_Fail(TC_ID, "Grid is not displayed ", test, driver);
				  throw new Exception(e.getMessage());
              }//end else
		                    }//catch end
			
		}
	public void Intake_Function() throws Throwable{
		try {
			//click run report
			action.elementDisplayed(driver.findElement(By.xpath("//span[@id='sidebar_left_toggle']")));
			log.info("after element");
			action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'ProductionIntake')]")), "Frame switch");
			
			action.clickButton(Rep.IntakeRun, "Intake run");
			action.clickButton(Rep.Intakeok, "Intake accept alert");
			//date
			Rep.StartDate.clear();
  			action.inputText(Rep.StartDate, ExcelHandling.GetExcelData(TC_ID, "StartDate"), "Provide Start Date");
			//select filtervalue
			action.selectDDByText(Rep.Intakefil, ExcelHandling.GetExcelData(TC_ID, "Filterby"));
			action.clickButton(Rep.IntakeRun, "Intake run");
			//verify report
			try
		    {
		  if(Rep.Intakeok.isDisplayed())
		   {
			  //check db
			 // DBW.sqlDatabaseConnectionEstablish("172.30.54.99", "1433", "iCRA_Master", "nicra_test", "nicra_test@321!");
				   
				//String c=DBW.sqlQueryExecution(System.getProperty("user.dir") + "\\src\\tempfile.csv", "select * from [iCRA_CallCenter_ClientName].[dbo].[RetrievedChaseGLO] where StatusCode = '"+ExcelHandling.GetExcelData(TC_ID, "LoginUsername")+"' and ProjectID='"+ExcelHandling.GetExcelData(TC_ID, "LoginUsername")+"';");
		
  				  Extent_Reporting.Log_Pass(TC_ID, "No data available", test, driver);

			
		   }
		     }//end 2 try
		catch (Exception e) {
              if(Rep.Intakegrid.isDisplayed())
                  {
				  Extent_Reporting.Log_Pass(TC_ID, "Data is available ", test, driver);
	              String FirstheaderAppli=driver.findElement(By.xpath("//tr[1]/th[3]")).getText();
				  //ExcelDownload(Rep.IntakeExcel, FirstheaderAppli,1, 1);
                  }//end if
              else
                 {
				  Extent_Reporting.Log_Fail(TC_ID, "Grid is not displayed ", test, driver);

                 }//end else
		                    }//catch end

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "Intake_Function is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}//end catch
	}///end
	
      public void MANQuality_Function() throws Throwable{
		
		try {
			action.clickButton(Rep.ProjectCombox, "ProjectCombox");

			action.clickButton(Rep.ManProjComboAll, "ManProjComboAll");
			
			WebElement Pro =driver.findElement(By.xpath("//li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "ProjectType")+"']/div[1]"));
			action.clickButton(Pro, " type is selectedproject");
			log.info("Project Type is selected");
			
			WebElement Aud =driver.findElement(By.xpath("//select[@id='ddlAuditee']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Auditte")+"')]"));	
			action.clickButton(Aud, "Select Auditte");
			
			WebElement DataTy =driver.findElement(By.xpath("//select[@id='ddlDateType']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "DataType")+"')]"));	
			action.clickButton(DataTy, "Select DataType");
			
			WebElement DataRa =driver.findElement(By.xpath("//select[@id='ddlDateRange']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "DateRan")+"')]"));	
			action.clickButton(DataRa, "Select DataRange");
			
			WebElement dxcode =driver.findElement(By.xpath("//select[@id='ddlDxCodes']//option[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Dxcode")+"')]"));	
			action.clickButton(dxcode, "Select DataRange");
			
			//submit run
			RunButton();
			//Verify Report and print message
			VerifyReport(Rep.GridRev,Rep.Alert);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "Quality_Function is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}//end catch
		
	}//Main function

      public void RecordQA_Function() throws Throwable{
  		try {
  			//frame switch
  			action.elementDisplayed(driver.findElement(By.xpath("//span[@id='sidebar_left_toggle']")));
  			log.info("after element");
  			action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'ProductionQA')]")), "Frame switch");
  			
  			action.clickButton(Rep.IntakeRun, "Intake run");
  			action.clickButton(Rep.Intakeok, "Intake accept alert");
  			
  			action.clickButton(Rep.QAProjectCombo, "ProjectCombox");
			action.selectDDByText(Rep.QAProjectCombo, ExcelHandling.GetExcelData(TC_ID, "ProjectType"));
			log.info("Project Type is selected");
			
  			//select filtervalue
  			action.selectDDByText(Rep.Intakefil, ExcelHandling.GetExcelData(TC_ID, "Filterby"));
  			Rep.StartDate.clear();
  			action.inputText(Rep.StartDate, ExcelHandling.GetExcelData(TC_ID, "StartDate"), "Provide Start Date");
  			action.clickButton(Rep.IntakeRun, "Intake run");
  			//verify report
  			try
  		    {
  		  if(Rep.Intakeok.isDisplayed())
  		   {
    				  Extent_Reporting.Log_Pass(TC_ID, "No data available", test, driver);

  		   }
  		     }//end 2 try
  		catch (Exception e) {
                if(Rep.Intakegrid.isDisplayed())
                    {
  				  Extent_Reporting.Log_Pass(TC_ID, "Data is available ", test, driver);
  	
                    }//end if
                else
                   {
  				  Extent_Reporting.Log_Fail(TC_ID, "Grid is not displayed ", test, driver);

                   }//end else
  		                    }//catch end

  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			Extent_Reporting.Log_Fail(TC_ID, "Intake_Function is failed"+e.getMessage(), test, driver);
  			throw new Exception(e.getMessage());
  		}//end catch
  	}///end
  	
      public void ManHCC_Function() throws Throwable{
    	  
    	  try {
    		  
			//check validation
			  action.clickButton(Rep.Run, "Click on Run Report ");
			  log.info("Project Validation" +Rep.ProjectSel.getText());
			  log.info("Report for valiation" +Rep.ReportforVal.getText());
			 //select value in dropdown 
				action.clickButton(Rep.HCCProjectCombo, "ProjectCombox");
				action.selectDDByText(Rep.HCCProjectCombo, ExcelHandling.GetExcelData(TC_ID, "ProjectType"));
				log.info("Project Type is selected");
				action.clickButton(Rep.ReportforCombo, "ReportFor");
				action.selectDDByText(Rep.ReportforCombo, ExcelHandling.GetExcelData(TC_ID, "ReportFor"));
				action.clickButton(Rep.ReportonCombo, "ReportOn");
				action.selectDDByText(Rep.ReportonCombo, ExcelHandling.GetExcelData(TC_ID, "ReportOn"));
				action.clickButton(Rep.Run, "Click on Run Report ");
				  try
		  		    {
					  if(Rep.HCCchart.isDisplayed())
	                    {
	  				  Extent_Reporting.Log_Pass(TC_ID, "Chart is available ", test, driver);
	  	
	                    }//end if
		  		     }//end 2 try
		  		catch (Exception e) {
		                          Extent_Reporting.Log_Pass(TC_ID, "chart is not available ", test, driver);
		  	                        }//catch end
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
  			Extent_Reporting.Log_Fail(TC_ID, "ManHCC is failed"+e.getMessage(), test, driver);

			throw new Exception(e.getMessage());

		}//end catch

      }//end
      
      public void ExcelDownload(WebElement Excel,String FirstheaderAppli,int FirRow,int Downnfirstcell) throws Throwable{
    	  try {
    		  
    		  action .clickButton(Excel, "Click excel button");
			//File file = JavaUtilities.getTheNewestFile(System.getProperty("user.dir")+"\\Downloads", "xls");
			File file = JavaUtilities.getTheNewestFile(System.getProperty("user.dir")+"\\Downloads", "xlsx");
			log.info("EXcel file downloaded And File Location is......." + file.getAbsolutePath());
			String fi = file.toString();
			fis = new FileInputStream(fi);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			//String RowValueAppli = ExcelHandling.GetExcelData(TC_ID, "PNPI");
			String Row1 =sheet.getRow(FirRow).getCell(Downnfirstcell).toString();
			if(FirstheaderAppli.equalsIgnoreCase(Row1))
			{
                Extent_Reporting.Log_Pass(TC_ID, "First header match witt the downloaded excel ", test, driver);
			}else {
	  			Extent_Reporting.Log_Fail(TC_ID, "Application header is not matching with downloaded report", test, driver);

			      }
			FileOutputStream fo = new FileOutputStream(file);
			wb.write(fo);
			fo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}

      }//end main
      
      public void Retrival_Dashboard() throws Throwable
      {
    	  try {
			//check select all i.s selected or not
              Thread.sleep(3000);
  			action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'Retrieval')]")), "Frame switch");
  			action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'power')]")), "Frame switch");


    		  //action.clickButton( Rep.RetProject, "RetProject");
              action.WaitUntilDisplayed(Rep.Retselectallcheckbox);
			  if(!Rep.Retselectallcheckbox.isDisplayed()) 
			  {
					Extent_Reporting.Log_Fail(TC_ID, "Select All project is not displayed", test, driver);

			  }//endif
			  else {
			      Extent_Reporting.Log_Pass(TC_ID, "Select All project is displayed", test, driver);
			       }
			  //checkperiod
			  if(!Rep.RetPeriod.isDisplayed()) 
			  {
					Extent_Reporting.Log_Fail(TC_ID, "4 Weeks Period  is not displayed", test, driver);

			  }//endif
			  else {
			      Extent_Reporting.Log_Pass(TC_ID, "4 Weeks Period is displayed", test, driver);
			       }
			  //Check element is present
			  Retrival_Element(Rep.WeekSucc);
			  Retrival_Element(Rep.WeekCallTre);
			  Retrival_Element(Rep.WeekCallRate);
			  Retrival_Element(Rep.WeekCharRet);
			  Retrival_Element(Rep.WeekuCum);
			  Retrival_Element(Rep.WeekForecast);
	  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
  			Extent_Reporting.Log_Fail(TC_ID, "Retrival_Dashboard is failed"+e.getMessage(), test, driver);

			throw new Exception(e.getMessage());
		}
       }
      
      public void Agent_TotalCall_LINK() throws Throwable
      {
    	  try {
    		  FRAME_SWITCH();

			 //Check Link
			  Retrival_Reviewlink(Rep.Count,Rep.Countpage,Rep.BACK,Rep.Count_AgentFircol,8000);
			  Retrival_Reviewlink(Rep.TotCall,Rep.TotCallPage,Rep.BACKTotCallPage,Rep.TableFircolAddressid,9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "Agent_TotalCall_LINK is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
			
		}
		  
      }
      public void AVG_REC_LINK() throws Throwable
      {
    	  try {
    		  FRAME_SWITCH();
			 //Check Link

				  Retrival_Reviewlink(Rep.Loca,Rep.LocPage,Rep.BACK,Rep.TableFircolAddressid,15000);
				  Retrival_Reviewlink(Rep.RetChaCount,Rep.RetChaCountpage,Rep.BACK,Rep.TableFircolAddressid,20000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "AVG_REC_LINK is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
		  
      }
      
      public void PRO_ADD_TOU_LINK() throws Throwable
      {
    	  try {
    		  FRAME_SWITCH();
			 //Check Link
				Retrival_Reviewlink(Rep.ProTou,Rep.ProToupage,Rep.BACK,Rep.TableFircolAddressid,12000);
				  Retrival_Reviewlink(Rep.AddTou,Rep.AddToupage,Rep.BACK,Rep.TableFircolAddressid,20000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "PRO_ADD_TOU_LINK is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
		  
      }
      
      public void PROLO_SUCC_LINK() throws Throwable
      {
    	  try {
    		  FRAME_SWITCH();

			 //Check Link
				Retrival_Reviewlink(Rep.ProLoc,Rep.ProLocpage,Rep.BACK,Rep.TableFircolAddressid,15000);
				  Retrival_Reviewlink(Rep.SucCall,Rep.SucCallpage,Rep.BACK,Rep.TableFircolAddressid,20000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "PROLO_SUCC_LINK is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
		  
      }
      public void ESC_SCAN_LINK() throws Throwable
      {
    	  try {
    		  FRAME_SWITCH();

			 //Check Link
				  Retrival_Reviewlink(Rep.ESC,Rep.ESCpage,Rep.BACK,Rep.TableFircolAddressid,11000);
				  Retrival_Reviewlink(Rep.Scan,Rep.Scanpage,Rep.BACK,Rep.TableFircolChaseID,20000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "ESC_SCAN_LINK is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
			
		}
		  
      }
      
      public void RET_SCAN_REC_LINK() throws Throwable
      {
    	  try {
    		  FRAME_SWITCH();

			 //Check Link
				  Retrival_Reviewlink(Rep.RET,Rep.RETPage,Rep.BACK,Rep.TableFircolAddressid,5000);
				  Retrival_Reviewlink(Rep.INT,Rep.INTPage,Rep.BACK,Rep.TableFircolRole,20000);
				  Retrival_Reviewlink(Rep.Rec,Rep.RecPage,Rep.BACK,Rep.TableFircolRole,20000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail(TC_ID, "RET_SCAN_REC_LINK is failed"+e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		} 
		  
      }
		
      public void Retrival_Reviewlink(WebElement Link,WebElement page,WebElement back,WebElement Fircol,int wait) throws Throwable
      {
		  try {
			//agent count
			  Thread.sleep(8000);
			  action.WaitUntilDisplayed(Link);
			  action.JSclickButton(Link, "LINK is clicked");
			  log.info("LINK is clicked" );
			  Thread.sleep(wait);
			 
			  if(page.isDisplayed())
			  {
			      Extent_Reporting.Log_Pass(TC_ID, page.getText()+" is displayed", test, driver);
			      //Click on filter.
			      
			      Actions builder = new Actions(driver);
					builder.moveToElement(Fircol).build().perform();
	              action.JSclickButton(Fircol, "Click on first column of"+page.getText());
	              //check 3 tooltip should be dispaled
	                  if(Rep.TooltipFilter.isDisplayed())
	                  {
					      Extent_Reporting.Log_Pass(TC_ID,"TooltipFilter value is displayed", test, driver);
	                  }
	                  else if(Rep.TooltipFocus.isDisplayed())
	                  {
					      Extent_Reporting.Log_Pass(TC_ID, "Tooltip focus value is displayed", test, driver);

	                  }
	                  else if(Rep.TooltipMenu.isDisplayed())
	                  {
					      Extent_Reporting.Log_Pass(TC_ID, "Tooltip menu Filter value is displayed", test, driver);

	                  }
	                  else
	                  {
					      Extent_Reporting.Log_Fail(TC_ID, "Tool tip -filter,focus,menu is not displayed", test, driver);

	                  }
	              //checkfilter
	              action.JSclickButton(Rep.RetFilter, "Show/Hide filter is clicked");
	              if(Rep.Count_AgentFirfil.isDisplayed())
	                {
				      Extent_Reporting.Log_Pass(TC_ID, page.getText()+"First Filter value is displayed", test, driver);
	                }
	              else
	                {
				      Extent_Reporting.Log_Fail(TC_ID, page.getText()+"First Filter value is not displayed", test, driver);

	                }
	              //check on filter
			  }
			  else
			  {
			      Extent_Reporting.Log_Fail(TC_ID, page.getText()+" is not displayed", test, driver);

			  }
			 
			  //back button
			  action.JSclickButton(back, "back button is clicked");
			  Thread.sleep(8000);
			 // action.WaitUntilDisplayed(Rep.Dashboard);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
  			Extent_Reporting.Log_Fail(TC_ID, "Retrival_Reviewlink is failed"+e.getMessage(), test, driver);
  			throw new Exception(e.getMessage());

		}

      }
      
      public void FRAME_SWITCH() throws Throwable
      {
    	 
			Thread.sleep(12000);
			action.WaitUntilDisplayed(driver.findElement(By.xpath("//iframe[contains(@src,'Retrieval')]")));
			  action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'Retrieval')]")), "Frame switch");
				action.frameSwitch(driver.findElement(By.xpath("//iframe[contains(@src,'power')]")), "Frame switch");
      }

      
      public void Retrival_Element(WebElement Eleme) throws Throwable
      {
    	  try {
			if(Eleme.isDisplayed())
			  {
			      Extent_Reporting.Log_Pass(TC_ID, Eleme.getText()+" is displayed", test, driver);
			  }
			  else
			  {
			      Extent_Reporting.Log_Fail(TC_ID, Eleme.getText()+" is not displayed", test, driver);

			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
  			Extent_Reporting.Log_Fail(TC_ID, "Retrival_Element is failed"+e.getMessage(), test, driver);
  			throw new Exception(e.getMessage());
		} 
      }
}

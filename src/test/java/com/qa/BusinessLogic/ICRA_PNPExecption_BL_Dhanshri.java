package com.qa.BusinessLogic;



import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_PNPException_PO_Dhanshri;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

public class ICRA_PNPExecption_BL_Dhanshri extends Extent_Reporting {
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PNPException_PO_Dhanshri icra_elements; 
	String BatchnameCreation = null;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream fis;
	
	public ICRA_PNPExecption_BL_Dhanshri(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PNPException_PO_Dhanshri(driver);
		
	}
	public void ExportToExcel() throws Throwable
	{	

		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");

			Thread.sleep(1000);
			action.WaitUntilDisplayed(icra_elements.ExportToExcel);
			action.JSclickButton(icra_elements.ExportToExcel, "Export to Excel");
			Thread.sleep(1000);

			
			 file = JavaUtilities.getTheNewestFile(GlobalConstant.DownloadPath, "xlsx");
			log.info("File Recevied And File Location is......." + file.getAbsolutePath());
			String fi = file.toString();
			log.info("file"+fi);
			fis = new FileInputStream(fi);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			log.info("tested");
			
			List<WebElement> label = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
			  int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			  Row row = sheet.getRow(0);
			 
			  log.info("rowCount+1 "+rowCount+1 );
			  log.info("label.size() "+label.size());
			  log.info("row.getLastCellNum() "+row.getLastCellNum());
			  
			if(label.size()==rowCount+1 && row.getLastCellNum()==12 )
			{
				Extent_Reporting.Log_Pass(TC_ID, "File download successfully ", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "File downloadnot successfully ", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_Reporting.Log_Fail("MethodFailed", "ExportToExcel() failed "+ e.getMessage(), test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
	public void SelectProject() throws Throwable
	{
			
		try {
			action.WaitUntilDisplayed(icra_elements.projectDD);
			
			action.selectDDByIndex(icra_elements.projectDD,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SelectProject() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		
	}

	
	public void SendChase() throws Throwable
	{
			
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			if(action.isElementDisplayed(icra_elements.Checkbox, "Checkbox"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			action.WaitUntilDisplayed(icra_elements.Checkbox);
			
			action.JSclickButton(icra_elements.Checkbox, "Click On Checkbox");
				
			action.inputText(icra_elements.ResolutionNote, ExcelHandling.GetExcelData(TC_ID, "Resolution Note"), "Enter Resolution Note ");
				
			action.JSclickButton(icra_elements.SendButton, "Click On Send Button");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SendChase() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		
	}
	
	public void SendChaseWRN() throws Throwable //Without resolution note click on send button
	{	
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			if(action.isElementDisplayed(icra_elements.Checkbox, "Checkbox"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			action.WaitUntilDisplayed(icra_elements.Checkbox);
			
			action.JSclickButton(icra_elements.Checkbox, "Click On Checkbox");
					
			action.JSclickButton(icra_elements.SendButton, "Click On Send Button");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SendChaseWRN() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	public void SendChaseWAD() throws Throwable //Without selecting anything click on send button
	{	
		
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			if(action.isElementDisplayed(icra_elements.SendButton, "SendButton"))
			{
			Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			action.JSclickButton(icra_elements.SendButton, "Click On Send Button");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SendChaseWAD() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	public void SendChaseWSCB() throws Throwable   //Without selecting check box click on send button
	{
				
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			if(action.isElementDisplayed(icra_elements.ResolutionNote, "ResolutionNote"))
			{
			Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
						
			action.inputText(icra_elements.ResolutionNote, ExcelHandling.GetExcelData(TC_ID, "Resolution Note"), "Enter Resolution Note ");
			
			action.JSclickButton(icra_elements.SendButton, "Click On Send Button");
			
			ValidateWSCB();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SendChaseWSCB() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	
	public void ReleaseChaseWAD() throws Throwable //Without selecting anything click on Release button
	{
					
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			if(action.isElementDisplayed(icra_elements.ReleaseButton, "ReleaseButton"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			action.JSclickButton(icra_elements.ReleaseButton, "Click On Release Button ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ReleaseChaseWAD() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	
	public void ReleaseChase() throws Throwable
	{
	
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			
			action.WaitUntilDisplayed(icra_elements.Checkbox);
			if(action.isElementDisplayed(icra_elements.Checkbox, "Check box"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			action.JSclickButton(icra_elements.Checkbox, "Click On Checkbox");
					
			action.inputText(icra_elements.ResolutionNote, ExcelHandling.GetExcelData(TC_ID, "Resolution Note"), "Enter MemberID ");
				
			action.JSclickButton(icra_elements.ReleaseButton, "Click On Release Button ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ReleaseChase() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}		
	}
	
	public void ReleaseChaseWRN() throws Throwable //Without resolution note click on Release button
	{
		
		try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			
			action.WaitUntilDisplayed(icra_elements.Checkbox);
			if(action.isElementDisplayed(icra_elements.Checkbox, "Check box"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			action.JSclickButton(icra_elements.Checkbox, "Click On Checkbox");
					
			action.JSclickButton(icra_elements.ReleaseButton, "Click On Release Button ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ReleaseChaseWRN() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		}
	
	public void ReleaseChaseWSCB() throws Throwable   //Without selecting check box click on Release button
	{
		
        try {
			action.WaitUntilDisplayed(icra_elements.TRow);
			
			action.JSclickButton(icra_elements.TRow, "Click On Row");
			action.WaitUntilDisplayed(icra_elements.ResolutionNote);
			if(action.isElementDisplayed(icra_elements.Checkbox, "Check box"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
					
			action.inputText(icra_elements.ResolutionNote, ExcelHandling.GetExcelData(TC_ID, "Resolution Note"), "Enter MemberID ");
			
			action.JSclickButton(icra_elements.ReleaseButton, "Click On Release Button ");
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ReleaseChaseWSCB() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
public void Validation() throws Throwable //With resolution note & check box click on Release/send button
{
	try {
		String valmsg;
		action.WaitUntilDisplayed(icra_elements.Valmsg);
		valmsg=icra_elements.Valmsg.getText();

		
if (valmsg.contains("Record saved successfully")) {
			
		
			Extent_Reporting.Log_Pass(TC_ID, "Record send successfully ", test, driver);
			
		} else {

			Extent_Reporting.Log_Fail(TC_ID, "Record not send successfully", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Validation() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
   
}
public void ValidateWRN() throws Throwable //Without resolution note click on Release/send button
{
	try {
		String valmsg;
		action.WaitUntilDisplayed(icra_elements.ErrormsgSCB);
		valmsg=icra_elements.ErrormsgSCB.getText();
		
		
if (valmsg.contains("Please insert comment")) {
			
		
			Extent_Reporting.Log_Pass(TC_ID, "Validation message display successfully ", test, driver);
		
		} else {
			
			Extent_Reporting.Log_Fail(TC_ID, "Validation message not display successfully", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "ValidateWRN() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
   
}
public void ValidateWAD()  throws Throwable//Without selecting anything click on Release/send button
{
	try {
		String valmsg;
		action.WaitUntilDisplayed(icra_elements.Errormsg);

		valmsg=action.elementGetText(icra_elements.Errormsg, "Validation message");
		
		
if (valmsg.contains("Please select atleast one exception")) {
			
			Extent_Reporting.Log_Pass(TC_ID, "Validation message display successfully ", test, driver);
			
		} else {
			
			Extent_Reporting.Log_Fail(TC_ID, "Validation message not display successfully", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "ValidateWAD() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
   
}
public void ValidateWSCB() throws Throwable //Without selecting check box click on Release/send button
{
	try {
		String valmsg;
		
		valmsg=action.elementGetText(icra_elements.ErrormsgWRN, "Validation message");

		
if (valmsg.contains("Please select atleast one exception")) {
			
			
			Extent_Reporting.Log_Pass(TC_ID, "Validation message display successfully ", test, driver);
			
		} else {
					Extent_Reporting.Log_Fail(TC_ID, "Validation message not display successfully", test, driver);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 Extent_Reporting.Log_Fail("MethodFailed", "ValidateWSCB() failed "+ e.getMessage(), test, driver);
		 throw new Exception(e.getMessage());
	}
	  


}

public void DFilter() throws Throwable
{
	try {
		String Exceptioncount= icra_elements.ExceptioncountFRW.getText();
		
		action.WaitUntilDisplayed(icra_elements.ExceptioncountF);
		action.JSclickButton(icra_elements.ExceptioncountF, "Click On Exception count Filter ");
		action.inputText(icra_elements.ExceptioncountTB, Exceptioncount, "Click On Exception count Filter ");
		
		icra_elements.ExceptioncountCB.click();
		
		if(Exceptioncount.contains(icra_elements.ExceptioncountFRW.getText()))
		{
			
			Extent_Reporting.Log_Pass(TC_ID, "Exceptioncount Filter apply Successfully ", test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail(TC_ID, "Exceptioncount Filter not apply Successfully", test, driver);	
		}
		icra_elements.ExceptioncountCB.click();
		//Filter for Type
		String Type=ExcelHandling.GetExcelData(TC_ID,"Type");

		action.WaitUntilDisplayed(icra_elements.TypeF);
		action.JSclickButton(icra_elements.TypeF, "Click On Type Filter ");
		Thread.sleep(1000);
		action.inputText(icra_elements.ExceptioncountTB,Type,"Click On Type Filter ");
		icra_elements.ExceptioncountCB.click();
		String type=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID,"Type")+"')]")).getText();
		
		if(type.contains(ExcelHandling.GetExcelData(TC_ID,"Type")))
		{
			
			Extent_Reporting.Log_Pass(TC_ID, "Type Filter apply Successfully ", test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail(TC_ID, " Type Filter not apply Successfully", test, driver);	
		}
		
		icra_elements.ExceptioncountCB.click();
		
		//Filter for PNPCode
			String PNPCode=ExcelHandling.GetExcelData(TC_ID,"PNPCode");
			action.WaitUntilDisplayed(icra_elements.PNPCodeF);
		
			action.JSclickButton(icra_elements.PNPCodeF, "Click On Type Filter ");
			Thread.sleep(1000);
			action.inputText(icra_elements.ExceptioncountTB,PNPCode,"Click On PNPCode Filter ");
			icra_elements.ExceptioncountCB.click();
			String pnpCode=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID,"PNPCode")+"')]")).getText();
			
			if(pnpCode.contains(PNPCode))
			{
				
				Extent_Reporting.Log_Pass(TC_ID, "PNPCode Filter apply Successfully ", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, " PNPCode Filter not apply Successfully", test, driver);	
			}
			icra_elements.ExceptioncountCB.click();
			
			//Filter for PNPExcept.
			String PNPExcept=ExcelHandling.GetExcelData(TC_ID,"PNPExcept");
			
			action.WaitUntilDisplayed(icra_elements.PNPExceptionF);
			action.JSclickButton(icra_elements.PNPExceptionF, "Click On PNPExcept Filter ");
			Thread.sleep(2000);
			action.inputText(icra_elements.ExceptioncountTB,PNPExcept,"Click On PNPExcept Filter ");
			icra_elements.ExceptioncountCB.click();
			String pnpExcept=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID,"PNPExcept.")+"')]")).getText();
			
			if(pnpExcept.contains(PNPExcept))
			{
				
				Extent_Reporting.Log_Pass(TC_ID, "PNPExcept Filter apply Successfully ", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, " PNPExcept Filter not apply Successfully", test, driver);	
			}
		//Filter for AddressCount
		
		
		icra_elements.ExceptioncountCB.click();
		String AddressCount=icra_elements.AddressCount.getText();
		
		action.WaitUntilDisplayed(icra_elements.AddressCountF);
		action.JSclickButton(icra_elements.AddressCountF, "Click On AddressCount Filter ");
		Thread.sleep(1000);
		action.inputText(icra_elements.ExceptioncountTB,AddressCount,"Click On AddressCount Filter ");
		icra_elements.ExceptioncountCB.click();
		Thread.sleep(1000);
		
		if(AddressCount.contains(icra_elements.AddressCountFRW.getText()))
		{
			
			Extent_Reporting.Log_Pass(TC_ID, "AddressCount Filter apply Successfully ", test, driver);
		}
		else
		{
			Extent_Reporting.Log_Fail(TC_ID, "AddressCount Filter not apply Successfully", test, driver);	
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 Extent_Reporting.Log_Fail("MethodFailed", "DFilter() failed "+ e.getMessage(), test, driver);
		 throw new Exception(e.getMessage());
	}
	
}



public void FilterTB2() throws Throwable
{
	try {
		action.WaitUntilDisplayed(icra_elements.TRow);
		action.JSclickButton(icra_elements.TRow, "Click On Row");
		
		
		//Filter for ChaseID
			String ChaseID= icra_elements.ChaseIDTRW.getText();
			
			action.WaitUntilDisplayed(icra_elements.ChaseIDF);
			action.JSclickButton(icra_elements.ChaseIDF, "Click On ChaseID Filter ");
			Thread.sleep(1000);
			action.inputText(icra_elements.ChaseIDTB, ChaseID, "Click On ChaseID Filter ");
			
			icra_elements.ChaseIDCB.click();
			String ChaseID1=icra_elements.ChaseIDTRW.getText();
			
			
			if(ChaseID.contains(ChaseID1))
			{
				
				Extent_Reporting.Log_Pass(TC_ID, "ChaseID Filter apply Successfully ", test, driver);
			}
			else
			{
				Extent_Reporting.Log_Fail(TC_ID, "ChaseID Filter not apply Successfully", test, driver);	
			}
			
			Thread.sleep(1000);
			
			icra_elements.ClearFilter.click();
			
			 
			//Filter for AddressID
					
			
			String AddressID= icra_elements.AddressIDTRW.getText();
				
					action.WaitUntilDisplayed(icra_elements.AddressIDF);
					
					action.JSclickButton(icra_elements.AddressIDF, "Click On AddressID Filter ");
					
					Thread.sleep(1000);
					action.inputText(icra_elements.ChaseIDTB, AddressID, "Click On AddressID Filter ");
					//icra_elements.ChaseIDTB.sendKeys(AddressID);
					
				
					Thread.sleep(1000);
					
					icra_elements.ChaseIDCB.click();
					
					if(AddressID.contains(icra_elements.AddressIDTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "AddressID Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "AddressID Filter not apply Successfully", test, driver);	
					}
					
					Thread.sleep(1000);
					
					icra_elements.ClearFilter.click();
					
					
					//Filter for MemberName
					
					//icra_elements.ChaseIDCB.click();
					String MemberName= icra_elements.MemberNameTRW.getText();
					
					
					
					action.JSclickButton(icra_elements.MemberNameF, "Click On MemberName Filter ");
					Thread.sleep(1000);
					//action.inputText(icra_elements.MemberNameCB, MemberName, "Click On MemberName Filter ");
					icra_elements.MemberNameCB.sendKeys(MemberName);
					
					Thread.sleep(1000);
					icra_elements.ChaseIDCB.click();
					if(MemberName.contains(icra_elements.MemberNameTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "MemberName Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "MemberName Filter not apply Successfully", test, driver);	
					}
					Thread.sleep(1000);
					
					icra_elements.ClearFilter.click();
					
					//Filter for MemberDOB
					
					
					String MemberDOB= icra_elements.MemberDOBTRW.getText();
					
					action.WaitUntilDisplayed(icra_elements.MemberDOBF);
				
					action.JSclickButton(icra_elements.MemberDOBF, "Click On MemberDOB Filter ");
					Thread.sleep(1000);
					icra_elements.MemberNameCB.sendKeys(MemberDOB);
					
					Thread.sleep(1000);
					icra_elements.ChaseIDCB.click();
					
					if(MemberDOB.contains(icra_elements.MemberDOBTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "MemberDOB Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "MemberDOB Filter not apply Successfully", test, driver);	
					}
			
					Thread.sleep(1000);
					
					icra_elements.ClearFilter.click();
					

					//Filter for ProviderName
					
					//icra_elements.ChaseIDCB.click();
					String ProviderName= icra_elements.ProviderNameTRW.getText();
				
					action.WaitUntilDisplayed(icra_elements.ProviderNameF);
					
					action.JSclickButton(icra_elements.ProviderNameF, "Click On ProviderName Filter ");
					Thread.sleep(1000);
					icra_elements.MemberNameCB.sendKeys(ProviderName);
					
					
					Thread.sleep(1000);
					icra_elements.ChaseIDCB.click();
					
					if(ProviderName.contains(icra_elements.ProviderNameTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "ProviderName Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "ProviderName Filter not apply Successfully", test, driver);	
					}
					Thread.sleep(1000);
					
					icra_elements.ClearFilter.click();
					

			/*
			 * //Filter for GroupName
			 * 
			 * //icra_elements.ChaseIDCB.click(); String GroupName=
			 * icra_elements.GroupNameTRW.getText(); log.info("GroupName "+ GroupName);
			 * action.WaitUntilDisplayed(icra_elements.GroupNameF);
			 * 
			 * action.JSclickButton(icra_elements.GroupNameF, "Click On GroupName Filter ");
			 * 
			 * icra_elements.ChaseIDTB.sendKeys(GroupName);
			 * //action.inputText(icra_elements.ChaseIDTB, GroupName,
			 * "Click On GroupName Filter "); Thread.sleep(5000);
			 * icra_elements.MemberNameCB.click();
			 * 
			 * if(GroupName.contains(icra_elements.GroupNameTRW.getText())) {
			 * 
			 * Extent_Reporting.Log_Pass(TC_ID, "GroupName Filter apply Successfully ",
			 * test, driver); } else { Extent_Reporting.Log_Fail(TC_ID,
			 * "GroupName Filter not apply Successfully", test, driver); }
			 * driver.navigate().refresh(); SelectProject();
			 * action.WaitUntilDisplayed(icra_elements.TRow);
			 * action.JSclickButton(icra_elements.TRow, "Click On Row");
			 */
					
					
					//Filter for State
					//icra_elements.ChaseIDCB.click();
					
					String State= icra_elements.StateTRW.getText();
									action.WaitUntilDisplayed(icra_elements.StateF);
					
					action.JSclickButton(icra_elements.StateF, "Click On State Filter ");
					Thread.sleep(1000);
					icra_elements.ChaseIDTB.sendKeys(State);
					
					
					Thread.sleep(1000);
					icra_elements.MemberNameCB.click();
					
					if(State.contains(icra_elements.StateTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "State Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "State Filter not apply Successfully", test, driver);	
					}
					Thread.sleep(1000);
					log.info("before clear filter ");
					
					//icra_elements.ClearFilterCB.click();
					log.info("after clear filter ");
					
					//Filter for Phone
					
					//icra_elements.ChaseIDCB.click();
					String Phone= icra_elements.PhoneTRW.getText();
				
					action.WaitUntilDisplayed(icra_elements.PhoneF);
					
					action.JSclickButton(icra_elements.PhoneF, "Click On Phone Filter ");
					Thread.sleep(1000);
					icra_elements.MemberNameCB.sendKeys(Phone);
					
					//action.inputText(icra_elements.ChaseIDTB, Phone, "Click On Phone Filter ");
					Thread.sleep(1000);
					icra_elements.ChaseIDCB.click();
					
					if(Phone.contains(icra_elements.PhoneTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "Phone Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "Phone Filter not apply Successfully", test, driver);	
					}
					
					Thread.sleep(1000);
					
					icra_elements.ClearFilter.click();
					
					//icra_elements.ChaseIDCB.click();
					//Filter for DateCreated
					
					
					String DateCreated= icra_elements.DateCreatedTRW.getText();
			
					action.WaitUntilDisplayed(icra_elements.DateCreatedF);
					
					action.JSclickButton(icra_elements.DateCreatedF, "Click On DateCreated Filter ");
					Thread.sleep(1000);
					icra_elements.MemberNameCB.sendKeys(DateCreated);
					//action.inputText(icra_elements.ChaseIDTB, DateCreated, "Click On DateCreated Filter ");
					Thread.sleep(1000);
					icra_elements.ChaseIDCB.click();
					
					if(DateCreated.contains(icra_elements.DateCreatedTRW.getText()))
					{
						
						Extent_Reporting.Log_Pass(TC_ID, "DateCreated Filter apply Successfully ", test, driver);
					}
					else
					{
						Extent_Reporting.Log_Fail(TC_ID, "DateCreated Filter not apply Successfully", test, driver);	
					}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 Extent_Reporting.Log_Fail("MethodFailed", "FilterTB2() failed "+ e.getMessage(), test, driver);
		 throw new Exception(e.getMessage());
	}
}



public void PNPSent2Client() throws Throwable
				{
					try {
						action.WaitUntilDisplayed(icra_elements.PNPsendtoclientTab);
						action.JSclickButton(icra_elements.PNPsendtoclientTab, "Click On PNPsendtoclientTab");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						 Extent_Reporting.Log_Fail("MethodFailed", "PNPSent2Client() failed "+ e.getMessage(), test, driver);
						 throw new Exception(e.getMessage());
					}
				}

public void PNPclientResponse() throws Throwable
				{
					try {
						action.WaitUntilDisplayed(icra_elements.PNPclientResponse);
						action.JSclickButton(icra_elements.PNPclientResponse, "Click On PNPclientResponse");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						 Extent_Reporting.Log_Fail("MethodFailed", "PNPclientResponse() failed "+ e.getMessage(), test, driver);
						 throw new Exception(e.getMessage());
					}
				}
}

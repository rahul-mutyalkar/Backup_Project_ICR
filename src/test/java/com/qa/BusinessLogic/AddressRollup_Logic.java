package com.qa.BusinessLogic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_PageObjects_Archana;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Priyanka;

import jdk.internal.org.jline.utils.Log;

public class AddressRollup_Logic  extends Extent_Reporting
{

	ElementAction action = new ElementAction();
	String TC_ID = null;	
	WebDriver driver;
	ICRA_PageObjects_Archana icra_elements; 
	String address2 = null;
	ICRA_BusinessLogic_Priyanka PBL = null;
	
	//String dateval = datetime("ddMMhhmmss");
	
	// Auto = new AutoAction();

	public AddressRollup_Logic(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PageObjects_Archana(driver);
		PBL = new ICRA_BusinessLogic_Priyanka(driver,TC_ID);
		
	}
	
	
	public void Pageload(int number, long time)
	{
		
		for(int i=0;i<=number;i++)
		{ 
			driver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
		}
	}
	
	public void WaitExplicit(WebElement ele,long time)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);						
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void JSCLICK(WebElement ele)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Extent_Reporting.Log_Message("Button" +" is clicked", test,driver);

	}
	
	
	public String DisplayComboboxVal(WebElement elem) 	
	{   
		Select select = new Select(elem);
		WebElement Act = select.getFirstSelectedOption();
		String Action = Act.getText();
		action.waitForPageLoad();
		Extent_Reporting.Log_Pass("ComboBox", Action + " is selected", test, driver);
		return Action;
	}
	
	public void Projectsubmit() throws Throwable	
	{ 
		try {
			action.clickButton(icra_elements.AddRollProjectSubmit, "Project Submit");
			////log.info("Project submit");
			Extent_Reporting.Log_Pass("Project submit", "Project submit is selected", test, driver);
			action.waitForPageLoad();
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Projectsubmit() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}
	}
	
	
	public void AddressId() throws Throwable 	
	{ 
		try {
			//Click on address id
			String add=ExcelHandling.GetExcelData(TC_ID, "Addressid");
			//int Addressnumber = Integer.parseInt();
			////log.info(add);
			WebElement addressid= driver.findElement(By.xpath("//a[contains(text(),'"+add+"')]"));	
			action.JSclickButton(addressid, "Address id");
			action.waitForPageLoad();
			////log.info("Address id is clicked");
			Extent_Reporting.Log_Pass("Addressid", "Address id is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "AddressId() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}

				
	}
	
	public void RetrievalMethod() throws Throwable
	{
		
		
		try {
			//case 1 Click on save button
			action.WaitUntilDisplayed(icra_elements.RetSave);
			action.clickButton(icra_elements.RetSave, "save button");
			action.waitForPageLoad();
			Extent_Reporting.Log_Pass("Save", "Retrieval Message :"  +icra_elements.RetrievalValidation.getText(), test, driver);
			
			//Case 2 check fax retrieval
//		if(ExcelHandling.GetExcelData(TC_ID, "Retrieval").equals("Fax"))
//		{
				action.selectDDByText(icra_elements.Retrieval, ExcelHandling.GetExcelData(TC_ID, "Retrieval"));
				Extent_Reporting.Log_Pass("Retrieval", "Retrieval type selected : "+ExcelHandling.GetExcelData(TC_ID, "Retrieval"), test, driver);
				DisplayComboboxVal(icra_elements.Retrieval);
				action.waitForPageLoad();
			
			//check Onsite Visit-Internal retrieval
			if(ExcelHandling.GetExcelData(TC_ID, "Retrieval").equals("Onsite Visit-Internal"))
			{
				
				//select scantech
				Extent_Reporting.Log_Pass("Retrieval", "Retrieval Message on EMR on Scant-Tech:"  +icra_elements.EMRValidation.getText(), test, driver);
				action.selectDDByText(icra_elements.Retrieval, "Onsite Visit-Internal");
				Extent_Reporting.Log_Pass("Retrieval", "Retrieval type selected : "+ExcelHandling.GetExcelData(TC_ID, "Retrieval"), test, driver);
				
				DisplayComboboxVal(icra_elements.Retrieval);
			}

			
			
			//Case 3 -click on save and capture expected date validation
			    WaitExplicit(icra_elements.RetSave, 60);
				//action.WaitUntilDisplayed(icra_elements.RetSave, 20);
				action.clickButton(icra_elements.RetSave, "save button");
				action.waitForPageLoad();
				Extent_Reporting.Log_Pass("Save", "Retrieval Message :"  +icra_elements.ExpectedValidation.getText(), test, driver);

				//date
				String Datecurrent=ExcelHandling.GetExcelData(TC_ID, "Expected");
				//PBL.datepicker(icra_elements.RetrievalExpected);
				
				action.clickButton(icra_elements.RetrievalExpected, "Current Date");
				action.waitForPageLoad();
				//driver.findElement(By.xpath("//td[@aria-label='"+Datecurrent+"']")).click();
				action.waitForPageLoad();
				
				////log.info("Verify Date:"  +icra_elements.RetrievalExpected.getText());
				action.WaitUntilDisplayed(icra_elements.TodayDate);
			    JSCLICK(icra_elements.TodayDate);
			    action.waitForPageLoad();
				
				
			//case 4-click on save and 
				action.WaitUntilDisplayed(icra_elements.RetSave);			
				//action.JSclickButton(icra_elements.RetSave, "save button");
				JSCLICK(icra_elements.RetSave);
				action.waitForPageLoad();
				//WebElement save=driver.findElement(By.xpath("//div[@aria-label='Data saved successfully']"));
				//log.info("Retrieval Method is save :");
				Extent_Reporting.Log_Pass("RetrievalSave", "Retrieval is save" , test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "RetrievalMethod() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}

			
			
	}
	
	public void CallDiposition() throws Throwable
	{
	
	try {
		//CALL DIPOSITION NOTES
			//Case 1-Call diposition Function Tab
			
			action.WaitUntilDisplayed(icra_elements.CallDipoSave);
			//action.WaitUntilDisplayed(icra_elements.CallDipoSave, 60);
			action.JSclickButton(icra_elements.CallDipoSave, "Call diposition");
			//log.info(" Call Diposition Save button is clicked");
			Extent_Reporting.Log_Pass(" CallDipositionSave", "Call Diposition Save button is clicked" , test, driver);

			 
			//Print validation call dipo and notes
			//log.info("Call Diposition :"  +icra_elements.CallDiposValidation.getText());
			
			//log.info("Notes :"  +icra_elements.CallNotesValidation.getText());	
			
			//case 2 -Select Call diposition value
//		if(ExcelHandling.GetExcelData(TC_ID, "CallDipovalue").equals("Busy Tone"))
//		{
				action.WaitUntilDisplayed(icra_elements.CallDiposSel);
				action.selectDDByText(icra_elements.CallDiposSel, ExcelHandling.GetExcelData(TC_ID, "CallDipovalue"));
				DisplayComboboxVal(icra_elements.CallDiposSel);
			//}
			//Case 3 - save and print  timezone validation
			
			action.WaitUntilDisplayed(icra_elements.CallDipoSave);
			action.JSclickButton(icra_elements.CallDipoSave, "Call diposition");
			action.waitForPageLoad();
			//log.info("Save button is clicked");
			
			//Print validation of time zone			 
			  //log.info("Timezone :"  +icra_elements.TimeZoneValidation.getText());	
			
			//Select timezone and display
			   action.selectDDByText(icra_elements.CallTimezone, ExcelHandling.GetExcelData(TC_ID, "TimeZone"));
			   DisplayComboboxVal(icra_elements.CallTimezone);
			   
			 
			
			//Case 4 - Call notes 
			   String Datecurrent=JavaUtilities.datetime("dd-MMM-yyyy HH:mm:ss");
			   action.inputText(icra_elements.CallNote, "TEST"+Datecurrent, "Call Message");
			   //log.info("Call Notes " +icra_elements.CallNote.getText());
			 
			//Case 5 - Office Hour
				String Time=JavaUtilities.datetime("HH_MM");
				 action.inputText(icra_elements.office, "TEST"+Datecurrent, "Call Message");
				 //log.info("Office Hours " +icra_elements.office.getText());
				 action.waitForPageLoad();
				 
			//Case 6 -Save and Verify
				 action.WaitUntilDisplayed(icra_elements.CallDipoSave);
				 //action.clickButton(icra_elements.CallDipoSave, "Call diposition");
				 JSCLICK(icra_elements.CallDipoSave);
				 action.waitForPageLoad();
				 
				 WebElement verifycall=driver.findElement(By.xpath("//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "CallDipovalue")+"')]"));

				 //log.info("Grid value "+verifycall.getText());	 
				Extent_Reporting.Log_Pass("verifycall", "verifycall Diposition"  +verifycall.getText(), test, driver);

		
		//TECHNICAL NOTES
			//case 1-Provide text in technical note	and print validation
				 action.WaitUntilDisplayed(icra_elements.TechnicalNoteTab);
				 //action.clickButton(icra_elements.TechnicalNoteTab, "TECHNICAL NOTES");
				 JSCLICK(icra_elements.TechnicalNoteTab);
				 action.waitForPageLoad();
				 action.WaitUntilDisplayed(icra_elements.TechNoteSave);
				// action.clickButton(icra_elements.TechNoteSave, "TECHNICAL NOTES");
				 JSCLICK(icra_elements.TechNoteSave);
				 action.waitForPageLoad();
				 action.WaitUntilDisplayed(icra_elements.TechValidaion);
				 //log.info("Technical Note "+icra_elements.TechValidaion.getText());	
				 String TechNote="TEST"+Datecurrent;
		         action.inputText(icra_elements.TechNote, TechNote, "Technical Notes");
		         action.waitForPageLoad();
		         //save notes
		         
		         action.WaitUntilDisplayed(icra_elements.TechNoteSave);
				 //action.clickButton(icra_elements.TechNoteSave, "TECHNICAL NOTES");
				 JSCLICK(icra_elements.TechNoteSave);
				 action.waitForPageLoad();
				 
				 WebElement verifyNotes=driver.findElement(By.xpath("//div[@id='tab15_2']//div[contains(text(),'"+TechNote+"')]"));

				 action.WaitUntilDisplayed(verifyNotes);
				 //log.info("Grid value technical note"+verifyNotes.getText());
				Extent_Reporting.Log_Pass("Gridvalue technicalnote", "verifycall Grid value technical note"  +verifyNotes.getText(), test, driver);

				action.waitForPageLoad();
		         
		        //ave  
		 
		  //SPECIALHANDLING
		     //case 1-print validation 
		         action.WaitUntilDisplayed(icra_elements.SpecialHanTab);
				 //action.clickButton(icra_elements.SpecialHanTab, "SPECIALHANDLING");
				 JSCLICK(icra_elements.SpecialHanTab);
				 action.waitForPageLoad();
				 //action.clickButton(icra_elements.SpecialSave, "SPECIALHANDLING Save");
				 action.WaitUntilDisplayed(icra_elements.SpecialSave);
				 JSCLICK(icra_elements.SpecialSave);
				 action.waitForPageLoad();
				 action.WaitUntilDisplayed(icra_elements.SpecialHanValid);
				 //log.info("Special handling validation "+icra_elements.SpecialHanValid.getText());	
				 action.WaitUntilDisplayed(icra_elements.SpecialHanNotesValid);
				 //log.info("Special handling Note "+icra_elements.SpecialHanNotesValid.getText());	
				 action.waitForPageLoad();
				 action.WaitUntilDisplayed(icra_elements.SpecialHan);
				 action.selectDDByValue(icra_elements.SpecialHan, ExcelHandling.GetExcelData(TC_ID, "Special"));
				 DisplayComboboxVal(icra_elements.SpecialHan);
				 action.waitForPageLoad();
				 action.WaitUntilDisplayed(icra_elements.SpecialHanNotes);
				 action.inputText(icra_elements.SpecialHanNotes, "TEST"+Datecurrent, "Special Notes");
				 //log.info("Special Notes "+icra_elements.SpecialHanNotes.getText());	 
				 //save notes
		         action.WaitUntilDisplayed(icra_elements.SpecialSave);
				// action.clickButton(icra_elements.SpecialSave, "SPECIALHANDLING");
				 JSCLICK(icra_elements.SpecialSave);
				 action.waitForPageLoad();
				 WebElement verifySpecial=driver.findElement(By.xpath("//div[@id='tab15_3']//div[4][@aria-colindex='4']"));
				 action.WaitUntilDisplayed(verifySpecial);
				 //log.info("Grid value Special"+verifySpecial.getText());
				Extent_Reporting.Log_Pass("Grid value Special", "Grid value Special"  +verifySpecial.getText(), test, driver);

				 action.waitForPageLoad();
				 
				 
		 //REQUEST NOTES	 
			 // case 1 -Request Note
				 action.WaitUntilDisplayed(icra_elements.RequestNoteTab);
				 //action.clickButton(icra_elements.RequestNoteTab, "REQUEST NOTES");
				 JSCLICK(icra_elements.RequestNoteTab);
				 action.waitForPageLoad();
				 
				// action.clickButton(icra_elements.RequestSave, "REQUEST NOTES Save");
				 action.WaitUntilDisplayed(icra_elements.RequestSave);
				 JSCLICK(icra_elements.RequestSave);
				 action.waitForPageLoad();
				 
				 action.WaitUntilDisplayed(icra_elements.RequestNoteVal);
				 //log.info("RequestNote "+icra_elements.RequestNoteVal.getText());
				 String TechNote1 =" TEST123"+Datecurrent;
				 action.inputText(icra_elements.RequestNote,TechNote1, "REQUEST NOTES");
				 action.waitForPageLoad();
				
				 //save notes
		         action.WaitUntilDisplayed(icra_elements.RequestSave);
				 //action.clickButton(icra_elements.RequestSave, "REQUEST NOTES");
				 JSCLICK(icra_elements.RequestSave);
				 action.waitForPageLoad();
				 
				 WebElement verifyRequest=driver.findElement(By.xpath("//div[@id='tab15_4']//div[contains(text(),'"+TechNote1+"')]"));

				  action.WaitUntilDisplayed(verifyRequest);
				 //log.info("Grid value Request"+verifyRequest.getText());
				Extent_Reporting.Log_Pass("GridvalueRequest", "Grid value Request"  +verifyRequest.getText(), test, driver);
	} catch (java.lang.Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "CallDiposition() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());

	}

			 
	}
	
	public void Exception() throws Throwable
	{
		  try {
			//Exception validation
			action.WaitUntilDisplayed(icra_elements.ExceptionMain);
			action.JSclickButton(icra_elements.ExceptionMain, "ExceptionMain");
			//icra_elements.ExceptionMain.click();
			action.waitForPageLoad();
			//log.info("Exception Main Submit button is clicked");
			//log.info("Exception Validation on chase " +icra_elements.ExceptionValidation.getText());
			Extent_Reporting.Log_Pass("ExceptionValidation", "Exception Validation on Chase"  +icra_elements.ExceptionValidation.getText(), test, driver);

			//click on check box
			Checkbox1();
			//Click on Exception main tab
			action.WaitUntilDisplayed(icra_elements.ExceptionMain);
			action.clickButton(icra_elements.ExceptionMain, "ExceptionMain");
			//icra_elements.ExceptionMain.click();
			action.waitForPageLoad();
			//log.info("Exception Main Submit button is clicked");		
			
			//Click on Exception sun-menu tab
			action.WaitUntilDisplayed(icra_elements.ExceptionSubmit);
			action.clickButton(icra_elements.ExceptionSubmit, "ExceptionSubmit");
			//icra_elements.ExceptionSubmit.click();
			action.waitForPageLoad();
			//log.info("Exception Sub-Menu Submit button is clicked");
					
			//Print validation
			//log.info("Exception Value :" +icra_elements.ExceptionVal.getText());
			Extent_Reporting.Log_Pass("Exception Value", "Exception Value"  +icra_elements.ExceptionVal.getText(), test, driver);

			//log.info("Exception Description :" +icra_elements.ExceptionDesVal.getText());
			Extent_Reporting.Log_Pass("ExceptionDescription ", "Exception Description "  +icra_elements.ExceptionDesVal.getText(), test, driver);

			
			//provide values and submit 
			action.WaitUntilDisplayed(icra_elements.ExceptionVal);
			//icra_elements.ExceptionVal.click();
			action.clickButton(icra_elements.ExceptionVal, "ExceptionVal");

			//action.WaitUntilDisplayed(icra_elements.ExceptionChaseValue, 30);
			String ExceptionType=ExcelHandling.GetExcelData(TC_ID, "ExceptionType");
			action.clickButton(driver.findElement(By.xpath("//span[contains(text(),'"+ExceptionType+"')]")),ExceptionType);
			//action.clickButton(icra_elements.ExceptionChaseValue, "Select chase exception");
			action.waitForPageLoad();
			action.WaitUntilDisplayed(icra_elements.ExceptionDesc);
			action.inputText(icra_elements.ExceptionDesc, "-Testing", "Chaseexception");
			action.waitForPageLoad();
			action.WaitUntilDisplayed(icra_elements.ExceptionSubmit);
			action.clickButton(icra_elements.ExceptionSubmit, "ExceptionSubmit");
			//icra_elements.ExceptionSubmit.click();
			action.waitForPageLoad();
			//log.info("Exception Success :" +icra_elements.ExceptionSucess.getText());
			Extent_Reporting.Log_Pass("ExceptionSuccess", "Exception Success "  +icra_elements.ExceptionSucess.getText(), test, driver);

			action.WaitUntilDisplayed(icra_elements.GlobalSearch);
			icra_elements.GlobalSearch.clear();
			action.inputText(icra_elements.GlobalSearch, ExceptionType, "ExceptionType");
			action.WaitUntilDisplayed(icra_elements.GlobalSearch);
			//log.info("Chase Status: "+icra_elements.ChaseStatus1.getText());		
			Extent_Reporting.Log_Pass("Chase Status", "Chase Status"  +icra_elements.ChaseStatus1.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Exception() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}

		
	}
	
	public void Move_Copy_Search(String address2,String Button) throws Throwable
	{
		try {
			// Paste address ,search 
					action.WaitUntilDisplayed(icra_elements.Move_Copy_address1);
					action.inputText(icra_elements.Move_Copy_address1, address2, "Paste address 2");
					action.WaitUntilDisplayed(icra_elements.Move_Copy_Search);
					icra_elements.Move_Copy_Search.click();
					action.waitForPageLoad();
					//log.info("Search button is clicked");
					
					//select address and move
					action.WaitUntilDisplayed(icra_elements.Move_Copy_radio);
					icra_elements.Move_Copy_radio.click();
					action.waitForPageLoad();
					//log.info("Radio button is clicked");
					
					if(Button.equals("Move"))
					{
					  action.WaitUntilDisplayed(icra_elements.Move_Submit);
					  icra_elements.Move_Submit.click();
					  action.waitForPageLoad();
					  //log.info("Move Submit button is clicked");
					Extent_Reporting.Log_Pass("MoveSubmit", "Move Submit button is clicked", test, driver);

					  
					}
					   else if(Button.equals("Copy"))
					    {
						  action.WaitUntilDisplayed(icra_elements.Copy_Submit);
						  icra_elements.Copy_Submit.click();
						  action.waitForPageLoad();
						  action.waitForPageLoad();

						  //log.info("Copy Submit button is clicked");
						Extent_Reporting.Log_Pass("CopySubmit", "Copy Submit button is clicked", test, driver);

						}
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Move_Copy_Search() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}
	}
	    
	public void ClickFirstAddress() throws Throwable	 
	{ 
		try {
			//Click on address id
			action.WaitUntilDisplayed(icra_elements.AddIDRollup1);
			icra_elements.AddIDRollup1.click();
			action.waitForPageLoad();
			//log.info("First address id is clicked");
			Extent_Reporting.Log_Pass("Firstaddress", "First address id is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ClickFirstAddress() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}

				
	}
	
	public void Move_Copy() throws Throwable
	{
		
		try {
			//Print Address id2, total chase2 and address details2 
			////log.info("Before Move/copy Address id2: "+ExcelHandling.GetExcelData(TC_ID, "Addressid2"));
			////log.info("Before Move/copy Total Chase: "+icra_elements.TotchaseCount.getText());
			Extent_Reporting.Log_Pass("BeforeTotalChase", "Before Movecopy Total Chase"  +icra_elements.Totalchase2.getText(), test, driver);

			////log.info("Before Move/copy Address Details2: "+ExcelHandling.GetExcelData(TC_ID, "AddressDetails2"));
			
			//Copy address 2 and go to address 1 and perform move copy
			String address2=icra_elements.Address2.getText();
			// Chasecount=ExcelHandling.GetExcelData(TC_ID, "TotalChase2");
			//int num= Integer.parseInt(Chasecount);
			//check chase count should be greater then 3			
			
			action.WaitUntilDisplayed(icra_elements.AddIDRollup1);
			//icra_elements.AddIDRollup1.click();
			action.clickButton(icra_elements.AddIDRollup1, "AddIDRollup1");
			action.waitForPageLoad();

			
			
			//click on chase link
			action.WaitUntilDisplayed(icra_elements.ChaseLink);
			action.clickButton(icra_elements.ChaseLink, "ChaseLink");
			//icra_elements.ChaseLink.click();
			action.waitForPageLoad();
			Extent_Reporting.Log_Pass("Chaselink","Chase link is clicked",test,driver);
			
			//click on move and capture validation
			action.WaitUntilDisplayed(icra_elements.Move);
			//icra_elements.Move.click();
			action.JSclickButton(icra_elements.Move, "Move");
			action.waitForPageLoad();
			//log.info("Move validation :" +icra_elements.MoveVal.getText());
			Extent_Reporting.Log_Pass("Movevalidation", "Move validation"  +icra_elements.MoveVal.getText(), test, driver);

			
			//click on checkbox and move button
			action.WaitUntilDisplayed(icra_elements.Checkbox1);
			//icra_elements.Checkbox1.click();
			action.clickButton(icra_elements.Checkbox1, "Checkbox1");
			action.waitForPageLoad(); 
			action.WaitUntilDisplayed(icra_elements.Move);
			action.clickButton(icra_elements.Move, "Move");
			//icra_elements.Move.click();
			action.waitForPageLoad(); 
			
			String Button = "Move";
			//search functionality
			Move_Copy_Search(address2,Button);
			
			////click on copy and capture validation
			action.WaitUntilDisplayed(icra_elements.Copy);
			//icra_elements.Copy.click();
			action.JSclickButton(icra_elements.Copy, "Copy");
			action.waitForPageLoad(); 
			//log.info("Copy validation :" +icra_elements.CopyVal.getText());
			Extent_Reporting.Log_Pass("CopyValvalidation", "CopyVal validation"  +icra_elements.CopyVal.getText(), test, driver);

			
			//click on checkbox and move button
			action.WaitUntilDisplayed(icra_elements.Checkbox1);
			//icra_elements.Checkbox1.click();
			action.clickButton(icra_elements.Checkbox1, "Copy");
			action.waitForPageLoad(); 
			action.WaitUntilDisplayed(icra_elements.Copy);
			//icra_elements.Copy.click();
			action.JSclickButton(icra_elements.Copy, "Copy");
			action.waitForPageLoad(); 
			Extent_Reporting.Log_Pass("Copy", "Copy button is clicked", test, driver);

			
			String Button2 = "Copy";
			//search functionality
			Move_Copy_Search(address2,Button2);

			
			//Click on address list
			AddressList();
			Projectsubmit();
			
			//Print Address id2, total chase2 and address details2 
			////log.info("After Move/copy Address id: "+icra_elements.AddIDRollup2.getText());
			////log.info("After Move/copy Address id: "+icra_elements.TotchaseCount.getText());
			Extent_Reporting.Log_Pass("Total Chase After", "After Movecopy Total Chase"  +icra_elements.Totalchase2.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Move_Copy() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}

		
	}
	
	public void Move_Button() throws Throwable
	{ 
		try {
			//click on move and capture validation
					action.WaitUntilDisplayed(icra_elements.Move);
					icra_elements.Move.click();
					action.waitForPageLoad(); 
					Extent_Reporting.Log_Pass("Move", "Move button is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Move_Button() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}
		

	}
	
	public void Copy_Button() throws Throwable
	{
	try {
		////click on copy and capture validation
				action.WaitUntilDisplayed(icra_elements.Copy);
				icra_elements.Copy.click();
				action.waitForPageLoad(); 
				Extent_Reporting.Log_Pass("Copy", "Copy button is clicked", test, driver);
	} catch (java.lang.Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Copy_Button() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());

	}

	}
	
	public void Checkbox1() throws Throwable
	{
	try {
		////click on copy and capture validation
			//click on checkbox and move button
					action.WaitUntilDisplayed(icra_elements.Checkbox1);
					action.JSclickButton(icra_elements.Checkbox1, "checkbox1");
					//icra_elements.Checkbox1.click();
					action.waitForPageLoad(); 
					Extent_Reporting.Log_Pass("Checkbox1", "Checkbox1 is clicked", test, driver);
	} catch (java.lang.Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Copy_Button() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());

	}
	}
    
	public void Move_Copy_SearchValidation(String Button) throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.Move_Copy_Search);
			action.clickButton(icra_elements.Move_Copy_Search, "Move_Copy_Search");
			action.clickButton(icra_elements.Move_Copy_Search, "Move_Copy_Search");
			//icra_elements.Move_Copy_Search.click();
			action.waitForPageLoad(); 
			//log.info("Search button is clicked");
			
			//action.WaitUntilDisplayed(icra_elements.SearchVal);
			//log.info("Search validation" +icra_elements.Alert.getText());
			Extent_Reporting.Log_Pass("Search validation", "Search validation"  +icra_elements.Alert.getText(), test, driver);

			
			action.WaitUntilDisplayed(icra_elements.Move_Copy_address1);
			action.inputText(icra_elements.Move_Copy_address1, ExcelHandling.GetExcelData(TC_ID, "AddressDetails2"), "Paste address 2");
			action.WaitUntilDisplayed(icra_elements.Move_Copy_Search);
			action.waitForPageLoad(); 
			//log.info(" Address autopopulate :" + icra_elements.addressautopopulate.getText());
			Extent_Reporting.Log_Pass("Address autopopulate", "Address autopopulate"  +icra_elements.addressautopopulate.getText(), test, driver);

			
			action.JSclickButton(icra_elements.Move_Copy_Search, "Move_Copy_Search");
			//icra_elements.Move_Copy_Search.click();
			action.waitForPageLoad(); 
			//log.info("Search button is clicked");
			action.WaitUntilDisplayed(icra_elements.addVerify);
			//log.info("Verify address :" + icra_elements.addVerify.getText());
			Extent_Reporting.Log_Pass("Search validation", "Search validation"  +icra_elements.addVerify.getText(), test, driver);

			//city
			action.WaitUntilDisplayed(icra_elements.Move_Copy_Cancel);
			//action.JSclickButton(icra_elements.Move_Copy_Cancel, "Move_Copy_Cancel");
			action.waitForPageLoad(); 
			icra_elements.Move_Copy_Cancel.click();
			if (Button.equals("Move"))
			{
				
				Checkbox1();
				Move_Button();
			}
			else
			{
				
				Checkbox1();
				Copy_Button();
			}

			action.WaitUntilDisplayed(icra_elements.City);
			action.inputText(icra_elements.City, ExcelHandling.GetExcelData(TC_ID, "City"), "City");
			action.waitForPageLoad(); 
			//action.WaitUntilDisplayed(icra_elements.Cityautopopulate);
			//log.info(" City autopopulate :" + icra_elements.Cityautopopulate.getText());
			Extent_Reporting.Log_Pass("City validation", "City autopopulate"  +icra_elements.Cityautopopulate.getText(), test, driver);

			action.WaitUntilDisplayed(icra_elements.Move_Copy_Search);
			action.JSclickButton(icra_elements.Move_Copy_Search, "Move_Copy_Search");
			//icra_elements.Move_Copy_Search.click();
			action.waitForPageLoad(); 
			action.WaitUntilDisplayed(icra_elements.CityVerify);
			//log.info("Verify City :" + icra_elements.CityVerify.getText());
			Extent_Reporting.Log_Pass("Verify City ", "Verify City"  +icra_elements.CityVerify.getText(), test, driver);

			action.WaitUntilDisplayed(icra_elements.Move_Copy_Cancel);
			action.JSclickButton(icra_elements.Move_Copy_Cancel, "Move_Copy_Cancel");
			if (Button.equals("Move"))
			{
				
				Checkbox1();
				Move_Button();
			}
			else
			{
				
				Checkbox1();
				Copy_Button();
			}
			action.WaitUntilDisplayed(icra_elements.Zipcode);
			action.inputText(icra_elements.Zipcode, ExcelHandling.GetExcelData(TC_ID, "Zipcode"), "Zipcode");
			//log.info(" Zipcode autopopulate :" + icra_elements.ZipcodeAutopopolate.getText());
			Extent_Reporting.Log_Pass("Zipcodeautopopulate", "Zipcode autopopulate"  +icra_elements.ZipcodeAutopopolate.getText(), test, driver);

			action.WaitUntilDisplayed(icra_elements.Move_Copy_Search);
			action.clickButton(icra_elements.Move_Copy_Search, "Move_Copy_Search");
			//sicra_elements.Move_Copy_Search.click();
			action.waitForPageLoad();
			action.WaitUntilDisplayed(icra_elements.ZipVerify);
			//log.info("Verify Zipcode :" + icra_elements.ZipVerify.getText());
			Extent_Reporting.Log_Pass("VerifyZipcode ", "Verify Zipcode"  +icra_elements.ZipVerify.getText(), test, driver);

			
			
			action.WaitUntilDisplayed(icra_elements.Move_Copy_Cancel);
			action.clickButton(icra_elements.Move_Copy_Cancel, "Move_Copy_Cancel");
			//icra_elements.Move_Copy_Cancel.click();
			if (Button.equals("Move"))
			{
				
				Checkbox1();
				Move_Button();
			}
			else
			{
				
				Checkbox1();
				Copy_Button();
			}
			action.WaitUntilDisplayed(icra_elements.NPI);
			action.inputText(icra_elements.NPI, ExcelHandling.GetExcelData(TC_ID, "NPI"), "NPI");
			//log.info(" NPI autopopulate :" + icra_elements.NPIAutopopulate.getText());
			Extent_Reporting.Log_Pass("NPIautopopulate", "NPIautopopulate"  +icra_elements.NPIAutopopulate.getText(), test, driver);

			action.WaitUntilDisplayed(icra_elements.Move_Copy_Search);
			action.clickButton(icra_elements.Move_Copy_Search, "Move_Copy_Search");
			//icra_elements.Move_Copy_Search.click();
			action.waitForPageLoad();
			action.WaitUntilDisplayed(icra_elements.CityVerify);
			//log.info("Verify NPI :" + icra_elements.CityVerify.getText());
			Extent_Reporting.Log_Pass("Verify NPI", "Verify NPI"  +icra_elements.CityVerify.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Move_Copy_SearchValidation() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

			
		}
	

		
	}
	 
	public void GlobalSearch() throws Throwable
	{
		try {
			action.inputText(icra_elements.GlobalSearch, ExcelHandling.GetExcelData(TC_ID, "GlobalSearch"), "GlobalSearch");
			//log.info(" GlobalSearch text is entered:");
			
			action.WaitUntilDisplayed(icra_elements.ChaseStatus1);
			//log.info("Search results Chase :"+icra_elements.ChaseStatus1.getText());
			Extent_Reporting.Log_Pass("SearchresultsChase", "Search results Chase"  +icra_elements.ChaseStatus1.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "GlobalSearch() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}

	}
	
	public void Move_Copy_Watermark() throws Throwable
	{
		try {
			if(icra_elements.NPI.isDisplayed())
			{
				//log.info("Npi Watermark  " +icra_elements.NPI.getAttribute("value"));
				Extent_Reporting.Log_Pass("NpiWatermark ", "Npi Watermark", test, driver);

			}
			if(icra_elements.Zipcode.isDisplayed())
			{
				//log.info("Zipcode Watermark  " +icra_elements.NPI.getAttribute("value"));
				Extent_Reporting.Log_Pass("ZipcodeWatermark ", "Zipcode Watermark", test, driver);

			}
			if(icra_elements.City.isDisplayed())
			{
				//log.info("City Watermark  " +icra_elements.City.getAttribute("value"));
				Extent_Reporting.Log_Pass("CityWatermark ", "City Watermark", test, driver);

			}
			if(icra_elements.Move_Copy_address1.isDisplayed())
			{
				//log.info("Address Watermark  " +icra_elements.Move_Copy_address1.getAttribute("value"));
				Extent_Reporting.Log_Pass("AddressWatermark", "Address Watermark", test, driver);

			}
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "Move_Copy_Watermark() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}
	}
	public void AddressList() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.AddressList);
			//icra_elements.AddressList.click();
			action.JSclickButton(icra_elements.AddressList, "Address list");
			action.waitForPageLoad();
			Extent_Reporting.Log_Pass("AddressList","Address List is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "AddressList() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}
	}
	
	public void SendRequest() throws Throwable
	{
		try {
			//click on send request button and submit button
			action.WaitUntilDisplayed(icra_elements.SendRequest);
			//icra_elements.SendRequest.click();
			JSCLICK(icra_elements.SendRequest);
			action.waitForPageLoad();
			
			//Select Mail radio button and submit
			action.WaitUntilDisplayed(icra_elements.MailSel);
			JSCLICK(icra_elements.MailSel);
			//icra_elements.MailSel.click();
			action.waitForPageLoad();
			//log.info("Mail radio button is clicked");
			
			action.WaitUntilDisplayed(icra_elements.SendSubmit);
			//icra_elements.SendSubmit.click();
			JSCLICK(icra_elements.SendSubmit);
			action.waitForPageLoad();
			
			//reset global search
			icra_elements.GlobalSearch.clear();
			action.WaitForElement(icra_elements.GlobalReset, "Clear");
			action.WaitForElement(icra_elements.GlobalReset, "Clear");
			action.JSclickButton(icra_elements.GlobalReset,"GlobalReset");
			action.waitForPageLoad();
			
			
			//Verify chase status
			action.WaitUntilDisplayed(icra_elements.ChaseStatus1);
			//log.info("Chase Status:"+icra_elements.ChaseStatus1.getText());
			Extent_Reporting.Log_Pass("ChaseStatus", "ChaseStatus After Send request"  +icra_elements.ChaseStatus1.getText(), test, driver);
			action.waitForPageLoad();
			action.waitForPageLoad();
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "SendRequest() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}
		
		
	}
	
	public void ResendRequest() throws Throwable
	{
	
		
		try {
			//click on send request button and submit button
			action.WaitUntilDisplayed(icra_elements.SendRequest);	
			action.clickButton(icra_elements.SendRequest,"GlobalReset");
			//icra_elements.SendRequest.click();
			action.waitForPageLoad(); 
			
			//action.WaitUntilDisplayed(icra_elements.SendValidation, 200);
			Extent_Reporting.Log_Pass("SendRequest", "SendRequest Message"  +icra_elements.Alert.getText(), test, driver);
			//log.info("Please click on resend request");
			action.waitForPageLoad(); 
			
			//reset and entered
			action.WaitUntilDisplayed(icra_elements.GlobalSearch);
			icra_elements.GlobalSearch.clear();
			//action.clearInputText(icra_elements.GlobalSearch, "GlobalSearch", "GlobalSearch");
			action.WaitForElement(icra_elements.GlobalReset, "Clear");
			action.clickButton(icra_elements.GlobalReset,"GlobalReset");
			action.waitForPageLoad(); 
			//Globalsearch
			String Chasestatus = icra_elements.ChaseStatus1.getText();
			action.inputText(icra_elements.GlobalSearch, Chasestatus, "GlobalSearch");
			//log.info(" GlobalSearch text is entered:");
			action.waitForPageLoad(); 
			
			//checkbox select
			Checkbox1();
			
			action.WaitUntilDisplayed(icra_elements.ResendRequest);
			//icra_elements.ResendRequest.click();
			JSCLICK(icra_elements.ResendRequest);
			action.waitForPageLoad(); 
			//log.info("Resend Button is clicked");
			
			action.WaitUntilDisplayed(icra_elements.SendSubmit);
			//icra_elements.SendSubmit.click();
			JSCLICK(icra_elements.SendSubmit);
			action.waitForPageLoad(); 
			//log.info("Submit button is clicked");
			
			//Print Validation of fax
			action.WaitUntilDisplayed(icra_elements.Alert);
			//log.info("Fax Validation :"+icra_elements.Alert.getText());
			Extent_Reporting.Log_Pass("FaxValidation", "Fax Validation"  +icra_elements.Alert.getText(), test, driver);

			////log.info("Please enter fax value");
			
			//Select Email radio button and print email validation
			action.WaitUntilDisplayed(icra_elements.EmailSel);
			//icra_elements.EmailSel.click();
			JSCLICK(icra_elements.EmailSel);
			action.waitForPageLoad(); 
			
			action.WaitUntilDisplayed(icra_elements.SendSubmit);
			//icra_elements.SendSubmit.click();
			JSCLICK(icra_elements.SendSubmit);
			action.waitForPageLoad(); 
			//log.info("Submit button is clicked");
			//print email validations
			action.WaitUntilDisplayed(icra_elements.Alert);
			//log.info("Email Validation :"+icra_elements.Alert.getText());
			Extent_Reporting.Log_Pass("EmailValidation", "Email Validation"  +icra_elements.Alert.getText(), test, driver);

			////log.info("Please enter email value ");
			
			action.WaitUntilDisplayed(icra_elements.SendClose);
			//icra_elements.SendSubmit.click();
			JSCLICK(icra_elements.SendClose);
			action.waitForPageLoad(); 
			//log.info("Close window of resend submenu button is clicked");
			
			
			//Provider details
			ProviderDetailsTab();
			AddContactPrimary();
			ChaseDetailsTab();
			
			
			//send fax 

			action.WaitUntilDisplayed(icra_elements.ResendRequest);
			//icra_elements.ResendRequest.click();
			JSCLICK(icra_elements.ResendRequest);
			action.waitForPageLoad(); 
			//log.info("Resend Button is clicked");
			
			action.WaitUntilDisplayed(icra_elements.SendSubmit);
			//icra_elements.SendSubmit.click();
			JSCLICK(icra_elements.SendSubmit);
			action.waitForPageLoad(); 
			//log.info("Submit button is clicked");
			
			//Print success of fax
			////log.info("Fax is sent");
			action.WaitUntilDisplayed(icra_elements.Alert);
			//log.info("Fax Success  :"+icra_elements.Alert.getText());
			Extent_Reporting.Log_Pass("FaxSuccess", "Fax Success"  +icra_elements.Alert.getText(), test, driver);

			
			//Rsend buuton
			action.WaitUntilDisplayed(icra_elements.ResendRequest);
			//icra_elements.ResendRequest.click();
			JSCLICK(icra_elements.ResendRequest);
			action.waitForPageLoad(); 
			//log.info("Resend Button is clicked");
			
			//select email
			action.WaitUntilDisplayed(icra_elements.EmailSel);
			//icra_elements.EmailSel.click();
			JSCLICK(icra_elements.EmailSel);
			action.waitForPageLoad(); 
			//log.info("EMail radio button is clicked");
			
			
			action.WaitUntilDisplayed(icra_elements.SendSubmit);
			//icra_elements.SendSubmit.click();
			JSCLICK(icra_elements.SendSubmit);
			action.waitForPageLoad(); 
			
			//Print success resent message
			action.WaitUntilDisplayed(icra_elements.Alert);
			//log.info("Resend success message :"+icra_elements.Alert.getText());
			Extent_Reporting.Log_Pass("ResendSuccess", "Resend Success"  +icra_elements.Alert.getText(), test, driver);
			
			////log.info("Resend request is sent");
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "ResendRequest() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}
		
	}
	
	public void CallDetailsTab_Retrieve() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.CallDetailsTab);
			action.JSclickButton(icra_elements.CallDetailsTab,"CallDetailsTab");
			action.waitForPageLoad(); 
			//log.info("Call Details Tab is clicked");
			
			
			//Retrieval Method
			action.selectDDByText(icra_elements.Retrieval, "Provider Portal");
			DisplayComboboxVal(icra_elements.Retrieval);
			action.waitForPageLoad(); 
			
			//date
			String Datecurrent=ExcelHandling.GetExcelData(TC_ID, "Expected");
			//log.info("Expected Date  :" +Datecurrent);
			action.clickButton(icra_elements.RetrievalExpected, "Current Date");
			action.waitForPageLoad(); 
			//icra_elements.ExpectedValidation.sendKeys(Datecurrent);
			//driver.findElement(By.xpath("//td[@aria-label='"+Datecurrent+"']")).click();
			action.waitForPageLoad(); 
			
			////log.info("Verify Date:"  +icra_elements.RetrievalExpected.getText());
			action.WaitUntilDisplayed(icra_elements.TodayDate);
			JSCLICK(icra_elements.TodayDate);
			action.waitForPageLoad(); 
			
			
//case 4-click on save and 
			action.WaitUntilDisplayed(icra_elements.RetSave);			
			//action.JSclickButton(icra_elements.RetSave, "save button");
			JSCLICK(icra_elements.RetSave);
			action.waitForPageLoad(); 
			//WebElement save=driver.findElement(By.xpath("//div[@aria-label='Data saved successfully']"));
			//log.info("Retrieval Method is save :");
			Extent_Reporting.Log_Pass("RetrievalMethod", "Retrieval Method Success  ", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "CallDetailsTab_Retrieve() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

	}
	
	public void ChaseDetailsTab() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.ChaseDetailsTab);
			//icra_elements.ChaseDetailsTab.click();
			JSCLICK(icra_elements.ChaseDetailsTab);
			action.waitForPageLoad(); 
			//log.info("Chase Details Tab is clicked");
			Extent_Reporting.Log_Pass("Chase Details Tab is clicked", "Chase Details Tab is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "ChaseDetailsTab() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}

	}
	
	public void ProviderDetailsTab() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.ProviderDetailsTab);
			//icra_elements.ProviderDetailsTab.click();
			JSCLICK(icra_elements.ProviderDetailsTab);
			action.waitForPageLoad(); 
			//log.info("ProviderDetailsTab  is clicked");
			Extent_Reporting.Log_Pass("ProviderDetailsTab is clicked", "ProviderDetails Tab is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "ProviderDetailsTab() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}

	}
	
	public void AddContactPrimary() throws Throwable
	{
		try {
			//Add button is clicked
			action.WaitUntilDisplayed(icra_elements.ContactAddbtn);
			//icra_elements.ContactAddbtn.click();
			JSCLICK(icra_elements.ContactAddbtn);
			action.waitForPageLoad(); 
			//log.info("ContactAddbtn  is clicked");
			Extent_Reporting.Log_Pass("ContactAddbtn is clicked", "ContactAddbtn Tab is clicked", test, driver);

			      //Input Primary first name
			       action.WaitUntilDisplayed(icra_elements.FirstName);
			       action.inputText(icra_elements.FirstName, ExcelHandling.GetExcelData(TC_ID, "FirstName"), "FirstName");
			       action.waitForPageLoad(); 
			       //log.info("FirstName  is sent ");
			
			        //Input Primary MiddleName
			        action.WaitUntilDisplayed(icra_elements.MiddleName);
			        action.inputText(icra_elements.MiddleName, ExcelHandling.GetExcelData(TC_ID, "MiddleName"), "MiddleName");
			        action.waitForPageLoad(); 
			        //log.info("MiddleName  is sent ");
			
			        //Input Primary LastName
					action.WaitUntilDisplayed(icra_elements.LastName);
					action.inputText(icra_elements.LastName, ExcelHandling.GetExcelData(TC_ID, "LastName"), "LastName");
					 action.waitForPageLoad(); 
					//log.info("LastName  is sent ");
			
					//Input Primary Phone
					action.WaitUntilDisplayed(icra_elements.Phone);
					action.inputText(icra_elements.Phone, ExcelHandling.GetExcelData(TC_ID, "Phone"), "FirstName");
					action.waitForPageLoad(); 
					//log.info("Phone  is sent ");
					
					//Input Primary ContactFax
					action.WaitUntilDisplayed(icra_elements.ContactFax);
					action.inputText(icra_elements.ContactFax, ExcelHandling.GetExcelData(TC_ID, "ContactFax"), "ContactFax");
					action.waitForPageLoad(); 
					//log.info("ContactFax  is sent ");
					
					//Input Primary ContactEmail
					action.WaitUntilDisplayed(icra_elements.ContactEmail);
					action.inputText(icra_elements.ContactEmail, ExcelHandling.GetExcelData(TC_ID, "ContactEmail"), "ContactEmail");
					 action.waitForPageLoad(); 
					//log.info("ContactEmail  is sent ");
					
					//Input Primary PrimaryAddRadio
					action.WaitUntilDisplayed(icra_elements.PrimaryAddRadio);
					//icra_elements.PrimaryAddRadio.click();
					JSCLICK(icra_elements.PrimaryAddRadio);
					 action.waitForPageLoad(); 
					//log.info("PrimaryAddRadio  is clicked ");
					
					
					//Input Primary save
					action.WaitUntilDisplayed(icra_elements.ContactSave);
					//icra_elements.ContactSave.click();
					JSCLICK(icra_elements.ContactSave);
					 action.waitForPageLoad(); 
					//log.info("ContactSave button  is clicked ");
					Extent_Reporting.Log_Pass("ContactSave is clicked", "ContactSave is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "AddContactPrimary() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

	}
	
	public void AddContact() throws Throwable
	{
		try {
			//Add button is clicked
					action.WaitUntilDisplayed(icra_elements.ContactAddbtn);
					//icra_elements.ContactAddbtn.click();
					JSCLICK(icra_elements.ContactAddbtn);
					action.waitForPageLoad(); 
					//log.info("ContactAddbtn  is clicked");
					
					      //Input Primary first name
					       action.WaitUntilDisplayed(icra_elements.FirstName);
					       action.inputText(icra_elements.FirstName, ExcelHandling.GetExcelData(TC_ID, "FirstName1"), "FirstName1");
					       action.waitForPageLoad(); 
					       //log.info("FirstName  is sent ");
					       
					       //Input Primary LastName
							action.WaitUntilDisplayed(icra_elements.LastName);
							action.inputText(icra_elements.LastName, ExcelHandling.GetExcelData(TC_ID, "LastName1"), "LastName1");
							 action.waitForPageLoad(); 
							//log.info("LastName  is sent ");
							
							//addcontact save Primary save
							action.WaitUntilDisplayed(icra_elements.ContactSave);
							//icra_elements.ContactSave.click();
							JSCLICK(icra_elements.ContactSave);
							 action.waitForPageLoad(); 
							//log.info("ContactSave button  is clicked ");
							Extent_Reporting.Log_Pass("ContactSave is clicked", "ContactSave is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "AddContact() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

				
	}
	
	public void SecondaryAddRadio() throws Throwable
	{
		try {
			//Input Primary PrimaryAddRadio
			action.WaitUntilDisplayed(icra_elements.SecondaryAddRadio);
			icra_elements.SecondaryAddRadio.click();
			//JSCLICK(icra_elements.PrimaryAddRadio);
			 action.waitForPageLoad(); 
			//log.info("Secondary radio is clicked ");
			Extent_Reporting.Log_Pass("Secondaryradio", "Secondary radio is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "SecondaryAddRadio() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

	}
	
	public void AddContactValidation() throws Throwable
	{
		try {
			//Add button is clicked
					action.WaitUntilDisplayed(icra_elements.ContactAddbtn);
					//icra_elements.ContactAddbtn.click();
					JSCLICK(icra_elements.ContactAddbtn);
					action.waitForPageLoad(); 
					//log.info("ContactAddbtn  is clicked");
					
			//Contact save
			action.WaitUntilDisplayed(icra_elements.ContactSave);
			icra_elements.ContactSave.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); 
			//log.info("ContactSave button  is clicked ");
			
			action.WaitUntilDisplayed(icra_elements.FirstNameVal);
			//log.info("First Name Validation :"  +icra_elements.FirstNameVal.getText());
			Extent_Reporting.Log_Pass("FirstNameValidation", "First Name Validation"  +icra_elements.FirstNameVal.getText(), test, driver);

			action.WaitUntilDisplayed(icra_elements.LastNameVal);
			//log.info("Last Name Validation :"  +icra_elements.LastNameVal.getText());
			Extent_Reporting.Log_Pass("LastNameValidation", "Last Name Validation"  +icra_elements.LastNameVal.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "AddContactValidation() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}

		
	}
	
	public void EditContact() throws Throwable
	{
		
		try {
			//Edit Button is clicked 
			action.WaitUntilDisplayed(icra_elements.EditContactBtn);
			icra_elements.EditContactBtn.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); 
			//log.info("Edit  button  is clicked ");
			
			//contact save 
			action.WaitUntilDisplayed(icra_elements.ContactSave);
			icra_elements.ContactSave.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); ;
			//log.info("ContactSave button  is clicked ");
			
			//print
			//log.info("Edit validation  :" +icra_elements.Alert.getText());
			Extent_Reporting.Log_Pass("Editvalidation", "Editvalidation"  +icra_elements.Alert.getText(), test, driver);

			
			//Select contact type as primary
			action.WaitUntilDisplayed(icra_elements.EditSelectContact);
			action.selectDDByText(icra_elements.EditSelectContact, "Primary");

			
			//Edit radio Button		
			SecondaryAddRadio();
			
			//contact save 
			action.WaitUntilDisplayed(icra_elements.ContactSave);
			icra_elements.ContactSave.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); ;
			
			//log.info("Contact success message:" +icra_elements.ContactsuccessMess.getText());
			Extent_Reporting.Log_Pass("Contact success message", "Contact success message"  +icra_elements.ContactsuccessMess.getText(), test, driver);

			
			//Verify secondary First nam
			action.WaitUntilDisplayed(driver.findElement(By.xpath("//a[@href='#tab122_2']")));
			driver.findElement(By.xpath("//a[@href='#tab122_2']")).click();
			WebElement Sec = driver.findElement(By.xpath("//div[@id='tab122_2']//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "LastName")+"')]"));
			//log.info("Verify Secondary Tab:" +Sec.getText());
			Extent_Reporting.Log_Pass("VerifySecondary", "Verify Secondary Tab"  +Sec.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "EditContact() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

	}
	
	
	public void ViewContact() throws Throwable
	{
		
		try {
			//View Button is clicked 
			action.WaitUntilDisplayed(icra_elements.ViewContactBtn);
			icra_elements.ViewContactBtn.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); 
			//log.info("View  button  is clicked ");
			
			//Select primary radio	of secondrow	
			//First row Primary Button is clicked 
			action.WaitUntilDisplayed(icra_elements.PrimaryViewRadio);
			icra_elements.PrimaryViewRadio.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); 
			//log.info("Primary view radio 1st row button  is clicked ");
			
			//log.info("Primary Validation Messge"  + icra_elements.Alert.getText() );
			Extent_Reporting.Log_Pass("PrimaryValidation", "Primary Validation Messge"  +icra_elements.Alert.getText(), test, driver);

			
			
			//First row Primary Button is clicked 
					action.WaitUntilDisplayed(icra_elements.PrimaryViewRadio_2row);
					icra_elements.PrimaryViewRadio_2row.click();
					//JSCLICK(icra_elements.ContactSave);
					 action.waitForPageLoad(); 
					//log.info("Primary view radio 2nd row button  is clicked ");
					
			//view save button is clicked
			action.WaitUntilDisplayed(icra_elements.ViewContactSave);
			icra_elements.ViewContactSave.click();
			//JSCLICK(icra_elements.ContactSave);
			 action.waitForPageLoad(); 
			//log.info("View  Save button  is clicked ");
			Extent_Reporting.Log_Pass("ViewSave", "View  Save button  is clicked", test, driver);

			
			//Verify Primary First name
			action.WaitUntilDisplayed(driver.findElement(By.xpath("//a[@href='#tab122_1']")));
			driver.findElement(By.xpath("//a[@href='#tab122_1']")).click();
			WebElement Sec = driver.findElement(By.xpath("//div[@id='tab122_1']//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "LastName1")+"')]"));
			//log.info("Verify Secondary Tab :" +Sec.getText());
			Extent_Reporting.Log_Pass("VerifySecondary", "Verify Secondary Tab"  +Sec.getText(), test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "ViewContact() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

		
	}
	
	public void Contact_Delete() throws Throwable
	{
		try {
			//View Button is clicked 
					action.WaitUntilDisplayed(icra_elements.ViewContactBtn);
					icra_elements.ViewContactBtn.click();
					//JSCLICK(icra_elements.ContactSave);
					 action.waitForPageLoad(); 
					//log.info("View  button  is clicked ");
					
					//Delete buton is clicked
					action.WaitUntilDisplayed(icra_elements.ViewDeleteBtn);
					icra_elements.ViewDeleteBtn.click();	
					 action.waitForPageLoad(); 
					 
					 //Confirm delete option
					 action.WaitUntilDisplayed(icra_elements.ViewDeleteConfirm);
						icra_elements.ViewDeleteConfirm.click();	
						action.waitForPageLoad(); 
						//log.info("Contact is deleted ");
						Extent_Reporting.Log_Pass("Contactdeleted ", "Contact is deleted ", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "Contact_Delete() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

				
	}
	
	public void Contact_Watermark() throws Throwable
	{
		try {
			if(icra_elements.FirstName.isDisplayed())
			{
				//log.info("FirstName Watermark  " +icra_elements.FirstName.getAttribute("placeholder"));
				Extent_Reporting.Log_Pass("FirstNameWatermark ", "FirstName Watermark is present ", test, driver);

			}
			else
			{
				//log.info("FirstName Watermark is absent");
				Extent_Reporting.Log_Fail("FirstNameWatermark ", "FirstName Watermark is absent", test, driver);

			}
			if(icra_elements.MiddleName.isDisplayed())
			{
				//log.info("MiddleName Watermark  " +icra_elements.MiddleName.getAttribute("placeholder"));
				Extent_Reporting.Log_Pass("MiddleNameWatermark ", "MiddleName Watermark is present", test, driver);

			}
			else
			{
				//log.info("MiddleName Watermark  is absent");
				Extent_Reporting.Log_Fail("MiddleName Watermark ", "MiddleName Watermark is absent ", test, driver);

			}
			if(icra_elements.LastName.isDisplayed())
			{
				//log.info("LastName Watermark  " +icra_elements.LastName.getAttribute("placeholder"));
				Extent_Reporting.Log_Pass("LastNameWatermark ", "LastName Watermark is present", test, driver);

			}
			else
			{
				//log.info("LastName Watermark is absent ");
				Extent_Reporting.Log_Fail("LastNameWatermark ", "LastName Watermark is absent ", test, driver);

			}
			if(icra_elements.Phone.isDisplayed())
			{
				//log.info("Phone Watermark  " +icra_elements.Phone.getAttribute("placeholder"));
				Extent_Reporting.Log_Pass("PhoneWatermark ", "Phone Watermark is present", test, driver);

			}
			else
			{
				//log.info("Phone Watermark is absent ");
				Extent_Reporting.Log_Fail("PhoneWatermark ", "Phone Watermark is absent ", test, driver);

			}
			if(icra_elements.ContactFax.isDisplayed())
			{
				//log.info("ContactFax Watermark  " +icra_elements.ContactFax.getAttribute("placeholder"));
				Extent_Reporting.Log_Pass("ContactFaxWatermark ", "ContactFax Watermark is present", test, driver);

			}
			else
			{
				//log.info("ContactFax Watermark is absent");
				Extent_Reporting.Log_Fail("ContactFaxWatermark ", "ContactFax Watermark is absent ", test, driver);

			}
			if(icra_elements.ContactEmail.isDisplayed())
			{
				//log.info("ContactEmail Watermark  " +icra_elements.ContactEmail.getAttribute("value"));
				Extent_Reporting.Log_Pass("ContactEmailWatermark ", "ContactEmail Watermark is present", test, driver);

			}
			else
			{
				//log.info("ContactEmail Watermark is absent ");
				Extent_Reporting.Log_Fail("ContactEmailWatermark ", "ContactEmail Watermark is absent ", test, driver);

			}//end else
			
			//Cancelbutton
			 action.WaitUntilDisplayed(icra_elements.AddcontactCancel);
			 //icra_elements.AddcontactCancel.click();	
			JSCLICK(icra_elements.AddcontactCancel);
			//log.info("Close button is clicked");
			Extent_Reporting.Log_Pass("Closebutton ", "Close button is clicked", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "Contact_Watermark() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

	}//end condition
	
	public void Address_Watermark() throws Throwable
	{
		try {
			if(icra_elements.Add1.isDisplayed())
			{
				//log.info("Add1 Watermark  " +icra_elements.Add1.getAttribute("value"));
				Extent_Reporting.Log_Pass("Add1Watermark ", "Add1 Watermark is present ", test, driver);

			}
			else
			{
				//log.info("Add1 Watermark is absent ");
				Extent_Reporting.Log_Fail("Add1Watermark ", "Add1 Watermark is absent ", test, driver);

			}//end else
			if(icra_elements.Add2.isDisplayed())
			{
				//log.info("Add2 Watermark  " +icra_elements.Add2.getAttribute("value"));
				Extent_Reporting.Log_Pass("Add2Watermark ", "Add1 Watermark is present ", test, driver);

			}
			else
			{
				//log.info("Add2 Watermark is absent ");
				Extent_Reporting.Log_Fail("Add2Watermark ", "Add2 Watermark is absent ", test, driver);

			}//end else
			if(icra_elements.AddCity.isDisplayed())
			{
				//log.info("AddCity Watermark  " +icra_elements.AddCity.getAttribute("value"));
				Extent_Reporting.Log_Pass("AddCityWatermark ", "AddCity Watermark is present ", test, driver);

			}
			else
			{
				//log.info("AddCity Watermark is absent ");
				Extent_Reporting.Log_Fail("AddCityWatermark ", "AddCity Watermark is absent ", test, driver);

			}//end else
			
			if(icra_elements.AddZip.isDisplayed())
			{
				//log.info("AddZip Watermark  " +icra_elements.AddZip.getAttribute("value"));
				Extent_Reporting.Log_Pass("AddZipWatermark ", "AddZip Watermark is present ", test, driver);

			}
			else
			{
				//log.info("AddZip Watermark is absent ");
				Extent_Reporting.Log_Fail("AddZipWatermark ", "AddZip Watermark is absent ", test, driver);

			}//end else
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "Address_Watermark() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}
		
		
	}
	
	public void Address_Validation() throws Throwable
	{
		
		 try {
			//Add button
			 action.WaitUntilDisplayed(icra_elements.AddressAdd);
			 icra_elements.AddressAdd.click();	
			 action.waitForPageLoad(); 
			 //log.info("AddressAdd is clicked ");
			 		 
			 icra_elements.AddZip.clear();
			 
			 action.WaitUntilDisplayed(icra_elements.AddressSave);
			 action.clickButton(icra_elements.AddressSave, "save");

			 //clear address
			 action.WaitUntilDisplayed(icra_elements.Add1);
			 icra_elements.Add1.clear();
			 icra_elements.AddCity.clear();
			 icra_elements.AddState.clear();
 
			 //Print validation message	
			 //action.WaitUntilDisplayed(icra_elements.Add1Val);
			 action.isElementDisplayed(icra_elements.Add1Val, icra_elements.Add1Val.getText());
			 //log.info("Address1 Validation  :" +icra_elements.Add1Val.getText());

			 //Print validation message	
			 action.WaitUntilDisplayed(icra_elements.CityVal);
			 //log.info("City Validation  :" +icra_elements.CityVal.getText());
			 
			//Print validation message	
			 action.WaitUntilDisplayed(icra_elements.StateVal);
			 //log.info("State Validation  :" +icra_elements.StateVal.getText());

			//Print validation message	
			 action.WaitUntilDisplayed(icra_elements.ZipVal);
			 //log.info("Zipcode Validation  :" +icra_elements.ZipVal.getText());
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "Address_Validation() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}
			 
	}
	
	public void AddAddress() throws Throwable
	{
		 try {
			//Add button
			 action.WaitUntilDisplayed(icra_elements.AddressAdd);
			 icra_elements.AddressAdd.click();	
			 action.waitForPageLoad(); 
			 //log.info("AddressAdd is clicked ");
			 
			//Input  Add1 name
			 icra_elements.Add1.clear();
			   action.WaitUntilDisplayed(icra_elements.Add1);
			   action.inputText(icra_elements.Add1, ExcelHandling.GetExcelData(TC_ID, "Add1"), "Add1");
			   action.waitForPageLoad(); 
			   //log.info("Add1  is sent ");
			 
			 //Input  add2  name
			   icra_elements.Add2.clear();
			   action.WaitUntilDisplayed(icra_elements.Add2);
			   action.inputText(icra_elements.Add2, "Test", "Add2");
			   action.waitForPageLoad(); 
			   //log.info("Add2 is sent ");
			   
			 //Input  AddCity name
			   icra_elements.AddCity.clear();
			   action.WaitUntilDisplayed(icra_elements.AddCity);
			   action.inputText(icra_elements.AddCity, ExcelHandling.GetExcelData(TC_ID, "City"), "City");
			   action.waitForPageLoad(); 
			   //log.info("City is sent ");
			   
			 //Input  AddState name
			   icra_elements.AddState.clear();
			   action.WaitUntilDisplayed(icra_elements.AddState);
			   action.inputText(icra_elements.AddState, ExcelHandling.GetExcelData(TC_ID, "State"), "State");
			   action.waitForPageLoad(); 
			   //log.info("State is sent "); 
			   
			 //Input  AddState name
			   icra_elements.AddZip.clear();
			   action.WaitUntilDisplayed(icra_elements.AddZip);
			   action.inputText(icra_elements.AddZip, ExcelHandling.GetExcelData(TC_ID, "Zipcode"), "Zipcode");
			   action.waitForPageLoad(); 
			   //log.info("Zipcode is sent "); 
			   
			 //Save button
				 action.WaitUntilDisplayed(icra_elements.AddressSave);
				 icra_elements.AddressSave.click();	
				 action.waitForPageLoad(); 
				 //log.info("Address Save is clicked ");
					Extent_Reporting.Log_Pass("AddressSave ", "Address Save is clicked ", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "AddAddress() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

				 
	}
	
	public void EditAddress() throws Throwable
	{
		 try {
			//Edit button
			 action.WaitUntilDisplayed(icra_elements.AddEdit);
			 icra_elements.AddEdit.click();	
			 action.waitForPageLoad(); 
			 //log.info("Edit is clicked ");
			 
			 //Edit 
			 action.WaitUntilDisplayed(icra_elements.Add2);
			   action.inputText(icra_elements.Add2, "Test", "FirstName");
			   action.waitForPageLoad(); 
			   //log.info("Add2 is sent ");
			   
			 
			//Save button
			 action.WaitUntilDisplayed(icra_elements.AddressSave);
			 icra_elements.AddressSave.click();	
			 action.waitForPageLoad(); 
			 //log.info("Address Save is clicked ");
				Extent_Reporting.Log_Pass("AddressSave ", "Address Save is clicked ", test, driver);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "EditAddress() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}

	}
	
	public void NPPES_Watermark() throws Throwable
	{
		try {
			//Save button
			 action.WaitUntilDisplayed(icra_elements.NPPESBtn);
			 icra_elements.NPPESBtn.click();	
			 action.waitForPageLoad(); 
			 //log.info("NPPES is clicked ");
			 
			 if(icra_elements.NPPESNPI.isDisplayed())
				{
					//log.info("NPPESNPI Watermark" +icra_elements.NPPESNPI.getAttribute("value"));
					Extent_Reporting.Log_Pass("NPPESNPIWatermark", "NPPESNPI Watermark is present", test, driver);

				}
				else
				{
					//log.info("NPPESNPI Watermark is absent ");
					Extent_Reporting.Log_Fail("NPPESNPIWatermark", "NPPESNPI Watermark is absent", test, driver);

				}//end else
			 
			 if(icra_elements.NPPESNPIFirst.isDisplayed())
				{
					//log.info("NPPESNPIFirst Watermark  " +icra_elements.NPPESNPIFirst.getAttribute("value"));
					Extent_Reporting.Log_Pass("NPPESNPIFirstWatermark", "NPPESNPIFirst Watermark is present", test, driver);

				}
				else
				{
					//log.info("NPPESNPIFirst Watermark is absent ");
					Extent_Reporting.Log_Fail("NPPESNPIFirstWatermark", "NPPESNPIFirst Watermark is absent", test, driver);

				}//end else
			 if(icra_elements.NPPESNPILast.isDisplayed())
				{
					//log.info("NPPESNPILast Watermark  " +icra_elements.NPPESNPILast.getAttribute("value"));
					Extent_Reporting.Log_Pass("NPPESNPILastWatermark", "NPPESNPILast Watermark is present", test, driver);

				}
				else
				{
					//log.info("NPPESNPILast Watermark is absent ");
					Extent_Reporting.Log_Fail("NPPESNPILastWatermark", "NPPESNPILast Watermark is absent", test, driver);

				}//end else
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "NPPES_Watermark() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());


		}
		 
	   }
	
	     public void NPPES_Search() throws Throwable
	     {
	    	 
			 
			try {
				//NPPES search button
				 icra_elements.NPPESSearch.click();	
				 //log.info("NPPES  button is clicked ");
				 
				 //Print Validation
				 //log.info("Search validation  :" +icra_elements.NPPESSearch.getText());  
				 Extent_Reporting.Log_Pass("Searchvalidation", "Search validation"  +icra_elements.NPPESSearch.getText(), test, driver);

				 
				 //search ny firstname
				 action.inputText(icra_elements.NPPESNPIFirst, ExcelHandling.GetExcelData(TC_ID, "NPPESFirst"), "NPPESFirst");
				// //log.info("NPPESFirst autopopulate  :" +icra_elements.NPPESSearch.getText());  
					WebElement Firauto = driver.findElement(By.xpath("//li[1]//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "NPPESFirst")+"')]"));
					//log.info("NPPESFirst autopopulate  :" +Firauto.getText());
					 Extent_Reporting.Log_Pass("NPPESFirstautopopulate", "NPPESFirst autopopulate"  +Firauto.getText(), test, driver);

					
					//NPPES search button
					 
					 action.clickButton(icra_elements.NPPESSearch, "NPPESSearch");
					 action.waitForPageLoad(); 
					 //icra_elements.NPPESSearch.click();	
					 //log.info("NPPES  button is clicked ");
					 
					WebElement VerifyFir= driver.findElement(By.xpath("//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "NPPESFirst")+"')]"));
					action.WaitUntilDisplayed(VerifyFir);
					action.WaitForElement(VerifyFir, "VerifyFir");
					//log.info("Verify Firstname :" +VerifyFir.getText());
					 Extent_Reporting.Log_Pass(" VerifyFirstname", "Verify Firstname "  +VerifyFir.getText(), test, driver);
					action.waitForPageLoad(); 
				 
					
					//serach my last
					 action.inputText(icra_elements.NPPESNPILast, ExcelHandling.GetExcelData(TC_ID, "NPPESLast"), "NPPESNPILast");
					
					 WebElement las = driver.findElement(By.xpath("//li[1]//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "NPPESLast")+"')]"));
					 action.mouseHover(las);
					 action.WaitUntilDisplayed(las);
					//log.info("NPPESNPILast autopopulate  :" +las.getText());
					 Extent_Reporting.Log_Pass("NPPESNPILastautopopulate", "NPPESNPILast autopopulate "  +las.getText(), test, driver);

					 action.waitForPageLoad(); 
					 
   
					//search by last namy
					 action.inputText(icra_elements.NPPESNPI, ExcelHandling.GetExcelData(TC_ID, "NPPESNPI"), "NPPESNPI");
						WebElement NPIAuto = driver.findElement(By.xpath("//li[1]//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "NPPESNPI")+"')]"));
						//log.info("NPPESNPI autopopulate  :" +NPIAuto.getText());
						 Extent_Reporting.Log_Pass(" NPPESNPIautopopulate", "NPPESNPI autopopulate "  +NPIAuto.getText(), test, driver);

						action.waitForPageLoad(); 
						
						//NPPES search button
						 action.WaitUntilDisplayed( icra_elements.NPPESSearch);
						 action.clickButton(icra_elements.NPPESSearch, "searc");
						 //log.info("NPPES  button is clicked ");
							action.waitForPageLoad(); 
						
						WebElement VerifyNPI= driver.findElement(By.xpath("//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "NPPESNPI")+"')]"));
						action.WaitUntilDisplayed(VerifyNPI);
						//log.info("Verify NPI  :" +VerifyNPI.getText());
						 Extent_Reporting.Log_Pass("VerifyNPI ", "VerifyNPI "  +VerifyNPI.getText(), test, driver);

//					WebElement VerifyLas= driver.findElement(By.xpath("//div[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "NPPESLast")+"')]"));
//					action.WaitUntilDisplayed(VerifyLas);
//					//log.info("Verify LastName  :" +VerifyFir.getText());
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "NPPES_Search() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());


			}
				
					
	     }
	     
	     public void Previous_Next_Untouched() throws Throwable
	     {
	    	 try {
				//Print address id before next
				 //log.info("Before next address Id :" +icra_elements.Addressidprint.getText());
				 Extent_Reporting.Log_Pass("BeforenextaddressId", "Before next address Id"  +icra_elements.Addressidprint.getText(), test, driver);

				 
				 //click next button
				 action.clickButton(icra_elements.NextBtn, "NextBtn");
				 //log.info("next buttons clicked");
				 //print address id
				 //log.info("After next address Id :" +icra_elements.Addressidprint.getText());
				 Extent_Reporting.Log_Pass("BeforenextaddressId", "Before next address Id"  +icra_elements.Addressidprint.getText(), test, driver);


				//click Previos button
				 action.clickButton(icra_elements.PreviousBtn, "PreviousBtn");
				 //log.info("Previous buttons clicked");
				 //print address id
				 //log.info("After Previous button clicked  address Id :" +icra_elements.Addressidprint.getText());
				 Extent_Reporting.Log_Pass("AfterPreviousaddressId ", "After Previous button clicked  address Id "  +icra_elements.Addressidprint.getText(), test, driver);


				//click Previos button
				 action.clickButton(icra_elements.PreviousBtn, "PreviousBtn");
				 //log.info("Previous buttons clicked");
				 
				 //Validation message if it is first address and previous button is clicked
				 //log.info("Validation on Previous:" +icra_elements.Previousalert.getText());
				 Extent_Reporting.Log_Pass("ValidationPrevious", "Validation on Previous"  +icra_elements.Previousalert.getText(), test, driver);
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "Previous_Next_Untouched() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());


			}


	     }
	     
	     public void AddressIDFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.AddFilter, "AddFilter");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "AddIDfilter"), "AddIDfilter");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "AddIDfilter")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "AddFilter");
				 
				//Print result of address
				 //log.info("Result of Addressids:" +icra_elements.AddIDRollup1.getText());
				 Extent_Reporting.Log_Pass("ResultAddressids", "Result of Addressids"  +icra_elements.AddIDRollup1.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "AddFilter");
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "AddressIDFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());


			}    	 
	    	 
	     }
	     
	     public void TotalchaseFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.TotalChaseFilter, "TotalChaseFilter");
				 action.waitForPageLoad();
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "TotalChaseFilter"), "TotalChaseFilter");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "TotalChaseFilter")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "TotalChaseFilter");
				 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "TotalChaseFilter")+"')]"));
				 //log.info("Result of Total Chase:" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultTotalChase", "Result of Total Chase"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "TotalChaseFilter");
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "TotalchaseFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());


			}	    	 
	    	 
	     }
	     
	     public void ProviderFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.ProviderCnt, "ProviderCnt");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.ProviderCnt,  "ProviderCnt");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "ProviderFil"), "ProviderFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "ProviderFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "ProviderFil");
				 action.waitForPageLoad(); 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "ProviderFil")+"')]"));
				 //log.info("Result of ProviderFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultProviderFil", "Result of ProviderFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "ProviderFil");	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "ProviderFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());


			} 
	    	 
	     }
	     public void Adress1Filter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.Address1Fil, "Address1Fil");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.SearchInput, "Address1Fil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "Address1Fil"), "Address1Fil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "Address1Fil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "Address1Fil");
				 action.waitForPageLoad(); 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Address1Fil")+"')]"));
				 //log.info("Result of Address1Fil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultAddress1Fil", "Result of Address1Fil"  +Totcha.getText(), test, driver);

				 //Uncheck box
				 action.clickButton(Checkbox, "Address1Fil");	  
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "Adress1Filter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			} 
	    	 
	     }
	     
	     public void Adress2Filter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.Address2Fil, "Address2Fil");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.SearchInput, "Address2Fil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "Address2Fil"), "Address2Fil");
				 action.waitForPageLoad(); 
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "Address2Fil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "Address2Fil");
				 action.waitForPageLoad(); 
				 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Address2Fil")+"')]"));
				 //log.info("Result of Address2Fil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultAddress2Fil", "Result of Address2Fil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "Address2Fil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "Adress2Filter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			} 
	    	 
	     }
	     
	     
	     public void CityFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.CityFil, "CityFil");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.SearchInput,  "CityFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "CityFil"), "CityFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "CityFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "CityFil");
				 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "CityFil")+"')]"));
				 //log.info("Result of CityFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultCityFil", "Result of CityFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "CityFil");
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "CityFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			} 
	    	 
	     }
	     
	     public void StateFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.StateFil, "StateFil");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.StateFil, "StateFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "StateFil"), "StateFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "StateFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "StateFil");
				 action.waitForPageLoad(); 
				 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "StateFil")+"')]"));
				 //log.info("Result of StateFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultStateFil", "Result of StateFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "StateFil");
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "StateFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());
			} 
	    	 
	     }
	     
	     public void ZipFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.ZipFil, "ZipFil");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.SearchInput, "ZipFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "ZipFil"), "ZipFil");
				 action.waitForPageLoad(); 
				 //click checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "ZipFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "ZipFil");
				 action.waitForPageLoad(); 
				 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "ZipFil")+"')]"));
				 //log.info("Result of ZipFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultZipFil", "Result of ZipFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "ZipFil");
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "ZipFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			} 	    	 
	     }
	     
	     public void ContactFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.ContatFil, "ContatFil");
				 action.waitForPageLoad(); 
				 action.WaitForElement(icra_elements.SearchInput, "ContatFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "ContatFil"), "ContatFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath("//li[contains(@aria-label,'"+ExcelHandling.GetExcelData(TC_ID, "ContatFil")+"')]//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "ContatFil");
				 action.waitForPageLoad(); 
				 
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "ContatFil")+"')]"));
				 //log.info("Result of ContatFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultContatFil", "Result of ContatFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "ContatFil");	
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "ContactFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	    	 
	     }
	     
	     public void FaxFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.FaxFil, "FaxFil");
				 action.waitForPageLoad();
				 action.WaitForElement(icra_elements.SearchInput, "ContatFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "FaxFil"), "FaxFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath("//li[contains(@aria-label,'"+ExcelHandling.GetExcelData(TC_ID, "FaxFil")+"')]//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "FaxFil");
				 action.waitForPageLoad();
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "FaxFil")+"')]"));
				 //log.info("Result of FaxFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultsFaxFil", "Result of FaxFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "FaxFil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "FaxFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     public void EmailFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.EmailFil, "EmailFil");
				 action.waitForPageLoad();
				 action.WaitForElement(icra_elements.SearchInput, "EmailFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "EmailFil"), "EmailFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "EmailFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "EmailFil");
				 action.waitForPageLoad();
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "EmailFil")+"')]"));
				 //log.info("Result of EmailFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultEmailFil", "Result of EmailFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "EmailFil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "EmailFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     public void InprocessTAB() throws Throwable
	     {
	    	 try {
				action.WaitForElement(icra_elements.InprocessTab, "InprocessTab");
				 action.JSclickButton(icra_elements.InprocessTab, "InprocessTab");
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "InprocessTAB() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     public void LastCallFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.LastContactFil, "LastCallFil");
				 action.waitForPageLoad();
				 action.WaitForElement(icra_elements.SearchInput, "LastCallFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "LastCallFil"), "LastCallFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "LastCallFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "LastCallFil");
				 action.waitForPageLoad();
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "LastCallFil")+"')]"));
				 //log.info("Result of LastCallFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultLastCallFil", "Result of LastCallFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "LastCallFil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "LastCallFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     public void StatusFilter() throws Throwable
	     {
	    	 //Click on address id
	    	 
	    	 try {
				action.JSclickButton(icra_elements.StatusFil, "StatusFil");
				 action.waitForPageLoad();
				 action.WaitForElement(icra_elements.SearchInput, "StatusFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "StatusFil"), "StatusFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "StatusFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "StatusFil");
				 action.waitForPageLoad();
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "StatusFil")+"')]"));
				 //log.info("Result of StatusFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultStatusFil", "Result of StatusFil"  +Totcha.getText(), test, driver);
				 
				 //Uncheck box
				 action.clickButton(Checkbox, "StatusFil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "StatusFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     public void Call_DispositionFilter() throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.Call_DispositionFil, "Call_DispositionFil");
				 action.waitForPageLoad();
				 action.WaitForElement(icra_elements.SearchInput, "Call_DispositionFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "Call_DispositionFil"), "Call_DispositionFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath(" //li[@aria-label='"+ExcelHandling.GetExcelData(TC_ID, "Call_DispositionFil")+"']//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "Call_DispositionFil");
				 action.waitForPageLoad();
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Call_DispositionFil")+"')]"));
				 //log.info("Result of Call_DispositionFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultCallDispositionFil", "Result of Call_DispositionFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "Call_DispositionFil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "Call_DispositionFilter() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     public void Follow_up_DateFilter()throws Throwable
	     {
	    	 try {
				//Click on address id
				 
				 action.JSclickButton(icra_elements.Follow_up_DateFil, "Follow_up_DateFil");
				 action.waitForPageLoad();
				 action.WaitForElement(icra_elements.SearchInput, "Follow_up_DateFil");
				 action.inputText(icra_elements.SearchInput, ExcelHandling.GetExcelData(TC_ID, "Follow_up_DateFil"), "Follow_up_DateFil");
				 //cllick checkbox
				 WebElement Checkbox= driver.findElement(By.xpath("//li[contains(@aria-label,'"+ExcelHandling.GetExcelData(TC_ID, "Follow_up_DateFil")+"')]//div[contains(@class,'ui-chkbox-box')]"));
				 action.clickButton(Checkbox, "Follow_up_DateFil");
				 action.waitForPageLoad();
				//Print result of address
				 WebElement Totcha=driver.findElement(By.xpath("//td[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Follow_up_DateFil")+"')]"));
				 //log.info("Result of Follow_up_DateFil :" +Totcha.getText());
				 Extent_Reporting.Log_Pass("ResultFollowupDateFil", "Result of Follow_up_DateFil"  +Totcha.getText(), test, driver);

				 
				 //Uncheck box
				 action.clickButton(Checkbox, "Follow_up_DateFil");	    	 
				 action.waitForPageLoad();
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "Follow_up_DateFilter () failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}
	     }
	     
	     
	     public void PrintBtn() throws Throwable
	     {
	    	 try {
				action.WaitForElement(icra_elements.PrintBtn, "PrintBtn");
				 action.clickButton(icra_elements.PrintBtn, "PrintBtn");
				 Extent_Reporting.Log_Pass("PrintBtn", "PrintBtn button is clicked", test, driver);
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "PrintBtn () failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());
			}
	    	 
	     }
}

package com.qa.BusinessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_PageObjects_Archana;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;

public class Scan_Tech_Logic extends Extent_Reporting
{

	ElementAction action = new ElementAction();
	String TC_ID = null;	
	WebDriver driver;
	ICRA_PageObjects_Archana icra_elements; 
	String address2 = null;
	String newDate1 =null;

	public Scan_Tech_Logic(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PageObjects_Archana(driver);
		
	}
	
	public void Pageload(int number, long time)
	{
		
		for(int i=0;i<=number;i++)
		{ 
			driver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
		}
	}
	
	public String DisplayComboboxVal(WebElement elem) 	
	{   
		Select select = new Select(elem);
		WebElement Act = select.getFirstSelectedOption();
		String Action = Act.getText();
		driver.manage().timeouts().pageLoadTimeout(GlobalConstant.Global_Wait,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info(Action + " is selected");
		return Action;
	}
	
    public void EMR() throws Throwable
    {
   	 try {
		//case1 - EMR2 Multiselect
		 action.clickButton(icra_elements.EMR2, "EMR2");
		 Pageload(1, 90);
		 
		 //select and print EMR2 Value
		//action.clickButton(icra_elements.EMRValueMulti, "Multi select combo  value");
		action.WaitForElement(icra_elements.EMRValueMulti, "EMRValueMulti");
		action.inputText(icra_elements.EMRValueMulti, "360", "360");
		 log.info("EMR value 360 is entered");
		    WebElement EMR2first = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label='Care 360']//parent::div"));
		action.clickButton(EMR2first, "First value");
		icra_elements.EMRValueMulti.clear();
		action.inputText(icra_elements.EMRValueMulti, "cerner", "cerner");
		WebElement EMR2second = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label='Cerner']//parent::div"));
		action.clickButton(EMR2second, "EMR2second value");
		 Pageload(1, 90);

		 log.info("EMR Multiselect value :" +icra_elements.EMRValueMulti.getText());
		 Extent_Reporting.Log_Pass("EMR Multiselect value", "EMR Multiselect value"+icra_elements.EMRValueMulti.getText(), test, driver);					

   
		   //case 2 paper
		 action.clickButton(icra_elements.paper, "paper");
		 Pageload(1, 90);
		 
		 //EMR button should be disabled
		 if(icra_elements.EMRValueSingle.isEnabled())
		 {
			 log.info("Button is Enabled");
			 Extent_Reporting.Log_Fail("Button enabled", "Button enabled", test, driver);					
		 }
		 else
		 {
			 log.info("Button is Disabled");
			 Extent_Reporting.Log_Pass("Button Disabled", "Button Disabled", test, driver);					
		 }
		 
		 //case 3 paper
		 action.clickButton(icra_elements.printpaper, "paper");
		 Pageload(1, 90);
		 
		 //EMR button should be disabled
		 if(icra_elements.EMRValueSingle.isEnabled())
		 {
			 log.info("Button is Enabled");
			 Extent_Reporting.Log_Fail("Button enabled", "Button enabled", test, driver);					
		 }
		 else
		 {
			 log.info("Button is Disabled");
			 Extent_Reporting.Log_Pass("Button Disabled", "Button Disabled", test, driver);					
		 }
		 
		//case 4 paper
		    action.clickButton(icra_elements.Hybrid, "Hybrid");
		    Pageload(1, 90);
		 
		    //Clear All
		     action.clickButton(icra_elements.ClearAll, "ClearAll");
		    //select and print EMR2 Value
		    	//action.clickButton(icra_elements.EMRValueMulti, "Multi select combo  value");
		    	action.WaitForElement(icra_elements.EMRValueMulti, "EMRValueMulti");
		    	action.inputText(icra_elements.EMRValueMulti, "360", "360");
		    	 log.info("EMR value 360 is entered");
			    WebElement EMR2first1 = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label='Care 360']//parent::div"));
		    	action.clickButton(EMR2first1, "First value");
		    	icra_elements.EMRValueMulti.clear();
		    	action.inputText(icra_elements.EMRValueMulti, "cerner", "cerner");
		    	WebElement EMR2second2 = driver.findElement(By.xpath("//span[@ng-reflect-ng-item-label='Cerner']//parent::div"));
		    	action.clickButton(EMR2second2, "EMR2second value");
		    	 Pageload(1, 90);
		    	 //log.info("EMR Multiselect value :" +icra_elements.EMRValueMulti.getText());
		    	 Extent_Reporting.Log_Pass("EMR Multiselect value", "EMR Multiselect value"+icra_elements.EMRValueMulti.getText(), test, driver);					

		
		    
		    //case 4 emr1
		        action.clickButton(icra_elements.EMR1, "EMRR1");
		        Pageload(1, 90);
		        action.selectDDByText(icra_elements.EMRValueSingle, ExcelHandling.GetExcelData(TC_ID, "EMRValue"));
		    	DisplayComboboxVal(icra_elements.EMRValueSingle);
		   	 Extent_Reporting.Log_Pass("EMR EMRValueSingle value", "EMR EMRValueSingle value"+icra_elements.EMRValueSingle.getText(), test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "EMR() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());

	}					

	    	
    }
    
      public void FieldTech_State() throws Throwable
    {
   	 try {
		//Click on state
		 WebElement state= driver.findElement(By.xpath("//*[contains(@id,'text')]//*[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "State")+"')]"));
		 action.clickButton(state, "state");
		 //log.info("state button is clicked");
		   	Extent_Reporting.Log_Pass("state button is clicked", "state button is clicked", test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "FieldTech_State() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
		
	}					

    }
    
    public void FieldTech_Cityradio() throws Throwable
    {
   	 try {
		//Field tech radio
		    action.WaitForElement(icra_elements.FieltechCity, "FieltechCity");
		 action.clickButton(icra_elements.FieltechCity, "state");
		 //log.info("City button is clicked");
		   	Extent_Reporting.Log_Pass("City button is clicked", "state button is clicked", test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "FieldTech_Cityradio() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
	}					

    }
    
    public void FieldTech_Function() throws Throwable
    {
   	
   	 
   	 try {
		//click on search and capture validation
		 action.clickButton(icra_elements.FieldTechSearchBTN, "FieldTechSearch");
		 log.info("Search validation : " +icra_elements.Alert.getText());
		   	Extent_Reporting.Log_Pass("Search validation", "Search validation"+icra_elements.Alert.getText(), test, driver);					

		 
		 //Select agent
		 action.selectDDByText(icra_elements.FieldTechName, "Agent, aamu");
		 //search text
		 action.inputText(icra_elements.FieldTechSearchtext, ""+ExcelHandling.GetExcelData(TC_ID, "Searchbox")+"", "searchbox");
		 
		 //search
		 action.clickButton(icra_elements.FieldTechSearchBTN,"FieldTechSearchBTN");
		 //click on select button
		 action.clickButton(icra_elements.FieldTechSelect,"FieldTechSelect");
		 
		 //click on select
		 WebElement add=driver.findElement(By.xpath("//li/label[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Searchbox")+"')]"));
		 action.clickButton(add, "Assignzipcode");
		 //click on add button
		 action.clickButton(icra_elements.FieldADD, "FieldADDZipcode");
		log.info("Field add buton is clicked");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "FieldTech_Function() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());

	}
    }
    
    public void FieldTech_Remove() throws Throwable
    {
   	 try {
		//Remove the addedd city
		 WebElement Remove=driver.findElement(By.xpath("//li/label[contains(text(),'"+ExcelHandling.GetExcelData(TC_ID, "Searchbox")+"')]"));
		 action.clickButton(Remove, "Assignzipcode");
		 Extent_Reporting.Log_Pass("Verify Remove", "Remove button is selected"+Remove.getText(), test, driver);					
		 //click on add button
		 action.clickButton(icra_elements.FieldRemove, "FieldRemove");
		 Extent_Reporting.Log_Pass("Verify Remove", "Remove button is clicked ", test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "FieldTech_Remove() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());

	}					
    }
    
    public void FieldTech_Assign() throws Throwable
    {
   	try {
		//aasign zipcode
		 action.clickButton(icra_elements.AssignZipcode, "FieldADDZipcode");
		 Pageload(5, 200);
		 //log.info("Zipcode Assign : " +icra_elements.Alert.getText());
		 Extent_Reporting.Log_Pass("Zipcode Assign ", "Verify Assign "+icra_elements.Alert.getText(), test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "FieldTech_Assign() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
	}					
   	 
    }
    
    public void ExceptionTab() throws Throwable
    {
   	 try {
		action.WaitForElement(icra_elements.ExceptionTab, "ExceptionTab");
		 action.JSclickButton(icra_elements.ExceptionTab, "ExceptionTab");
		 action.waitForPageLoad();
		Extent_Reporting.Log_Pass("ExceptionTab", "ExceptionTab", test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "ExceptionTab() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());

	}
    }
    
    public void RequestedTab() throws Throwable
    {
   	 try {
		action.WaitForElement(icra_elements.RequestedTab, "RequestedTab");
		 action.JSclickButton(icra_elements.RequestedTab, "RequestedTab");
		 action.waitForPageLoad();
		 Extent_Reporting.Log_Pass("RequestedTab", "RequestedTab", test, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
        Extent_Reporting.Log_Fail("MethodFailed", "RequestedTab() failed "+ e.getMessage(), test, driver);
        throw new Exception(e.getMessage());
	}

    }
    
    public void ScanTech_Delete() throws Throwable
    {
    	try {
			//date set
			  //Date
  	 Calendar c = Calendar.getInstance();
			// Set the calendar to monday of the current week
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			// Print dates of the current week starting on Monday to Friday
			DateFormat df = new SimpleDateFormat("dd");
			String oldDate1 = df.format(c.getTime());
			System.out.println(" old Date " +oldDate1);
			for (int i = 0; i <= 10; i++) {
			    //System.out.println(df.format(c.getTime()));
			    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			    if (dayOfWeek == Calendar.FRIDAY) { // If it's Friday so skip to Monday
			        c.add(Calendar.DATE, 3);
			        break;
			        //String newDate1 = df.format(c.getTime());
			    } else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
			        c.add(Calendar.DATE, 2);
			        break;
			        //String newDate1 = df.format(c.getTime());

			    } else {
			        c.add(Calendar.DATE, 1);
			        break;
			       // String newDate1 = df.format(c.getTime());

			    }
			}
			String newDate1 = df.format(c.getTime());
			System.out.println(" NEW Date " +newDate1);

			//delete if schdule found
			WebElement Event1 =driver.findElement(By.xpath("//td[contains(@data-date,'"+newDate1+"')]//div[@class='fc-event-time']"));
			List<WebElement> Event = driver.findElements(By.xpath("//td[contains(@data-date,'"+newDate1+"')]//div[@class='fc-event-time']"));	 			
			for(int i=1;i<=Event.size();i++)
			{
				
				//click on delete
				log.info("Print event count"  +Event.size());
				//delete the appointment
				//action.clickButton(DesEdit1, "DesEdit1");
				if(Event1.isDisplayed()) {
				action.WaitForElement(Event1, "FixAppointBtn");
				action.JSclickButton(Event1, "FixAppointBtn");
				//click on delete then confirm
				action.JSclickButton(icra_elements.ScanTechDelete, "ScanTechDelete");
				action.JSclickButton(icra_elements.ScanTechDeleteYES, "ScanTechDelete");
				//log.info("Delete Appointment");
			   	Extent_Reporting.Log_Pass("Delete", "Delete button is clicked", test, driver);		
			   	Thread.sleep(1000);
			   	//action.waitForPageLoad();
			   	}
				else {
				   	Extent_Reporting.Log_Pass("NOEVENT", "NO scheduled event found", test, driver);					

			    break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "ScanTech_Delete() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

		}
    	
    }
    
    public void ScanTech_Add_Edit() throws Throwable
    {
         try {
			//Date
			 Calendar c = Calendar.getInstance();
			 // Set the calendar to monday of the current week
			 c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			 // Print dates of the current week starting on Monday to Friday
			 DateFormat df = new SimpleDateFormat("dd");
			 String oldDate1 = df.format(c.getTime());
			 System.out.println(" old Date " +oldDate1);
			 for (int i = 0; i <= 10; i++) {
			     //System.out.println(df.format(c.getTime()));
			     int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			     if (dayOfWeek == Calendar.FRIDAY) { // If it's Friday so skip to Monday
			         c.add(Calendar.DATE, 3);
			         break;
			         //String newDate1 = df.format(c.getTime());
			     } else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
			         c.add(Calendar.DATE, 2);
			         break;
			         //String newDate1 = df.format(c.getTime());

			     } else {
			         c.add(Calendar.DATE, 1);
			         break;
			        // String newDate1 = df.format(c.getTime());

			     }
			 }
			 String newDate1 = df.format(c.getTime());
			 System.out.println(" NEW Date " +newDate1);
			//WebElement FixAppointBtn=driver.findElement(By.xpath("//td[contains(@data-date,'fc-day-future')]//following::td[contains(@data-time,'"+ExcelHandling.GetExcelData(TC_ID, "ScanTime")+"')]//following-sibling::td"));
			WebElement FixAppointBtn=driver.findElement(By.xpath("//div[contains(@class,'fc-daygrid')]//parent::td[contains(@data-date,'"+newDate1+"')]"));
			action.clickButton(FixAppointBtn, "schedule aapont");
			Pageload(1, 90);			
			//select user and provide description
			action.WaitForElement(FixAppointBtn, "FixAppointBtn");
			action.JSclickButton(FixAppointBtn, "FixAppointBtn");	 			
			//select field tech user name
			action.selectDDByText(icra_elements.FieldUser, "Agent, aamu");
			String Datecurrent="TestingScantech"+(JavaUtilities.datetime("dd-MMM-yyyy"));
			action.inputText(icra_elements.AppointDes, Datecurrent, "AppointDes");
			log.info("Appointment Description");	 			
			//save appoint
			action.clickButton(icra_elements.ScanTechSave, "Save");
			log.info("scan tech save button");
			
			//Verify SaEditve
			WebElement DesEdit= driver.findElement(By.xpath("//div[contains(text(),'"+Datecurrent+"')]"));
			//display
			//log.info("Verify Schedule Appointment" +DesEdit.getText());
			Extent_Reporting.Log_Pass("Verify Schedule Appointment", "Schedule Appointment"+DesEdit.getText(), test, driver);					

			
			//To edit click on save appoint
			action.clickButton(DesEdit, "Click on save Button");
			String Datecurrentedit="TestingScantech"+(JavaUtilities.datetime("dd-MM-yyyy"));
			icra_elements.AppointDes.clear();
			action.inputText(icra_elements.AppointDes, Datecurrentedit, "AppointDes");
			log.info("Appointment Description"); 		 			
			//save appoint
			action.clickButton(icra_elements.ScanTechEdit, "Save");
			log.info("scan tech save button");
			
			
			//Verify edit dispay
			WebElement DesEdit1= driver.findElement(By.xpath("//div[contains(text(),'"+Datecurrentedit+"')]"));
			//display
			log.info("Verify Schedule Appointment" +DesEdit1.getText());
			Extent_Reporting.Log_Pass("Verify Schedule Appointment", "Schedule Appointment"+DesEdit1.getText(), test, driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            Extent_Reporting.Log_Fail("MethodFailed", "ScanTech_Add_Edit() failed "+ e.getMessage(), test, driver);
            throw new Exception(e.getMessage());

			
		}					

		
		
    }
    
       public void ScanTech() throws Throwable
    {
   	
			try {
				//select scantech
				action.selectDDByText(icra_elements.Retrieval, "Onsite Visit-Internal");
				DisplayComboboxVal(icra_elements.Retrieval);

				action.WaitUntilDisplayed(icra_elements.RetSave);
				action.clickButton(icra_elements.RetSave, "save button");
				Pageload(2, 60);
				log.info("Save button is clicked");

				//Print Validation
				action.WaitForElement(icra_elements.EMRValidation, "EMR Validation");
				//log.info("EMR Validation :" +icra_elements.EMRValidation.getText());
				Extent_Reporting.Log_Pass("EMR Validation", "EMR Validation"+icra_elements.EMRValidation.getText(), test, driver);					


				//action click scantech 
				action.clickButton(icra_elements.ScanTech, "ScanTech");
				log.info("scan tech button");
				
				//schedule appoint
				WebElement AppointBtn1=driver.findElement(By.xpath("//td[contains(text(),'aamu')]//following::td//button"));
				action.clickButton(AppointBtn1, "Appointment");
				Extent_Reporting.Log_Pass("ScheduleAppointment", "ScheduleAppointment for aamu is clicked", test, driver);					
				
				//delee if event present
				ScanTech_Delete();
				//check  Datevalidation
				ScanTech_Add_Edit();

				
  //close submemenu calender
				action.clickButton(icra_elements.Calenderclose, "calenderclose");
				//schedule appoint
				WebElement AppointBtn2=driver.findElement(By.xpath("//td[contains(text(),'aamu')]//following::td//button"));
				action.clickButton(AppointBtn2, "Appointment");
				Extent_Reporting.Log_Pass("ScheduleAppointment", "ScheduleAppointment for aamu is clicked", test, driver);					
				
				
				//select user and provide descriptio	
				WebElement FixAppointBtn1=driver.findElement(By.xpath("//div[contains(@class,'fc-daygrid-day-frame')]//parent::td[contains(@class,'fc-day-future')]"));
				action.clickButton(FixAppointBtn1, "FixAppointBtn1");
				//JavascriptExecutor executor = (JavascriptExecutor)driver;
				//executor.executeScript("arguments[0].click();", FixAppointBtn1);
				Extent_Reporting.Log_Message("Button" +" is clicked", test,driver);
				
				action.waitForPageLoad();
				
				//select field tech user name
				action.WaitForElement(icra_elements.FieldUser, "FieldUser");
				action.selectDDByText(icra_elements.FieldUser, "Agent, aamu");
				String Dateagain="TestingScantech"+(JavaUtilities.datetime("dd-MMM-yyyy"));
				action.inputText(icra_elements.AppointDes, Dateagain, "AppointDes");
				log.info("Appointment Description");	 			
				//save appoint
				action.clickButton(icra_elements.ScanTechSave, "Save");
				 Pageload(1, 90);
				//log.info("scan tech save button");
				Extent_Reporting.Log_Pass("scan tech save button", "scan tech save button"	, test, driver);					

				
				
				//close submemenu calender
				action.JSclickButton(icra_elements.Calenderclose, "calenderclose");
				 Pageload(1, 90);
				//close schedule appoint
				action.JSclickButton(icra_elements.ScanTechclose, "ScanTechclose");
				 Pageload(1, 90);
				 // emr1
				action.JSclickButton(icra_elements.EMR1, "EMRR1");
				Pageload(1, 90);
				action.selectDDByText(icra_elements.EMRValueSingle, ExcelHandling.GetExcelData(TC_ID, "EMRValue"));
				DisplayComboboxVal(icra_elements.EMRValueSingle);
				
				//retrieval save
				action.WaitUntilDisplayed(icra_elements.RetSave);
				action.JSclickButton(icra_elements.RetSave, "save button");
				Pageload(2, 60);
				log.info("Save button is clicked");
				Extent_Reporting.Log_Pass("Save button is clicked", "Save button is clicked", test, driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                Extent_Reporting.Log_Fail("MethodFailed", "ScanTech() failed "+ e.getMessage(), test, driver);
                throw new Exception(e.getMessage());

			}					

    }
    

       
}

package com.qa.BusinessLogic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_InboundCall_PO_Dhanshri;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;

public class ICRA_InboundCall_BL_Dhanshri  extends Extent_Reporting {
	
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_InboundCall_PO_Dhanshri icra_elements; 
	String BatchnameCreation = null;
	
	
	public ICRA_InboundCall_BL_Dhanshri(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_InboundCall_PO_Dhanshri(driver);
		
	}
	
	
	
	

	

	public void MemberIdSearch() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.memeberId);
			action.inputText(icra_elements.memeberId, ExcelHandling.GetExcelData(TC_ID, "MemberID"), "Enter MemberID ");		
			action.WaitUntilDisplayed(icra_elements.memeberIdAuto);
			if(action.isElementDisplayed(icra_elements.memeberIdAuto, "Member id Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			String inputval = icra_elements.memeberIdAuto.getText().trim();
			Clearbutton();
			action.waitForPageLoad();
			action.inputText(icra_elements.memeberId, inputval, "Enter MemberID ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "MemberIdSearch() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());

		}	
		
		}
	
	public void MemberNSearch() throws Throwable
	{
		try {
			action.inputText(icra_elements.memeberName, ExcelHandling.GetExcelData(TC_ID, "MemberName"), "Enter MemberName ");	
			action.WaitUntilDisplayed(icra_elements.memeberNameAuto);
			if(action.isElementDisplayed(icra_elements.memeberNameAuto, "Member Name Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			String inputval = icra_elements.memeberNameAuto.getText().trim();
			Clearbutton();
			action.inputText(icra_elements.memeberName, inputval, "Enter Member Name ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "MemberNSearch() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	 }
		
	public void ProviderNSearch() throws Throwable
	{
		
		try {
			action.WaitUntilDisplayed(icra_elements.providerName);
			action.inputText(icra_elements.providerName, ExcelHandling.GetExcelData(TC_ID, "ProviderName"), "Enter Provider Name ");
			
			action.WaitUntilDisplayed(icra_elements.providerNameAuto);
			if(action.isElementDisplayed(icra_elements.providerNameAuto, "Provider Name Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			String inputval = icra_elements.providerNameAuto.getText().trim();
			Clearbutton();
			action.inputText(icra_elements.providerName, inputval, "Enter provider Name ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ProviderNSearch() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}											
	}
	public void ProviderNPISearch() throws Throwable
	{ 
		try {
			action.inputText(icra_elements.providerNPI, ExcelHandling.GetExcelData(TC_ID, "ProviderNPI"), "Enter Provider NPI ");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			action.WaitUntilDisplayed(icra_elements.providerNPIAuto);
			if(action.isElementDisplayed(icra_elements.providerNPIAuto, "Provider NPI Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
			String inputval = icra_elements.providerNPIAuto.getText().trim();
			Clearbutton();
			
			action.inputText(icra_elements.providerNPI, inputval, "Enter provider NPI ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ProviderNPISearch() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}							
	}
	public void VDProviderDetail() throws Throwable
	{
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			icra_elements.Taddressid.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			executor.executeScript("arguments[0].click();", icra_elements.ProviderDetailtab);
			 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			
			String povider=icra_elements.providerdetail.getText();
			
			String idexcel=ExcelHandling.GetExcelData(TC_ID, "ProviderName");
			
if (povider.contains(idexcel)) {
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				Extent_Reporting.Log_Pass(TC_ID, "Provider Detail match", test, driver);
				
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID, "Provider Detail not match", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "VDProviderDetail() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	   
	}
	public void SBAddressID() throws Throwable
	{
		try {
			action.WaitUntilDisplayed(icra_elements.addressId);
			action.inputText(icra_elements.addressId, ExcelHandling.GetExcelData(TC_ID, "AddressID"), "Enter AddressId ");
			action.WaitUntilDisplayed(icra_elements.addressIdAuto);
			
			if(action.isElementDisplayed(icra_elements.addressIdAuto, "AddressId Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
				String val=icra_elements.addressIdAuto.getText();
			Clearbutton();
			
			action.WaitUntilDisplayed(icra_elements.addressId);
			
			action.inputText(icra_elements.addressId, val, "Enter AddressId ");
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SBAddressID() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	public void Searchbutton() throws Throwable
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,GlobalConstant.Global_Wait);
			action.JSclickButton(icra_elements.SearchButton, "click Search Button");
			
			wait.until(ExpectedConditions.visibilityOf(icra_elements.TAddress));
			if(action.isElementDisplayed(icra_elements.TAddress, "AddressId Displayed"))
			{
				
			Extent_Reporting.Log_Pass("Address Id", icra_elements.TAddress+" is Display", test,driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Searchbutton() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	public void Clearbutton() throws Throwable
	{
			
		try {
			action.JSclickButton(icra_elements.ClearButton, "click Clear Button");
			if(icra_elements.memeberName.getText().isEmpty()||icra_elements.providerName.getText().isEmpty());
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Clearbutton() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		
		
	}
	
	public void validateid() throws Throwable
	{
		try {
			log.info("validation");
			action.JSclickButton(icra_elements.AddressIdfilter, "click on filter");
			action.inputText(icra_elements.Searchfilter, ExcelHandling.GetExcelData(TC_ID, "AddressID"), "Enter AddressId ");
			String id=icra_elements.Taddressid.getText();
			log.info("validation1");
			String idexcel=ExcelHandling.GetExcelData(TC_ID, "AddressID");
					
			if (id.contains(idexcel)) {
			        	
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
						Extent_Reporting.Log_Pass(TC_ID, "AddressID match", test, driver);
						
					} else {
						
						Extent_Reporting.Log_Fail(TC_ID, "AddressID not match", test, driver);
					}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "validateid() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	public void SBCity() throws Throwable
	{
		
		try {
			WebDriverWait wait=new WebDriverWait(driver,GlobalConstant.Global_Wait);
			wait.until(ExpectedConditions.visibilityOf(icra_elements.City));
			wait.until(ExpectedConditions.elementToBeClickable(icra_elements.City));
			action.inputText(icra_elements.City, ExcelHandling.GetExcelData(TC_ID, "City"), "Enter City ");
			action.WaitUntilDisplayed(icra_elements.CityAuto);
			if(action.isElementDisplayed(icra_elements.CityAuto, "City Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
				String val=icra_elements.CityAuto.getText();
			Clearbutton();
			action.inputText(icra_elements.City, val, "Enter City ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SBCity() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	public void ValidateCity() throws Throwable
	{
		try {
			action.JSclickButton(icra_elements.Cityfilter, "click on filter");
			action.inputText(icra_elements.SearchfilterC, ExcelHandling.GetExcelData(TC_ID, "City"), "Enter City ");
			icra_elements.SearchfilterC.click();
			
			String id=icra_elements.TCity.getText();
			String idexcel=ExcelHandling.GetExcelData(TC_ID, "City");
			
			
if (id.contains(idexcel)) {
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				Extent_Reporting.Log_Pass(TC_ID, "City match", test, driver);
				
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID, "City not match", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ValidateCity() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	public void SBState() throws Throwable
	{
		
		try {
			WebDriverWait wait=new WebDriverWait(driver,GlobalConstant.Global_Wait);
			wait.until(ExpectedConditions.visibilityOf(icra_elements.State));
			wait.until(ExpectedConditions.elementToBeClickable(icra_elements.State));
			action.inputText(icra_elements.State, ExcelHandling.GetExcelData(TC_ID, "State"), "Enter State ");
			action.WaitUntilDisplayed(icra_elements.StateAuto);
			if(action.isElementDisplayed(icra_elements.StateAuto, "State Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);
				String val=icra_elements.StateAuto.getText();
			Clearbutton();
			action.inputText(icra_elements.State, val, "Enter State ");
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SBState() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	public void ValidateState() throws Throwable
	{
		
		try {
			String id=icra_elements.TState.getText();
				String idexcel=ExcelHandling.GetExcelData(TC_ID, "State");
				
				
if (id.contains(idexcel)) {
			    	
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
					Extent_Reporting.Log_Pass(TC_ID, "State match", test, driver);
					
				} else {
					
					Extent_Reporting.Log_Fail(TC_ID, "State not match", test, driver);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ValidateState() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}	
	}
	public void SBZipcode() throws Throwable
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,GlobalConstant.Global_Wait);
			wait.until(ExpectedConditions.visibilityOf(icra_elements.Zipcode));
			wait.until(ExpectedConditions.elementToBeClickable(icra_elements.Zipcode));
			action.inputText(icra_elements.Zipcode, ExcelHandling.GetExcelData(TC_ID, "Zipcode"), "Enter Zipcode ");
			action.WaitUntilDisplayed(icra_elements.ZipcodeAuto);
			if(action.isElementDisplayed(icra_elements.ZipcodeAuto, "Zipcode Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);   
				String val=icra_elements.ZipcodeAuto.getText();
				Clearbutton();
			action.inputText(icra_elements.Zipcode, val, "Enter Zipcode ");
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SBZipcode() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	public void ValidateZipcode() throws Throwable
	{
		
		try {
			String id=icra_elements.TZipcode.getText();
			String idexcel=ExcelHandling.GetExcelData(TC_ID, "Zipcode");
			
			
if (id.contains(idexcel)) {
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Extent_Reporting.Log_Pass(TC_ID, "Zipcode match", test, driver);
				
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID, "Zipcode not match", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ValidateZipcode() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	}
	
	
	
	public void SBGroupName() throws Throwable
	{
		WebDriverWait wait=new WebDriverWait(driver,GlobalConstant.Global_Wait);
		try {
			wait.until(ExpectedConditions.visibilityOf(icra_elements.GroupName));
			wait.until(ExpectedConditions.elementToBeClickable(icra_elements.GroupName));
			action.inputText(icra_elements.GroupName, ExcelHandling.GetExcelData(TC_ID, "GroupName"), "Enter Group Name ");
			action.WaitUntilDisplayed(icra_elements.GroupNameAuto);
			if(action.isElementDisplayed(icra_elements.GroupNameAuto, "Group Name Auto Populated"))
			{
				Extent_Reporting.Log_Pass(TC_ID, "successfully ", test, driver);  
				String val=icra_elements.GroupNameAuto.getText();
			Clearbutton();
			action.inputText(icra_elements.GroupName, val, "Enter GroupName ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "SBGroupName() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	
		}
	
	public void Member_ProviderSearch() throws Throwable
	{
        try {
			action.WaitUntilDisplayed(icra_elements.memeberId);	
			action.inputText(icra_elements.memeberId, ExcelHandling.GetExcelData(TC_ID, "MemberID"), "Enter MemberID ");	
			action.WaitUntilDisplayed(icra_elements.providerNPI);
			action.inputText(icra_elements.providerNPI, ExcelHandling.GetExcelData(TC_ID, "ProviderNPI"), "Enter Provider NPI ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Member_ProviderSearch() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		  	
	    	
	    }
	
	 
	public void VDDataGriddetail() throws Throwable
	{
		try {
			String name,fax,phoneno,emailid;
			
			name=icra_elements.TContactDetail.getText();
			emailid=icra_elements.TEmailId.getText();
			fax=icra_elements.TFax.getText();
			phoneno=icra_elements.TContactDetail.getText();
			
			fax=fax.replaceAll("-", "");
			phoneno=phoneno.replaceAll("-", "");
			   
			icra_elements.Taddressid.click();		
			
			
			if (name.contains(icra_elements.AMName.getText()) && emailid.contains(icra_elements.AMEmailId.getText())) {
				
				Extent_Reporting.Log_Pass(TC_ID, "Data match", test, driver);
				Thread.sleep(1000);
				if(fax.contains(icra_elements.AMFax.getText())){
									
						
					
				}
							
			}
			else {
				
				Extent_Reporting.Log_Fail(TC_ID, "Data not match", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "VDDataGriddetail() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
			
			}
	
	public void VDCount() throws Throwable
	{
		try {
			String cCount;
			cCount=icra_elements.ChaseCount.getText();
			
			if (cCount.contains(icra_elements.TChaseCount.getText()))
					{
			
				
				Extent_Reporting.Log_Pass(TC_ID, "Count Data match", test, driver);
					}
			else {
				
				Extent_Reporting.Log_Fail(TC_ID, "Count Data not match", test, driver);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "VDCount() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
		
	}
	
	
	
	
	public void Nodatafound() throws Throwable
	{
		String ele="";
		
		try {
			action.JSclickButton(icra_elements.SearchButton, "click Search Button");
			
			
			ele=icra_elements.Nodatfound.getText();
			
 
 if (ele.contains("No records found")) {
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				Extent_Reporting.Log_Pass(TC_ID, "Return to Inbound page", test, driver);
				
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID, "not Return to Inbound page", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Nodatafound() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
	   
	    	
	    	
	    }
		
	
	
	public void ICRA_IB_Errors() throws Throwable
	{
		try {
			String msg="";
			action.JSclickButton(icra_elements.SearchButton, "click Search Button");
			WebElement w=driver.findElement(By.xpath("//div[contains(@role,'alertdialog')]"));
			  action.WaitUntilDisplayed(w);
			   if(action.isElementDisplayed(w,"AlertDialog"))
			    {
			       msg = action.elementGetText(w, "Alert dialog");
			       log.info("validation"+msg);
			    }
			 if(msg.contains("Please input search parameter"))
			 {
			 	Extent_Reporting.Log_Pass(TC_ID, msg, test, driver);
			 
			 }
			 else
			 {
			 	Extent_Reporting.Log_Fail(TC_ID, msg, test, driver);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "ICRA_IB_Errors() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
			}

	public void Inboundlink() throws Throwable
	
	{
		try {
			action.JSclickButton(icra_elements.Taddressid, "Address id clicked");
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			executor.executeScript("arguments[0].click();", icra_elements.Inboundlink);

			
			String url = executor.executeScript("return document.URL;").toString();			
     
			
			if (url.contains("/ICRARevamp/#/Inbound-call")) {
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				Extent_Reporting.Log_Pass(TC_ID, "Return to Inbound page", test, driver);
				
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID, "not Return to Inbound page", test, driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   Extent_Reporting.Log_Fail("MethodFailed", "Inboundlink() failed "+ e.getMessage(), test, driver);
			   throw new Exception(e.getMessage());
		}
        

	}
	
	

public void InboundcallRB() throws Throwable
	
	{
	try {
		action.JSclickButton(icra_elements.Taddressid, "Address id clicked");
		boolean flag=false;
		flag=icra_elements.RadioButton.isSelected();
		

		
		
		 if (flag==true) {
		 	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				Extent_Reporting.Log_Pass(TC_ID, "Inbound call radio button is selected", test, driver);
				
			} else {
				
				Extent_Reporting.Log_Fail(TC_ID, "Inbound call radio button is not selected", test, driver);
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "InboundcallRB() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
     

	}

public void Alldata() throws Throwable
{
	try {
		action.WaitUntilDisplayed(icra_elements.memeberId);
		action.inputText(icra_elements.memeberId, ExcelHandling.GetExcelData(TC_ID, "MemberID"), "Enter MemberID ");
		action.inputText(icra_elements.memeberName, ExcelHandling.GetExcelData(TC_ID, "MemberName"), "Enter MemberName ");	
		
		action.inputText(icra_elements.providerNPI, ExcelHandling.GetExcelData(TC_ID, "ProviderNPI"), "Enter Provider NPI ");
		action.inputText(icra_elements.providerName, ExcelHandling.GetExcelData(TC_ID, "ProviderName"), "Enter Provider Name ");
		
		action.inputText(icra_elements.addressId, ExcelHandling.GetExcelData(TC_ID, "AddressID"), "Enter AddressId ");
		
		action.inputText(icra_elements.City, ExcelHandling.GetExcelData(TC_ID, "City"), "Enter City ");
		
		action.inputText(icra_elements.State, ExcelHandling.GetExcelData(TC_ID, "State"), "Enter State ");
		
		action.inputText(icra_elements.Zipcode, ExcelHandling.GetExcelData(TC_ID, "Zipcode"), "Enter Zipcode ");
		
		action.inputText(icra_elements.GroupName, ExcelHandling.GetExcelData(TC_ID, "GroupName"), "Enter Group Name ");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		   Extent_Reporting.Log_Fail("MethodFailed", "Alldata() failed "+ e.getMessage(), test, driver);
		   throw new Exception(e.getMessage());
	}
	
	
}
	

}

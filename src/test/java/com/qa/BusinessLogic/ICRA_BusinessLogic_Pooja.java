package com.qa.BusinessLogic;

/**
 * @author pbhattacharjee

 *
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.FailedLoginException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.JavaUtilities;

import junit.framework.Assert;

import com.google.common.base.Throwables;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.qa.MainFunctions.DriverCalling;
import com.qa.MainFunctions.GlobalConstant;
import com.qa.PageObjects.ICRA_PageObjects_Pooja;

public class ICRA_BusinessLogic_Pooja extends Extent_Reporting {

	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Pooja icra_elements;

	public ICRA_BusinessLogic_Pooja(WebDriver driver, String TC_ID) {
		this.driver = driver;
		this.TC_ID = TC_ID;
		icra_elements = new ICRA_PageObjects_Pooja(driver);
	}

	
	public void ICRA_Login() throws Throwable {
		String msg = null;
		try {
			action.WaitUntilDisplayed(icra_elements.Username);
			action.inputText(icra_elements.Username, ExcelHandling.GetExcelData(TC_ID, "LoginUsername"), "Username");
			action.WaitUntilDisplayed(icra_elements.Password);
			action.inputText(icra_elements.Password, ExcelHandling.GetExcelData(TC_ID, "LoginPassword"), "Password");
			action.clickButton(icra_elements.LoginBtn, "Submit button");
	    	msg = action.elementGetText(icra_elements.AlertDialog, "AlertDialog");
	    	if(msg.contains("Successfully"))
	    	 {
	    			  	Extent_Reporting.Log_Pass("Login", msg, test, driver);
	         }
	    	else
	    		throw new FailedLoginException();
	    	
		}
		catch (Exception e) 
		{
			Extent_Reporting.Log_FailMessage("ICRA_Login() failed", test, driver);
			driver.quit();
			throw new Exception(e.getMessage());
			

		}
		
	}
	
     public void RememberMe() throws Throwable {
	
    	String Remember = ExcelHandling.GetExcelData(TC_ID, "rememberme");
 		try {
			if (Remember.equalsIgnoreCase("yes")) {
				
				action.WaitUntilDisplayed(icra_elements.Rememberme);
				action.clickButton(icra_elements.Rememberme, "remember me checkbox is checked ");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("RememberMe() failed", test, driver);
			throw new Exception(e.getMessage());
			}
     }
    
	
	public void forgotpassword() throws Throwable {
		
		try {
			action.WaitUntilDisplayed(icra_elements.forgotpasswordlink);
			action.clickButton(icra_elements.forgotpasswordlink, "click on forgot password ");
			action.WaitUntilDisplayed(icra_elements.Username);
			action.inputText(icra_elements.Username, ExcelHandling.GetExcelData(TC_ID, "LoginUsername"), "Username");
			action.clickButton(icra_elements.backtologin, "click on back to login ");
			Extent_Reporting.Log_Pass("Login", "Back to login page", test, driver);
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("forgotpassword() failed", test, driver);
			throw new Exception(e.getMessage());
			}
	}

	
	
	public void loginErrors() throws Throwable
	{
		try {
			Extent_Reporting.Log_Pass("Errors", "Errors are displayed", test, driver);
			List<WebElement> blankerror = driver.findElements(By.xpath("//label[contains(@class,'field prepend-icon')]//span"));
			if((blankerror.size())>0)
			{
			for (int i=1;i<=blankerror.size();i++)
			{
				String ele = driver.findElement(By.xpath("(//label[contains(@class,'field prepend-icon')])["+i+"]")).getAttribute("for");
				String errormsg = driver.findElement(By.xpath("(//label[contains(@class,'field prepend-icon')]//span)["+i+"]")).getText();
				Extent_Reporting.Log_Message("Error  in field "+ele+" is :"+errormsg, test, driver);
			}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_FailMessage("loginErrors() failed", test, driver);
			throw new Exception(e.getMessage());
			}
		
	  }

	
}

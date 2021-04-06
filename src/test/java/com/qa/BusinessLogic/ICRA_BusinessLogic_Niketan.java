package com.qa.BusinessLogic;




import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.FailedLoginException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.ElementAction;
import com.qa.PageObjects.ICRA_PageObjects_Niketan;


public class ICRA_BusinessLogic_Niketan extends Extent_Reporting{
	
	ElementAction action = new ElementAction();
	String TC_ID = null;
	WebDriver driver;
	ICRA_PageObjects_Niketan icra_elements; 
	
	
	
	public ICRA_BusinessLogic_Niketan(WebDriver driver,String TC_ID)
	{
		this.driver=driver;
		this.TC_ID=TC_ID;
		icra_elements= new ICRA_PageObjects_Niketan(driver);
	}
	
	public void ICRA_Login() throws Throwable
	{
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
	
	
	public void SelectClient() throws Exception
	{
		try
		{
		action.WaitUntilDisplayed(icra_elements.ClientDropdown);
		action.clickButton(icra_elements.ClientDropdown, "Client dropdown button");
		String dropdownvalue=ExcelHandling.GetExcelData(TC_ID, "ClientName");
		action.clickButton(driver.findElement(By.xpath("//option[contains(text(),'"+dropdownvalue+"')]")), "Client dropdown button");	
		action.WaitUntilDisplayed(icra_elements.SubmitButton_ClientDropdown);
		action.clickButton(icra_elements.SubmitButton_ClientDropdown, "Submit button");
		}
		catch (Exception e)
		{
           Extent_Reporting.Log_FailMessage("SelectClient() failed", test, driver);
		   throw new Exception(e.getMessage());
		}
		
	}
	
	

	public void PageLoad(int time,long t)
	{
		for(int i=1;i<=time;i++)
		{
			driver.manage().timeouts().pageLoadTimeout(t, TimeUnit.SECONDS);
		}
	}
	
   public void ClickWelCmeUser() throws Exception
   {
	   try
	   {
	     action.clickButton(icra_elements.Heading_WelCm_User, "Heading_WelCm_User");
	   }
	   catch (Exception e)
		{
           Extent_Reporting.Log_FailMessage("ClickWelCmeUser() failed", test, driver);
		   throw new Exception(e.getMessage());
		}
   }
   
   public void ICRA_Logout() throws Exception
	{
		try {  
	        action.clickButton(icra_elements.LogoutLink,"Logout link");
	     }
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ICRA_Logout() failed", test, driver);
			throw new Exception(e.getMessage());
		}
	}
	
   public void ClickMenus() throws Exception
	
	{
		String mainmenu=ExcelHandling.GetExcelData(TC_ID, "MainMenu");
		String submenu=ExcelHandling.GetExcelData(TC_ID, "SubMenu");
		log.info(mainmenu);
		log.info(submenu);
		try
		{
		if (submenu.equals("N/A"))
		{
			List<WebElement> maintabs=driver.findElements(By.xpath("//ul[@class='nav sidebar-menu']/li"));
			for(int i=1;i<=maintabs.size();i++)
			{
			 WebElement w1=driver.findElement(By.xpath("//ul[@class='nav sidebar-menu']/li["+i+"]/a/span[2]"));
			 if(w1.getText().equals(mainmenu))
			   {
				 action.clickButton(w1, "Mainmenu");
			     Extent_Reporting.Log_Pass("Mainmenu", mainmenu+" is selected", test,driver);
			     break;
			   }
			}
		}
		else
		{
			List<WebElement> maintabs=driver.findElements(By.xpath("//ul[@class='nav sidebar-menu']/li"));
			outerloop:
			for(int i=1;i<=maintabs.size();i++)
			{
			 WebElement w1=driver.findElement(By.xpath("//ul[@class='nav sidebar-menu']/li["+i+"]/a/span[2]"));
			 if(w1.getText().equals(mainmenu))
			   {
				 action.clickButton(w1, "Mainmenu");
				 log.info("Main menu is clicked"); 
				 PageLoad(500,20000000);
				 List<WebElement> subtabs=driver.findElements(By.xpath("//ul[@class='nav sidebar-menu']/li["+i+"]/ul/li/a"));
				 for(int k=1;k<=subtabs.size();k++)
				   {
					 WebElement w2=driver.findElement(By.xpath("//ul[@class='nav sidebar-menu']/li["+i+"]/ul/li["+k+"]/a"));
					 if(w2.getText().equals(submenu))
					 {
						 action.clickButton(w2, "Submenu");
						 log.info("Sub menu is clicked");
						 Extent_Reporting.Log_Pass("Submenu", submenu+" is selected", test,driver);
						 break outerloop;
					  }					
				   }
			    }
		     }
		}
		}
		catch (Exception e)
		{
            Extent_Reporting.Log_FailMessage("ClickMenus() failed", test, driver);
			throw new Exception(e.getMessage());
		}
		
	}
		
		public void ICRA_Login1() throws Exception
		{
			try
			{
			action.WaitUntilDisplayed(icra_elements.Username);
			action.inputText(icra_elements.Username, ExcelHandling.GetExcelData(TC_ID, "LoginUsername1"), "Username");
			action.inputText(icra_elements.Password, ExcelHandling.GetExcelData(TC_ID, "LoginPassword"), "Password");
			action.JSclickButton(icra_elements.LoginBtn, "Submit button");
			}
			catch (Exception e)
    		{
                Extent_Reporting.Log_FailMessage("ICRA_Login1() failed", test, driver);
    			throw new Exception(e.getMessage());
    		}
		}
		
		public void ClickAdrRollup() throws Exception
		{
            try
            {
             WebElement w=driver.findElement(By.xpath("//span[contains(text(),'Call Center')]//following::a[contains(text(),'Address Rollup')][1]"));
             action.clickButton(w, "Address Rollup");
            }
            catch (Exception e)
    		{
                Extent_Reporting.Log_FailMessage("ClickAdrRollup() failed", test, driver);
    			throw new Exception(e.getMessage());
    		}
            
		}
		
		public void RefreshPage()
		{
			driver.navigate().refresh();
			PageLoad(3000,40000000);
			
		}
		
		public void ClkRecordQAApproval() throws Exception 
		{
			try
			{
			WebElement w=driver.findElement(By.xpath("//a[@ng-reflect-router-link='/record-qa-approval']"));
             action.clickButton(w, "Address Rollup");
			}
			catch (Exception e)
    		{
                Extent_Reporting.Log_FailMessage("ClkRecordQAApproval() failed", test, driver);
    			throw new Exception(e.getMessage());
    		}
			
		}
			
	}

 
	
	
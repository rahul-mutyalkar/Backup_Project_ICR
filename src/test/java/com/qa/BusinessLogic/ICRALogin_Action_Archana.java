package com.qa.BusinessLogic;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.MainFunctions.GlobalConstant;

import com.qa.PageObjects.ICRALogin_PageObject_Archana;
import com.qa.Utilities.ElementAction;
import com.qa.Utilities.ExcelHandling;
import com.qa.Utilities.Extent_Reporting;
import com.qa.Utilities.JavaUtilities;
import com.qa.BusinessLogic.ICRA_BusinessLogic_Pooja;


public class ICRALogin_Action_Archana extends Extent_Reporting{

		ElementAction action = new ElementAction();
		String TC_ID = null;	
		ICRALogin_PageObject_Archana ica_elements; 
		String BatchnameCreation = null;
		ICRA_BusinessLogic_Pooja BL = null;

		public ICRALogin_Action_Archana(WebDriver driver,String TC_ID)
		{
			this.driver=driver;
			this.TC_ID=TC_ID;
			ica_elements= new ICRALogin_PageObject_Archana(driver);
			BL = new ICRA_BusinessLogic_Pooja(driver,TC_ID);
			
		}
		
		
		public void ValidateUserName() throws Throwable
		{
			try {
				Boolean Username = (ica_elements.UsernamePre).isDisplayed();
				 if (Username)
					{
						log.info("User name is displayed");
						 Extent_Reporting.Log_Pass("User name is displayed", " User name is displayed", test,driver);

					}	
				 else
				 {
					 log.info("Failed : user name is not present");

				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "ValidateUserName() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());
				 

			}
			
		}
		
		public void ValidatePassword() throws Throwable
		{
			try {
				Boolean Username = (ica_elements.PasswordPre).isDisplayed();
				 if (Username)
					{
						log.info("Password is displayed");
						 Extent_Reporting.Log_Pass("Password is displayed", " Password is displayed", test,driver);

					}	
				 else
				 {
					 log.info("Failed : Password is not present");

				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "ValidatePassword() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());

			}
			
		}
		public void ValidateGebbslogo() throws Throwable
		{
			try {
				
				Boolean Username = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ica_elements.Gebbslogo);
				 if (Username)
					{
						log.info("Log0 is displayed");
						 Extent_Reporting.Log_Pass("Log0 is displayed", " Log0 is displayed", test,driver);

					}	
				 else
				 {
					 log.info("Failed : logo is not present");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "ValidateGebbslogo() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());

			}
			
		}
		public void Validateicralogo() throws Throwable
		{
         try {
				
				Boolean Username = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ica_elements.ICRAlogo);
				 if (Username)
					{
						log.info("Log0 is displayed");
						 Extent_Reporting.Log_Pass("Log0 is displayed", " Log0 is displayed", test,driver);

					}	
				 else
				 {
					 log.info("Failed : logo is not present");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "Validateicralogo() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());

			}
		}
		
		public void ValidateCopyright() throws Throwable
		{
         try {
				Boolean Username = (ica_elements.CheckCopyRgt).isDisplayed();
				 if (Username)
					{
						log.info("Copy right is displayed");
						 Extent_Reporting.Log_Pass("Copy right is displayed", " Copy right is displayed", test,driver);

					}	
				 else
				 {
					 log.info("Failed : Copy right is not displayed");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "ValidateCopyright() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());

			}
		}
		
		public void ValidateDis() throws Throwable
		{
         try {
				Boolean Username = (ica_elements.CheckDisc).isDisplayed();
				 if (Username)
					{
						log.info("Disclaimer is displayed");
						 Extent_Reporting.Log_Pass("Disclaimer is displayed", " Disclaimer is displayed", test,driver);

					}	
				 else
				 {
					 log.info("Failed : Disclaimer is not displayed");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "ValidateDis() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());

			}
		}
		
		
		/*public void Logout()
		{
       	 try {
       		waitingElement(ica_elements.Menu);
       		action.JSclickButton(ica_elements.Menu, "Click remember button");
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				 Extent_Reporting.Log_Pass("Menu Button", " Menu button is clicked", test,driver);

				log.info("Menu button is clicked");
				waitingElement(ica_elements.Logout);
			 action.JSclickButton(ica_elements.Logout, "Click remember button");
				driver.manage().timeouts().implicitlyWait(GlobalConstant.Global_Wait, TimeUnit.SECONDS);

				log.info("Log out button");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Log out button is not working");
		} 
         }*/
		
	
		
		
		public void RememberSelection() throws Throwable
		{
       	 try {
			Boolean rem = (ica_elements.Rememberme).isSelected();
				 if (rem)
				 {						 
					 Extent_Reporting.Log_Pass("remember button", "remember button", test, driver);
				 }
				 else
				 {
					 waitingElement(ica_elements.Rememberme);
					 action.clickButton(ica_elements.Rememberme, "Click remember button");
					 log.info("remember button is clicked");
					 Extent_Reporting.Log_Pass("Remember is displayed", " Remember is displayed", test,driver);

					 driver.manage().timeouts().pageLoadTimeout(GlobalConstant.Global_Wait, TimeUnit.SECONDS);
				 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        Extent_Reporting.Log_Fail("MethodFailed", "RememberSelection() failed "+ e.getMessage(), test, driver);
	        throw new Exception(e.getMessage());
		}
		}
	
		
		
		
		public String Changepassword() throws Throwable
		  {
			 String NewPassword = null;
			try {
				Thread.sleep(20000);
				  action.WaitUntilDisplayed(ica_elements.ProfileDD);
				  action.clickButton(ica_elements.ProfileDD, "Profile Dropdown");
				  Thread.sleep(20000);
				  action.WaitUntilDisplayed(ica_elements.ChangePassword);
				  action.clickButton(ica_elements.ChangePassword, "ChangePassword");
				  action.inputText(ica_elements.CurrentPass, ExcelHandling.GetExcelData(TC_ID, "LoginPassword"), "Password");
				  String Num=ExcelHandling.GetExcelData(TC_ID, "LoginPassword");
				  NewPassword = ("Geb@"+JavaUtilities.datetime("ssSSS"));
				  log.info(NewPassword);
				   
				action.inputText(ica_elements.NewPass, NewPassword , "Password");
				action.inputText(ica_elements.ConfirmPass,NewPassword, "Password");
				 action.clickButton(ica_elements.PasswordButton, "Password saved Successfully");
				log.info("Changepassword button is clicked");
			} catch (Exception e) {
				e.printStackTrace();
		        Extent_Reporting.Log_Fail("MethodFailed", "Changepassword() failed "+ e.getMessage(), test, driver);
		        throw new Exception(e.getMessage());
			}

		    return NewPassword;
				//ExcelHandling.WriteInExcel("LoginPassword", NewPassword, TC_ID);
				
         }
		
		public void waitingElement(WebElement ele)
		{
			WebDriverWait wait=new WebDriverWait(driver,GlobalConstant.Global_Wait);						
			wait.until(ExpectedConditions.visibilityOf(ele));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
	
}


package com.qa.PageObjects;
/**
 * @author pbhattacharjee
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class ICRA_PageObjects extends DriverCalling{
	
	@FindBy(xpath = "//input[@formcontrolname='UserName']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@formcontrolname='Password']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Remember')]")
	public WebElement Rememberme;
	
	@FindBy(xpath = "//a[@href= '/ICRARevamp/ForgotPassword']")
	public WebElement forgotpasswordlink;
	
	@FindBy(xpath = "//button[contains(text(),'Forgot Password')]")
	public WebElement forgotpasswordbutton;
	
	@FindBy(xpath = "//a[@href='/ICRARevamp/login']")
	public WebElement backtologin;
	
	
	public ICRA_PageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}

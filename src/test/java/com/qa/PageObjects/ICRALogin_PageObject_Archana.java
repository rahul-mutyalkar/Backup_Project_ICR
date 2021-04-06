package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class ICRALogin_PageObject_Archana extends DriverCalling{

	@FindBy(xpath = "//img[@src='assets/img/pages/logo_w156.png']")
	public WebElement Gebbslogo;
	
	@FindBy(xpath = "//img[@src='assets/img/logo_login_form.png']")
	public WebElement ICRAlogo;
	
	@FindBy(xpath = "//input[@ng-reflect-name='UserName']")
	public WebElement UsernamePre;

	@FindBy(xpath = "//input[@ng-reflect-name='Password']")
	public WebElement PasswordPre;
	
	@FindBy(xpath = "//div[contains(text(),'All rights reserved')]")
	public WebElement CheckCopyRgt;
	
	@FindBy(xpath = "//a[contains(text(),'Disclaimer')]")
	public WebElement CheckDisc;
	
	
	@FindBy(xpath = "//li[contains(@class,'dropdown')]/a")
	public WebElement ProfileDD;
	
	@FindBy(xpath = "//button[@routerlink='/login']")
	public WebElement Logout;
	
	@FindBy(xpath = "//label[contains(text(),'Remember')]")
	public WebElement Rememberme;
	
	@FindBy(xpath = "//a[@ng-reflect-router-link='/ForgotPassword']")
	public WebElement Forgot;
	

	@FindBy(xpath = "//input[@formcontrolname='UserName']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@formcontrolname='Password']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement ClientSel;

	@FindBy(xpath = "//div[@class='col-md-2']//button[@type='button']")
	public WebElement ClientSubmit;
	
	@FindBy(xpath = "//a[contains(@href,'ResetPassword')]")
	public WebElement ChangePassword;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Current')]")
	public WebElement CurrentPass;
	
	@FindBy(xpath = "//input[contains(@placeholder,'New')]")
	public WebElement NewPass;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Confirm')]")
	public WebElement ConfirmPass;
	
	@FindBy(xpath = "//input[@id='btnSubmit']")
	public WebElement PasswordButton;
	
	public ICRALogin_PageObject_Archana(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
}

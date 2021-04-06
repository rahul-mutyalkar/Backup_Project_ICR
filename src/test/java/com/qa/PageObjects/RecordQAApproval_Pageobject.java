package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class RecordQAApproval_Pageobject extends DriverCalling{
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	public WebElement RecordQASubmitBtn;
	
	@FindBy(xpath = "//label[@id='btnlabel']")
	public WebElement RecordQATotCha;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement RecordQAAlert;
	
	@FindBy(xpath = "//label[@id='lblMname']")
	public WebElement MemberMiddle;
	
	public RecordQAApproval_Pageobject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
}

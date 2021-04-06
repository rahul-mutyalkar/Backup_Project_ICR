package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class ICRA_InboundCall_PO_Dhanshri extends DriverCalling{
	
	/*******************Login Button ********************************/
	
	@FindBy(xpath = "//input[@ng-reflect-name='UserName']")
	public WebElement UsernamePre;

	@FindBy(xpath = "//input[@ng-reflect-name='Password']")
	public WebElement PasswordPre;
	
	@FindBy(xpath = "//input[@formcontrolname='UserName']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@formcontrolname='Password']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	public WebElement LoginBtn;
	
	/*******************Client Selection ********************************/
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement ClientSel;

	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement ClientSubmit;
	
	@FindBy(xpath = "//div[contains(text(),'Select Client')]")
	public WebElement SelectClientHeading;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement ClientDropdown;
	
	@FindBy(xpath = "//button[@type='button']/i")
	public WebElement SubmitButton_ClientDropdown;
	
	/*******************In bound call menu ********************************/
	
	@FindBy(xpath = "//span[@id='sidebar_left_toggle']/i")
	public WebElement MenuButton;

	@FindBy(xpath = "//span[contains(text(),' Call Center')]")
	public WebElement Mainmenu;

	@FindBy(xpath = "//a[contains(text(),'Inbound Call')]")
	public WebElement Submenu;
	
	/*******************Member Search********************************/
	
	@FindBy(xpath = "//input[@placeholder='Enter Member ID ']")
	public WebElement memeberId;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement memeberIdAuto;
	
	@FindBy(xpath = "//input[@placeholder='Enter Member Last Name, First Name']")
	public WebElement memeberName;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement memeberNameAuto;
	
	
	/*******************Provider Search********************************/
	
	@FindBy(xpath = "//input[@placeholder='Enter Provider Last Name, First Name']")
	public WebElement providerName;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement providerNameAuto;

	
	
	@FindBy(xpath = "//input[@placeholder='Enter Provider NPI']")
	public WebElement providerNPI;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement providerNPIAuto;
	
	
	@FindBy(xpath = "//input[@placeholder='Enter Group Name']")
	public WebElement GroupName;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement GroupNameAuto;
	
	
	@FindBy(xpath = "//input[@placeholder='Enter City']")
	public WebElement City;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement CityAuto;
	
	@FindBy(xpath = "//input[@placeholder='Enter State']")
	public WebElement State;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement StateAuto;
	
	@FindBy(xpath = "//input[@placeholder='Enter Zip Code']")
	public WebElement Zipcode;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement ZipcodeAuto;
	
	@FindBy(xpath = "//input[@placeholder='Enter Address ID']")
	public WebElement addressId;
	
	@FindBy(xpath = "//li[1]//div[@class='ui-helper-clearfix ng-star-inserted']")
	public WebElement addressIdAuto;
	/*******************Buttons********************************/
	@FindBy(xpath = "//button[@id='btnSubmit']")
	public WebElement SearchButton;
	
	@FindBy(xpath = "//Button[contains(text(),'Clear')]")
	public WebElement ClearButton;
	
	
	@FindBy(xpath = "//input[@id='inlineRadio1']")
	public WebElement RadioButton;
	
	
	/*******************Validation********************************/
	
     @FindBy(xpath = "//tbody[@class='ui-table-tbody']//a")
	public WebElement Taddressid;
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[8]")
	public WebElement TCity;
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[9]")
	public WebElement TState;
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[10]")
	public WebElement TZipcode;
	
	@FindBy(xpath = "//a[contains(text(),' Chase Details ')]")
	public WebElement Chasedetail;
	
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[6]")
	public WebElement TAddress;
	
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[11]")
	public WebElement TContactDetail;
	
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[12]")
	public WebElement TPhoneNo;
	
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[13]")
	public WebElement TFax;
	
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']//td[14]")
	public WebElement TEmailId;
	
	@FindBy(xpath = "//div[@id='tab6_1']//tr[1]//th[3]//span//div")
	public WebElement AMName;
	
	@FindBy(xpath = "//div[@id='tab6_1']//tr[1]//th[9]//span//div//span ")
	public WebElement AMEmailId;
	
	
	@FindBy(xpath = "//div[@id='tab6_1']//tr[1]//th[7]//span//div")
	public WebElement AMFax;
	
	@FindBy(xpath = "//div[@id='tab6_1']//tr[1]//th[5]//span//div ")
	public WebElement AMPhoneNo;
	
	@FindBy(xpath = "//div[@col-id='ProviderCompleteName'][@aria-colindex='2']")
	public WebElement providerdetail;
	
	@FindBy(xpath = "//div[contains(text(),'Please input search')]")
	public WebElement errormessage;
	
	//@FindBy(xpath = "//*[@id=\\\"toast-container\\\"]/div/div[2]")
	//public WebElement errormessage;
	
	
	@FindBy(xpath = "//b[contains(text(),' No records found')]")
	public WebElement Nodatfound;
	
	@FindBy(xpath = "//button[@title='Inbound Call']")
	public WebElement Inboundlink;
	
	@FindBy(xpath = "/html/head/comment()[1]")
	public WebElement iplink;
	
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Provider Details')]")
	public WebElement ProviderDetailtab;

	
	//@FindBy(xpath = "//*[@id=\"tab6_2\"]/div[2]//div[1]/div[1]/label")
	@FindBy(xpath = "//div[contains(@class,'col-md-3 pull-left pl5 pt5')]//label")
	public WebElement ChaseCount;
	
	
	@FindBy(xpath = "//tr//td[4][@class='text-center']")
	public WebElement TChaseCount;
	
	
	/*******************Filter********************************/
	
	@FindBy(xpath = "//span[contains(text(),'All Address ID')]")
	public WebElement AddressIdfilter;
	
	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement Searchfilter;
	
	
	@FindBy(xpath = "//span[contains(text(),'All City')]")
	//@FindBy(xpath = "//*[@id=\"content\"]//table/thead/tr[2]/th[8]/span/div/span/p-multiselect/div/div[3]/span")
	public WebElement Cityfilter;
	
	
	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement SearchfilterC;
	
	
	
	
	
	

	
	
	public ICRA_InboundCall_PO_Dhanshri(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

}

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

public class ICRA_PageObjects_Pooja extends DriverCalling{
	
	@FindBy(xpath = "//input[@formcontrolname='UserName']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@formcontrolname='Password']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement SelectClient;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement AlertDialog;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement ClientDropdown;
	
	@FindBy(xpath = "//label[contains(text(),'Remember')]")
	public WebElement Rememberme;
	
	@FindBy(xpath = "//div[@ref='eCenterContainer']")
	public WebElement SearchResult;
	
	@FindBy(xpath = "//div[contains(@col-id,'ProviderNPI') and @role = 'gridcell']")
	public WebElement NPIdata;
	
	@FindBy(xpath = "//a[contains(@href, 'ForgotPassword')]")
	public WebElement forgotpasswordlink;
	
	@FindBy(xpath = "//button[contains(text(),'Forgot Password')]")
	public WebElement forgotpasswordbutton;
	
	@FindBy(xpath = "//h3[contains(text(),'Forgot Password')]//following::a[contains(@href, 'login')]")
	public WebElement backtologin;
	
	@FindBy(xpath = "//select[@id='ddlSelectClient']")
	public WebElement selectclient;
	
	@FindBy(xpath = "//button[contains(text(),'Submit ')]")
	public WebElement submitbutton;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[contains(text(),'Successfully logged in')]")
	public WebElement successfullogintoaster;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[contains(text(),'User name is invalid')]")
	public WebElement failedlogintoaster;
	
	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	public WebElement AdminMenu;
	
	@FindBy(xpath = "//a[@routerlink='provider-management/add-provider']")
	public WebElement ProviderManagementMenu;
	
	@FindBy(xpath = "//label[@for='Provider First']/preceding-sibling::input[@formcontrolname='PFirstName']")
	public WebElement AddPFirstName;
	
	@FindBy(xpath = "//label[@for='Provider Middle  Name']/preceding-sibling::input[@formcontrolname='PMiddleName']")
	public WebElement AddPMiddleName;
	
	@FindBy(xpath = "//label[@for='Provider Last  Name']/preceding-sibling::input[@formcontrolname='PLastName']")
	public WebElement AddPLastName;
	
	@FindBy(xpath = "//label[@for='Provider Credentials']/preceding-sibling::input[@formcontrolname='PCredentials']")
	public WebElement AddPCredentials;
	
	@FindBy(xpath = "//div[@class='required-icon']/preceding-sibling::label/preceding-sibling::input[@formcontrolname='ProviderNPI']")
	public WebElement AddPNPI;
	
	@FindBy(xpath = "//label[@for='Provider State']/preceding-sibling::input[@formcontrolname='PState']")
	public WebElement AddPState;
	
	@FindBy(xpath = "//label[@for='Provider Group Name']/parent::label/input[@formcontrolname='PGroupName']")
	public WebElement AddPGroupname;

	@FindBy(xpath = "//button[contains(text(),'Clear')]")
	public WebElement ClearButton;
	
	@FindBy(xpath = "//i[@title='Download Sample Excel for Upload']/parent::button")
	public WebElement Downtemplatefile;

	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	public WebElement Uplodfilebuton;
	
	@FindBy(xpath = "//button[contains(text(),'Search ')]/parent::div/preceding-sibling::div/div/div/label/input[@formcontrolname='ProviderNPI']")
	public WebElement SearchNPIfield;
	
	@FindBy(xpath = "//label[@for='Provider First Name']/preceding-sibling::input[@formcontrolname='PFirstName']")
	public WebElement SearchPFirstname;
	
	@FindBy(xpath = "//label[@for='Provider Middle Name']/preceding-sibling::input[@formcontrolname='PMiddleName']")
	public WebElement SearchPMiddleame;
	
	@FindBy(xpath = "//label[@for='Provider Last Name']/preceding-sibling::input[@formcontrolname='PLastName']")
	public WebElement SearchPLastame;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[contains(text(),' Provider inserted successfully.! ')]")
	public WebElement sucessfulprovidertoaster;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[contains(text(),' Please provide any search option for provider.')]")
	public WebElement unsucessfulsearchprovidertoaster;
	
	@FindBy(xpath = "//input[@type='file']")
	public WebElement ChooseFileButton;

	@FindBy(xpath = "//div[@ref='eValue1']/div/input")
	public WebElement filterinputtext;
	
	@FindBy(xpath = "//button[contains(text(),'Search ')]")
	public WebElement searchbutton;
	@FindBy(xpath = "//div[contains(text(),'First Name Should Contain Only Characters')]")
	public WebElement invalid_msgfor_digitsin_PFirstname;
	
	@FindBy(xpath = "//span[contains(text(),'Provider First Name')]/parent::div/preceding-sibling::span/span[@class='ag-icon ag-icon-menu']")
	public WebElement searchfirstnamefilter;
	
	@FindBy(xpath = "//label[contains(.,'AND')]/parent::div/div/input")
	public WebElement filterANDradio;
	
	@FindBy(xpath = "//label[contains(.,'OR')]/parent::div/div/input")
	public WebElement filterORradio;
	
	@FindBy(xpath = " //span[contains(text(),'Provider First Name')]/parent::div")
	public WebElement sortasc_Firstname;
	@FindBy(xpath = "//label[contains(.,'OR')]/parent::div/div/input")
	public WebElement sortdesc_Firstname;
	
	@FindBy(xpath = "//button[@routerlink='/login']")
	public WebElement Logout;
	@FindBy(xpath = "//div[@ref='eHeaderContainer']")
	public WebElement grid;
	
	
	@FindBy(xpath = "//input[@formcontrolname='SplitFrom']")
	public WebElement frompagenotxt;

	@FindBy(xpath = "//input[@formcontrolname='SplitTill']")
	public WebElement Topagenotxt;

	@FindBy(xpath = "//button[contains(text(),'Reorder')]")
	public WebElement ReorderButton;

	@FindBy(xpath = "//legend[contains(text(),'Member')]")
	public WebElement MemberTab;

	@FindBy(xpath = "//input[@formcontrolname='MemberLastName']")
	public WebElement MemberLastNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='MemberFirstName']")
	public WebElement MemberFirstNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='MemberMiddleName']")
	public WebElement MemberMiddleNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='MemberDOB']")
	public WebElement MemberDOBTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderLastName']")
	public WebElement ProviderLastNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderFirstName']")
	public WebElement ProviderFirstNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderMiddleName']")
	public WebElement ProviderMiddleNameTxt;

	@FindBy(xpath = "//input[@formcontrolname='ProviderNPI']")
	public WebElement ProviderNPITxt;

	@FindBy(xpath = "//textarea[@formcontrolname='ProviderAddress']")
	public WebElement ProviderAddressTxt;

	@FindBy(xpath = "//button[contains(text(),'Search Chase')]")
	public WebElement SearchChaseButton;

	@FindBy(xpath = "//button[contains(text(),'Finish')]")
	public WebElement FinishButton;

	@FindBy(xpath = "//input[@formcontrolname='ChaseNotFound']")
	public WebElement ChaseNotFoundCheckBox;

	@FindBy(xpath = "//input[@formcontrolname='DuplicateDocument']")
	public WebElement DuplicateDocumentCheckBox;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement SubmitButton;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	public WebElement CloseButton;

	@FindBy(xpath = "//legend[contains(text(),'Provider')]")
	public WebElement Providertab;

	@FindBy(xpath = "//span[contains(text(),'Chart Retrival')]")
	public WebElement ChartRetrivalMenu;

	@FindBy(xpath = "//a[@href='/ICRARevamp/intake']")
	public WebElement intakeMenu;

	@FindBy(xpath = "//a[contains(text(),'Intake - Document Routing')]")
	public WebElement intakePageHeader;

	@FindBy(xpath = "//div[contains(text(),' Please map the chase OR mark this file as Duplicate Document OR Chase Not Found.')]")
	public WebElement failchasetoaster;

	@FindBy(xpath = "//input[@id='pageNumber']")
	public WebElement maxnumpages;
	@FindBy(xpath = "//iframe[@title='ng2-pdfjs-viewer']")
	public WebElement pdfframe;

	@FindBy(xpath="//div[@role='alertdialog']")
	public WebElement alertToaster;
	
	@FindBy(xpath="//strong[contains(text(),'Project Name:')]")
	public WebElement Projectname;
	@FindBy(xpath="//strong[contains(text(),'File Name:')]")
	public WebElement Filename;
	@FindBy(xpath="//strong[contains(text(),'Retrieval Method:')]")
	public WebElement RetrievaMethod;
	
	@FindBy(xpath="//strong[contains(text(),'Chase Id:')]")
	public WebElement ChaseId;
	
	@FindBy(xpath="//strong[contains(text(),'Chase Status:')]")
	public WebElement ChaseStatus;
	
	@FindBy(xpath="//span[contains(text(),'Original')]/parent::button")
	public WebElement   ViewOriginalButton;
	
	
	

	@FindBy(xpath="//button[contains(text(),'155269')]")
	public WebElement   hardchaseid;


	public ICRA_PageObjects_Pooja(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}

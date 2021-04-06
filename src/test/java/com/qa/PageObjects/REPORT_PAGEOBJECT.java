package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.MainFunctions.DriverCalling;

public class REPORT_PAGEOBJECT extends DriverCalling{
	
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	public WebElement Run;

	@FindBy(xpath = "//span[contains(text(),'Project')]")
	public WebElement ProjectSel;
	
	@FindBy(xpath = "//span[contains(text(),'Auditee')]")
	public WebElement AudSel;
	
	@FindBy(xpath = "//span[contains(text(),'Coder')]")
	public WebElement CodSel;
	
	@FindBy(xpath = "//span[contains(text(),'DateType')]")
	public WebElement DataSel;
	
	@FindBy(xpath = "//p-multiselect[@formcontrolname='ddlProject']")
	public WebElement ProjectCombox;
	
	@FindBy(xpath = "//select[@id='ddlAuditee']")
	public WebElement AuditCombox;
	
	@FindBy(xpath = "//select[@id='ddlDateType']")
	public WebElement DatatypeCombox;
	
	@FindBy(xpath = "//select[@id='ddlDateRange']")
	public WebElement DataRangeCombox;
	
	@FindBy(xpath = "//div[@role='checkbox']")
	public WebElement CoderAll;
	
	@FindBy(xpath = "//div[contains(@role,'alertdialog')]")
	public WebElement Alert;
	

    @FindBy(xpath = "//tbody[contains(@class,'ui-table-tbody')]")
	public WebElement Grid;
    
    @FindBy(xpath = "//div[@id='highcharts-vcd9klt-7']")
   	public WebElement GridRev;
    
    //intake report---------------------------------------------
    @FindBy(xpath = "//input[@id='btnSubmit']")
   	public WebElement IntakeRun;
    
    @FindBy(xpath = "//select[@id='ddlFilterType']")
   	public WebElement Intakefil;
  
    @FindBy(xpath = "//span[contains(text(),'Ok')]")
   	public WebElement Intakeok; 
  
    @FindBy(xpath = "//tbody[@id='tbodySummaryDetails']")
   	public WebElement Intakegrid; 
  
    @FindBy(xpath = "//tbody[@id='tbodySummaryDetails']")
   	public WebElement IntakeAlert; 
    
    @FindBy(xpath = "//input[@value='Export To Excel']")
   	public WebElement IntakeExcel; 
 
    
    //Management review report.............
    
    @FindBy(xpath = "//div[contains(@class,'ui-chkbox ui-widget ng')]")
   	public WebElement ManProjComboAll; 
    
    @FindBy(xpath = "//input[@id='txtStartDate1']")
   	public WebElement StartDate; 
    
    @FindBy(xpath = "//select[@id='ddlProjectName']")
   	public WebElement QAProjectCombo;   
    //------HCC
    
    @FindBy(xpath = "//select[@id='ddlProject']")
   	public WebElement HCCProjectCombo;   
    
    @FindBy(xpath = "//select[@id='ddlReportfor']")
   	public WebElement ReportforCombo;   
    
    @FindBy(xpath = "//select[@id='ddlReporton']")
   	public WebElement ReportonCombo; 
    
    @FindBy(xpath = "//input[@id='txtAsofDate']")
   	public WebElement ASofdate; 
    
    @FindBy(xpath = "//span[contains(text(),'Report for')]")
   	public WebElement ReportforVal; 
    
    @FindBy(xpath = "//div[contains(@class,'highcharts-container ')]")
   	public WebElement HCCchart; 
    
    //review dashboard
    @FindBy(xpath = "//div[contains(@aria-label,'ProjectName')]")
   	public WebElement RetProject; 
    
    @FindBy(xpath = "//div[contains(text(),'All')]")
   	public WebElement Retselectallcheckbox; 
  
    @FindBy(xpath = "//div[contains(text(),'4 WEEKS AS OF TODAY')]")
   	public WebElement RetPeriod;
    
    @FindBy(xpath = "//button[@aria-label='Filters Show/hide pane']")
   	public WebElement RetFilter;
    
    @FindBy(xpath = "//visual-container-modern[21]//button[@class='themableBackgroundColor']")
   	public WebElement Count;
    
    @FindBy(xpath = "//div[contains(text(),'Agent Details')]")
   	public WebElement Countpage;
    
    @FindBy(xpath = "//div[@title='Agent Name']//div")
   	public WebElement Count_AgentFircol;
  
    @FindBy(xpath = "//div[@class='filterCardTitleSection']")
   	public WebElement Count_AgentFirfil;
  
    @FindBy(xpath = "//button[@class='vcFilterRestatementBtn']")
   	public WebElement TooltipFilter;
    
    @FindBy(xpath = "//button[@class='vcPopOutBtn']")
   	public WebElement TooltipFocus;
    
    @FindBy(xpath = "//button[@class='vcMenuBtn']")
   	public WebElement TooltipMenu;
    
    @FindBy(xpath = "//visual-container-modern[22]//button[@class='themableBackgroundColor']")
   	public WebElement TotCall;
    
    @FindBy(xpath = "//div[contains(text(),'Total Call Details')]")
   	public WebElement TotCallPage;
    
    
    @FindBy(xpath = "//visual-container-modern[2]//button[@class='themableBackgroundColor']")
   	public WebElement BACKTotCallPage;
    
    @FindBy(xpath = "//visual-container-modern[23]//button[@class='themableBackgroundColor']")
   	public WebElement Loca;
    
    @FindBy(xpath = "//div[contains(text(),'Average Call Per Location')]")
   	public WebElement LocPage;
    
    @FindBy(xpath = "//div[@title='Address ID']//div")
   	public WebElement TableFircolAddressid;
    
    @FindBy(xpath = "//div[@title='ChaseID']//div")
   	public WebElement TableFircolChaseID;
    
    @FindBy(xpath = "//div[@title='Role']//div")
   	public WebElement TableFircolRole;
    
    @FindBy(xpath = "//visual-container-modern[24]//button[@class='themableBackgroundColor']")
   	public WebElement RetChaCount;
    
    @FindBy(xpath = "//div[contains(text(),'Chase Details')]")
   	public WebElement RetChaCountpage;
    
    @FindBy(xpath = "//visual-container-modern[25]//button[@class='themableBackgroundColor']")
   	public WebElement ProTou;
    
    @FindBy(xpath = "//div[contains(text(),'Providers Touched')]")
   	public WebElement ProToupage;
    
    @FindBy(xpath = "//visual-container-modern[48]//button[@class='themableBackgroundColor']")
   	public WebElement AddTou;
    
    @FindBy(xpath = "//div[contains(text(),'Address Touched Details')]")
   	public WebElement AddToupage;
    
    @FindBy(xpath = "//visual-container-modern[42]//button[@class='themableBackgroundColor']")
   	public WebElement ProLoc;
    
    @FindBy(xpath = "//div[@title='Provider Location Details']//div[contains(text(),'Provider Location Details')]")
   	public WebElement ProLocpage;
    
    @FindBy(xpath = "//visual-container-modern[41]//button[@class='themableBackgroundColor']")
   	public WebElement SucCall;
    
    @FindBy(xpath = "//div[contains(text(),'Successful ')]")
   	public WebElement SucCallpage;
    
    @FindBy(xpath = "//visual-container-modern[44]//button[@class='themableBackgroundColor']")
   	public WebElement ESC;
    
    @FindBy(xpath = "//div[contains(text(),'Escalation ')]")
   	public WebElement ESCpage;
    
    @FindBy(xpath = "//visual-container-modern[43]//button[@class='themableBackgroundColor']")
   	public WebElement Scan;
    
    @FindBy(xpath = "//div[contains(text(),'Scan ')]")
   	public WebElement Scanpage;
    
    @FindBy(xpath = "//visual-container-modern[40]//button[@class='themableBackgroundColor']")
   	public WebElement RET;
    
    @FindBy(xpath = "//div[contains(text(),'Retrieval Details')]")
   	public WebElement RETPage;
    
    @FindBy(xpath = "//visual-container-modern[45]//button[@class='themableBackgroundColor']")
   	public WebElement INT;
    
    @FindBy(xpath = "//div[contains(text(),'Intake')]")
   	public WebElement INTPage;
    
    @FindBy(xpath = "//visual-container-modern[46]//button[@class='themableBackgroundColor']")
   	public WebElement Rec;
    
    @FindBy(xpath = "//div[contains(text(),'Record QA')]")
   	public WebElement RecPage;
    
    @FindBy(xpath = "//visual-container-modern[1]//button[@class='themableBackgroundColor']")
   	public WebElement BACK;
    
    @FindBy(xpath = "//visual-container-modern[13]//button[@class='themableBackgroundColor']")
   	public WebElement Dashboard;
    
    @FindBy(xpath = "//transform//div[contains(text(),'Call Success')]")
   	public WebElement WeekSucc;
    
    @FindBy(xpath = "//transform//div[contains(text(),'Call Trend_Weekly')]")
   	public WebElement WeekCallTre;
    
    @FindBy(xpath = "//transform//div[contains(text(),'Call Rates_Weekly')]")
   	public WebElement WeekCallRate;
    
    @FindBy(xpath = "//transform//div[contains(text(),'Chart Retrieval')]")
   	public WebElement WeekCharRet;
    
    @FindBy(xpath = "//transform//div[contains(text(),'Cumulative ')]")
   	public WebElement WeekuCum;
    
    @FindBy(xpath = "//transform//div[contains(text(),'Forecast')]")
   	public WebElement WeekForecast;
    
	public REPORT_PAGEOBJECT(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}

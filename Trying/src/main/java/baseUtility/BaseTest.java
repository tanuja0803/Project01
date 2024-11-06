package baseUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import WD_JavaUtility.JavaUtility;
import genericUtilities.ReadingDataFromPropertiesFile;

public class BaseTest {
	public WebDriver driver=null;
	public ExtentSparkReporter esreport=null;
	public ExtentReports ereport=null;
	public ExtentTest test=null;
	public JavaUtility ju=new JavaUtility();
	public ReadingDataFromPropertiesFile read=new ReadingDataFromPropertiesFile();
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void itsBeforeSuite() {
		Reporter.log("Before Suite Started",true);
		String date=ju.getSystemDate();
		date.replace(':', '_').replace(' ', '_');
		esreport= new ExtentSparkReporter("./advanceReport/Advance_Report_"+date+".html");
		esreport.config().setDocumentTitle("VTiger Report");
		esreport.config().setReportName("AdbanceReport"+ju.generateRandomNumber());
	}
	
	@BeforeClass(groups = {"Smoke","Regression"})
	public void itsBeforeClass() {
		Reporter.log("Before Class Started",true);
		ereport= new ExtentReports();
		ereport.attachReporter(esreport);
		ereport.setSystemInfo("OS", "Windows");
		ereport.setSystemInfo("Environment", "Testing");
	}
	
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void itsBeforeMethod() throws Exception {
		Reporter.log("Before Method Started",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(read.readDataFromFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(read.readDataFromFile("user1"));
		driver.findElement(By.name("user_password")).sendKeys(read.readDataFromFile("pwd1"));
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod(groups = {"Smoke","Regression"})
	public void itsAfterMethod() {
		Reporter.log("After Method Started",true);
		try {
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		}
		catch(StaleElementReferenceException e) {
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		}
	}
	
	@AfterClass(groups = {"Smoke","Regression"})
	public void itsAfterClass() {
		Reporter.log("After Class Started",true);
		driver.quit();
	}
	
	@AfterSuite(groups = {"Smoke","Regression"})
	public void itsAfterSuite() {
		Reporter.log("After Suite Started",true);
		ereport.flush();
	}
}

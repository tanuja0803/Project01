package genericUtilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseUtility.BaseTest;

public class ListenerImplementation extends BaseTest implements ITestListener,ISuiteListener {
	public void onStart(ISuite suite) {
	    System.out.println("On start of suite");
	  }
	
	public void onFinish(ISuite suite) {
	    System.out.println("On finish of suite");
	  }
	
	public void onStart(ITestContext context) {
		    System.out.println("on start of test");
	 }
	
	public void onFinish(ITestContext context) {
	    System.out.println("on finish of test");
	  }
	
	public void onTestStart(ITestResult result) {
	    System.out.println("On Test Start");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("On Test Success");
	  }
	
	public void onTestFailure(ITestResult result) {
	    TakesScreenshot ts=(TakesScreenshot)driver;
	    String temp=ts.getScreenshotAs(OutputType.BASE64);
	  }
	
	public void onTestSkipped(ITestResult result) {
	    System.out.println("On Test Skipped");
	  }
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    System.out.println("On Test Failed But Within Success Percentage");
	  }
	
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("On Test Failed With Timeout");
	    onTestFailure(result);
	  }

}

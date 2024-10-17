package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter SparkReporter;
	public ExtentReports extent;
	public ExtentTest Test;
	
	String repName;
	public void onStart(ITestContext testContext) {
		/*
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date df=new Date();
	    String currentdatetimestamp	=dateFormat.format(df);
	    */
	    String timeStamp=   new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    
	    repName="Test Report-"+ timeStamp+ ".html";
	    
	    SparkReporter=new ExtentSparkReporter(".\\reports\\"+repName); //specify location of the report
	    
	    SparkReporter.config().setDocumentTitle("opencart automation title");
	    SparkReporter.config().setReportName("opencart Functional testing");
	    SparkReporter.config().setTheme(Theme.DARK);
	    
	    
	    extent=new ExtentReports();
	    extent.attachReporter(SparkReporter);
	    extent.setSystemInfo("Application", "opencart");
	    extent.setSystemInfo("module", "admin");
	    extent.setSystemInfo("sub module", "customer");
	    extent.setSystemInfo("user name", System.getProperty("user.name"));
	    extent.setSystemInfo("Environment", "QA");
	    
	    
	  String oS=  testContext.getCurrentXmlTest().getParameter("os");
	  extent.setSystemInfo("Operating System", oS);
	  
	String browser=  testContext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);
	
List<String>includeGroup=testContext.getCurrentXmlTest().getIncludedGroups();
if(!includeGroup.isEmpty()) {
	extent.setSystemInfo("Groups", includeGroup.toString());
}


	}
public void onTestSuccess(ITestResult result) {
	
	Test=extent.createTest(result.getTestClass().getName());
	Test.assignCategory(result.getMethod().getGroups());//to display group in report
	Test.log(Status.PASS, result.getName()+"got successfully executed");
}	

public void onTestFailure(ITestResult result) {
	Test=extent.createTest(result.getClass().getName());
	Test.assignCategory(result.getMethod().getGroups());//to display group in report
	
	Test.log(Status.FAIL, result.getName()+"got Failed");
	Test.log(Status.INFO, result.getThrowable().getMessage());
	try {
	String imgPath=new BaseClass().captureScreen(result.getName());
	Test.addScreenCaptureFromPath(imgPath);
	}
	catch (IOException e) {
		e.printStackTrace();
	}
		
	}
public void onTestSkipped(ITestResult result) {
	
	Test=extent.createTest(result.getTestClass().getName());
	Test.assignCategory(result.getMethod().getGroups());//to display group in report
	Test.log(Status.FAIL, result.getName()+"got Skipped");
	Test.log(Status.INFO, result.getThrowable().getMessage());
}

public void onFinish(ITestContext testContext) {
	extent.flush();
	String pathOfTheExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
File extentReport=new File(pathOfTheExtentReport);

try {
	Desktop.getDesktop().browse(extentReport.toURI());
}catch (IOException e) {
	e.printStackTrace();
}
}
	
	

	
}

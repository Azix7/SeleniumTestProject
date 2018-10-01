package config;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class InvokeBrowser {
  
	public static WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	String method;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	@BeforeTest 
	public void report(){
		
		htmlreporter = new ExtentHtmlReporter("reports/MyHtmlReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		
	}
	
	@BeforeMethod
	
	public void MethodName(Method method){
		
		parentTest = extent.createTest(method.getName());
		
	}
	
  @BeforeClass
  public void beforeClass() {
      

	  System.setProperty("webdriver.chrome.driver","C:/Users/ai-maroc/Downloads/chromedriver_win32/chromedriver.exe");
      driver= new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
  
  }

  @AfterClass
  public void afterClass() {
	 
	  extent.flush();
	  driver.quit();
  }

}

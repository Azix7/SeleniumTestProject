package customCommands;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import config.InvokeBrowser;
import objectRepository.MyAccountPage;

public class ActionDriver {

	WebDriver driver;
	
	public ActionDriver(){
		
		driver=InvokeBrowser.driver;
			
	}
	
	public void LaunchApplication(String url) throws Exception{
		
		try {
			
			InvokeBrowser.childTest.pass("Navigate to "+url+"  successfully");
			driver.get(url);
		} catch (Exception e) {
			
			InvokeBrowser.childTest.fail("Unable to Navigate to "+url+ InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
			throw e;
		}
		
	}
	
	public void Type(By locator, String testData, String elementName) throws Exception{
		
		try {
			InvokeBrowser.childTest.pass("Able to type in" + elementName);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(testData);
		} catch (Exception e) {
			InvokeBrowser.childTest.fail("Unable to type in" + elementName+InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
			throw e;
		}	
	}
	
	public void Click(By locator, String elementName) throws Exception{
		
		try {
			InvokeBrowser.childTest.pass("Able to click on" + elementName);
			driver.findElement(locator).click();
		} catch (Exception e) {
			InvokeBrowser.childTest.fail("Unable to click on" + elementName + InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
			throw e;
			
		}
		
	}
	
	
	public void IsVisible(By locator, String elementName) throws Exception{
		
		try {
			InvokeBrowser.childTest.pass("Able to see "+ elementName+" in page");
			driver.findElement(locator).isDisplayed();
			
		} catch (Exception e) {
			InvokeBrowser.childTest.fail("Unable to see "+ elementName+ " in page "+ InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
			throw e;
		}
		
		
	}
	
	public void WrongPassword(By locator, String elementName, String txt) throws IOException{
		
		
		try {
			InvokeBrowser.childTest.pass("Able to see error message : "+ driver.findElement(locator).getText() +InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
		txt = driver.findElement(locator).getText();
			 System.out.println(txt);
		} catch (Exception e) {
			InvokeBrowser.childTest.fail(" unable to get the error message "+ elementName+" in page"+ InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
			throw e;
		}
		
	}
	
	public void SelectFromDropDown(By locator, String elementName) throws Exception{
		
		 Select drp;
		
		try {
			InvokeBrowser.childTest.pass("clicked on  :" + elementName );
			drp = new Select(driver.findElement(locator));
			drp.selectByVisibleText("S5_5_QA_AZIZ");
			
		} catch (Exception e) {
			InvokeBrowser.childTest.fail("unable to find the element specified from :" + elementName+ InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
		throw e;
		}
					
	}
	
	public void UploadPhoto(By locator, String elementName) throws Exception{
		
		try {
			InvokeBrowser.childTest.pass(" Able to click on :" + elementName );
			driver.switchTo().frame("slot1");
			driver.findElement(locator).click();
			
			driver.findElement(locator).sendKeys("C:\\Users\\ai-maroc\\Desktop\\logo.jpg");
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ESCAPE);
	     	robot.keyRelease(KeyEvent.VK_ESCAPE);
			
		} catch (Exception e) {
			InvokeBrowser.childTest.fail(" Unable to upload Photo by :" + elementName+InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));
			throw e;
		}
		
	}
	
	public void MouseHouver(By locator, String elementName) throws Exception{
		
          try {
        	 InvokeBrowser.childTest.pass(" Able to Mouse Houver on :" + elementName );  
			Actions a = new Actions(driver);
			
			WebElement mo = driver.findElement(locator);
			a.moveToElement(mo).build().perform();
			
		} catch (Exception e) {
			InvokeBrowser.childTest.fail(" unable to Mouse Houver on :" + elementName + InvokeBrowser.childTest.addScreenCaptureFromPath(ScreenShot(driver)));  
		}

	}
	
	public String ScreenShot(WebDriver driver){
		
		String src_path ="/SShot/azz.jpeg";
		
	//	UUID uuid = UUID.randomUUID();
		
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try{
			FileUtils.copyFile(srcFile, new File(src_path));
			
		}catch (Exception e)
		{
			System.out.println("Unable to take a screenshot");
		}
		return src_path;
	}
	
	
	public void SwitchToPopUpPage(){
		

		String mainWindow=driver.getWindowHandle();
		 // It returns no. of windows opened by WebDriver and will return Set of Strings
		 Set<String> set =driver.getWindowHandles();
		 // Using Iterator to iterate with in windows
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
		 String childWindow=itr.next();
		    // Compare whether the main windows is not equal to child window. If not equal, we will close.
		 if(!mainWindow.equals(childWindow)){
		 driver.switchTo().window(childWindow);
		 System.out.println(driver.switchTo().window(childWindow).getTitle());
		 
 
		 }
		 }
 
	}

}

package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import config.InvokeBrowser;
import customCommands.ActionDriver;
import objectRepository.MyAccountPage;
import reuse.CommonFunctions;

public class TestCase_DoneesTechniques extends InvokeBrowser {
	
	@Test(priority=0)
	public void SignIn() throws Exception{
		
		CommonFunctions aDriver = new CommonFunctions();
		 aDriver.Sign_In();
	}
	
   @Test(priority=1)
  public void TestDonneesTechniques() throws Exception {
	  
   
	  CommonFunctions aDriver = new CommonFunctions();  	  
	  try
	  {
	   
	   aDriver.TestDonneesTechniques();
	   InvokeBrowser.childTest.pass("able to get into donnees techniques page");
	   
	} catch (Exception e) {
		InvokeBrowser.childTest.fail("Unable to get into donnees techniques page" );
		
	}
   
  }
}

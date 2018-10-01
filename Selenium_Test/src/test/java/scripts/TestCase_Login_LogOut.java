package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import config.InvokeBrowser;
import customCommands.ActionDriver;
import objectRepository.HomePage;
import objectRepository.MyAccountPage;
import objectRepository.MyProfilePage;
import reuse.CommonFunctions;

public class TestCase_Login_LogOut extends InvokeBrowser{
	 
	
	
  @Test(priority=1)
  public void TestLoginIn() throws Exception  {
 
	  CommonFunctions aDriver = new CommonFunctions();
       aDriver.Sign_In();
       aDriver.Sign_Out();
    
   }
 
  
}

package scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import config.InvokeBrowser;
import customCommands.ActionDriver;
import objectRepository.MyAccountPage;
import objectRepository.MyProfilePage;
import reuse.CommonFunctions;

public class TestCase_UploadPhoto extends InvokeBrowser{
  
	
	 @Test
  public void TestUploadPhoto() throws Exception{
	    	
		 CommonFunctions aDriver = new CommonFunctions();
		 aDriver.Sign_In();
         aDriver.Upload_Photo();
	      
	}
}
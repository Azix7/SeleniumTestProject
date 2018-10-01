package scripts;

import org.testng.annotations.Test;

import reuse.CommonFunctions;

public class TestCase_WrongPassword {
  @Test
public void TestWrongPassword() throws Exception{
	  
	  CommonFunctions aDriver = new CommonFunctions();
	  aDriver.WrongPasswordTest();
	  	  
  }
}

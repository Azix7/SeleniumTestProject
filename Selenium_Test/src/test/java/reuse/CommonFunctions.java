package reuse;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;

import config.InvokeBrowser;
import customCommands.ActionDriver;
import objectRepository.HomePage;
import objectRepository.MyAccountPage;
import objectRepository.MyProfilePage;
import objectRepository.ReadUsingAdvicesPage;
import utilities.Xls_Reader;

public class CommonFunctions {
	
	 public ActionDriver aDriver;
	 public Xls_Reader reader;
	 
	public CommonFunctions(){
		
		aDriver= new ActionDriver();
		reader = new Xls_Reader("C:\\Users\\ai-maroc\\git\\TestRepository\\Selenium_Test\\testData\\TestData.xlsx");
		
	}
	
	//Sign in to application
	public void Sign_In() throws Exception{
		
		  InvokeBrowser.childTest=InvokeBrowser.parentTest.createNode("Sign in to application");
		  aDriver.LaunchApplication("https://s5-5-qa.sylob.local:8443");
		  aDriver.Type(HomePage.txtLogin, reader.getCellData("Feuil1", "Login", 2), " Login field");
		  aDriver.Type(HomePage.txtPassword, reader.getCellData("Feuil1", "Password", 2) , " password field");
		  aDriver.SelectFromDropDown(HomePage.ddcompany, "company dropdown list ");
		  aDriver.Click(HomePage.btnLoginIn, " login button");
		  
		  		
    }
	
	// Sign out form application
      public void Sign_Out() throws Exception{
		
		InvokeBrowser.childTest=InvokeBrowser.parentTest.createNode("Sign out from application");
		aDriver.Click(MyAccountPage.pixProfile, "My account link");
		aDriver.Click(MyAccountPage.btnLogOut, "Log out Button");
		
	}
  
    // Sign in with wrong Login/Password	  
      public void WrongPasswordTest() throws Exception{
    	  
    	  
    	  InvokeBrowser.childTest=InvokeBrowser.parentTest.createNode("Testing wrong password");
    	  aDriver.LaunchApplication("https:/s5-4-pg.sylob.local:8443/");
		  aDriver.Type(HomePage.txtLogin, reader.getCellData("Feuil1", "Login", 3), " Login field");
		  aDriver.Type(HomePage.txtPassword, reader.getCellData("Feuil1", "Password", 3) , " password field");
		  aDriver.Click(HomePage.btnLoginIn, " login button");
		  
    	  aDriver.WrongPassword(HomePage.txtErrorMsg, "error message:" , "");
    	  
      }
      
    // uploading a photo in the profile page 
      public void Upload_Photo() throws Exception{
    	  
    	  InvokeBrowser.childTest=InvokeBrowser.parentTest.createNode("Testing Uploading a Photo");
    	  aDriver.Click(MyAccountPage.btnMyAccount, "My account link");
   	      aDriver.Click(MyAccountPage.btnProfile, "edit my profile"); 
   	      aDriver.UploadPhoto(MyProfilePage.btnUpload, "upload button");
    	  
      }
      
      public void ControlPopUpWindow() throws Exception{
    	  
    	  aDriver.Click(MyAccountPage.btnMyAccount, "My account link");
    	  aDriver.Click(MyAccountPage.btnReadUserAdvices,"Using advices");
    	  aDriver.SwitchToPopUpPage();
    	  aDriver.Type(ReadUsingAdvicesPage.txtOpenHelp, "abcdefghij", "ddd");
    	  aDriver.Click(ReadUsingAdvicesPage.btnPrint, "imprimer");
    	
      }
     
      public void TestDonneesTechniques() throws Exception {
 			
          InvokeBrowser.childTest=InvokeBrowser.parentTest.createNode("Tester le repertoire donnees techniques");
 		  
           aDriver.Click(MyAccountPage.lnkConcevoir, "Concevoir");
    	   aDriver.Click(MyAccountPage.lnkDonneeTechniques, " Donnees techniques");
    	   aDriver.Click(MyAccountPage.btnDonneeTechniques, " Donnees techniques file");    
      }
      
}

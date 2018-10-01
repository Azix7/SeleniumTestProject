package objectRepository;

import org.openqa.selenium.By;

public class MyAccountPage {

	// Action About
	public static By lnkActivity = By.xpath("/html/body/table/tbody/tr[2]/td[1]/div/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]");
	public static By btnMyAccount = By.id("about");
	public static By btnLogOut = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/div/ul[5]/li");
	public static By btnProfile = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/div/ul[1]/li");
	public static By pixProfile = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div[1]/img");
	public static By btnReadUserAdvices = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/div/ul[2]/li[1]"); 
	public static By btnHelpConsult = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/div/ul[2]/li[2]"); 
	public static By btnAskSupport = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/div/ul[3]/li[1]");                             
	
	
	
	
     //Activities
	
	public static By lnkConcevoir = By.xpath("/html/body/table/tbody/tr[2]/td[1]/div/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td/table/tbody/tr/td[1]");	
	public static By lnkDonneeTechniques = By.xpath("/html/body/table/tbody/tr[2]/td[1]/div/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]");
	public static By btnDonneeTechniques = By.xpath("/html/body/table/tbody/tr[2]/td[1]/div/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td/table/tbody/tr/td[1]/font");
	// Start activity "Démarrer une activité"
	public static By txtLauncher = By.id("Launcher");
	
	
}



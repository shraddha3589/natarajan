package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import module.HomePageModules;
import utility.ExcelUtil;

public class KeywordDrive {
public static HomePageModules modules;
	public static void main(String[] args) throws Exception {
	WebDriver driver=new FirefoxDriver();
	modules = new HomePageModules();
		driver.get(Constants.Url);
		driver.manage().window().maximize();
	WebDriverWait sync = new WebDriverWait(driver,60);
	String Path = "C:\\Users\\NatarajanRamanathan\\workspace\\AutomationDemo\\srcModular\\utility\\KeyWord.xlsx";
	String SheetName = "Sheet3";
	String AK;
	ExcelUtil.setExcelFile(Path, SheetName);
	for(int i=0;i<5;i++)
	{
		AK = ExcelUtil.getCellData(i, 1);
		if (AK.equalsIgnoreCase("verifyPassword_label"))
			modules.verifyPassword_label(driver, sync);
		else if(AK.equalsIgnoreCase("verifyRemember_label"))
			modules.verifyRemember_label(driver, sync);
		else if(AK.equalsIgnoreCase("verifyEmail"))
			modules.verifyEmail(driver, sync);
	}
	}

}

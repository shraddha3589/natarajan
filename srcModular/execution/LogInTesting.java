package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.Constants;
import module.HomePageModules;

public class LogInTesting {
	public static WebDriver driver;
	public static WebDriverWait sync;
	@BeforeTest
	public void loadEnvironment()
	{
		driver=new FirefoxDriver();
		driver.get(Constants.Url);
		driver.manage().window().maximize();
		sync = new WebDriverWait(driver,60);
	}
	@Test(priority=1, description="Testing for right access credentials")
	  public void ValidCredentials_Login() throws InterruptedException{
		  HomePageModules.loginmethod(driver, sync, Constants.Username, Constants.Password);
	  }
	  @Test(priority=2, description="Testing for wrong access credentials")
	  public void InValidCredential_Login() throws InterruptedException{
		  HomePageModules.loginmethod(driver, sync, Constants.InvalidUser, Constants.InvalidPassword);
	  }
	  @AfterTest
	  public void Teardown(){
		  driver.quit();
	  }
}

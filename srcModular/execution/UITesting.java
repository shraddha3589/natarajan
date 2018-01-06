package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.Constants;
import module.HomePageModules;

public class UITesting {
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
  @Test(priority=1, groups="smoke")
  public void Verify_Title() throws InterruptedException {
	  HomePageModules.verifyTitle(driver, sync);
  }
  @Test(priority=2, groups="smoke")
  public void Verify_Header() throws InterruptedException {
	  HomePageModules.verifyheader(driver, sync);
	  throw new SkipException("Skipping this exception");  //skip a test sample
  }
  @Test(priority=3, groups="smoke")
  public void Verify_Email_Label() throws InterruptedException {
	  HomePageModules.verifyEmail_label(driver, sync);
  }
  @Test(priority=4, groups="smoke")
  public void Verify_Email_Text_Box() throws InterruptedException {
	  HomePageModules.verifyEmail(driver, sync);
  }
  @Test(priority=5, groups="regression")
  public void Verify_Password_Label() throws InterruptedException {
	  HomePageModules.verifyPassword_label(driver, sync);
  }
  @Test(priority=6, groups="regression")
  public void Verify_Password_Text_Box() throws InterruptedException {
	  HomePageModules.VerifyPassword(driver, sync);
  }
  @Test(priority=7, groups="regression")
  public void Verify_RememberMe_Label() throws InterruptedException {
	  HomePageModules.verifyRemember_label(driver, sync);
  }
  @Test(priority=8, groups="regression")
  public void Verify_RememberMe_ChkBox() throws InterruptedException {
	  HomePageModules.VerifyRemember_chk_box(driver, sync);
  }
  @Test(priority=9, groups="regression")
  public void Verify_SignIn_Btn() throws InterruptedException {
	  HomePageModules.verifySignInBtn(driver, sync);
  }
  @Test(priority=10, groups="smoke")
  public void Verify_ForgotPassword() throws InterruptedException {
	  HomePageModules.verifyForgotPassowrdlink(driver, sync);
  }
  @AfterTest
  public void Teardown(){
	  driver.quit();
  }
}

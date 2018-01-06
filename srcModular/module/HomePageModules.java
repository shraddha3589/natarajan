package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.HomePage;

@SuppressWarnings("deprecation")
public class HomePageModules {
public static void verifyTitle(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	String title=HomePage.title(driver,sync).getText();
	try{
	Assert.assertEquals("Vibrant Technologies Ltd", title);
	Reporter.log("Title Verified");
	}
	catch(Exception e)
	{
		Reporter.log("Title assertion failed");
		Assert.fail();
	}
}
public static void verifyheader(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	String header = HomePage.header(driver,sync).getText();
	try{
		Assert.assertEquals("Sign In", header);
		Reporter.log("Sign In Heading Verified");
	}
	catch(Exception e){
		Reporter.log("Sign In heading verification failed");
		Assert.fail();
	}
}
public static void verifyEmail_label(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	String label= HomePage.Email_label(driver,sync).getText();
	try{
		Assert.assertEquals("Email", label);
		Reporter.log("Email label Verified");
	}
	catch(Exception e){
		Reporter.log("Email label verification failed");
		Assert.fail();
	}
}
public static void verifyPassword_label(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	String label= HomePage.Passowrd_label(driver,sync).getText();
	try{
		Assert.assertEquals("Password", label);
		Reporter.log("Password label Verified");
	}
	catch(Exception e){
		Reporter.log("Password label verification failed");
		Assert.fail();
	}
}
public static void verifyRemember_label(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	String label= HomePage.Remember_label(driver,sync).getText();
	try{
		Assert.assertEquals("Remember me", label);
		Reporter.log("Remember me label Verified");
	}
	catch(Exception e){
		Reporter.log("Remember me label verification failed");
		Assert.fail();
	}
}
public static void verifyEmail(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	boolean Email= HomePage.Email(driver,sync).isDisplayed();
	try{
		Assert.assertEquals(true, Email);
		Reporter.log("Email Text Box Element Present");
	}
	catch(Exception e){
		Reporter.log("Email Text Box Element Not Present");
		Assert.fail();
	}
}
public static void VerifyPassword(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	boolean Password = HomePage.Password(driver,sync).isDisplayed();
	try{
		Assert.assertEquals(true, Password);
		Reporter.log("Password Text Box Element Present");
	}
	catch(Exception e){
		Reporter.log("Password Text Box Element not Present");
		Assert.fail();
	}
}
public static void VerifyRemember_chk_box(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	boolean Chk_box = HomePage.Remember_chk_box(driver,sync).isDisplayed();
	try{
		Assert.assertEquals(true, Chk_box);
		Reporter.log("Remember me check box is present");
		boolean chk_boxenabled = HomePage.Remember_chk_box(driver,sync).isSelected();
		if(chk_boxenabled)
		{
			Reporter.log("Remember me check box is selected");
		}
		else
		{
			Reporter.log("Remember me check box is not selected");
		}
	}
	catch(Exception e){
		Reporter.log("Remember me check box is not present");
		Assert.fail();
	}
}
public static void verifySignInBtn(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	boolean btn = HomePage.Password(driver,sync).isDisplayed();
	try{
		Assert.assertEquals(true, btn);
		Reporter.log("Sign In Button Present");
	}
	catch(Exception e){
		Reporter.log("Sign In Button not Present");
		Assert.fail();
	}
}
public static void verifyForgotPassowrdlink(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	String text = HomePage.forgotPasswordLink(driver,sync).getText();
	String tag = HomePage.forgotPasswordLink(driver,sync).getTagName();
	try{
		Assert.assertEquals("Forgot your password?", text);
		Assert.assertEquals("b", tag);                          //fail a test sample
		Reporter.log("Forgot your password link Present");
	}
	catch(Exception e){
		Reporter.log("Forgot your password link not Present");
		Assert.fail();
	}
}
public static void loginmethod(WebDriver driver, WebDriverWait sync, String username, String Password) throws InterruptedException
{
	HomePage.Email(driver,sync).sendKeys(username);
	HomePage.Password(driver,sync).sendKeys(Password);
	HomePage.SignIn(driver,sync).click();
	Thread.sleep(4000);
	sync.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
	String h3 = driver.findElement(By.tagName("h3")).getText();
	if(h3.equalsIgnoreCase("Candidates"))
	{
		Reporter.log("login successful");
		driver.findElement(By.linkText("Sign Out")).click();
	}
	else if(h3.equalsIgnoreCase("Sign In"))
	{
		Reporter.log("login failed");
	}
}
}

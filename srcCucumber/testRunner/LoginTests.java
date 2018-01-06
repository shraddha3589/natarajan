package testRunner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTests {
//driver is initiated public to be accessed throughout the class
public static WebDriver driver;
	@Given ("^I am on www.magentocommerce.com web Page$")
	public void LaunchPage()
	{
		driver = new FirefoxDriver();
		driver.get("https://www.magentocommerce.com/products/customer/account/login?_ga=1.108156289.2079771868.1463475820");
		driver.manage().window().maximize();
	}
	@When ("^I enter ([^\"]*) credentials$")
	public void IEnter(String str) throws InterruptedException
	{
		if(str.equals("right"))
		{
			driver.findElement(By.id("email")).sendKeys("natarajan.ramanathan93@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Welcome@1");
			driver.findElement(By.id("send2")).click();
		}
		else if(str.equals("wrong"))
		{
			driver.findElement(By.id("email")).sendKeys("natarajan.ramanathan3@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Welcome@1");
			driver.findElement(By.id("send2")).click();
			Thread.sleep(3000);
		}
	}
	@Then ("^I should log into profile page$")
	public void SuccessLogIn()
	{
		try
		{
			driver.findElement(By.linkText("Log Out"));
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		driver.quit();
	}
	@Then ("^I should remain on the same page$")
	public void InvalidLogin()
	{
		try
		{
			driver.findElement(By.id("send2"));
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	driver.quit();
	}
}

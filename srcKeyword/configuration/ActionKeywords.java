package configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ActionKeywords {
	public static WebDriver driver;
	public static AndroidDriver<AndroidElement> ad;
 
	public static void Open(String Object, String Data) throws MalformedURLException
	{
		if(Object.equals("Browser_Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Object.equals("Browser_Mobile"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			Reporter.log("Initiating the capabilities");
			capabilities.setCapability("appium-version", "1.4.16");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "4.1");
			capabilities.setCapability("deviceName", "Titanium S5");
			ad=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver = ad;
		}
		else if(Object.equals("Browser_Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Object.equals("Browser_InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	public static void Navigate(String Object, String Data)
	{
		if(Object.equals("URL"))
		{
			driver.get(Data);
		}
	}
	public static void Click(String Object, String Data)
	{
		driver.findElement(By.xpath(Object)).click();
	}
	public static void SendKeys(String Object, String Data)
	{
		driver.findElement(By.xpath(Object)).sendKeys(Data);
	}
	public static void Quit(String Object, String Data)
	{
		driver.quit();
	}
	public static void Maximize(String Object, String Data)
	{
		driver.manage().window().maximize();
	}
	public static void Select(String Object, String Data)
	{
		Select drop=new Select(driver.findElement(By.xpath(Object)));
		drop.selectByVisibleText(Data);
		
	}
}

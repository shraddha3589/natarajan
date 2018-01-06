package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Highlight;

public class HomePage {
public static WebElement Element;
public static WebDriver driver;
public static By Locator;
public static WebElement title(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.tagName("h2");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement header(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.tagName("h3");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement Email_label(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.xpath("//*[@for='user_email']");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement Email(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.id("user_email");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement Passowrd_label(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.xpath("//*[@for='user_password']");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement Password(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.id("user_password");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement Remember_label(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.xpath("//*[@for='user_remember_me']");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement Remember_chk_box(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.id("user_remember_me");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement SignIn(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.xpath("//*[@value='Sign in']");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
public static WebElement forgotPasswordLink(WebDriver driver, WebDriverWait sync) throws InterruptedException
{
	Locator = By.linkText("Forgot your password?");
	sync.until(ExpectedConditions.presenceOfElementLocated(Locator));
	Element = driver.findElement(Locator);
	Highlight.fnHighlight(driver, Element);
	return Element;
}
}

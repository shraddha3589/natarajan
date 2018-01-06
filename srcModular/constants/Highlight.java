package constants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight {

	public static void fnHighlight(WebDriver driver,WebElement element) throws InterruptedException{
		  //Creating JavaScriptExecuter Interface
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   for (int iCnt = 0; iCnt < 3; iCnt++) {
		      //Execute javascript
		         js.executeScript("arguments[0].style.border='4px groove red'", element);
		         Thread.sleep(400);
		         js.executeScript("arguments[0].style.border=''", element);
		   }
		 }
	
}

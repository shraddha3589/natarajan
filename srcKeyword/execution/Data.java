package execution;

import org.testng.annotations.Test;

import configuration.ActionKeywords;
import configuration.Constants;
import utility.ExcelUtils;
import utility.Jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Data {
	public static ActionKeywords actionKeywords;
	public static Method method[];
	@BeforeTest
	public void beforeTest()
	{
		Reporter.log("Test Initiated");
	}
  @Test(dataProvider = "Excel")
  public void TestStep(String TS_ID, String Desc, String sAction, String sObject, String sData) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	  //System.out.println(" "+TS_ID+" "+Desc+" "+sAction+" "+sObject+" "+sData);
	  actionKeywords = new ActionKeywords();
	  method = actionKeywords.getClass().getMethods();
	  for(int i = 0;i < method.length ;i++){
			//This is now comparing the method name with the ActionKeyword value got from excel
			if(method[i].getName().equals(sAction)){
				//In case of match found, it will execute the matched method
				method[i].invoke(sAction, sObject, sData);
				//Once any method is executed, this break statement will take the flow outside of for loop
				if(Desc!=null)
				{
					Reporter.log(Desc+"        Passed");
				}
				break;
				}
			}
  }
  @AfterTest
  public void afterTest(){
	  Reporter.log("Test Execution complete");
  }
  @DataProvider (name = "Excel")
  public Object[][] excel() throws Exception {
	return ExcelUtils.getTableArray(Constants.Path_TestData, Constants.Sheet_TestSteps);
    }
  @DataProvider(name = "SQLDB")
  public Object[][] database() throws SQLException
  {
	  return (Jdbc.jdbc());
  }
}
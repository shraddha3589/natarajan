package configuration;
 
public class Constants {
 
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value	
	public static final String URL = "http://www.store.demoqa.com";
	public static final String Path_TestData = "C:\\Users\\NatarajanRamanathan\\workspace\\AutomationDemo\\srcKeyword\\dataEngine\\KeyWord.xlsx";
	public static final String File_TestData = "KeyWord.xlsx";
 
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1;
	public static final int Col_Object =4;
	public static final int Col_Action = 3;
	public static final int Col_Data = 5;
 
	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "TestStep";
 
	// List of Test Data
	public static final String UserName = "natarajan93";
	public static final String Password = "welcome";
 
}
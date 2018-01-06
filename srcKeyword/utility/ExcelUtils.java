package utility;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
                public static String Path;
            //This method is to set the File path and to open the Excel file
            //Pass Excel Path and SheetName as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
	                FileInputStream ExcelFile = new FileInputStream(Path);
	                ExcelWBook = new XSSFWorkbook(ExcelFile);
	                ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   }
    		public static void setCellData(String Path, String Result,  int RowNum, int ColNum) throws Exception	
    		{
     			try
     			{
           			Row  = ExcelWSheet.getRow(RowNum);
 					Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
 					if (Cell == null) {
 						Cell = Row.createCell(ColNum);
 						Cell.setCellValue(Result);
 						} else {
 							Cell.setCellValue(Result);
 						}
           // Constant variables Test Data path and Test Data file name
           				FileOutputStream fileOut = new FileOutputStream(Path);
           				ExcelWBook.write(fileOut);
           				fileOut.flush();
  						fileOut.close();
 						}catch(Exception e){
 
							throw (e);
 
					}
 
				}
 
            //This method is to read the test data from the Excel cell
            //In this we are passing parameters/arguments as Row Num and Col Num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
            	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                  String CellData = Cell.getStringCellValue();
                  return CellData;
            	}
            public static int RowCount()
            {
            	return ExcelWSheet.getPhysicalNumberOfRows();
            }
            public static int getRows()
            {
            	return ExcelWSheet.getLastRowNum();
            }
            public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
     		   String[][] tabArray = null;
     		   try {
    			   FileInputStream ExcelFile = new FileInputStream(FilePath);
     			   // Access the required test data sheet
   			   ExcelWBook = new XSSFWorkbook(ExcelFile);
   			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
  			   int startRow = 1;
 			   int startCol = 0;
 			   int ci,cj;
     		   int totalRows = ExcelWSheet.getLastRowNum();
      	   // you can write a function as well to get Column count
      		   int totalCols = 6;
      		   tabArray=new String[totalRows][totalCols];
      		   ci=0;
      		   for (int i=startRow;i<=totalRows;i++, ci++) {           	   
      		   cj=0;
      		   for (int j=startCol;j<=totalCols;j++, cj++){
      			   try{
      			   tabArray[ci][cj]=getCellData(i,j);}
      			   catch(Exception e){}
      			}
      		   	System.out.println();
      			}
      			}
       			catch (FileNotFoundException e){
      			System.out.println("Could not read the Excel sheet");
      			e.printStackTrace();
      		}
       			catch (IOException e){
       			System.out.println("Could not read the Excel sheet");
      			e.printStackTrace();
      			}
       			return(tabArray);
       			}
    	}
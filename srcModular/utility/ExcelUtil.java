package utility;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    public class ExcelUtil {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
 
            //This method is to set the File path and to open the Excel file
            //Pass Excel Path and SheetName as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
	                FileInputStream ExcelFile = new FileInputStream(Path);
	                ExcelWBook = new XSSFWorkbook(ExcelFile);
	                ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   }
            public static int RowCount()
            {
            	return ExcelWSheet.getPhysicalNumberOfRows();
            }
 
            //This method is to read the test data from the Excel cell
            //In this we are passing parameters/arguments as Row Num and Col Num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
            	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                  String CellData = Cell.getStringCellValue();
                  return CellData;
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
    	}
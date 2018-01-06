package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	public static String[][] jdbc() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "welcome");
		Statement s= con.createStatement();
		ResultSet rs = s.executeQuery("select count(*) from teststep");
		rs.next();
		int startRow = 2;
		   int startCol = 2;
		   int ci,cj;
		   int totalRows= rs.getInt(1)+1;
		   rs = s.executeQuery("select * from qadbt.teststep"); 
	  // you can write a function as well to get Column count
		   int totalCols = 7;
		   String[][] tabArray=new String[totalRows][totalCols-1];
		   ci=0;
		   for (int i=startRow;i<=totalRows;i++, ci++) {           	   
		   cj=0;
		   for (int j=startCol;j<=totalCols;j++, cj++){
			   try{
			   tabArray[ci][cj]= rs.getString(j);
				}
			   catch(Exception e){}
			}
		   System.out.println("");
		   rs.next();
		   }
	return tabArray;
	}
}

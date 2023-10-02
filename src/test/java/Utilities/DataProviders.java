package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
//check in git as well for this code
//dataproovider will get data from excel sheet to 2 dimensional array and sends to testmethods
public class DataProviders {
	
	@DataProvider(name="LoginData")
    public String[][] getData() throws IOException
   {
		String path = ".\\TestData\\login_data.xlsx"; //taking xl file from testdata
		
		ExcelUtility xlutil = new ExcelUtility(path);   //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows][totalcols];
		for(int i=1;i<totalrows;i++)     //1   read the data from xlstoring in two dimensional array
		{
			for(int j=0;j<totalcols;j++)      //0       i=row j=col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);   //1,0
			}
		}
		
		return logindata; //returning two dimensional array
		
   }
	
	
	//DataProvider 2
	//DataProvider 3
	//DataProvider 4
	//DataProvider 5
}

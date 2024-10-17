package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path =".\\testData\\Opencart_LoginData1.xlsx";
		
		ExcelUtility xlExcelUtility= new ExcelUtility(path);
		
	    int totalRows=xlExcelUtility.getRowCount("Sheet1");
	    int totalCells=  xlExcelUtility.cellCount("Sheet1",1);
	    
	    String loginData[][]=new String[totalRows][totalCells];
	    
	    for(int r=1;r<totalRows;r++) {
	    	for(int c=0;c<totalCells;c++) {
	    	loginData[r-1][c]=xlExcelUtility.getCellData("Sheet1", r, c);
	    	}
	    }return loginData;
	}
}

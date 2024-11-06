package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\testData\\data.xlsx";
		
		XExcelUtils xutils = new XExcelUtils();
		xutils.NALExcelXLSReader(path);
		
		int totalrows = xutils.getRowCount("Login");
		System.out.println(totalrows);
		int totalcols = xutils.getColumnCount("Login");
		
		String loginData[][] = new String[totalrows - 1][totalcols];
		
		for(int i=2;i<=totalrows;i++) {
			
			for(int j=0;j<totalcols; j++) {
				
				loginData[i-2][j] = xutils.getCellData("Login", j, i);
			}
		}
		
		return loginData;
	}

}

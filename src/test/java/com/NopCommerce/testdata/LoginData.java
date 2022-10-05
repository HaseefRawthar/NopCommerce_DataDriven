package com.NopCommerce.testdata;

public class LoginData {

	TestDataImportUI tdImport = new TestDataImportUI();
	String[] testData;
	
	public String[] getValidLoginData()
	{
		testData = new String[2];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		return testData;
	}
	
	public String[] getInValidLoginData()
	{
		testData = new String[2];
		testData[0] = tdImport.getCellData(2, 0);
		testData[1] = tdImport.getCellData(2, 1);
		return testData;
	}
}

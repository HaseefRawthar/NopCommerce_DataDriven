package com.NopCommerce.testdata;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class RegisterUserData {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	TestDataImportUI tdImport = new TestDataImportUI();
	String[] testData;
	
	public void generateFakeRegisterData()
	{
		tdImport.writeCell(1, 0, fake.name().firstName());
		tdImport.writeCell(1, 1, fake.name().lastName());
		tdImport.writeCell(1, 2, fake.bothify("????????#?#?@email.com"));
	}
	
	public String[] registerUserData()
	{
		testData = new String[5];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		return testData;
	}
}

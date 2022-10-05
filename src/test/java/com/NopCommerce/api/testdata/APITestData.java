package com.NopCommerce.api.testdata;

import java.util.Locale;

import com.NopCommerce.baseclass.SetUp;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class APITestData extends SetUp {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	TestDataImportAPI tdImport = new TestDataImportAPI();
	String[] testData;
	
	public void generateFakePostData()
	{
		tdImport.writeCell(1, 0, fake.name().firstName());
		tdImport.writeCell(1, 1, fake.bothify("????????#?#?@email.com"));
	}
	public String[] apiData()
	{
		testData = new String[2];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		return testData;
	}
}

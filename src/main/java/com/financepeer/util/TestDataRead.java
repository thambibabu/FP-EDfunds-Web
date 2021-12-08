package com.financepeer.util;

public class TestDataRead {
	
	static Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	//Getting dashboard excel data 
	static String dashboard_sheet	= "Dashboard";
	static String DOB 		= "DOB";
	
	static String  day= reader.getCellData(dashboard_sheet, DOB, 2);
	String month= reader.getCellData(dashboard_sheet, DOB, 2);
	String year= reader.getCellData(dashboard_sheet, DOB, 2);
	
	
	
}

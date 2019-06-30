package com.cts.generic;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib {
	
	public static String getPpt(String path,String key) {
		String value="";
		Properties p = new Properties();
		try {
		p.load(new FileInputStream(path));
	    value=p.getProperty(key); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
		}
	
	
	public static String getValue(String path,String sheet,int r,int c) {
	    String value="";
	    try {
	    	Workbook w = WorkbookFactory.create(new FileInputStream(path));
	    	value=w.getSheet(sheet).getRow(r).getCell(c).toString();
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
}

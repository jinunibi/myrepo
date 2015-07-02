package com.qtpselenium.salesforce.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.Keywords;
import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class LoginTest {
	
	Keywords k = Keywords.getInstance();//new Keywords();
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//salesforce//config//TestCases.xlsx");

	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data){
		k.log("**************************Starting login test*******************");
		// runmode of the test
		if(!TestUtil.getRunmode("LoginTest", xls)){
			k.log("Skipping logintest");
			throw new SkipException("Skipping Test as Runmode is NO");
		}

		// runmode of data set
		if(data.get("Runmode").equals("N")){
			k.log("Skipping logintest data iteration");
			throw new SkipException("Skipping as flag is N");
			
		}	
		
		
		
		k.executeKeywords("LoginTest", xls, data);
		k.log("******************Ending login test********************8");

		
		// why 3 different ff
		// chrome and IE
		// validation
	}
	
	@AfterTest
	public void close(){
		//k.close();
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtil.getData("LoginTest", xls);
		/*Object data[][] = new Object[3][4];
		
		// 1st row
		data[0][0] = "U1";
		data[0][1] = "P1";
		data[0][2] = "Mozilla";
		data[0][3] = "Y";


		
		// 2nd row
		data[1][0] = "U2";
		data[1][1] = "P2";
		data[1][2] = "Chrome";//
		data[1][3] = "Y";


		
		// 3rd row
		data[2][0] = "U3";
		data[2][1] = "P3";		
		data[2][2] = "Mozilla";
		data[2][3] = "Y";


		
		return data;*/
		
		
		
		
	}
	
	
	
	
	
	
	
	

}

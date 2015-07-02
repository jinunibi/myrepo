package com.qtpselenium.salesforce.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.Keywords;
import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class CreateLead {
	
	Keywords session = Keywords.getInstance();//new Keywords();
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//salesforce//config//TestCases.xlsx");

	
	@Test(dataProvider="getData")
	public void createLead(Hashtable<String,String> data){
		
		// runmode of the test
		if(!TestUtil.getRunmode("CreateLeadTest", xls))
			throw new SkipException("Skipping Test as Runmode is NO");
		
		// runmode of data set
		if(data.get("Runmode").equals("N"))
			throw new SkipException("Skipping as flag is N");
		
		
		session.openBrowser(data.get("browser"));
		
		// check if you are logged in
		//if(!session.isElementPresent("searchField")){
			// login
			session.loginAsDefaultUser();
		//}
		session.click("leadsTab");
		session.click("newLeadButton");
		///Assert.assertTrue(session.validateText("Ashish Thakur", "leadOwner"), "Lead owner name not correct");
		session.input("firstNameTitle", data.get("title"));
		session.input("leadName",  data.get("firstName"));
		session.input("leadLastName", data.get("lastName"));
		session.input("leadCompany", data.get("company"));
		session.input("leadStatus", data.get("status"));
		session.click("leadSave");
				
		// check if lead is created
	}
	
	@DataProvider//(parallel=true)
	public Object[][] getData(){
		
		return TestUtil.getData("CreateLeadTest", xls);
		/*Object data[][] = new Object[2][1];
		Hashtable<String,String> t1 = new Hashtable<String,String>();
		t1.put("title", "Mr.");
		t1.put("firstName", "Barrack");
		t1.put("lastName", "Obama");
		t1.put("company", "USA");
		t1.put("status", "Qualified");
		t1.put("browser", "Mozilla");

		/*data[0][1]="Barrack";
		data[0][2]="Obama";
		data[0][3]="USA";
		data[0][4]="Qualified";
		data[0][5]="Mozilla";
		
		Hashtable<String,String> t2 = new Hashtable<String,String>();

		t2.put("title", "Mr.");
		t2.put("firstName", "Barrack");
		t2.put("lastName", "Obama");
		t2.put("company", "USA");
		t2.put("status", "Qualified");
		t2.put("browser", "Chrome");
		
		data[0][0]=t1;
		data[1][0]=t2;
		
		
		return data;*/
	}
	
	
	

}

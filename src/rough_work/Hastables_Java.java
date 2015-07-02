package rough_work;

import java.util.Hashtable;

public class Hastables_Java {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hashtable<String,String> t = new Hashtable<String,String>();
		t.put("username", "obama");
		t.put("country", "USA");
		t.put("key", "value");
		
		System.out.println(t.get("country"));
		
		
	}

}

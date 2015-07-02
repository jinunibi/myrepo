package rough_work;

public class Car {
	
	String name;
	int number;
	static Car c;
	
	private Car(){
		System.out.println("Object created");
	}
	
	
	public static Car getInstance(){
		
		if(c==null)
			c= new Car();
		
		
		return c;
		
		
		
	}

}

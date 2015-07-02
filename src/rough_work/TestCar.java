package rough_work;

public class TestCar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//Car c1 = new Car();
		//Car c2 = new Car();
		//Car c3 = new Car();
		
		Car c1 = Car.getInstance();
		Car c2 = Car.getInstance();
		Car c3 = Car.getInstance();
		
		
		c1.name="Audi";
		System.out.println(c2.name);
		
	}

}

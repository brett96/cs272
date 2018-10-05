package edu.orangecoastcollege.cs272.ic04.vehicle;

public class VehicleDemo {

	public static void main(String[] args) {
		
		// Surround with single try/catch block.
		try{
		Vehicle car = new Vehicle("Sedan", 4);
		System.out.println(car);
		
		Vehicle bustedCar = new Vehicle("Junkyard", 3);
		System.out.println(bustedCar);
		}
		catch (IllegalNumberOfWheelsException e)
		{
			System.out.println(e.getMessage());
			// Print the chain of events (with line numbers)
			// that generated the exception
			e.printStackTrace();
		}

	}

}

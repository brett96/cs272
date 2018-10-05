package edu.orangecoastcollege.cs272.btomita.p01;

import java.util.*;

/**
 * Creates inventory of MotorVehicles and keeps track of fastest vehicle
 * @author Brett Tomita
 *
 */
public class MotorVehicleDemo 
{
	/**
	 * Takes in inventory list of vehicles and returns fastest vehicle
	 * @param inventory inventory of vehicles
	 * @return fastest vehicle
	 */
	public static MotorVehicle findFastestMotorVehicle(ArrayList<MotorVehicle> inventory)
	{
		MotorVehicle fastest = null;
		double topSpeed = 0;
		for(MotorVehicle vehicle : inventory)
		{
			if(vehicle.getSpeed() >= topSpeed)
			{
				fastest = vehicle;
				topSpeed = vehicle.getSpeed();
			}
		}
		return fastest;
	}
	
	/**
	 * Starts process of adding vehicles to inventory, and returns fastest vehicle in the end
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<MotorVehicle> vehicles = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		boolean done = false;
		while(!done)
		{
			System.out.println("What would you like to add to the inventory?:\n1. Enter a new Motorcycle\n2. Enter a new Car\n"
					+ "3. Enter a new Truck\n4. Exit");
			int action = input.nextInt();
			if(action == 1)
			{
				System.out.print("What is the make of the motorcycle? ");
				String mMake = input.next();
				System.out.print("\nWhat is the speed of the motorcycle? ");
				double mSpeed = input.nextDouble();
				System.out.print("\nWhat is the motorcycle's VIN? ");
				String mVIN = input.next();
				System.out.print("\nWhat is the year of the motorcycle? ");
				int mYear = input.nextInt();
				System.out.print("\nWhat is the motorcycle's wheelbase? ");
				double mWheelbase = input.nextDouble();
				
				Motorcycle motorcycle = new Motorcycle(mMake, mSpeed, mVIN, mYear, mWheelbase);
				vehicles.add(motorcycle);
			}
			
			else if(action == 2)
			{
				System.out.print("What is the make of the car? ");
				String mMake = input.next();
				System.out.print("\nWhat is the speed of the car? ");
				double mSpeed = input.nextDouble();
				System.out.print("\nWhat is the car's VIN? ");
				String mVIN = input.next();
				System.out.print("\nWhat is the year of the car? ");
				int mYear = input.nextInt();
				System.out.print("\nHow many passengers can the car hold? ");
				int mPassengers = input.nextInt();
				
				Car car = new Car(mMake, mSpeed, mVIN, mYear, mPassengers);
				vehicles.add(car);
			}
			
			else if(action == 3)
			{
				System.out.print("What is the make of the truck? ");
				String mMake = input.next();
				System.out.print("\nWhat is the speed of the truck? ");
				double mSpeed = input.nextDouble();
				System.out.print("\nWhat is the truck's VIN? ");
				String mVIN = input.next();
				System.out.print("\nWhat is the year of the truck? ");
				int mYear = input.nextInt();
				System.out.print("\nWhat is the truck's payload? ");
				int mPayload = input.nextInt();
				
				Truck truck = new Truck(mMake, mSpeed, mVIN, mYear, mPayload);
				vehicles.add(truck);
			}
			
			else
			{
				for(MotorVehicle vehicle : vehicles)
				{
					System.out.println(vehicle);
				}
				System.out.println("\nThe fastest vehicle is: " + findFastestMotorVehicle(vehicles));
				done = true;
				input.close();
			}
		}
	}

}

package edu.orangecoastcollege.cs272.ic04.vehicle;

/**
 * Vehicle
 * 
 * @author Cay Horstmann (Big Java)
 * @version Jan 23, 2014, 3:02:40 PM
 * 
 * Describes a vehicle with a self-contained propulsion unit.
 */
public class Vehicle
{
    private String mType;
    private int mWheelCount;

    /**
     * Constructs a vehicle
     * 
     * @param aType the type of the vehicle
     * @param numWheels the number of wheels on this vehicle
     */
    											// throws == passes on
    public Vehicle(String aType, int numWheels) throws IllegalNumberOfWheelsException
    {
        if (aType.equals("motorcycle"))
        {
            if (numWheels != 2){
            	// Here's where the exception was born (generated)
                throw new IllegalNumberOfWheelsException("Motorcycles need two wheels");
            }
        }
        else if (numWheels < 4)
        {
            throw new IllegalNumberOfWheelsException();
        }
        mType = aType;
        mWheelCount = numWheels;
    }

    /**
     * Represents a vehicle as a string
     */
    public String toString()
    {
        return "Vehicle[type=" + mType + ", wheelCount=" + mWheelCount + "]";
    }

}
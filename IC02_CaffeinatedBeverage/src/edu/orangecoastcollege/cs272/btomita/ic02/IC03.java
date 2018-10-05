package edu.orangecoastcollege.cs272.btomita.ic02;

import java.text.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
//JavaDoc = comments in Java code that can be converted into HTML documentation for your API (Application Programming Interface)
// Think of API as a collection of variables and methods that you can reuse
//JavaDoc anything PUBLIC or PROTECTED

/**
 * 1-2 sentence description about the purpose of the class
 * A <code>CaffeinatedBeverage</code> represents a beverage with caffeine, including info about the beverage name, size in ounces, and price.
 * @author Brett Tomita
 * @version 1.0
 *
 */
public abstract class CaffeinatedBeverage
{
    //Define fields (data for each object)
    //protected (access modifier) that allows access in this class within the same package AND to all sub classes
    // m prefix = member variable (used in Android)
    //To refactor (rename all instances): Alt + Shift + r
    
    /**
     * Represents the name of the beverage
     */
    protected String mName;
    protected int id;
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    protected int mOunces;
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mName == null) ? 0 : mName.hashCode());
        result = prime * result + id;
        long temp;
        temp = Double.doubleToLongBits(mPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
    private static final DateFormat dtf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
    
    
    public void getTimeData()
    {
    	Date current = new Date();
    	System.out.println(dtf.format(current));
    	
    	Date dateForDerek = new Date();
    	boolean foreverAlone = false;
    	int love;
    	love++;
    }

    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        String other = (String) obj;

        if (mName == null)
        {
            if (other.length() != mName.length()) return false;
        }

        if (Double.doubleToLongBits(mPrice) != Double.doubleToLongBits(other.length())) return false;
        return true;
    }
    
    /**
     * Describes the price of the drink
     */
    protected double mPrice;
    
    /**
     * Retrieves the name of the drink
     * @return name of drink
     */
    public String getName()
    {
        return mName;
    }
    
    /**
     * Sets the name of the beverage
     * @param mName The name of the beverage
     */
    public void setName(String mName)
    {
        this.mName = mName;
    }
    
    /**
     * Gets the size of the beverage
     * @return The size of the beverage
     */
    public int getOunces()
    {
        return mOunces;
    }
    
    /**
     * Sets the ounces of the drink
     * @param mOunces  How many ounces the drink is
     */
    public void setOunces(int mOunces)
    {
        this.mOunces = mOunces;
    }
    
    /**
     * Retrieves the price of the drink
     * @return Drink price
     */
    public double getPrice()
    {
        return mPrice;
    }
    
    /**
     * Sets the price of the drink
     * @param mPrice
     */
    public void setPrice(double mPrice)
    {
        this.mPrice = mPrice;
    }
    
    //To generate code in Eclipse: right-click, choose Source ->
}

package edu.orangecoastcollege.cs272.btomita.ic02;

/**
 * Class for Coffee object of type CaffeinatedBeverage
 * @author btomita
 *
 */
public class Coffee extends CaffeinatedBeverage
{
	/**
	 * Describes the roast type of the coffee
	 */
    public int mRoastType;
    
    /**
     * Retrieves the roast type of the coffee
     * @return roast type of coffee
     */
    public int getRoastType()
    {
        return mRoastType;
    }

    /**
     * Sets the roast type of the coffee
     * @param roastType roast type of coffee
     */
    public void setRoastType(int roastType)
    {
        this.mRoastType = roastType;
    }
    
    /**
     * Default constructor for the Coffee object
     * @param mName  Name of coffee
     * @param mOunces  How many ounces in drink
     * @param mPrice  Price of drink
     * @param mRoastType  Roast type of drink
     */
    public Coffee(String mName, int mOunces, double mPrice, int mRoastType)
    {
        this.mName = mName;
        this.mOunces = mOunces;
        this.mPrice = mPrice;
        this.mRoastType = mRoastType;
    }

    /**
     * Overridden hashCode method
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + mRoastType;
        return result;
    }

    /**
     * Overridden equals method for Coffee object
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Coffee other = (Coffee) obj;
        if (mRoastType != other.mRoastType) return false;
        return true;
    }

    /**
     * Overridden toString method to display Coffee information as a string
     */
    @Override
    public String toString()
    {
        String mRoast;
        if(mRoastType == 1)
            mRoast = "light roast";
        else if(mRoastType == 2)
            mRoast = "medium roast";
        else
            mRoast = "dark roast";
        
        return String.format("[Coffee: %s, %s ounces, %s, $%1.2f]", mName,  mOunces, mRoast, mPrice);
    }
    
}

package edu.orangecoastcollege.cs272.btomita.ic02;

/**
 * Class for the EnergyDrink object of type CaffeinatedBeverage
 * @author btomita
 *
 */
public class EnergyDrink extends CaffeinatedBeverage
{
	/**
	 * Describes flavor of energy drink
	 */
    public String mFlavor;

    /**
     * @return  Flavor of energy drink
     */
    public String getFlavor()
    {
        return mFlavor;
    }
    
    /**
     * Sets the flavor of the energy drink
     * @param flavor  Flavor of energy drink
     */
    public void setFlavor(String flavor)
    {
        this.mFlavor = flavor;
    }
    
    /**
     * Default constructor for EnergyDrink
     * @param mName  Name of energy drink
     * @param mOunces  Ounces of energy drink
     * @param mPrice  Price of energy drink
     * @param mFlavor  Flavor of energy drink
     */
    public EnergyDrink(String mName, int mOunces, double mPrice, String mFlavor)
    {
        this.mName = mName;
        this.mOunces = mOunces;
        this.mPrice = mPrice;
        this.mFlavor = mFlavor;
    }
    
    /**
     * Overridden method for hash code
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((mFlavor == null) ? 0 : mFlavor.hashCode());
        return result;
    }

    /**
     * Overridden equals method
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        EnergyDrink other = (EnergyDrink) obj;
        if (mFlavor == null)
        {
            if (other.mFlavor != null) return false;
        }
        else if (!mFlavor.equals(other.mFlavor)) return false;
        return true;
    }

    /**
     * Overridden toString method to display energy drink information as a string
     */
    @Override
    public String toString()
    {
        return String.format("[Energy Drink: %s, %s ounces, %s, $%1.2f]", mName,  mOunces, mFlavor, mPrice);
    }
    
}

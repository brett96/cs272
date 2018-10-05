package edu.orangecoastcollege.cs272.midterm;

public abstract class TakeOutFood implements NutritionalInfo
{
    protected boolean mDelivery;
    protected double mPrice;
    protected String mRestaurant;
    protected int mTotalCalories;
    
    public boolean isDelivery()
    {
        return mDelivery;
    }
    
    public void setDelivery(boolean mDelivery)
    {
        this.mDelivery = mDelivery;
    }
    
    public double getPrice()
    {
        return mPrice;
    }
    
    public void setPrice(double mPrice)
    {
        this.mPrice = mPrice;
    }
    
    public String getRestaurant()
    {
        return mRestaurant;
    }
    
    public void setRestaurant(String mRestaurant)
    {
        this.mRestaurant = mRestaurant;
    }
    
    public int getTotalCalories()
    {
        return mTotalCalories;
    }
    
    public void setTotalCalories(int mTotalCalories)
    {
        this.mTotalCalories = mTotalCalories;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (mDelivery ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(mPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((mRestaurant == null) ? 0 : mRestaurant.hashCode());
        result = prime * result + mTotalCalories;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TakeOutFood other = (TakeOutFood) obj;
        if (mDelivery != other.mDelivery) return false;
        if (Double.doubleToLongBits(mPrice) != Double.doubleToLongBits(other.mPrice)) return false;
        if (mRestaurant == null)
        {
            if (other.mRestaurant != null) return false;
        }
        else if (!mRestaurant.equals(other.mRestaurant)) return false;
        if (mTotalCalories != other.mTotalCalories) return false;
        return true;
    }
    
    protected TakeOutFood(String restaurant, double price, int totalCalories, boolean delivery)
    {
        mDelivery = delivery;
        mPrice = price;
        mRestaurant = restaurant;
        mTotalCalories = totalCalories;
    }
    
    
}

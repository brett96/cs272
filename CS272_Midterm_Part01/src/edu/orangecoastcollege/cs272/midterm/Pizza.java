package edu.orangecoastcollege.cs272.midterm;

import java.text.NumberFormat;

public class Pizza extends TakeOutFood implements NutritionalInfo
{
    private int mSlices;
    
    protected Pizza(String restaurant, int slices, double price, int totalCalories, boolean delivery)
    {
        super(restaurant, price, totalCalories, delivery);
        setSlices(slices);
    }
    
    

    public int getSlices()
    {
        return mSlices;
    }



    public void setSlices(int mSlices)
    {
        this.mSlices = mSlices;
    }



    @Override
    public int caloriesPerServing()
    {
        return this.getTotalCalories() / mSlices;
    }

    @Override
    public boolean isLowCarb()
    {
        return false;
    }

    @Override
    public boolean isLowFat()
    {
        return false;
    }
    
    @Override
    public String toString()
    {
        NumberFormat price = NumberFormat.getCurrencyInstance();
        String prices = price.format(getPrice());
        
        String doesDeliver = isDelivery() ? "Yes" : "No";
        String lowCarb = isLowCarb() ? "Yes" : "No";
        String lowFat = isLowFat() ? "Yes" : "No";
        
        return ("Pizza [Restaurant=" + getRestaurant() + ", Slices=" + getSlices() + ", Price =" + prices + ", Total Calories=" + getTotalCalories()
                + ", Calories Per Serving=" + caloriesPerServing() + ", Delivery=" + doesDeliver + ", Low Carbs=" + lowCarb + ", Low Fat=" + lowFat);
    }

}

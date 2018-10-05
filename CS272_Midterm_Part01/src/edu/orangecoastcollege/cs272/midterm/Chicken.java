package edu.orangecoastcollege.cs272.midterm;

import java.text.NumberFormat;

public class Chicken extends TakeOutFood implements NutritionalInfo
{
    private int mStrips;
    
    protected Chicken(String restaurant, int strips, double price, int totalCalories, boolean delivery)
    {
        super(restaurant, price, totalCalories, delivery);
        this.mStrips = strips;
    }

    
    public int getStrips()
    {
        return mStrips;
    }


    public void setStrips(int mStrips)
    {
        this.mStrips = mStrips;
    }


    @Override
    public int caloriesPerServing()
    {
        return getTotalCalories() / getStrips();
    }

    @Override
    public boolean isLowCarb()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isLowFat()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString()
    {
        NumberFormat price = NumberFormat.getCurrencyInstance();
        price.format(getPrice());
        
        String doesDeliver = isDelivery() ? "Yes" : "No";
        String lowCarb = isLowCarb() ? "Yes" : "No";
        String lowFat = isLowFat() ? "Yes" : "No";
        
        return ("Chicken [Restaurant=" + getRestaurant() + ", Strips=" + getStrips() + ", Price =" + price + ", Total Calories=" + getTotalCalories()
                + ", Calories Per Serving=" + caloriesPerServing() + ", Delivery=" + doesDeliver + ", Low Carbs=" + lowCarb + ", Low Fat=" + lowFat);
    }

}

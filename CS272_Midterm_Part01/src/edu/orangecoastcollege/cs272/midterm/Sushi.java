package edu.orangecoastcollege.cs272.midterm;

import java.text.NumberFormat;

public class Sushi extends TakeOutFood implements NutritionalInfo
{
    private int mPieces;
    
    protected Sushi(String restaurant, int pieces, double price, int totalCalories, boolean delivery)
    {
        super(restaurant, price, totalCalories, delivery);
        this.mPieces = mPieces;
    }

    
    public int getPieces()
    {
        return mPieces;
    }


    public void setPieces(int mPieces)
    {
        this.mPieces = mPieces;
    }


    @Override
    public int caloriesPerServing()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isLowCarb()
    {
        // TODO Auto-generated method stub
        return false;
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
        
        return ("Sushi [Restaurant=" + getRestaurant() + ", Pieces=" + getPieces() + ", Price =" + price + ", Total Calories=" + getTotalCalories()
                + ", Calories Per Serving=" + caloriesPerServing() + ", Delivery=" + doesDeliver + ", Low Carbs=" + lowCarb + ", Low Fat=" + lowFat);
    }
    
}

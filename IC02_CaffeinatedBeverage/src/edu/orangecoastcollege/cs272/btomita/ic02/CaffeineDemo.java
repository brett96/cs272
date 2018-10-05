package edu.orangecoastcollege.cs272.btomita.ic02;
import java.util.*;

/**
 * CaffieneDemo takes in information about coffee and energy drinks and stores them in an ArrayList of type CaffeinatedBeverage
 * @author btomita
 *
 */
public class CaffeineDemo
{
    /**
     * findHighestPricedEnergyDrink examines all of the energy drinks in the array and returns the most expensive energy drink
     * @param inventory = array of all caffeinated beverages
     * @return = highest priced energy drink
     */
    public static CaffeinatedBeverage findHighestPricedEnergyDrink(ArrayList<CaffeinatedBeverage> inventory)
    {
        double highestPrice = Double.MIN_VALUE;
        CaffeinatedBeverage highestEnergyDrink = null;
        for(CaffeinatedBeverage singleBev : inventory)
        {
            if(singleBev instanceof EnergyDrink)
            {
                if(singleBev.getPrice() > highestPrice)
                {
                    highestPrice = singleBev.getPrice();
                    highestEnergyDrink = singleBev;
                }
            }
        }
        return highestEnergyDrink;
    }
    
    /**
     * Starts process of collecting information on caffeinated beverages and adding them to the array
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        ArrayList<CaffeinatedBeverage> drinks = new ArrayList<CaffeinatedBeverage>();
        int action = 0;
        int ounces, roastType = 0;
        boolean actionDone = false;
        double price = 0.00;
        
        while(!actionDone)
        {
        	Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do?\n1.  Add a new coffee\n2.  Add a new energy drink"
                    + "\n3.  Exit");
            action = input.nextInt();
//            if(action == 1 || action == 2 || action == 3)
//                actionDone = true;
            if(action == 1)
            {
                System.out.println("What is the name of the coffee? ");
                String name = "";
                input.nextLine();
                name = input.nextLine();
                System.out.println("How many ounces? ");
                ounces = input.nextInt();
                System.out.println("What is the price? ");
                price = input.nextDouble();
                System.out.println("What is the roast type? \n"
                        + "1.  Light Roast\n2.  Medium Roast\n3.  Dark Roast");
                roastType = input.nextInt();
                Coffee coffee = new Coffee(name, ounces, price, roastType);
                drinks.add(coffee);
                for (CaffeinatedBeverage drink : drinks)
                {
                    System.out.println(drink.toString());
                }
                //System.out.println(coffee.toString());
            }
            
            else if(action == 2)
            {
                System.out.println("What is the name of the energy drink? ");
                String name;
                input.nextLine();
                name = input.nextLine();
                System.out.println("How many ounces? ");
                ounces = input.nextInt();
                System.out.println("What is the price? ");
                price = input.nextDouble();
                System.out.println("What is the flavor? ");
                String flavor;
                input.nextLine();
                flavor = input.nextLine();
                EnergyDrink energy = new EnergyDrink(name, ounces, price, flavor);
                drinks.add(energy);
                //System.out.println(energy.toString());
                for (CaffeinatedBeverage drink : drinks)
                {
                    System.out.println(drink.toString());
                }
                System.out.println("Most Expensive Energy Drink: " + findHighestPricedEnergyDrink(drinks));
            }
            else
            {
                System.out.println("Stay Alert!");
                actionDone = true;
                input.close();
            }  
        }
    }
}

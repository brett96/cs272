package edu.orangecoastcollege.cs272.midterm;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TakeOutDemo {

	public static void main(String[] args) 
	{
	    List<TakeOutFood> food = new ArrayList<>();
		Pizza pieology = new Pizza("Pielogy", 4, 10.72, 990, false);
		Pizza dominos = new Pizza("Dominos", 8, 9.99, 1450, true);

		Chicken canes = new Chicken("Raising Cane's", 6, 6.38, 1200, true);
		Chicken elPollo = new Chicken("El Pollo Loco", 4, 4.99, 1000, false);

		Sushi kaisen = new Sushi("Kaisen Sushi", 4, 10.95, 325, false);
		Sushi orange = new Sushi("Orange Sushi", 4, 9.95, 450, true);
		
		food.add(pieology);
		food.add(dominos);
		food.add(canes);
		food.add(elPollo);
		food.add(kaisen);
		food.add(orange);
		
		Scanner input = new Scanner(System.in);
		boolean done = false;
		while(!done)
		{
		    System.out.println("What would you like to order?\n1. Pizza\n2. Chicken\n3.Sushi\n4. Exit");
		    int choice = input.nextInt();
		    
		    //switch(choice)
		    if(choice == 1)
		    {
		        System.out.println("What is the name of the restaurant? ");
		        String restaurant = input.next();
		        System.out.println("How many slices? ");
		        int slices = input.nextInt();
		        System.out.println("What is the price? ");
		        double price = input.nextDouble();
		        System.out.println("How many calories?");
		        int calories = input.nextInt();
		        System.out.println("Does " + restaurant + " deliver? (Y)es/(N)o");
		        String delivery = input.next();
		        char deliver = delivery.toLowerCase().charAt(0);
		        boolean doesDeliver = deliver == 'y' ? true : false;
		        Pizza pizza = new Pizza(restaurant, slices, price, calories, doesDeliver);
		        food.add(pizza);
		    }
		    
		    else if(choice == 2)
		    {
		        System.out.println("What is the name of the restaurant? ");
                String restaurant = input.next();
                System.out.println("How many strips? ");
                int strips = input.nextInt();
                System.out.println("What is the price? ");
                double price = input.nextDouble();
                System.out.println("How many calories?");
                int calories = input.nextInt();
                System.out.println("Does " + restaurant + " deliver? (Y)es/(N)o");
                String delivery = input.next();
                char deliver = delivery.toLowerCase().charAt(0);
                boolean doesDeliver = deliver == 'y' ? true : false;
                Chicken chicken = new Chicken(restaurant, strips, price, calories, doesDeliver);
                food.add(chicken);
		    }
		    
		    else if(choice == 3)
		    {
		        System.out.println("What is the name of the restaurant? ");
                String restaurant = input.next();
                System.out.println("How many pieces? ");
                int pieces = input.nextInt();
                System.out.println("What is the price? ");
                double price = input.nextDouble();
                System.out.println("How many calories?");
                int calories = input.nextInt();
                System.out.println("Does " + restaurant + " deliver? (Y)es/(N)o");
                String delivery = input.next();
                char deliver = delivery.toLowerCase().charAt(0);
                boolean doesDeliver = deliver == 'y' ? true : false;
                Sushi sushi = new Sushi(restaurant, pieces, price, calories, doesDeliver);
                food.add(sushi);
		    }
		    
		    else
		    {
		        done = true;
		        System.out.println("~~~~~~~~~All Takeout Foods~~~~~~~~~");
		        for(TakeOutFood item : food)
		        {
		            System.out.println(item);
		        }
		        
		        List<TakeOutFood> lessThan10 = food.stream()
		                .filter(f -> f.getPrice() < 10.00)
		                .collect(Collectors.toList());
		        System.out.println("~~~~~~~~~Takeout Food Less than $10~~~~~~~~~");
		        lessThan10.forEach(System.out :: println);
		        
		        System.out.println("~~~~~~~~~Low Carb Takeout Food~~~~~~~~~");
		        List<TakeOutFood> lowCarbList = food.stream()
		                .filter(i -> i.isLowCarb())
		                .collect(Collectors.toList());
		        lowCarbList.forEach(System.out :: println);
		        
		        System.out.println("~~~~~~~~~Low Fat Takeout Food~~~~~~~~~");
		        List<TakeOutFood> lowFatList = food.stream()
                        .filter(i -> i.isLowFat())
                        .collect(Collectors.toList());
                lowCarbList.forEach(System.out :: println);
		    }  
		}
//		public static Predicate<TakeOutFood>foodsLessThan(double price)
//		{
//		    List<TakeOutFood> lessThan10 = food.stream()
//                    .filter(f -> f.getPrice() < 10.00)
//                    .collect(Collectors.toList());
//		}
	}

}

package edu.orangecoastcollege.cs272.btomita.ic01;
import java.util.ArrayList;

/**
 * Abstract inheritance creates three Shape2D objects and prints their shape and area
 * @author Brett Tomita
 *
 */
public class AbstractInheritance
{
	/**
	 * Creates a rectangle, triangle, and parallelogram with specific dimensions, and prints their shape and area
	 * @param args
	 */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
    	ArrayList<Shape2D> shapes = new ArrayList<Shape2D>();
    	Rectangle rectangle = new Rectangle();
    	rectangle.setWidth(5);
    	rectangle.setHeight(4);
    	//rectangle.toString(rectangle.getBase(), rectangle.getHeight());
    	shapes.add(rectangle);
    	Triangle triangle = new Triangle(0, 0, "blue", 5, 5);
    	//triangle.toString(triangle.getBase(), triangle.getHeight());
    	shapes.add(triangle);
    	Parallelogram parallelogram = new Parallelogram(0, 0, "blue", 20, 10);
    	//parallelogram.toString(parallelogram.getBase(), parallelogram.getHeight());
    	shapes.add(parallelogram);
    	
    	for(int i = 0; i < shapes.size(); i++)
    	{
    		shapes.get(i).toString(shapes.get(i).getBase(), shapes.get(i).getHeight());
    	}
    }

}

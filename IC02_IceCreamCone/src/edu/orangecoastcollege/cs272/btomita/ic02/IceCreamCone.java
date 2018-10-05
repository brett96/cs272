package edu.orangecoastcollege.cs272.btomita.ic02;

/**
 * IceCreamCone creates an IceCreamCone object and calculates its volume and surface area
 * @author Brett Tomita
 *
 */
public class IceCreamCone 
{
	/**
	 * Represents height of cone
	 */
	protected double height;
	
	/**
	 * Represents radius of cone
	 */
	protected double radius;
	
	/**
	 * Calculates the surface area of the cone
	 * @param radius  Radius of cone
	 * @param height  Height of cone
	 * @return  Surface Area of cone
	 */
	public double getSurfaceArea(double radius, double height)
	{
		return Math.PI*radius*height;
	}
	
	/**
	 * Calculates the volume of the cone
	 * @param radius  Radius of cone
	 * @param height  Height of cone
	 * @return  Volume of cone
	 */
	public double getVolume(double radius, double height)
	{
		return ((Math.PI*Math.pow(radius, 2)*height)/3);
	}
	
	/**
	 * Returns the radius of the cone
	 * @return  Radius of cone
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Returns the height of the cone
	 * @return  Height of cone
	 */
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * Default constructor for IceCreamCone
	 * @param radius  Radius of cone
	 * @param height  Height of cone
	 */
	public IceCreamCone(double radius, double height)
	{
		this.radius = radius;
		this.height = height;
	}
	
	/**
	 * Creates a new IceCreamCone object and prints its volume and surface area
	 * @param args
	 */
	public static void main(String[] args)
	{
		IceCreamCone cone = new IceCreamCone(1.5, 3.25);
		System.out.printf("The Surface Area of this Ice Cream Cone is %.2f, and the volume is %.2f"
				,cone.getSurfaceArea(cone.getRadius(), cone.getHeight()), cone.getVolume(cone.getRadius(), cone.getHeight()));
		
	}
}

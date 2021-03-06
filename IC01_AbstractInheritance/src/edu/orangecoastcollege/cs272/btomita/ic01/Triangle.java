package edu.orangecoastcollege.cs272.btomita.ic01;

public class Triangle extends Shape2D
{
	public int base;
	public int height;
	
	public void setBase(int value)
	{
		base = value;
	}
	
	public void setHeight(int value)
	{
		height = value;
	}
	
	public int getBase()
	{
		return base;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Triangle(int xVal, int yVal, String c, int b, int h)
	{
		x = xVal;
		y = yVal;
		color = c;
		base = b;
		height = h;
	}
	
	public double calculateArea() 
	{
		return 0.5*base*height;
	}
	
	public boolean equals(int xVal, int yVal, String c, int b, int h)
	{
		if(x == xVal && y == yVal && color == c && base == b && height == h)
		{
			return true;
		}
		return false;
	}
	public void toString(int base, int height)
	{
		for(int i = 1; i <= height; i++)
		{
			int x = i;
			while(x > 0)
			{
				System.out.print('*');
				x--;
			}
			
			System.out.println();
		}
		System.out.println("The area of this triangle is " + calculateArea() + " square units\n");
	}
	
}

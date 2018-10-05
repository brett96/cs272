package edu.orangecoastcollege.cs272.btomita.ic01;

public class Rectangle extends Shape2D
{
	int width;
    int height;
    
    public Rectangle()
    {
    	x = 0;
    	y = 0;
    	color = "";
    	width = 0;
    	height = 0;
    }
    public void setWidth(int value)
    {
        width = value;
    }
    
    public int getBase()
    {
    	return width;
    }
    
    public void setHeight(int value)
    {
    	height = value;
    }
    
    
    public int getHeight()
    {
    	return height;
    }
    public Rectangle(int xVal, int yVal, String c, int w, int h)
    {
        x = xVal;
        y = yVal;
        color = c;
        width = w;
        height = h;
    }
    
    public double calculateArea()
    {
        return width*height;
    }
    
    public boolean equals(int xVal, int yVal, int w, int h)
    {
    	if(x == xVal && y == yVal && width == w && height == h)
    	{
    		return true;
    	}
    	return false;
    }
    
    public void toString(int width, int height)
    {
    	for(int i = 0; i < height; i++)
    	{
	    	for(int j = 0; j < width; j++)
	    	{
	    		System.out.print('*');
	    	}
	    	System.out.println();
    	}
    	System.out.println("The area of this rectangle is " + calculateArea() + " square units.\n");
    }
    
}

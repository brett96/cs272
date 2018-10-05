package edu.orangecoastcollege.cs272.btomita.ic01;

/**
 * Shape2D is an abstract parent class for rectangle, triangle, and parallelogram
 * @author Brett Tomita
 *
 */
public abstract class Shape2D 
{
	public int x;
    public int y;
    public String color;
    
    /**
     * Returns the value of x
     * @return
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Returns the value of y
     * @return
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Returns the color of the shape
     * @return
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Sets value of x
     * @param value
     */
    public void setX(int value)
    {
        x = value;
    }
    
    /**
     * Sets the value of y
     * @param value
     */
    public void setY(int value)
    {
        y = value;
    }
    
    /**
     * Sets the color of the shape
     * @param value
     */
    public void setColor(String value)
    {
        color = value;
    }
    abstract double calculateArea();
    
    abstract void toString(int base, int height);
    
    abstract int getBase();
    
    abstract int getHeight();
}

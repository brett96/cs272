package edu.orangecoastcollege.cs272.btomita.p01;

import java.util.Arrays;

public class Sequence 
{
    @Override
    public String toString()
    {
        String result = "{";
        if (mArray.length > 0)
        {
            result += mArray[0];
            for (int i = 1; i < mArray.length; i++)
            {
                result += ", " + mArray[i];
            }
        }
        return result + "}";
    }
	
	private int[] mArray;
    
    /**
     * Constructs a sequence of integers.
     * @param array the array to initialize the sequence.
     */
    public Sequence(int[] array)
    {
        mArray = array.clone();
    }
    
    // TODO: Write the three versions of slice() here
    public String slice(int start)
    {
    	if(start < 0)
    	{
    		int[] result = new int[Math.abs(start)];
    		int i = 0;
    		while(start < 0)
    		{
    			result[i] = mArray[mArray.length + start];
    			i++;
    			start++;
    		}
    		//return result.toString();
    		return Arrays.toString(result);
    	}
    	else
    	{
    		int[] result = new int[mArray.length-start];
    		int i = 0;
    		while(start < mArray.length)
    		{
    			result[i] = mArray[start];
    			i++;
    			start++;
    		}
//    		return result.toString();
    		return Arrays.toString(result);
    	}
    }
    
    public String slice(int start, int end)
    {
    	if(start < 0)
    	{
    		int[] result = new int[end - start];
    		int i = 0;
    		while(start < end)
    		{
    			result[i] = mArray[start];
    			start++;
    			i++;
    		}
//    		return result.toString();
    		return Arrays.toString(result);
    	}
    	
    	else
    	{
    		int[] result = new int[end - start];
    		int i = 0;
    		while(end > start)
    		{
    			result[i] = mArray[start];
    			start++;
    			i++;
    		}
    		//return result.toString();
    		return Arrays.toString(result);
    	}
    }
    
    public String slice(int start, int end, int step)
    {
    	if(start < 0)
    	{
    		int[] result = new int[mArray.length];
    		int i = 0;
    		while(i < result.length)
    		{
    			result[i] = mArray[mArray.length + start];
    			start+=step;
    			i++;
    		}
    		//return result.toString();
    		return Arrays.toString(result);
    	}
    	
    	else
    	{
    		int[] result = new int[mArray.length];
    		int i = 0;
    		while (start < result.length)
    		{
    			result[i] = mArray[start];
    			start+=step;
    			i++;
    		}
    		//return result.toString();
    		return Arrays.toString(result);
    	}
    }
    

    
    public static void main(String[] args)
    {
        Sequence a = new Sequence(new int[]{1, 2, 3, 4, 5});
        // some informal testing
        System.out.println("a.slice(0)->" + a.slice(0));
        System.out.println("a.slice(1)->" + a.slice(1));
        System.out.println("a.slice(-1)->" + a.slice(-1));
        System.out.println("a.slice(-2)->" + a.slice(-2));
        System.out.println("a.slice(5)->" + a.slice(5));
        System.out.println("a.slice(-5)->" + a.slice(-5));
        System.out.println("a.slice(0, 5, 2)->" + a.slice(0, 5, 2));
        System.out.println("a.slice(0, 5)->" + a.slice(0, 5));
        System.out.println("a.slice(1, 5, 2)->" + a.slice(1, 5, 2));
        System.out.println("a.slice(1, 5, 3)->" + a.slice(1, 5, 3));
        System.out.println("a.slice(2, 5, 3)->" + a.slice(2, 5, 3));
        System.out.println("a.slice(-1, -6, -1)->" + a.slice(-1, -6, -1));
        System.out.println("a.slice(-1, -6)->" + a.slice(-1, -6));
    }
}

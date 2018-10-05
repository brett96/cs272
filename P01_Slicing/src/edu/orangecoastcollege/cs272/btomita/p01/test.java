package edu.orangecoastcollege.cs272.btomita.p01;

public class test 
{
	public static int[] copyArray(int[] a)
	{
		int[] result = new int[a.length];
		for(int i = 0; i < a.length; i++)
		{
			result[i] = a[i];
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(copyArray(nums));
		
	}

}

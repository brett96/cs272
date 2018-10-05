package edu.orangecoastcollege.cs272.btomita.ic07;

public class HoorayList <E>
{
	private int mCapacity;
	private int mSize;	
	private E[] mData;
	private static final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public HoorayList(int initialCapacity)
	{
		mCapacity = initialCapacity;
		mSize = 0;
		mData = (E[]) new Object[mCapacity];
	}
	
	public HoorayList()
	{
		this(DEFAULT_CAPACITY);	// Calls parameterized constructor
	}
	
	public E get(int index)
	{	
		if(index < 0 || index > mSize) throw new IndexOutOfBoundsException();
		else return mData[index];
	}
	
	public E set(int index, E element)
	{
		if(index < 0 || index >= mSize) throw new IndexOutOfBoundsException();
		else
		{
			for(int i = index; i < mCapacity - 1; i++)
			{
				mData[i+1] = mData[i];
			}
			mData[index] = element;
			return mData[index+1];
		}
	}
	
	public boolean add(E element)
	{
		return add(mSize, element);
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(int index, E element)
	{
		if(index < 0 || index > mSize) throw new IndexOutOfBoundsException();
		if(mSize >= mCapacity) 
		{
			// Make an array double the capacity
			mCapacity *= 2;
			E[] temp = (E[]) new Object[mCapacity];
			// Use for loop to copy old data into new array (temp)
			for(int i = 0; i < mSize; i++)
			{
				temp[i] = mData[i];
			}
			// Now update mData to be new array (temp)
			mData = temp;
		}
		
		// Add new element to array; shift rest down by 1
		for(int i = mSize; i > index; i--)
		{
			mData[i] = mData[i-1];
		}
		mData[index] = element;
		mSize++;
		return true;
	}
	
	public E remove(int index)
	{
		if(index < 0 || index > mSize) throw new IndexOutOfBoundsException();
		mData[index] = null;
		E result = mData[index];
		for(int i = index; i < mSize-1; i++)
		{
			mData[i] = mData[i+1];
		}
		mSize--;
		return result;
	}
	
	public boolean remove(Object o)
	{
		int index = 0;
		for(Object obj : mData)
		{
			if(obj.equals(o)) 
			{
				remove(index);
				return true;
			}
			index++;
		}
		mSize--;
		return false;
	}
	
	public void clear()
	{
		for(E item : mData)
		{
			item = null;
		}
		mSize = 0;
	}
	
	@Override
	public String toString()
	{
		String result = "[";
		for(int i = 0; i < mSize; i++)
		{
			result += mData[i] + ", ";
		}
		result += "Horray!]";
		
		return result;
	}
}

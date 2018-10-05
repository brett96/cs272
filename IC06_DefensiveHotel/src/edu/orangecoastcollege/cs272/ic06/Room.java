package edu.orangecoastcollege.cs272.ic06;

public class Room 
{
	private int mNumber;
	private int mCapacity;
	private RoomType mRoomType;
	
	public int getNumber() 
	{
		return mNumber;
	}
	public int getCapacity() 
	{
		return mCapacity;
	}
	public RoomType getRoomType() 
	{
		return mRoomType;
	}
	
	public Room(int mNumber, int i, RoomType mRoomType)
	{
		this.mNumber = mNumber;
		this.mCapacity = i;
		this.mRoomType = mRoomType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCapacity;
		result = prime * result + mNumber;
		result = prime * result + ((mRoomType == null) ? 0 : mRoomType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (mCapacity != other.mCapacity)
			return false;
		if (mNumber != other.mNumber)
			return false;
		if (mRoomType != other.mRoomType)
			return false;
		return true;
	}
	
	
}
	

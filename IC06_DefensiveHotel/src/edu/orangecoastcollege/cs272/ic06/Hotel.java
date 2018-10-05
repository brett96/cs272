package edu.orangecoastcollege.cs272.ic06;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hotel
{
	private String mName;
	private List<Room> mAllRoomsList;
	private List<Room> mAvailableRoomsList;
	private List<Room> mOccupiedRoomsList;
	
	public Hotel(String name, List<Room> allRoomsList)
	{
		super();
		mName = name;
		// MAKE DEFENSIVE COPIES OF ALL LISTS!!!
		mAllRoomsList = new ArrayList<Room>(allRoomsList);
		mOccupiedRoomsList = new ArrayList<Room>();
		mAvailableRoomsList = new ArrayList<Room>(allRoomsList);
		// Everytime return a list, make defensive copy
		
//		mAllRoomsList = allRoomsList;
//		mOccupiedRoomsList = new ArrayList<Room>();
//		mAvailableRoomsList = allRoomsList;
	}
	
	public String getName() 
	{
		return mName;
	}

	public boolean bookRoom(RoomType roomType)
	{
		//Get a list of all available rooms matching specific room type
		List<Room> availableRooms = getAvailableRoomsMatching(roomType);
		// If list is empty, can't book list & return false
		if(availableRooms.isEmpty()) return false;
		// Otherwise, we do have a room available
		Room roomToBook = availableRooms.get(0);
		// Add room to occupied list
		mOccupiedRoomsList.add(roomToBook);
		// Remove room from available list
		mAvailableRoomsList.remove(roomToBook);
		return true;
	}
	
	public List<Room> getAvailableRoomsMatching(RoomType roomType)
	{
		return filter(mAvailableRoomsList, matchType(roomType));
	}
	
	private Predicate<Room> matchType(RoomType roomType)
	{
		return r -> r.getRoomType() == roomType;
	}
	
	private List<Room>filter(List<Room> allRoomsList, Predicate<Room> predicate)
	{
		return allRoomsList.stream().filter(predicate).collect(Collectors.<Room> toList());
	}
	
	public List<Room> getAllRooms()
	{
		//MAKE DEFENSIVE COPY OF LISTS IN ALL GETTERS
		return new ArrayList<Room>(mAllRoomsList);
	}
	
	public List<Room> getAvailableRooms()
	{
		return new ArrayList<Room>(mAvailableRoomsList);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mAllRoomsList == null) ? 0 : mAllRoomsList.hashCode());
		result = prime * result + ((mAvailableRoomsList == null) ? 0 : mAvailableRoomsList.hashCode());
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mOccupiedRoomsList == null) ? 0 : mOccupiedRoomsList.hashCode());
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
		Hotel other = (Hotel) obj;
		if (mAllRoomsList == null) {
			if (other.mAllRoomsList != null)
				return false;
		} else if (!mAllRoomsList.equals(other.mAllRoomsList))
			return false;
		if (mAvailableRoomsList == null) {
			if (other.mAvailableRoomsList != null)
				return false;
		} else if (!mAvailableRoomsList.equals(other.mAvailableRoomsList))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mOccupiedRoomsList == null) {
			if (other.mOccupiedRoomsList != null)
				return false;
		} else if (!mOccupiedRoomsList.equals(other.mOccupiedRoomsList))
			return false;
		return true;
	}
	
	
	
}


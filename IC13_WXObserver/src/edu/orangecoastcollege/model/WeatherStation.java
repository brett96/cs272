package edu.orangecoastcollege.model;

public class WeatherStation {

	private String mStationId;
	private String mStationName;
	private String mState;
	private String mXMLURL;
		
	/**
	 * WeatherStation constructor
	 * @param stationId
	 * @param stationName
	 * @param state
	 * @param xMLURL
	 */
	public WeatherStation(String stationId, String stationName, String state, String xMLURL) {
		super();
		mStationId = stationId;
		mStationName = stationName;
		mState = state;
		mXMLURL = xMLURL;
	}
	
	/**
	 * Gets station ID
	 * @return
	 */
	public String getStationId() {
		return mStationId;
	}
	
	/**
	 * Sets station ID
	 * @param stationId
	 */
	public void setStationId(String stationId) {
		mStationId = stationId;
	}
	
	/**
	 * gets station name
	 * @return
	 */
	public String getStationName() {
		return mStationName;
	}
	
	/**
	 * Sets station name
	 * @param stationName
	 */
	public void setStationName(String stationName) {
		mStationName = stationName;
	}
	
	/**
	 * Returns state
	 * @return
	 */
	public String getState() {
		return mState;
	}
	
	/**
	 * Sets state
	 * @param state
	 */
	public void setState(String state) {
		mState = state;
	}
	
	/**
	 * Returns xml url
	 * @return
	 */
	public String getXMLURL() {
		return mXMLURL;
	}
	
	/**
	 * Sets xml url
	 * @param xMLURL
	 */
	public void setXMLURL(String xMLURL) {
		mXMLURL = xMLURL;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mState == null) ? 0 : mState.hashCode());
		result = prime * result + ((mStationId == null) ? 0 : mStationId.hashCode());
		result = prime * result + ((mStationName == null) ? 0 : mStationName.hashCode());
		result = prime * result + ((mXMLURL == null) ? 0 : mXMLURL.hashCode());
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
		WeatherStation other = (WeatherStation) obj;
		if (mState == null) {
			if (other.mState != null)
				return false;
		} else if (!mState.equals(other.mState))
			return false;
		if (mStationId == null) {
			if (other.mStationId != null)
				return false;
		} else if (!mStationId.equals(other.mStationId))
			return false;
		if (mStationName == null) {
			if (other.mStationName != null)
				return false;
		} else if (!mStationName.equals(other.mStationName))
			return false;
		if (mXMLURL == null) {
			if (other.mXMLURL != null)
				return false;
		} else if (!mXMLURL.equals(other.mXMLURL))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return mStationId + " - " + mStationName;
	}
	
	
	
}

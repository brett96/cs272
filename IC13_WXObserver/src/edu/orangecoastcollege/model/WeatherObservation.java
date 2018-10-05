package edu.orangecoastcollege.model;

public class WeatherObservation {

	private String mStationId;
	private String mLocation;
	private String mWeather; // Summary of weather
	private double mTemp;
	private double mDewpoint;
	private double mVisibility;
	private String mWind;
	
	public WeatherObservation(String stationId, String location, String weather, double temp, double dewpoint,
			double visibility, String wind) {
		super();
		mStationId = stationId;
		mLocation = location;
		mWeather = weather;
		mTemp = temp;
		mDewpoint = dewpoint;
		mVisibility = visibility;
		mWind = wind;
	}

	public String getStationId() {
		return mStationId;
	}

	public void setStationId(String stationId) {
		mStationId = stationId;
	}

	public String getLocation() {
		return mLocation;
	}

	public void setLocation(String location) {
		mLocation = location;
	}

	public String getWeather() {
		return mWeather;
	}

	public void setWeather(String weather) {
		mWeather = weather;
	}

	public double getTemp() {
		return mTemp;
	}

	public void setTemp(double temp) {
		mTemp = temp;
	}

	public double getDewpoint() {
		return mDewpoint;
	}

	public void setDewpoint(double dewpoint) {
		mDewpoint = dewpoint;
	}

	public double getVisibility() {
		return mVisibility;
	}

	public void setVisibility(double visibility) {
		mVisibility = visibility;
	}

	public String getWind() {
		return mWind;
	}

	public void setWind(String wind) {
		mWind = wind;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(mDewpoint);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mLocation == null) ? 0 : mLocation.hashCode());
		result = prime * result + ((mStationId == null) ? 0 : mStationId.hashCode());
		temp = Double.doubleToLongBits(mTemp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mVisibility);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mWeather == null) ? 0 : mWeather.hashCode());
		result = prime * result + ((mWind == null) ? 0 : mWind.hashCode());
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
		WeatherObservation other = (WeatherObservation) obj;
		if (Double.doubleToLongBits(mDewpoint) != Double.doubleToLongBits(other.mDewpoint))
			return false;
		if (mLocation == null) {
			if (other.mLocation != null)
				return false;
		} else if (!mLocation.equals(other.mLocation))
			return false;
		if (mStationId == null) {
			if (other.mStationId != null)
				return false;
		} else if (!mStationId.equals(other.mStationId))
			return false;
		if (Double.doubleToLongBits(mTemp) != Double.doubleToLongBits(other.mTemp))
			return false;
		if (Double.doubleToLongBits(mVisibility) != Double.doubleToLongBits(other.mVisibility))
			return false;
		if (mWeather == null) {
			if (other.mWeather != null)
				return false;
		} else if (!mWeather.equals(other.mWeather))
			return false;
		if (mWind == null) {
			if (other.mWind != null)
				return false;
		} else if (!mWind.equals(other.mWind))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Current Weather Observation for Station ");
		output.append(mStationId).append("\n");
		output.append("Location: ").append(mLocation).append("\n");
		output.append("Weather: ").append(mWeather).append("\n");
		output.append("Temp: ").append(mTemp).append(" Degrees F\n");
		output.append("Dewpoint: ").append(mDewpoint).append(" Degrees F\n");
		output.append("Visibility: ").append(mVisibility).append(" Miles\n");
		output.append("Wind: ").append(mWind).append("\n");
		return output.toString();
	}
	
	
}

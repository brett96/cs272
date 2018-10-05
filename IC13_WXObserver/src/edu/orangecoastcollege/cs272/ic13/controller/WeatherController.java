package edu.orangecoastcollege.cs272.ic13.controller;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import edu.orangecoastcollege.model.WeatherObservation;
import edu.orangecoastcollege.model.WeatherStation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeatherController {

	/**
	 * Gets the current weather observation using NOAA weather data
	 * from a given XML URL (weather station).
	 * @param xmlURL The URL to the XMl file containing weather data.
	 * @return The current weather observation.
	 */
	public WeatherObservation getCurrentWeather(String xmlURL) {
		WeatherObservation currentWeather = null;
	
		//TODO: Implement this method
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			// To connect to an XML source (3 ways):
	
			//File
			Document doc = builder.parse(xmlURL);
			XPathFactory xpFactory = XPathFactory.newInstance();
			XPath path = xpFactory.newXPath();
			
			/*
			 * 	private String mStationId;
				private String mLocation;
				private String mWeather; // Summary of weather
				private double mTemp;
				private double mDewpoint;
				private double mVisibility;
				private String mWind;
			 */
			String stationID = path.evaluate("current_observation/station_id", doc);
			String location = path.evaluate("current_observation/location", doc);
			String weather = path.evaluate("current_observation/weather", doc);
			Double temp = Double.parseDouble(path.evaluate("current_observation/temp_f", doc));
			Double dewpoint = Double.parseDouble(path.evaluate("current_observation/dewpoint_f", doc));
			Double visibility = Double.parseDouble(path.evaluate("current_observation/visibility_mi", doc));
			String wind = path.evaluate("current_observation/wind_string", doc);
			// Get all info needed
			
			// Create new WeatherObservation object
			currentWeather = new WeatherObservation(stationID, location, weather, temp, dewpoint, visibility, wind);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentWeather;
		
	}

	/**
	 * Gets a list of California weather stations as recognized by NOAA.
	 * @return A list of California weather stations.
	 */
	public ObservableList<WeatherStation> getCAWeatherStations() {
		ObservableList<WeatherStation> allWeatherStations = FXCollections.observableArrayList();
		
		//TODO: Implement this method
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			// To connect to an XML source (3 ways):
	
			//File
			Document doc = builder.parse(new File("weather_stations.xml"));
			XPathFactory xpFactory = XPathFactory.newInstance();
			XPath path = xpFactory.newXPath();
			
			// Get a count of the stations:
			int stationCount = Integer.parseInt(path.evaluate("count(wx_station_index/station)", doc));
			for(int i = 1; i <= stationCount; i++)
			{
				// Only create new WeatherStation objects if the station is based in California
				// First get the state:
				String state = path.evaluate("wx_station_index/station[" + i + "]/state", doc);
				if("CA".equalsIgnoreCase(state))
				{
					// Get the rest of information
					String stationID = path.evaluate("wx_station_index/station[" + i + "]/station_id", doc);
					String stationName = path.evaluate("wx_station_index/station[" + i + "]/station_name", doc);
					String xmlURL = path.evaluate("wx_station_index/station[" + i + "]/xml_url", doc);
					
					// Create new WeatherStation object
					WeatherStation ws = new WeatherStation(stationID, stationName, state, xmlURL);
					// Add to observable list
					allWeatherStations.add(ws);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allWeatherStations;
	}

}

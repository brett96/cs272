package edu.orangecoastcollege.cs272.ic14.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.ic14.model.DBModel;
import edu.orangecoastcollege.cs272.ic14.model.User;
import edu.orangecoastcollege.cs272.ic14.model.VideoGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

	private static Controller theOne;

	private static final String DB_NAME = "vg_inventory.db";
	
	private static final String USER_TABLE_NAME = "user";
	private static final String[] USER_FIELD_NAMES = { "id", "name", "email", "role", "password"};
	private static final String[] USER_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT"};

	private static final String VIDEO_GAME_TABLE_NAME = "video_game";
	private static final String[] VIDEO_GAME_FIELD_NAMES = { "id", "name", "platform", "year", "genre", "publisher"};
	private static final String[] VIDEO_GAME_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "TEXT"};
	private static final String VIDEO_GAME_DATA_FILE = "videogames_lite.csv";

	private static final String USER_GAMES_TABLE_NAME = "user_games";
	private static final String[] USER_GAMES_FIELD_NAMES = { "user_id", "game_id"};
	private static final String[] USER_GAMES_FIELD_TYPES = { "INTEGER", "INTEGER"};

	private User mCurrentUser;
	private DBModel mUserDB;
	private DBModel mVideoGameDB;
	private DBModel mUserGamesDB;
	
	private ObservableList<User> mAllUsersList;
	private ObservableList<VideoGame> mAllGamesList;
	
	private Controller() {
	}

	/**
	 * Creates instance of controller
	 * @return
	 */
	public static Controller getInstance() {
		if (theOne == null) {
			theOne = new Controller();
			theOne.mAllUsersList = FXCollections.observableArrayList();
			theOne.mAllGamesList = FXCollections.observableArrayList();

			try {
				theOne.mUserDB = new DBModel(DB_NAME, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);

				ResultSet rs = theOne.mUserDB.getAllRecords();
				while (rs.next()) {
					int id = rs.getInt(USER_FIELD_NAMES[0]);
					String name = rs.getString(USER_FIELD_NAMES[1]);
					String email = rs.getString(USER_FIELD_NAMES[2]);
					String role = rs.getString(USER_FIELD_NAMES[3]);
					theOne.mAllUsersList.add(new User(id, name, email, role));
				}
				
				theOne.mVideoGameDB = new DBModel(DB_NAME, VIDEO_GAME_TABLE_NAME, VIDEO_GAME_FIELD_NAMES, VIDEO_GAME_FIELD_TYPES);
				theOne.initializeVideoGameDBFromFile();
				rs = theOne.mVideoGameDB.getAllRecords();
				while (rs.next())
				{
					int id = rs.getInt(VIDEO_GAME_FIELD_NAMES[0]);
					String name = rs.getString(VIDEO_GAME_FIELD_NAMES[1]);
					String platform = rs.getString(VIDEO_GAME_FIELD_NAMES[2]);
					int year = rs.getInt(VIDEO_GAME_FIELD_NAMES[3]);
					String genre = rs.getString(VIDEO_GAME_FIELD_NAMES[4]);
					String publisher = rs.getString(VIDEO_GAME_FIELD_NAMES[5]);
					theOne.mAllGamesList.add(new VideoGame(id, name, platform, year, genre, publisher));
				}
				
				theOne.mUserGamesDB= new DBModel(DB_NAME, USER_GAMES_TABLE_NAME, USER_GAMES_FIELD_NAMES, USER_GAMES_FIELD_TYPES);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theOne;
	}

	public boolean isValidPassword(String password)
	{
		// Valid password must contain (see regex below):
		// At least one lower case letter
		// At least one digit
		// At least one special character (@, #, $, %, !)
		// At least one upper case letter
		// At least 8 characters long, but no more than 16
		return password.matches("((?=.*[a-z])(?=.*d)(?=.*[@#$%!])(?=.*[A-Z]).{8,16})");
	}
	
	public boolean isValidEmail(String email)
	{
		return email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}	

	public String signUpUser(String name, String email, String password)
	{
		//TODO: Implement this method
		for(User user : theOne.mAllUsersList)
		{
			if(user.getEmail().equalsIgnoreCase(email))
				return "Email already exists";
		}
		
		// Add user to database (keep track of new id generated)
		String[] values = {name, email, "STANDARD", password};
		// Insert user into database
		try {
			int id = theOne.mUserDB.createRecord(Arrays.copyOfRange(USER_FIELD_NAMES, 1, USER_FIELD_NAMES.length), values);
			// Let's make the new user
			User newUser = new User(id, name, email, "STANDARD");
			// Add to observable list
			theOne.mAllUsersList.add(newUser);
			theOne.mCurrentUser = newUser;
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Account not created.  Please try again.";
		}
	}	
	
	public String signInUser(String email, String password) {
		//TODO: Implement this method
		// Loop through ObservableList, see if email matches
		for(User user : theOne.mAllUsersList)
		{
			if(user.getEmail().equalsIgnoreCase(email))
			{
				//Query database for password
				try {
					ResultSet rs = theOne.mUserDB.getRecord(String.valueOf(user.getId()));
					String storedPassword = rs.getString(USER_FIELD_NAMES[4]);
					if(password.equals(storedPassword))
					{
						theOne.mCurrentUser = user;
						return "SUCCESS";
					}
					else
						return "Password incorrect.  Please try again.";
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
				}
			}
		}
		return "Email and password combination incorrect.  Please try again.";
	}
	
	public ObservableList<VideoGame> getGamesForCurrentUser()
	{
		ObservableList<VideoGame> userGamesList = FXCollections.observableArrayList();
		//TODO: Implement this method
		// Query the user_games table, get all the game ids for that user
		try {
			ResultSet rs = theOne.mUserGamesDB.getRecord(String.valueOf(mCurrentUser.getId()));
			while (rs.next())
			{
				// Grab game id from result set
				int gameId = rs.getInt(USER_GAMES_FIELD_NAMES[1]);
				// Search through the ObservableList of VideoGames to find game id
				for(VideoGame vg : theOne.mAllGamesList)
				{
					if(vg.getId() == gameId)
						userGamesList.add(vg);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userGamesList;
	}
	
	public boolean addGameToUsersInventory(VideoGame selectedGame)  {
		// Get all the games for the current user:
		ObservableList<VideoGame> gamesForCurrentUser = theOne.getGamesForCurrentUser();
		// Loop through user's games, if duplicate, return false
		if(gamesForCurrentUser.contains(selectedGame))
			return false;
		
		// If game is new, add to relationship table:
		String[] values = {String.valueOf(mCurrentUser.getId()), String.valueOf(selectedGame.getId())};
		try {
			theOne.mUserGamesDB.createRecord(USER_GAMES_FIELD_NAMES, values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public User getCurrentUser()
	{
		return mCurrentUser;
	}
	
	
	public ObservableList<User> getAllUsers() {
		return theOne.mAllUsersList;
	}

	public ObservableList<VideoGame> getAllVideoGames() {
		return theOne.mAllGamesList;
	}

	public ObservableList<String> getDistinctPlatforms() {
		ObservableList<String> platforms = FXCollections.observableArrayList();
		for (VideoGame vg : theOne.mAllGamesList)
			if (!platforms.contains(vg.getPlatform()))
				platforms.add(vg.getPlatform());
		FXCollections.sort(platforms);
		return platforms;
	}
	
	public ObservableList<String> getDistinctPublishers() {
		ObservableList<String> publishers = FXCollections.observableArrayList();
		for (VideoGame vg : theOne.mAllGamesList)
			if (!publishers.contains(vg.getPublisher()))
				publishers.add(vg.getPublisher());
		FXCollections.sort(publishers);
		return publishers;
	}
	


	private int initializeVideoGameDBFromFile() throws SQLException {
		int recordsCreated = 0;

		// If the result set contains results, database table already has
		// records, no need to populate from file (so return false)
		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			// Otherwise, open the file (CSV file) and insert user data
			// into database
			Scanner fileScanner = new Scanner(new File(VIDEO_GAME_DATA_FILE));
			// First read is for headings:
			fileScanner.nextLine();
			// All subsequent reads are for user data
			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				// Length of values is one less than field names because values
				// does not have id (DB will assign one)
				String[] values = new String[VIDEO_GAME_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];	
				theOne.mVideoGameDB.createRecord(Arrays.copyOfRange(VIDEO_GAME_FIELD_NAMES, 1, VIDEO_GAME_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			// All done with the CSV file, close the connection
			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}
	
}

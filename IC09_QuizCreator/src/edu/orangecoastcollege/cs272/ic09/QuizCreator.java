package edu.orangecoastcollege.cs272.ic09;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QuizCreator 
{
	public static void main(String[] args)
	{
		int nextID = 0;
		int id = 0;
//		try 
//		{
//			Class.forName("org.sqlite.JDBC");
//		} 
//		
//		catch (ClassNotFoundException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Establish a connection to the database:
//		Connection connection = null;
//		try 
//		{
//			connection = DriverManager.getConnection("jdbc:sqlite:cs272.db");
//			Statement stmt = connection.createStatement();
//			stmt.setQueryTimeout(30);
//			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS questions (id INTEGER PRIMARY KEY, question TEXT"
//					+ ", choice_a TEXT, choice_b TEXT, choice_c TEXT, choice_d TEXT, answer TEXT)");
//		} 
//		catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try 
		{
			Connection connection = null;
//			try 
//			{
			connection = DriverManager.getConnection("jdbc:sqlite:cs272.db");
			Statement stmt = connection.createStatement();
			stmt.setQueryTimeout(30);
			
			stmt.executeUpdate("DROP TABLE IF EXISTS questions");
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS questions (id INTEGER PRIMARY KEY, question TEXT, "
					+ "choice_a TEXT, choice_b TEXT, choice_c TEXT, choice_d TEXT, answer TEXT)");
			
			Scanner fileScanner = new Scanner(new File("quiz.txt"));
			while (fileScanner.hasNextLine())
			{
				String idString = fileScanner.nextLine(); // "1."
				if(idString.length() == 0)
					idString = fileScanner.nextLine();
				//idString = idString.substring(0, idString.indexOf('.'));
				id = Integer.parseInt(idString.substring(0, idString.indexOf('.')));
				nextID = id;
				ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
				//int id = rs.getInt("id");
				while(rs.next())
				{
					id = rs.getInt("id");
					if(id + 1 > nextID)
						nextID = id + 1;
				}
				
				String question = fileScanner.nextLine();
				String choiceA = fileScanner.nextLine();
				String choiceB = fileScanner.nextLine();
				String choiceC = fileScanner.nextLine();
				String choiceD = fileScanner.nextLine();
				String answer = fileScanner.nextLine();
				
				try 
				{
					Class.forName("org.sqlite.JDBC");
				} 
				
				catch (ClassNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Establish a connection to the database:
//				Connection connection = null;
				try 
				{
//					connection = DriverManager.getConnection("jdbc:sqlite:cs272.db");
//					Statement stmt = connection.createStatement();
//					stmt.setQueryTimeout(30);
//					stmt.executeUpdate("CREATE TABLE IF NOT EXISTS questions (id INTEGER PRIMARY KEY, question TEXT"
//							+ ", choice_a TEXT, choice_b TEXT, choice_c TEXT, choice_d TEXT, answer TEXT)");

					stmt.executeUpdate("INSERT INTO questions VALUES (" + nextID + ", '" + question + "', '"
							+ choiceA + "', '" + choiceB + "', '" + choiceC + "', '" + choiceD + "', '" 
							+ answer + "')");
					
//					ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
//					
//					while(rs.next())
//					{
//						System.out.println(rs);
//					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + ".");
				System.out.println(rs.getString("question"));
				System.out.println(rs.getString("choice_a"));
				System.out.println(rs.getString("choice_b"));
				System.out.println(rs.getString("choice_c"));
				System.out.println(rs.getString("choice_d"));
				System.out.println(rs.getString("answer") + "\n");
			}
			connection.close();
			fileScanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}
}

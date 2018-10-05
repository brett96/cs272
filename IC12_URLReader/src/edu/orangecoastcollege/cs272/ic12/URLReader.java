package edu.orangecoastcollege.cs272.ic12;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * GUI App that returns the web data of a website
 * @author Brett
 *
 */
public class URLReader extends Application {

	// Nodes on the main scene
	TextField urlTF = new TextField("http://");
	TextArea outputTA = new TextArea("Enter URL in the text field above, then press the enter key.\n\n" + 
	"The contents of the resource will be displayed here if found.\n" +
			"Otherwise, an error code and message will display.");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane pane = new GridPane();
		pane.setVgap(10.0);
		pane.setHgap(10.0);
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		urlTF.setOnAction(e -> readURL());
		pane.add(new Label("Enter URL and press ENTER : "), 0, 0);
		pane.add(urlTF,  1, 0);
					
		outputTA.setPrefHeight(550);
		outputTA.setPrefWidth(800);
		pane.add(outputTA, 0, 1, 2, 1);
		
		primaryStage.setScene(new Scene(pane));
		primaryStage.setTitle("URL Reader");
		primaryStage.show();
	}
	
	private void readURL() {
	
		//TODO: Implement this method
		String urlText = urlTF.getText();
		
		// HTTP Connection = establishes a connection over the web to a specific URL
		HttpURLConnection httpConnection;
		// Data is returned as an input stream
		Scanner webScanner;
		// Use scanner to read each line of input stream one at a time
		InputStream inStream;
		
		try
		{
			// Create a url object from URL text
			URL url = new URL(urlText);
			//https://maps.googleapis.com/maps/api/place/textsearch/xml?query=restaurants&location=33.66492516885242,%20-117.96954345729318%20&radius=10000&key=AIzaSyAzP7ZW9UVE_iQawavvyDjA0lU1OKVH7T4
			//https://maps.googleapis.com/maps/api/place/textsearch/xml?query=restaurants
			// Build URL connection first
			URLConnection connection = url.openConnection();
			// HTTP Connection takes us there
			httpConnection = (HttpURLConnection) connection;
			// Check response code & message
			int code = httpConnection.getResponseCode();
			String message = httpConnection.getResponseMessage();
			if(code != HttpURLConnection.HTTP_OK)
			{
				// If code not 200, display code and message in text area
				outputTA.setText(code + " " + message);
				return;
			}
			inStream = httpConnection.getInputStream();
			// Create a web scanner on input stream
			webScanner = new Scanner(inStream);
			
			StringBuilder sb = new StringBuilder();
			while (webScanner.hasNextLine())
			{
				sb.append(webScanner.nextLine()).append("\n");
			}
			outputTA.setText(sb.toString());
			webScanner.close();
			httpConnection.disconnect();
			// The InputStream is data feed(stream of bytes)
			
		}
		catch (Exception e)
		{
			outputTA.setText(e.getMessage());
		}

	}

	/**
	 * Starts Application
	 * @param args
	 */
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}

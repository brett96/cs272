package edu.orangecoastcollege.cs272.ic14.view;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignInScene {

	private static Controller controller = Controller.getInstance();

	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label signInErrorLabel;

	
	@FXML
	public Object signIn() 
	{
		// Read email
		String email = emailAddressTF.getText();
		String password = passwordTF.getText();
		if(email.isEmpty())
			emailErrorLabel.setVisible(true);
		if(password.isEmpty())
			passwordErrorLabel.setVisible(true);
		
		if(emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
			return null;
		
//		if(!controller.isValidEmail(email))
//		{
//			emailErrorLabel.setVisible(true);
//			signInErrorLabel.setText("Email address invalid");
//			signInErrorLabel.setVisible(true);
//		}
		
		// Assume email and password are validated:
		// Use controller to sign in (check username and password)
		String result = controller.signInUser(email, password);
		if(result.equalsIgnoreCase("SUCCESS"))
		{
			// Move on to next scene
			ViewNavigator.loadScene("Video Games List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
		}
		else
		{
			signInErrorLabel.setText(result);
			signInErrorLabel.setVisible(true);
		}
		// TODO: Complete this method
		return null;
	}
	
	@FXML
	public Object loadSignUp()
	{
		//TODO: Complete this method
		ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
		return this;
	}

}

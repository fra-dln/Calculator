package calc;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class FirstFX extends Application {
	
	public static void main (String[] args) {
		launch(args);
		}
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
		stage.setTitle("Calculator");
		Scene scene= new Scene(root);
		stage.setScene(scene);		
		stage.show();		
	}
}

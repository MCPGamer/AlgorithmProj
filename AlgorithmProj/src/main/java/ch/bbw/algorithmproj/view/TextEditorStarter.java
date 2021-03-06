package ch.bbw.algorithmproj.view;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class TextEditorStarter extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("TextEditor.fxml"));
			Scene scene = new Scene(root,900,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("TextEditor");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Images/icon.png")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

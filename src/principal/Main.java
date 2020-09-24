package principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.TelaCadastroController;

public class Main{
	
	public static void main(String[] args) {

	new TelaCadastroController().execute();
}


//public class Main extends Application{
//	public void start(Stage primaryStage) throws Exception {
//		try {
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
//			Scene scene = new Scene(root, 400, 400);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public static void main(String[] args) {
//		Application.launch(args);
//	}
}

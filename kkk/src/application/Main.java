package application;
	
import InterFac.Compuerta;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		BorderPane root = new BorderPane();
		    //Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		    root.setCenter(new IPrincipal());
	}
	
	//"llamada" a la clase Base la cual usa el recurso sample.fxml
	//root.setCenter(new Base());
	
	public static void main(String[] args) {
		launch(args);
		
		FabCompuertas Fab = new FabCompuertas();
		Compuerta a1 = Fab.getConexion("Or");
		a1.conectar();
		Compuerta a2 = Fab.getConexion("And");
		a2.conectar();
	}
}
